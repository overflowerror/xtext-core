/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.AbstractSemanticPredicate;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils.StreamUtils;

/**
 * @author overflow - Initial contribution and API
 */
public class HoistingProcessor {
	private Map<String, HoistingGuard> ruleCache = new ConcurrentHashMap<>();
	private Map<Group, HoistingGuard> groupCache = new ConcurrentHashMap<>();
	
	private Logger log = Logger.getLogger(this.getClass());
	
	private static final int TOKEN_ANALYSIS_LIMIT = 10;
	
	private boolean isParserRule(AbstractElement element) {
		return (element instanceof RuleCall) && (((RuleCall) element).getRule() instanceof ParserRule);
	}
	
	private boolean cardinalityAllowsEmpty(AbstractElement element) {
		String cardinality = element.getCardinality();
		return cardinality != null && (cardinality.equals("?") || cardinality.equals("*"));
	}
	
	private boolean cardinalityAllowsRepetition(AbstractElement element) {
		String cardinality = element.getCardinality();
		return cardinality != null && (cardinality.equals("+") || cardinality.equals("*"));
	}
	
	private TokenAnalysisPaths getTokenForIndexesAlternatives(Alternatives path, TokenAnalysisPaths prefix, boolean needsLength) throws TokenAnalysisAbortedException {
		if (prefix.isDone()) {
			return prefix;
		}
		
		TokenAnalysisPaths result;
		if (cardinalityAllowsEmpty(path)) {
			result = prefix;
			if (needsLength) {
				// analysis is not done but there are no more mandatory tokens
				throw new TokenAnalysisAbortedException();
			}
		} else {
			result = TokenAnalysisPaths.empty(prefix);
		}
		
		boolean loop = cardinalityAllowsRepetition(path);
		
		do {
			boolean allDone = true;
			
			for (AbstractElement element : path.getElements()) {
				TokenAnalysisPaths current = new TokenAnalysisPaths(prefix);
				current = getTokenForIndexes(element, current, needsLength); // will check for needsLength
				
				if (!current.isDone()) {
					allDone = false;
				}
				
				result = result.merge(current);
			}
			
			if (allDone) {
				break;
			}
			
			prefix = result;
			
			// repeat until all further extensions of prefix are done 
		} while(loop);
	
		return result;
	}
	
	private TokenAnalysisPaths getTokenForIndexesGroup(Group path, TokenAnalysisPaths prefix, boolean needsLength) throws TokenAnalysisAbortedException {
		if (prefix.isDone()) {
			return prefix;
		}
		
		TokenAnalysisPaths result; 
		TokenAnalysisPaths current = new TokenAnalysisPaths(prefix);
		
		if (cardinalityAllowsEmpty(path)) {
			result = prefix;
			if (needsLength) {
				// analysis is not done but there are no more mandatory tokens
				throw new TokenAnalysisAbortedException();
			}
		} else {
			result = TokenAnalysisPaths.empty(prefix);
		}
		
		boolean loop = cardinalityAllowsRepetition(path);
		
		log.info("group: " + prefix);
		
		do {
			for (AbstractElement element : path.getElements()) {
				current = getTokenForIndexes(element, current, false);
				
				if (current.isDone()) {
					// no need to look further
					
					log.info("done: " + current);
					
					return result.merge(current);
				}
			}
			
			if (needsLength && !current.isDone()) {
				// analysis is not done but there are no more mandatory tokens
				throw new TokenAnalysisAbortedException();
			}
			
			result = result.merge(current);
			current = new TokenAnalysisPaths(result);
		} while(loop);
		
		// if cardinality is trivial or ? return result
		return result;
	}
	
	private TokenAnalysisPaths getTokenForIndexesDefault(AbstractElement path, TokenAnalysisPaths prefix, boolean needsLength) throws TokenAnalysisAbortedException {
		if (prefix.isDone()) {
			return prefix;
		}
		
		TokenAnalysisPaths result;
		
		if (cardinalityAllowsEmpty(path)) {
			result = prefix;
			if (needsLength) {
				throw new TokenAnalysisAbortedException();
			}
		} else {
			result = TokenAnalysisPaths.empty(prefix);
		}
		
		TokenAnalysisPaths current = new TokenAnalysisPaths(prefix);
		
		boolean loop = cardinalityAllowsRepetition(path);
		do {
			if (Token.isToken(path)) {
				current.add(path);
			} else if (isParserRule(path)) {
				// path doesn't need length, because we're going to check that anyway in this function
				current = getTokenForIndexes(((RuleCall) path).getRule().getAlternatives(), current, false);
			} else if (path instanceof Assignment) {
				current = getTokenForIndexes(((Assignment) path).getTerminal(), current, false);
			} else {
				throw new IllegalArgumentException("unknown element: " + path.eClass().getName());
			}
			
			result = result.merge(current);
			
			if (current.isDone()) {
				return result;
			}
			
			if (needsLength) {
				throw new TokenAnalysisAbortedException();
			}
		} while(loop);
		
		return result;
	}
	
	private TokenAnalysisPaths getTokenForIndexes(AbstractElement path, TokenAnalysisPaths prefix, boolean needsLength) throws TokenAnalysisAbortedException {
		if (path instanceof Alternatives) {
			return getTokenForIndexesAlternatives((Alternatives) path, prefix, needsLength);
		} else if (path instanceof Group) {
			return getTokenForIndexesGroup((Group) path, prefix, needsLength);
		} else if (path instanceof Action ||
		           path instanceof AbstractSemanticPredicate
				) {
			// TODO: make sure empty token analysis paths don't cause problems down the line
			return TokenAnalysisPaths.empty(prefix);
		} else {
			return getTokenForIndexesDefault(path, prefix, needsLength);
		}
	}
	
	private Set<List<Token>> getTokenForIndexes(AbstractElement path, List<Integer> indexes) throws TokenAnalysisAbortedException {
		return getTokenForIndexes(path, new TokenAnalysisPaths(indexes), true).getTokenPaths();
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
		for (int i = 0; i < TOKEN_ANALYSIS_LIMIT; i++) {
			Set<List<Token>> tokenListSet1;
			Set<List<Token>> tokenListSet2;
			
			List<Integer> range = range(0,  i);
			
			try {
				tokenListSet1 = getTokenForIndexes(path1, range);
			} catch (TokenAnalysisAbortedException e) {
				tokenListSet1 = null;
			}
			
			try {
				tokenListSet2 = getTokenForIndexes(path2, range);
			} catch (TokenAnalysisAbortedException e) {
				tokenListSet2 = null;
			}
			
			if (tokenListSet1 == null && tokenListSet2 == null) {
				return true;
			}
			if (tokenListSet1 == null || tokenListSet2 == null) {
				// the paths have different length
				return false;
			}
			if (!tokenListSet1.equals(tokenListSet2)) {
				// TODO: hashCode method of Token classes
				return false;
			}
		}
		
		// we can't analyze the paths any further
		// we can assume that the paths are identical because the path diff analysis would cause an error anyway.
		// TODO maybe warning?
		return true;
	}
	
	private boolean arePathsIdentical(AbstractElement path1, AbstractElement path2) {
		try {
			return arePathsIdenticalSymbolic(path1, path2);
		} catch (SymbolicAnalysisFailedException e) {
			return arePathsIdenticalFallback(path1, path2);
		}
	}
	
	
	private void tokenCombinations(Function<List<Integer>, Boolean> callback) {
		for (int i = 1; i <= TOKEN_ANALYSIS_LIMIT; i++) {
			if (tokenCombinations(0, 0, i, callback)) {
				return;
			}
		}
	}
	private boolean tokenCombinations(long prefix, int prefixLength, int ones, Function<List<Integer>, Boolean> callback) {
		if (ones == 0) {
			List<Integer> indexes = new ArrayList<>(TOKEN_ANALYSIS_LIMIT);
			for (int i = 0; i < TOKEN_ANALYSIS_LIMIT; i++) {
				if ((prefix & (1 << i)) > 0) {
					indexes.add(i);
				}
			}
			return callback.apply(indexes);
		} else if (prefixLength + ones > TOKEN_ANALYSIS_LIMIT) {
			// prefix is too long
			return false;
		} else {
			for (int i = prefixLength; i < TOKEN_ANALYSIS_LIMIT - ones + 1; i++) {
				long current = prefix | (1 << i);
				if (tokenCombinations(current, i + 1, ones - 1, callback)) {
					return true;
				}
			}
			return false;
		}
	}
	
	private List<Set<List<Token>>> findMinimalPathDifference(List<AbstractElement> paths) throws TokenAnalysisAbortedException {
		List<Set<List<Token>>> result = paths.stream()
				.map(p -> (Set<List<Token>>) null)
				.collect(Collectors.toList());
		
		tokenCombinations(indexList -> {
			log.info("current index list: " + indexList);
			
			// will throw TokenAnalysisAborted if any path is too short
			// TODO: when TokenAnalysisAborted, add new index
			List<Set<List<Token>>> tokenListSets = paths.stream()
					.peek(p -> log.info("next path: " + p))
					.map(p -> getTokenForIndexes(p, indexList))
					.collect(Collectors.toList());

			log.info("sets: " + tokenListSets);
			
			int size = result.size();
			for (int i = 0; i < size; i++) {
				if (result.get(i) != null) {
					continue;
				}
				
				Set<List<Token>> tokenListSet = tokenListSets.get(i);
				if (!tokenListSet.stream()
					.anyMatch(tokenList -> tokenListSets.stream()
							.filter(s -> s != tokenListSet)
							.anyMatch(s -> s.contains(tokenList))
					)
				) {
					log.info("set:  " + tokenListSet);
					// token list set is unique for path i
					result.set(i, tokenListSet);
				}
				
			}
			
			log.info(result);
			
			return result.stream()
					.allMatch(Objects::nonNull);
		});
		
		return result;
	}
	
	// TODO: handling for TokenAnalysisAbortedException
	// TODO: skip if all guards are trivial
	private HoistingGuard findGuardForAlternatives(Alternatives alternatives) {
		log.info("find guard for alternative");
		
		List<AbstractElement> paths = alternatives.getElements();
		List<MergedPathGuard> guards = paths.stream()
				.map(this::findGuardForElement)
				.map(MergedPathGuard::new)
				.collect(Collectors.toList());
		
		log.info("path identity check");
		int size = paths.size();
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				if (arePathsIdentical(paths.get(i), paths.get(j))) {
					guards.get(i).add(guards.get(j));
					
					paths.remove(j);
					guards.remove(j);
					j--;
					size--;
				}
			}
		}
		
		log.info("paths:" + paths);
		
		log.info("minimal path difference");
		
		// if all paths are empty the above step will eliminate all paths
		// -> size = 1
		if (size > 1) {
			return StreamUtils.zip(
				findMinimalPathDifference(paths).stream()
					.map(a -> a.stream()
						.map(s -> s.stream()
								.map(SingleTokenGuard::new)
								.collect(Collectors.toList())
						)
						.map(TokenSequenceGuard::new)
						.collect(Collectors.toSet())
					)
					.map(AlternativeTokenSequenceGuard::new),
				guards.stream(),
				(TokenGuard tokenGuard, MergedPathGuard pathGuard) -> Tuples.pair(tokenGuard, pathGuard)
			).map(p -> new PathGuard(p.getFirst(), p.getSecond()))
			.collect(AlternativesGuard.collector());
		} else {
			return guards.get(0);
		}
	}
	
	private HoistingGuard findGuardForGroup(Group group) {
		log.info("find guard for group");
		
		GroupGuard groupGuard = new GroupGuard();
		
		for (AbstractElement element : group.getElements()) {
			// TODO: findGuardForElement doesn's support non-trivial cardinalities
			HoistingGuard guard = findGuardForElement(element);
			groupGuard.add(guard);
			
			if (guard.hasTerminal()) {
				groupGuard.setHasTerminal();
				break;
			}
		}
		
		return groupGuard;
	}
	
	public HoistingGuard findGuardForRule(ParserRule rule) {
		return ruleCache.computeIfAbsent(rule.getName(), s -> findGuardForElement(rule.getAlternatives()));
	}
	
	public HoistingGuard findGuardForElement(AbstractElement element) {
		log.info("finding guard for element: " + element.toString());
		
		if (element instanceof Alternatives) {
			return findGuardForAlternatives((Alternatives) element);
		} else if (element instanceof Group) {
			return groupCache.computeIfAbsent((Group) element, this::findGuardForGroup);
		} else if (element instanceof AbstractSemanticPredicate) {
			return new PredicateGuard((AbstractSemanticPredicate) element);
		} else if (element instanceof Keyword) {
			return HoistingGuard.terminal();
		} else if (element instanceof RuleCall) {
			RuleCall call = (RuleCall) element;
			AbstractRule rule = call.getRule();
			if (rule instanceof TerminalRule || rule instanceof EnumRule) {
				return HoistingGuard.terminal();
			} else {
				// rule is parser rule
				// TODO: check for enum rules
				// TODO: findGuardForElement can't deal with cardinalities
				return findGuardForRule((ParserRule) rule);
			}
		} else if (element instanceof Action) {
			// TODO: Maybe find better indicator for "we don't care about this element"
			return HoistingGuard.unguarded();
		} else if (element instanceof UnorderedGroup) {
			// TODO: No support for Unordered Groups yet.
			throw new UnsupportedOperationException("unordered groups are not yet supported");
		} else if (element instanceof Assignment) {
			// TODO: findGuardForElement can't deal with cardinalities
			return findGuardForElement(((Assignment) element).getTerminal());
		} else {
			throw new UnsupportedOperationException("element not supported: " + element.toString());
		}
	}
}
