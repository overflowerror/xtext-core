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
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.EmptyRecursionPathInContextAnalysisException;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.NestedPrefixAlternativesException;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.SymbolicAnalysisFailedException;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.TokenAnalysisAbortedException;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.token.Token;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils.DebugUtils;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils.MutablePrimitiveWrapper;

import static org.eclipse.xtext.GrammarUtil.*;

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
	
	private List<AbstractElement> getNextElementsInContext(AbstractElement last) {
		List<AbstractElement> result = new ArrayList<>();
		
		AbstractElement _last = last;
		AbstractElement container = last;
		
		while(container != null && (
				container == last ||
				!(container instanceof CompoundElement) ||
				container instanceof Alternatives
			)
		) {
			EObject _container = _last;
			while (_container == _last || 
			       !(_container instanceof AbstractElement)
			) {
				_container = _container.eContainer();
				if (_container == null)
					break;
			}
			_last = container;
			container = (AbstractElement) _container;
			
			if (last != _last && isMultipleCardinality(_last)) {
				// last is + or * quantified
				result.add(_last);
			}
		}
		last = _last;
		
		CompoundElement compoundContainer = (CompoundElement) container;
		
		if (compoundContainer == null) {
			// no container element; this is last element in a rule definition
			AbstractRule rule = containingRule(last);			
			List<RuleCall> calls = findAllRuleCalls(grammar, rule);

			if (calls.isEmpty()) {
				// has to be start rule
				// context is EOF
				result.add(null);
			}
			
			for (RuleCall call : calls) {
				result.addAll(getNextElementsInContext(call));
			}
		} else if (compoundContainer instanceof Group) {
			List<AbstractElement> elements = compoundContainer.getElements();
			int index = elements.indexOf(last);
			if (index < 0) {
				log.error("context analysis: element not part of compound");
				log.info(last.eClass().getName());
				log.info(abstractElementToString(compoundContainer));
			}
			
			int size = elements.size();
			AbstractElement next = null;
			
			// skip simple non-token-elements
			while (index < size - 1) {
				next = elements.get(index + 1);
				if (!(
						(next instanceof Action) ||
						(next instanceof JavaAction) ||
						(next instanceof AbstractSemanticPredicate)
				)) {
					break;
				}
					
				index++;
			}
			if (index < size - 1) {
				result.add(next);
			} else {
				// this is the last element
				if (isMultipleCardinality(compoundContainer)) {
					result.add(compoundContainer);
				}
				
				result.addAll(getNextElementsInContext(compoundContainer));
			}
		} else if (compoundContainer instanceof UnorderedGroup) {
			result.addAll(compoundContainer.getElements().stream()
				.collect(Collectors.toList())
			);
			result.addAll(getNextElementsInContext(compoundContainer));
		} else {
			throw new IllegalArgumentException("unknown compound element: " + container.eClass().getName());
		}
		
		return result;
	}
	
	private TokenAnalysisPaths getTokenPathsContext(AbstractElement last, TokenAnalysisPaths prefix, boolean shortcutEndlessLoops) {
		return getTokenPathsContext(last, prefix, shortcutEndlessLoops, new HashSet<>());
	}
	
	private TokenAnalysisPaths getTokenPathsContext(AbstractElement last, TokenAnalysisPaths prefix, boolean shortcutEndlessLoops, Set<AbstractElement> callStack) {
		log.info("get context for: " + abstractElementToShortString(last));
		
		List<AbstractElement> context = getNextElementsInContext(last);
		
		log.info(context.size());
		log.info(context.stream().map(DebugUtils::abstractElementToShortString).collect(Collectors.toList()));
				
		TokenAnalysisPaths result = TokenAnalysisPaths.empty(prefix);
		
		if (context.isEmpty()) {
			// TODO: is this special case necessary?
			throw new TokenAnalysisAbortedException("context analysis failed: no context");
		}
		
		for (AbstractElement element : context) {
			log.info("context element: " + abstractElementToShortString(element));
			TokenAnalysisPaths path = new TokenAnalysisPaths(prefix);
			path.resetProgress();
			path = getTokenPaths(element, path, false, false, shortcutEndlessLoops);
			if (!path.isDone() && element != null) {
				if (callStack.contains(element) && !path.hasProgress()) {
					throw new EmptyRecursionPathInContextAnalysisException("no progress in recursion");
				}
				Set<AbstractElement> localCallStack = new HashSet<>(callStack);
				localCallStack.add(element);
				path = getTokenPathsContext(element, path, shortcutEndlessLoops, localCallStack);
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
	
	private TokenAnalysisPaths getTokenPathsTrivial(Group path, TokenAnalysisPaths prefix, boolean shortcutEndlessLoops) {
		TokenAnalysisPaths result = new TokenAnalysisPaths(prefix);
		
		for(AbstractElement element : path.getElements()) {
			result = getTokenPaths(element, result, false, false, shortcutEndlessLoops);
			if (result.isDone()) {
				break;
			}
		}
		
		return result;
	}
	private TokenAnalysisPaths getTokenPathsTrivial(Alternatives path, TokenAnalysisPaths prefix, boolean shortcutEndlessLoops) {
		TokenAnalysisPaths result = TokenAnalysisPaths.empty(prefix);
		
		for(AbstractElement element : path.getElements()) {
			result = result.merge(getTokenPaths(element, prefix, false, false, shortcutEndlessLoops));
		}
		
		return result;
	}
	private TokenAnalysisPaths getTokenPathsTrivial(UnorderedGroup path, TokenAnalysisPaths prefix, boolean shortcutEndlessLoops) {
		log.info("unordered group");
		
		TokenAnalysisPaths result;
		TokenAnalysisPaths current;
		
		if (path.getElements().stream().allMatch(GrammarUtil::isOptionalCardinality)) {
			result = new TokenAnalysisPaths(prefix);
		} else {
			result = TokenAnalysisPaths.empty(prefix);
		}
		
		int currentPosition = result.getMinPosition();
		
		do {
			log.info("unordered group loop");
			
			current = TokenAnalysisPaths.empty(result);
			current.resetProgress();
			for (AbstractElement element : path.getElements()) {
				log.info(abstractElementToShortString(element));
				log.info(current.hasProgress() + " - " + current.getSize());
				current = current.merge(getTokenPaths(element, result, false, false, shortcutEndlessLoops));
				log.info(current.hasProgress() + " - " + current.getSize());
			}
			
			result.resetProgress();
			result = result.merge(current);
			
			if (current.getMinPosition() == currentPosition) {
				// endless loop
				// result will never be done since there is no progress to the shortest path
				if (shortcutEndlessLoops) {
					if (!result.hasProgress()) {
						// no progress
						// abort endless loop
						break;
					} else {
						// there is still some progress done
						continue;
					}
				} else {
					throw new TokenAnalysisAbortedException("no progress in loop");
				}
			}
		} while(!current.isDone());
		
		return result;
	}
	
	private TokenAnalysisPaths getTokenPathsTrivial(AbstractElement path, TokenAnalysisPaths prefix, boolean shortcutEndlessLoops) {
		return new XtextSwitch<TokenAnalysisPaths>() {
			@Override
			public TokenAnalysisPaths caseGroup(Group group) {
				return getTokenPathsTrivial(group, prefix, shortcutEndlessLoops);
			};
			@Override
			public TokenAnalysisPaths caseAlternatives(Alternatives alternatives) {
				return getTokenPathsTrivial(alternatives, prefix, shortcutEndlessLoops);
			};
			@Override
			public TokenAnalysisPaths caseUnorderedGroup(UnorderedGroup unorderedGroup) {
				return getTokenPathsTrivial(unorderedGroup, prefix, shortcutEndlessLoops);
			};
			@Override
			public TokenAnalysisPaths caseAssignment(Assignment assignment) {
				return getTokenPaths(assignment.getTerminal(), prefix, false, false, shortcutEndlessLoops);
			};
			@Override
			public TokenAnalysisPaths caseRuleCall(RuleCall call) {
				if (isParserRuleCall(call) || 
				    isEnumRuleCall(call)
				) {
					return getTokenPaths(call.getRule().getAlternatives(), prefix, false, false, shortcutEndlessLoops);
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
	private TokenAnalysisPaths getTokenPaths(
			AbstractElement path, TokenAnalysisPaths prefix, boolean analyseContext, boolean needsLength, boolean shortcutEndlessLoops
	) {
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
				result = getTokenPathsContext(path, prefix, shortcutEndlessLoops);
			} else if (needsLength) {
				throw new TokenAnalysisAbortedException("token expected but path is optional");
			} else {
				result = new TokenAnalysisPaths(prefix);
			}
		} else {
			result = TokenAnalysisPaths.empty(prefix);
		}
		
		boolean loop = isMultipleCardinality(path);
		
		int currentMinPosition = result.getMinPosition();
		
		do {
			result.resetProgress();
			TokenAnalysisPaths tokenPaths = getTokenPathsTrivial(path, result, shortcutEndlessLoops);
			
			if (tokenPaths.isDone()) {
				result = result.merge(tokenPaths);
				break;
			} else if (analyseContext) {
				tokenPaths = getTokenPathsContext(path, tokenPaths, shortcutEndlessLoops);
				result = result.merge(tokenPaths);
			} else if (needsLength) {
				throw new TokenAnalysisAbortedException("requested length not satisfyable");
			} else {
				result = result.merge(tokenPaths);
			}
			
			if (loop) {
				if (result.getMinPosition() == currentMinPosition) {
					// endless loop
					// result will never be done since there is no progress to the shortest path
					if (shortcutEndlessLoops) {
						if (!result.hasProgress()) {
							// no progress
							// abort endless loop
							break;
						} else {
							// there is still some progress done
							continue;
						}
					} else {
						throw new TokenAnalysisAbortedException("no progress in loop");
					}
				} else {
					currentMinPosition = result.getMinPosition();
				}
			}
		} while (loop);
		
		return result;
	}
	
	private List<List<Token>> getTokenPaths(AbstractElement path, List<Integer> indexes, boolean analyseContext) throws TokenAnalysisAbortedException {
		return getTokenPaths(path, new TokenAnalysisPaths(indexes), analyseContext, true, false).getTokenPaths();
	}
	
	private List<List<Token>> getTokenPathsContextOnly(AbstractElement path, List<Integer> indexes) {
		return getTokenPathsContext(path, new TokenAnalysisPaths(indexes), false).getTokenPaths();
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
		if (config.isDebug()) {
			log.info("path1: " + abstractElementToString(path1));
			log.info("path2: " + abstractElementToString(path2));
		}
		
		int i;
		// + 1, because otherwise identical paths of length token limit can't be checked
		int limit = config.getTokenLimit() + 1;
		for (i = 0; i < limit; i++) {
			TokenAnalysisPaths tokenPaths1;
			TokenAnalysisPaths tokenPaths2;
			
			List<Integer> range = range(0,  i);
			
			// there shouldn't be a TokenAnalysisAbortedException if needsLength is false
			tokenPaths1 = getTokenPaths(path1, new TokenAnalysisPaths(range), false, false, false);
			tokenPaths2 = getTokenPaths(path2, new TokenAnalysisPaths(range), false, false, false);
			
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
			// path length exhausted while searching for minimal differences
			// this indicates nested prefix alternatives
			throw new NestedPrefixAlternativesException();
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
			
			// no context analysis // TODO why?
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
		

		if (config.isDebug()) {
			paths.forEach(p -> {
				log.info("\n" + abstractElementToString(p));
			});
		}
		
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
	
	public List<List<AbstractElement>> getAllPossiblePaths(AbstractElement path) {
		// token limit + 2 so identity analysis will recognize paths that are identical up to the token limit on the flattened tree
		return getTokenPaths(path, new TokenAnalysisPaths(range(0, config.getTokenLimit() + 2)), false, false, true)
				.getTokenPaths()
				.stream()
				.map(l -> l.stream()
					.map(Token::getElement)
					.collect(Collectors.toList()))
				.collect(Collectors.toList());
				
	}
}
