/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.pathAnalysis;

import static org.eclipse.xtext.GrammarUtil.*;
import static org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils.DebugUtils.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.AbstractSemanticPredicate;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.JavaAction;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.util.XtextSwitch;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.HoistingConfiguration;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.NestedIdenticalPathException;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.TokenAnalysisAbortedException;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.UnsupportedConstructException;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.token.Token;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils.DebugUtils;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils.MutableWrapper;

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
	
	private List<AbstractElement> getNextElementsInContext(AbstractElement last, boolean considerCardinalities) {
		return getNextElementsInContext(last, considerCardinalities, new HashSet<>());
	}
	
	private List<AbstractElement> getNextElementsInContext(AbstractElement last, boolean considerCardinalities, Set<AbstractElement> visited) {
		List<AbstractElement> result = new ArrayList<>();
		
		AbstractElement _last = last;
		AbstractElement container = last;
		
		while(
			container != null && (
				container == last ||
				!(container instanceof CompoundElement) ||
				container instanceof Alternatives
			)
		) {
			EObject _container = _last;
			while (
				_container == _last || 
				!(_container instanceof AbstractElement)
			) {
				_container = _container.eContainer();
				if (_container == null)
					break;
			}
			_last = container;
			container = (AbstractElement) _container;
			
			if (considerCardinalities && last != _last && isMultipleCardinality(_last)) {
				// last is + or * quantified, so it may be repeated -> add to result
				result.add(_last);
			}
		}
		last = _last;
		
		CompoundElement compoundContainer = (CompoundElement) container;
		
		if (compoundContainer == null) {
			if (config.isDebug())
				log.info("no container");
			
			// no container element; this is last element in a rule definition
			AbstractRule rule = containingRule(last);
			
			if (isStartRule(grammar, rule)) {
				// context is EOF
				result.add(null);
			}
			
			findAllRuleCalls(grammar, rule).stream()
				.filter(Predicate.not(visited::contains))
				.forEach(call -> {
					Set<AbstractElement> _visited = new HashSet<>(visited);
					_visited.add(call);
					result.addAll(getNextElementsInContext(call, considerCardinalities, _visited));
				});
		} else if (compoundContainer instanceof Group) {
			if (config.isDebug())
				log.info("group container");
			
			List<AbstractElement> elements = compoundContainer.getElements();
			int index = elements.indexOf(last);
			if (index < 0) {
				throw new UnsupportedConstructException("context analysis: element not part of compound: " + 
						last.eClass().getName() + " in " + abstractElementToString(compoundContainer));
			}
			
			int size = elements.size();
			AbstractElement next = null;
			
			// skip simple non-token-elements
			while (index < size - 1) {
				next = elements.get(index + 1);
				if (
					!(
						(next instanceof Action) ||
						(next instanceof JavaAction) ||
						(next instanceof AbstractSemanticPredicate)
					)
				) {
					break;
				}
					
				index++;
			}
			if (index < size - 1) {
				result.add(next);
			} else {
				// this is the last element
				if (considerCardinalities && isMultipleCardinality(compoundContainer)) {
					result.add(compoundContainer);
				}
				
				result.addAll(getNextElementsInContext(compoundContainer, considerCardinalities, visited));
			}
		} else if (compoundContainer instanceof UnorderedGroup) {
			if (config.isDebug())
				log.info("unordered group container");
			
			if (considerCardinalities) {
				result.addAll(compoundContainer.getElements().stream()
					.collect(Collectors.toList())
				);
			}
			result.addAll(getNextElementsInContext(compoundContainer, considerCardinalities, visited));
		} else {
			throw new IllegalArgumentException("unknown compound element: " + container.eClass().getName());
		}
		
		return result;
	}
	
	private TokenAnalysisPaths getTokenPathsContext(AbstractElement last, TokenAnalysisPaths prefix) {
		return getTokenPathsContext(last, prefix, true, new HashSet<>());
	}
	
	private TokenAnalysisPaths getTokenPathsContext(AbstractElement last, TokenAnalysisPaths prefix, boolean considerCardinalities, Set<AbstractElement> visitedElements) {
		if (config.isDebug())
			log.info("get context for: " + abstractElementToShortString(last) + 
				(considerCardinalities ? " with" : " without") + " cardinalities");
		
		List<AbstractElement> context = getNextElementsInContext(last, considerCardinalities);
		
		if (config.isDebug())
			log.info(context.stream().map(DebugUtils::abstractElementToShortString).collect(Collectors.toList()));
				
		TokenAnalysisPaths result = TokenAnalysisPaths.empty(prefix);
		
		int actualNumberOfElements = 0;
		for (AbstractElement element : context) {
			if (config.isDebug())
				log.info("context element: " + abstractElementToShortString(element));
			TokenAnalysisPaths path = new TokenAnalysisPaths(prefix);
			path.resetProgress();
			
			// shortcut endless loops instead of throwing exception
			path = getTokenPaths(element, path, false, false);
			
			if (!path.isDone() && element != null) {
				boolean _considerCardinalities = considerCardinalities;
				if (visitedElements.contains(element) && !path.hasProgress()) {
					if (_considerCardinalities) {
						_considerCardinalities = false;
					} else {
						// considerCardinalities is already false
						log.info("failed to analyse cardinalities in context");
						// ignore this branch
						continue;
					}
				}
				Set<AbstractElement> localVisitedElements = new HashSet<>(visitedElements);
				localVisitedElements.add(element);
				path = getTokenPathsContext(element, path, _considerCardinalities, localVisitedElements);
			}
			if (path.isDone()) {
				result = result.merge(path);
			} else {
				if (config.isDebug())
					log.info("context analysis failed");
				throw new TokenAnalysisAbortedException("context analysis failed");
			}
			actualNumberOfElements++;
		}
		
		if (actualNumberOfElements == 0) {
			// necessary in case all possible path are ignored
			// (considerCardinalities is false, all elements were visited and there was no progress)

			if (config.isDebug())
				log.info("context analysis failed: no context");
			throw new TokenAnalysisAbortedException("context analysis failed: no context");
		}
		
		if (config.isDebug())
			log.info("context analysis done");
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
		
		do {
			current = TokenAnalysisPaths.empty(result);
			current.resetProgress();
			
			for (AbstractElement element : path.getElements()) {
				current = current.merge(getTokenPaths(element, result, false, false));
			}
			
			result.resetProgress();
			result = result.merge(current);
			
		} while(result.hasProgress());
		
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
				if (
					isParserRuleCall(call) || 
					isEnumRuleCall(call)
				) {
					return getTokenPaths(call.getRule().getAlternatives(), prefix, false, false);
				} else {
					// probably terminal rule call -> go to default case
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
					// create new state without empty flag
					return new TokenAnalysisPaths(prefix);
				}
			};
		}.doSwitch(path);
	}
	
	boolean isVirtualOptionalCardinality(String cardinality) {
		return "?".equals(cardinality) || "*".equals(cardinality);
	}

	boolean isVirtualMultipleCardinality(String cardinality) {
		return "+".equals(cardinality) || "*".equals(cardinality);
	}
	
	private TokenAnalysisPaths getTokenPaths(
			AbstractElement path, TokenAnalysisPaths prefix, boolean analyseContext, boolean needsLength
	) {
		if (prefix.isDone()) {
			return prefix;
		}
		
		if (path == null) {
			// empty path means EOF
			TokenAnalysisPaths result;
			result = new TokenAnalysisPaths(prefix);
			result.add(path);
			return result;
		}
		
		// use actual cardinality from path
		return getTokenPaths(path, path.getCardinality(), prefix, analyseContext, needsLength);
	}
	
	private TokenAnalysisPaths getTokenPaths(
			AbstractElement path, String cardinality, TokenAnalysisPaths prefix, boolean analyseContext, boolean needsLength
	) {
		// analyseContext implies needsLength
		
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
		
		if (isVirtualOptionalCardinality(cardinality)) {
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
		
		boolean loop = isVirtualMultipleCardinality(cardinality);
		
		do {
			result.resetProgress();
			
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
			
		} while (loop && result.hasProgress());
		
		return result;
	}
	
	private TokenAnalysisPaths getTokenPathsNoLength(AbstractElement path, List<Integer> indexes) {
		return getTokenPaths(path, new TokenAnalysisPaths(indexes), false, false);
	}
	
	private TokenAnalysisPaths getTokenPathsContext(AbstractElement path, List<Integer> indexes) {
		return getTokenPaths(path, new TokenAnalysisPaths(indexes), true, true);
	}
	
	private TokenAnalysisPaths getTokenPaths(AbstractElement path, String virtualCardinality, List<Integer> indexes, boolean analyseContext, boolean needsLength) {
		return getTokenPaths(path, virtualCardinality, new TokenAnalysisPaths(indexes), analyseContext, needsLength);
	}
	
	private TokenAnalysisPaths getTokenPathsContextOnly(AbstractElement path, List<Integer> indexes) throws TokenAnalysisAbortedException {
		return getTokenPathsContext(path, new TokenAnalysisPaths(indexes));
	}
	
	private List<Integer> range(int i, int j) {
		return IntStream.rangeClosed(i, j).boxed().collect(Collectors.toList());
	}
	
	public boolean arePathsIdentical(AbstractElement path1, AbstractElement path2) {
		if (config.isDebug()) {
			log.info("path1: " + abstractElementToString(path1));
			log.info("path2: " + abstractElementToString(path2));
		}
		
		// + 1, because otherwise identical paths of length token limit can't be checked
		int limit = config.getTokenLimit() + 1;
		for (int i = 0; i < limit; i++) {
			TokenAnalysisPaths tokenPaths1;
			TokenAnalysisPaths tokenPaths2;
			
			List<Integer> range = range(0,  i);
			
			// there shouldn't be a TokenAnalysisAbortedException if needsLength is false
			tokenPaths1 = getTokenPathsNoLength(path1, range);
			tokenPaths2 = getTokenPathsNoLength(path2, range);
			
			Set<Set<Token>> tokenListSet1 = tokenPaths1.getTokenPaths().stream().map(HashSet::new).collect(Collectors.toSet());
			Set<Set<Token>> tokenListSet2 = tokenPaths2.getTokenPaths().stream().map(HashSet::new).collect(Collectors.toSet());
			
			if (!tokenListSet1.equals(tokenListSet2)) {
				return false;
			}
			
			if (tokenPaths1.getMaxPosition() < i + 1) {
				// different max positions would have failed the equals-Operation
				// if the max position is smaller than i + 1 the end of the path has been reached
				// -> the paths are identical
				return true;
			}
		}
		
		// token analysis limit reached
		// we can't analyze the paths any further
		throw new TokenAnalysisAbortedException("token limit exhausted while looking for identical paths");
	}
	
	private void tokenCombinations(Function<List<Integer>, Boolean> callback) {
		MutableWrapper<Integer> limit = new MutableWrapper<>(config.getTokenLimit());
		
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
			// path length exhausted while searching for minimal differences
			// this indicates the presence of nested identical paths
			throw new NestedIdenticalPathException();
		}
	}
	private boolean tokenCombinations(long prefix, int prefixLength, int ones, Function<List<Integer>, Boolean> callback, MutableWrapper<Integer> limit) {
		if (ones <= 0) {
			List<Integer> indexes = new ArrayList<>(limit.get());
			int l = limit.get();
			for (int i = 0; i < l; i++) {
				if ((prefix & (1 << i)) > 0) {
					indexes.add(i);
				}
			}
			return callback.apply(indexes);
		} else if (prefixLength + ones > limit.get()) {
			// prefix is too long
			return false;
		} else {
			// we can not cache the value of limit here since it might be modified during the recursion
			for (int i = prefixLength; i < limit.get() - ones + 1; i++) {
				long current = prefix | (1 << i);
				try {
					if (tokenCombinations(current, i + 1, ones - 1, callback, limit)) {
						return true;
					}
				} catch (TokenAnalysisAbortedException e) {
					if (config.isDebug())
						log.info("tokens exhausted: " + e.getMessage());
					
					// tokens exhausted; abort current prefix
					// set limit for calling functions so this index is not checked again
					limit.set(i);
					return false;
				}
			}
			return false;
		}
	}
	
	public List<List<Token>> findMinimalPathDifference(AbstractElement element, String virtualCardinality) throws TokenAnalysisAbortedException {
		// this method is for finding the path differences between the 
		// element (with optional cardinality) and the context
		
		// virtualCardinality is what should be used instead of the actual cardinality of the root element
		// this way ? and * can both be handled by this method
		
		// first dimension of result corresponds to the alternatives
		// the second dimension are tokens of the alternatives
		// no need return the context tokens
		
		MutableWrapper<List<List<Token>>> result = new MutableWrapper<List<List<Token>>>(null);
		
		tokenCombinations(indexList -> {
			
			// no context analysis // TODO why?
			List<List<Token>> tokenListsForPath = getTokenPaths(element, virtualCardinality, indexList, false, true)
				.getTokenPaths();
			List<List<Token>> tokenListForContext = getTokenPathsContextOnly(element, indexList)
				.getTokenPaths();
				
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
		

		if (config.isDebug()) {
			paths.forEach(p -> {
				log.info("\n" + abstractElementToString(p));
			});
		}
		
		tokenCombinations(indexList -> {
			
			// will throw TokenAnalysisAborted if any path is too short
			List<List<List<Token>>> tokenListsForPaths = paths.stream()
					.peek(p -> {
						if (config.isDebug())
							log.info("next path: " + p);
					})
					.map(p -> getTokenPathsContext(p, indexList).getTokenPaths())
					.collect(Collectors.toList());
			
			int size = result.size();
			for (int i = 0; i < size; i++) {
				if (result.get(i) != null) {
					continue;
				}
				
				List<List<Token>> tokenListOfCurrentPath = tokenListsForPaths.get(i);
				if (!tokenListOfCurrentPath.stream()
					.anyMatch(tokenList -> tokenListsForPaths.stream()
							.filter(s -> s != tokenListOfCurrentPath)
							// does any other path contain a similar token list (= alternative) ?
							.anyMatch(s -> s.contains(tokenList))
					)
				) {
					// token list set is unique for path i
					result.set(i, tokenListOfCurrentPath);
				}
				
			}
			
			// abort when all paths have an identifying token sequence set
			return result.stream()
					.allMatch(Objects::nonNull);
		});
		
		return result;
	}
	
	public List<List<AbstractElement>> getAllPossiblePaths(AbstractElement path) {
		// token limit + 2 so identity analysis will recognize paths that are identical up to the token limit on the flattened tree
		return getTokenPathsNoLength(path, range(0, config.getTokenLimit() + 2))
				.getTokenPaths()
				.stream()
				.map(l -> l.stream()
					.map(Token::getElement)
					.collect(Collectors.toList()))
				.collect(Collectors.toList());
				
	}
}
