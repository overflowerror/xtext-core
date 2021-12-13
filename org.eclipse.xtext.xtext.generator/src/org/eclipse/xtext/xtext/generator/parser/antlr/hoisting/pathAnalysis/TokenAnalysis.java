/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.pathAnalysis;

import static org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils.DebugUtils.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.util.XtextSwitch;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.HoistingConfiguration;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.SymbolicAnalysisFailedException;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.TokenAnalysisAbortedException;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.token.Token;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils.DebugUtils;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils.MutablePrimitiveWrapper;

import static org.eclipse.xtext.GrammarUtil.*;
import static org.eclipse.xtext.EcoreUtil2.*;

/**
 * @author overflow - Initial contribution and API
 */
public class TokenAnalysis {
	private HoistingConfiguration config;
	private Grammar grammar;
	
	private Logger log = Logger.getLogger(TokenAnalysis.class);
	
	public TokenAnalysis(HoistingConfiguration config, Grammar grammar) {
		this.config = config;
		this.grammar = grammar;
	}
	
	private AbstractElement getContainer(AbstractElement element) {
		EObject tmp = element.eContainer();
		while (!(tmp instanceof AbstractElement)) {
			if (tmp == null) {
				return null;
			}
			tmp = tmp.eContainer();
		}
		return (AbstractElement) tmp;
	}
	
	private CompoundElement getCompoundContainer(AbstractElement element) {
		if (element instanceof CompoundElement) {
			// get container of compoundElement since getContainerOfType 
			// would return the same element
			element = getContainer(element);
			if (element == null) {
				return null;
			}
		}
		return getContainerOfType(element, CompoundElement.class);
	}
	
	private List<AbstractElement> getNextElementsInContext(AbstractElement last) {		
		CompoundElement container = getCompoundContainer(last);
		while (container instanceof Alternatives || 
		       last.eContainer() instanceof Assignment
		) {
			// skip alternatives since they have to be covered separately
			last = getContainer(last);
			if (last == null) {
				return Arrays.asList((AbstractElement) null);
			}
			container = getCompoundContainer(last);
		}
		
		log.info("getNext: " + abstractElementToShortString(last));
		log.info("container: " + abstractElementToShortString(container));
		
		if (container instanceof UnorderedGroup) {
			List<AbstractElement> result = new ArrayList<>();
			result.addAll(container.getElements().stream()
				.collect(Collectors.toList())
			);
			result.addAll(getNextElementsInContext(container));
			return result;
		} else if (container instanceof Group) {
			List<AbstractElement> elements = container.getElements();
			int index = elements.indexOf(last);
			if (index < 0) {
				log.error("context analysis: element not part of compound");
				log.info(last.eClass().getName());
				log.info(abstractElementToString(container));
			}
			if (index < elements.size() - 1) {
				return Arrays.asList(elements.get(index + 1));
			} else {
				// this is the last element
				return getNextElementsInContext(container);
			}
		} else if (container == null) {
			// end of rule
			AbstractRule rule = containingRule(last);			
			List<RuleCall> calls = findAllRuleCalls(grammar, rule);

			if (calls.isEmpty()) {
				// has to be start rule
				// context is EOF
				return Arrays.asList((AbstractElement) null);
			}
			
			List<AbstractElement> result = new ArrayList<>();
			for (RuleCall call : calls) {
				result.addAll(getNextElementsInContext(call));
			}
			
			return result;
		} else {
			throw new IllegalArgumentException("unknown compound element: " + container.eClass().getName());
		}
	}
	
	
	private TokenAnalysisPaths getTokenPathsContext(AbstractElement last, TokenAnalysisPaths prefix) {
		log.info("get context for: " + abstractElementToShortString(last));
		
		List<AbstractElement> context = getNextElementsInContext(last);
		
		log.info(context.size());
		log.info(context.stream().map(DebugUtils::abstractElementToShortString).collect(Collectors.toList()));
				
		TokenAnalysisPaths result = TokenAnalysisPaths.empty(prefix);
		
		if (context.isEmpty()) {
			// TODO: is this special case necessary?
			throw new TokenAnalysisAbortedException("context analysis failed: no context");
		}

		int currentPosition = prefix.getMinPosition();
		
		for (AbstractElement element : context) {			
			TokenAnalysisPaths path = new TokenAnalysisPaths(prefix);
			path = getTokenPaths(element, path, false, false);
			if (!path.isDone() && element != null) {
				if (path.getMinPosition() == currentPosition) {
					throw new TokenAnalysisAbortedException("no progress in context analysis");
				}
				
				path = getTokenPathsContext(element, path);
			}
			if (path.isDone()) {
				result = result.merge(path);
			} else {
				throw new TokenAnalysisAbortedException("context analysis failed");
			}
		}
		
		log.info("done");
		return result;
	}
	
	private TokenAnalysisPaths getTokenPathsTrivial(Group path, TokenAnalysisPaths prefix) {
		TokenAnalysisPaths result = new TokenAnalysisPaths(prefix);
		
		for(AbstractElement element : path.getElements()) {
			result = getTokenPaths(element, result, false, false);
			if (result.isDone()) {
				break;
			}
		}
		
		return result;
	}
	private TokenAnalysisPaths getTokenPathsTrivial(Alternatives path, TokenAnalysisPaths prefix) {
		TokenAnalysisPaths result = TokenAnalysisPaths.empty(prefix);
		
		for(AbstractElement element : path.getElements()) {
			result = result.merge(getTokenPaths(element, prefix, false, false));
		}
		
		return result;
	}
	private TokenAnalysisPaths getTokenPathsTrivial(UnorderedGroup path, TokenAnalysisPaths prefix) {
		TokenAnalysisPaths result;
		TokenAnalysisPaths current;
		
		if (path.getElements().stream().allMatch(GrammarUtil::isOptionalCardinality)) {
			result = new TokenAnalysisPaths(prefix);
		} else {
			result = TokenAnalysisPaths.empty(prefix);
		}
		
		int currentPosition = result.getMinPosition();
		
		do {
			current = TokenAnalysisPaths.empty(result);
			for (AbstractElement element : path.getElements()) {
				current = current.merge(getTokenPaths(element, result, false, false));
			}
			
			if (current.getMinPosition() == currentPosition) {
				throw new TokenAnalysisAbortedException("no progress in loop");
			}
			
			result = result.merge(current);
		} while(!current.isDone());
		
		return result;
	}
	
	private TokenAnalysisPaths getTokenPathsTrivial(AbstractElement path, TokenAnalysisPaths prefix) {
		return new XtextSwitch<TokenAnalysisPaths>() {
			@Override
			public TokenAnalysisPaths caseGroup(Group group) {
				return getTokenPathsTrivial(group, prefix);
			};
			@Override
			public TokenAnalysisPaths caseAlternatives(Alternatives alternatives) {
				return getTokenPathsTrivial(alternatives, prefix);
			};
			@Override
			public TokenAnalysisPaths caseUnorderedGroup(UnorderedGroup unorderedGroup) {
				return getTokenPathsTrivial(unorderedGroup, prefix);
			};
			@Override
			public TokenAnalysisPaths caseAssignment(Assignment assignment) {
				return getTokenPaths(assignment.getTerminal(), prefix, false, false);
			};
			@Override
			public TokenAnalysisPaths caseRuleCall(RuleCall call) {
				if (isParserRuleCall(call) || 
				    isEnumRuleCall(call)
				) {
					return getTokenPaths(call.getRule().getAlternatives(), prefix, false, false);
				} else {
					// go to default case
					return null;
				}
			};
			@Override
			public TokenAnalysisPaths defaultCase(EObject object) {
				AbstractElement element = (AbstractElement) object;
				
				if (Token.isToken(element)) {
					TokenAnalysisPaths result = new TokenAnalysisPaths(prefix);
					result.add(element);
					return result;
				} else {
					// Actions, Predicates, JavaActions, ...
					return prefix;
				}
			};
		}.doSwitch(path);
	}
	
	// analyseContext implies needsLength
	private TokenAnalysisPaths getTokenPaths(AbstractElement path, TokenAnalysisPaths prefix, boolean analyseContext, boolean needsLength) {
		if (prefix.isDone()) {
			return prefix;
		}
		
		TokenAnalysisPaths result;
		
		if (path == null) {
			// empty path means EOF
			result = new TokenAnalysisPaths(prefix);
			result.add(path);
			return result;
		}
		
		if (isOptionalCardinality(path)) {
			if (analyseContext) {
				result = getTokenPathsContext(path, prefix);
			} else if (needsLength) {
				throw new TokenAnalysisAbortedException("token expected but path is optional");
			} else {
				result = new TokenAnalysisPaths(prefix);
			}
		} else {
			result = TokenAnalysisPaths.empty(prefix);
		}
		
		boolean loop = isMultipleCardinality(path);
		
		int currentPosition = result.getMinPosition();
		
		do {	
			TokenAnalysisPaths tokenPaths = getTokenPathsTrivial(path, result);
			
			if (tokenPaths.isDone()) {
				result = result.merge(tokenPaths);
				break;
			} else if (analyseContext) {
				tokenPaths = getTokenPathsContext(path, tokenPaths);
				result = result.merge(tokenPaths);
			} else if (needsLength) {
				throw new TokenAnalysisAbortedException("requested length not satisfyable");
			} else {
				result = result.merge(tokenPaths);
			}
			
			if (loop) {
				if (result.getMinPosition() == currentPosition) {
					throw new TokenAnalysisAbortedException("no progress in loop");
				} else {
					currentPosition = result.getMinPosition();
				}
			}
		} while (loop);
		
		return result;
	}
	
	private List<List<Token>> getTokenPaths(AbstractElement path, List<Integer> indexes, boolean analyseContext) throws TokenAnalysisAbortedException {
		return getTokenPaths(path, new TokenAnalysisPaths(indexes), analyseContext, true).getTokenPaths();
	}
	
	private List<List<Token>> getTokenPathsContextOnly(AbstractElement path, List<Integer> indexes) {
		return getTokenPathsContext(path, new TokenAnalysisPaths(indexes)).getTokenPaths();
	}
	
	private boolean arePathsIdenticalSymbolic(AbstractElement path1, AbstractElement path2) throws SymbolicAnalysisFailedException {
		// ignore symbolic analysis for the moment
		// TODO
		throw new SymbolicAnalysisFailedException(); 
	}
	
	private List<Integer> range(int i, int j) {
		return IntStream.rangeClosed(i, j).boxed().collect(Collectors.toList());
	}
	
	private boolean arePathsIdenticalFallback(AbstractElement path1, AbstractElement path2) {
		// + 1, because otherwise identical paths of length token limit can't be checked
		
		log.info("path1: " + abstractElementToString(path1));
		log.info("path2: " + abstractElementToString(path2));
		
		int i;
		int limit = config.getTokenLimit() + 1;
		for (i = 0; i < limit; i++) {
			TokenAnalysisPaths tokenPaths1;
			TokenAnalysisPaths tokenPaths2;
			
			List<Integer> range = range(0,  i);
			
			// there shouldn't be a TokenAnalysisAbortedException if needsLength is false
			tokenPaths1 = getTokenPaths(path1, new TokenAnalysisPaths(range), false, false);
			tokenPaths2 = getTokenPaths(path2, new TokenAnalysisPaths(range), false, false);
			
			Set<Set<Token>> tokenListSet1 = tokenPaths1.getTokenPaths().stream().map(HashSet::new).collect(Collectors.toSet());
			Set<Set<Token>> tokenListSet2 = tokenPaths2.getTokenPaths().stream().map(HashSet::new).collect(Collectors.toSet());
			
			int maxPosition1 = tokenPaths1.getMaxPosition();
			int maxPosition2 = tokenPaths2.getMaxPosition();
			
			log.info("set1: " + tokenListSet1 + ", " + maxPosition1);
			log.info("set2: " + tokenListSet2 + ", " + maxPosition2);
			
			if (!tokenListSet1.equals(tokenListSet2)) {
				return false;
			}
			
			if (maxPosition1 < i + 1) {
				// different max positions would have failed the equals-Operation
				// if the max position is smaller than i + 1 the end of the path has been reached
				return true;
			}
		}
		
		// token analysis limit reached
		// we can't analyze the paths any further
		// TODO maybe assume paths are equal and show warning instead of exception
		throw new TokenAnalysisAbortedException("token limit exhausted while looking for identical paths");
	}
	
	public boolean arePathsIdentical(AbstractElement path1, AbstractElement path2) {
		try {
			return arePathsIdenticalSymbolic(path1, path2);
		} catch (SymbolicAnalysisFailedException e) {
			return arePathsIdenticalFallback(path1, path2);
		}
	}
	
	
	private void tokenCombinations(Function<List<Integer>, Boolean> callback) {
		MutablePrimitiveWrapper<Integer> limit = new MutablePrimitiveWrapper<>(config.getTokenLimit());
		
		for (int i = 1; i <= limit.get(); i++) {
			if (tokenCombinations(0, 0, i, callback, limit)) {
				return;
			}
		}
		// we tried all possible combinations
		// -> abort
		if (limit.get().equals(config.getTokenLimit())) {
			throw new TokenAnalysisAbortedException("token limit exhausted while searching for minimal differences");
		} else {
			throw new TokenAnalysisAbortedException("path length exhausted while searching for minimal differences");
		}
	}
	private boolean tokenCombinations(long prefix, int prefixLength, int ones, Function<List<Integer>, Boolean> callback, MutablePrimitiveWrapper<Integer> limit) {
		if (ones == 0) {
			List<Integer> indexes = new ArrayList<>(limit.get());
			for (int i = 0; i < limit.get(); i++) {
				if ((prefix & (1 << i)) > 0) {
					indexes.add(i);
				}
			}
			return callback.apply(indexes);
		} else if (prefixLength + ones > limit.get()) {
			// prefix is too long
			return false;
		} else {
			for (int i = prefixLength; i < limit.get() - ones + 1; i++) {
				long current = prefix | (1 << i);
				try {
					if (tokenCombinations(current, i + 1, ones - 1, callback, limit)) {
						return true;
					}
				} catch (TokenAnalysisAbortedException e) {
					// tokens exhausted; abort current prefix
					// set limit for calling functions so this index is not checked again
					limit.set(i);
					return false;
				}
			}
			return false;
		}
	}
	
	public List<List<Token>> findMinimalPathDifference(AbstractElement element) throws TokenAnalysisAbortedException {
		// this method is for finding the path differences between the 
		// element (with optional cardinality) and the context
		
		// first dimension of result corresponds to the alternatives
		// the second dimension are tokens of the alternatives
		
		MutablePrimitiveWrapper<List<List<Token>>> result = new MutablePrimitiveWrapper<List<List<Token>>>(null);
		
		tokenCombinations(indexList -> {
			log.info("current index list: " + indexList);
			
			// no context analysis
			List<List<Token>> tokenListsForPath = getTokenPaths(element, indexList, false);
			List<List<Token>> tokenListForContext = getTokenPathsContextOnly(element, indexList);
				
			if (!tokenListsForPath.stream()
					.anyMatch(tokenListForContext::contains)
			) {
				// context does not contain any token lists for path
				result.set(tokenListsForPath);
			}
			
			return result.get() != null;
		});
		
		return result.get();
	}
	
	public List<List<List<Token>>> findMinimalPathDifference(List<AbstractElement> paths) throws TokenAnalysisAbortedException {
		// first dimension of result corresponds to the paths
		// the second dimension are the alternatives of the path
		// the third dimension are tokens of the alternative of the path
		
		List<List<List<Token>>> result = paths.stream()
				.map(p -> (List<List<Token>>) null)
				.collect(Collectors.toList());
		
		paths.forEach(p -> {
			log.info("\n" + abstractElementToString(p));
		});
		
		tokenCombinations(indexList -> {
			log.info("current index list: " + indexList);
			
			// will throw TokenAnalysisAborted if any path is too short
			List<List<List<Token>>> tokenListsForPaths = paths.stream()
					//.peek(p -> log.info("next path: " + p))
					.map(p -> getTokenPaths(p, indexList, true))
					.collect(Collectors.toList());

			log.info("token lists: " + tokenListsForPaths);
			
			int size = result.size();
			for (int i = 0; i < size; i++) {
				if (result.get(i) != null) {
					continue;
				}
				
				List<List<Token>> tokenListOfCurrentPath = tokenListsForPaths.get(i);
				if (!tokenListOfCurrentPath.stream()
					.anyMatch(tokenList -> tokenListsForPaths.stream()
							.filter(s -> s != tokenListOfCurrentPath)
							// does any other path contain a similar token list (= alternative)
							.anyMatch(s -> s.contains(tokenList))
					)
				) {
					// token list set is unique for path i
					result.set(i, tokenListOfCurrentPath);
				}
				
			}
			
			return result.stream()
					.allMatch(Objects::nonNull);
		});
		
		return result;
	}
}
