/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
public class Hoisting {
	private Map<String, HoistingGuard> ruleCache = new HashMap<>();
	private Map<Group, HoistingGuard> groupCache = new HashMap<>();

	private boolean isParserRule(AbstractElement element) {
		return (element instanceof RuleCall) && (((RuleCall) element).getRule() instanceof ParserRule);
	}
	
	private boolean cardinalityAllowsEmpty(AbstractElement element) {
		String cardinality = element.getCardinality();
		return cardinality.equals("?") || cardinality.equals("*");
	}
	
	private boolean cardinalityAllowsRepetition(AbstractElement element) {
		String cardinality = element.getCardinality();
		return cardinality.equals("+") || cardinality.equals("*");
	}
	
	private TokenAnalysisPaths getTokenForIndexes(Alternatives path, TokenAnalysisPaths prefix, boolean needsLength) throws TokenAnalysisAbortedException {
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
			result = TokenAnalysisPaths.empty();
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
	
	private TokenAnalysisPaths getTokenForIndexes(Group path, TokenAnalysisPaths prefix, boolean needsLength) throws TokenAnalysisAbortedException {
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
			result = TokenAnalysisPaths.empty();
		}
		
		boolean loop = cardinalityAllowsRepetition(path);
		
		do {
			for (AbstractElement element : path.getElements()) {
				current = getTokenForIndexes(element, current, false);
				
				if (current.isDone()) {
					// no need to look further
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
	
	private TokenAnalysisPaths getTokenForIndexes(AbstractElement path, TokenAnalysisPaths prefix, boolean needsLength) throws TokenAnalysisAbortedException {
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
			result = TokenAnalysisPaths.empty();
		}
		
		TokenAnalysisPaths current = new TokenAnalysisPaths(prefix);
		
		boolean loop = cardinalityAllowsRepetition(path);
		do {
			if (Token.isToken(path)) {
				current.add(path);
			} else if (isParserRule(path)) {
				current = getTokenForIndexes(((RuleCall) path).getRule().getAlternatives(), current, false);
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
	
	private Set<List<Token>> getTokenForIndexes(AbstractElement path, List<Integer> indexes) throws TokenAnalysisAbortedException {
		return getTokenForIndexes(path, new TokenAnalysisPaths(indexes), true).getTokenPaths();
	}
	
	private boolean arePathsIdenticalSymbolic(AbstractElement path1, AbstractElement path2) throws SymbolicAnalysisFailedException {
		return false;
	}
	
	private boolean arePathsIdenticalFallback(AbstractElement path1, AbstractElement path2) {
		return false;
	}
	
	private boolean arePathsIdentical(AbstractElement path1, AbstractElement path2) {
		try {
			return arePathsIdenticalSymbolic(path1, path2);
		} catch (SymbolicAnalysisFailedException e) {
			return arePathsIdenticalFallback(path1, path2);
		}
	}
	
	private List<Set<Token>> findMinimalPathDifference(List<AbstractElement> paths) {
		return null;
	}
	
	private HoistingGuard findGuardForAlternatives(Alternatives alternatives) {
		List<AbstractElement> paths = alternatives.getElements();
		List<MergedPathGuard> guards = paths.stream()
				.map(this::findGuardForElement)
				.map(MergedPathGuard::new)
				.collect(Collectors.toList());
		
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
		
		if (size > 1) {
			return StreamUtils.zip(
				findMinimalPathDifference(paths).stream()
					.map(s -> s.stream()
						.map(TokenGuard::new)
						.collect(Collectors.toSet())
					),
				guards.stream(),
				(Set<TokenGuard> tokenSet, MergedPathGuard guard) -> Tuples.pair(tokenSet, guard)
			).map(p -> new PathGuard(p.getFirst(), p.getSecond()))
			.collect(AlternativesGuard.collector());
		} else {
			return guards.get(0);
		}
	}
	
	private HoistingGuard findGuardForGroup(Group group) {
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
	
	private HoistingGuard findGuardForElement(AbstractElement element) {
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
				// TODO: findGuardForElement can't deal with cardinalities
				return ruleCache.computeIfAbsent(rule.getName(), s -> findGuardForElement(rule.getAlternatives()));
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
