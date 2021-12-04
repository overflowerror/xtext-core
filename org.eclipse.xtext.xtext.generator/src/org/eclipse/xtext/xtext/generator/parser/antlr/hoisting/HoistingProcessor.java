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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.AbstractSemanticPredicate;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.JavaAction;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.util.Tuples;
import static org.eclipse.xtext.GrammarUtil.*;

import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.OptionalCardinalityWithoutContextException;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.TokenAnalysisAbortedException;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.UnsupportedConstructException;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.AlternativeTokenSequenceGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.AlternativesGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.GroupGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.Guard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.HoistingGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.MergedPathGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.PathGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.PredicateGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.SingleTokenGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.TokenGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.TokenSequenceGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.pathAnalysis.TokenAnalysis;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.token.Token;
import static org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils.DebugUtils.*;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils.StreamUtils;

/**
 * @author overflow - Initial contribution and API
 */
public class HoistingProcessor {
	private Map<String, HoistingGuard> ruleCache = new HashMap<>();
	private Map<Group, HoistingGuard> groupCache = new HashMap<>();
	
	private Logger log = Logger.getLogger(this.getClass());
	
	private HoistingConfiguration config = new HoistingConfiguration();
	private TokenAnalysis analysis;
	
	public HoistingProcessor() {
		analysis = new TokenAnalysis(config);
	}
	
	// TODO: handling for TokenAnalysisAbortedException
	private HoistingGuard findGuardForAlternatives(CompoundElement alternatives, AbstractRule currentRule) {
		log.info("find guard for alternative");
		
		List<AbstractElement> paths = new ArrayList<>(alternatives.getElements());
		List<MergedPathGuard> guards = paths.stream()
				.map(p -> findGuardForElement(p, currentRule))
				.map(MergedPathGuard::new)
				.collect(Collectors.toList());
		
		if (guards.stream().allMatch(Guard::isTrivial)) {
			// all paths are trivial
			
			// if there is a terminal on all branches set has terminal to true
			// else we need might need to consider the following tokens in the path
			if (guards.stream().allMatch(HoistingGuard::hasTerminal)) {
				return HoistingGuard.terminal();
			} else {
				return HoistingGuard.unguarded();
			}
		}

		log.info("path identity check");
		int size = paths.size();
		try {
			for (int i = 0; i < size; i++) {
				for (int j = i + 1; j < size; j++) {
					if (analysis.arePathsIdentical(paths.get(i), paths.get(j))) {
						guards.get(i).add(guards.get(j));
						
						paths.remove(j);
						guards.remove(j);
						j--;
						size--;
					}
				}
			}
		} catch (TokenAnalysisAbortedException e) {
			throw new TokenAnalysisAbortedException(e.getMessage(), e, currentRule);
		}
		
		log.info("paths:" + paths);
		
		log.info("minimal path difference");
		
		// if all paths are empty the above step will eliminate all paths
		// -> size = 1
		if (size > 1) {
			try {
				return StreamUtils.zip(
					analysis.findMinimalPathDifference(paths).stream()
						.map(a -> a.stream()
							.map(s -> s.stream()
									.map(SingleTokenGuard::new)
									.collect(Collectors.toList())
							)
							.map(TokenSequenceGuard::new)
							.collect(Collectors.toList())
						)
						.map(AlternativeTokenSequenceGuard::new),
					guards.stream(),
					(TokenGuard tokenGuard, MergedPathGuard pathGuard) -> Tuples.pair(tokenGuard, pathGuard)
				).map(p -> new PathGuard(p.getFirst(), p.getSecond()))
				.collect(AlternativesGuard.collector());
			} catch(TokenAnalysisAbortedException e) {
				throw new TokenAnalysisAbortedException(e.getMessage(), e, currentRule);
			}
		} else {
			return guards.get(0);
		}
	}
	
	private List<AbstractElement> rewriteUnorderedGroupsAndGetElements(Group group) {
		List<AbstractElement> elements = new ArrayList<>(group.getElements());
		
		int size = elements.size();
		for (int i = 0; i < size; i++) {
			AbstractElement element = elements.get(i);
			if (element instanceof UnorderedGroup) {
				// Unordered group (A & B) is the same as (A | B)+ or (A | B)* (is A and B are optional)
				// -> create virtual element
				
				Alternatives virtualAlternatives = XtextFactory.eINSTANCE.createAlternatives();
				addElementsToCompoundElement(virtualAlternatives, ((UnorderedGroup) element).getElements());
				
				// if A and B are optional the cardinality would be *
				// but it doesn't matter for hoisting
				virtualAlternatives.setCardinality("+");
				
				elements.set(i, virtualAlternatives);
			}
		}
		
		return elements;
	}
	
	private HoistingGuard findGuardForGroup(Group group, AbstractRule currentRule) {
		log.info("find guard for group");
		
		GroupGuard groupGuard = new GroupGuard();
		
		Iterator<AbstractElement> iterator = rewriteUnorderedGroupsAndGetElements(group).iterator();
		while (iterator.hasNext()) {
			AbstractElement element = iterator.next();
			
			String cardinality = element.getCardinality();
			if (cardinality == null ||
			    cardinality.equals("") ||
			    cardinality.equals("+")) {
				
				HoistingGuard guard = findGuardForElementWithTrivialCardinality(element, currentRule);
				groupGuard.add(guard);
				
				// if cardinality is + and there is a terminal we don't need to consider
				// the following elements
				// if cardinality is + and there is no token the guard won't change even if the
				// element could be repeated
				if (guard.hasTerminal()) {
					groupGuard.setHasTerminal();
					break;
				}
			} else if (cardinality.equals("?") ||
			           cardinality.equals("*")) {
				// rewrite cardinality to alternatives
				// A? B -> A B | B
				// A* B -> A+ B | B -> A B (see above)
				
				// we need a clone of the element because we need to set the cardinality without changing the
				// original syntax tree
				AbstractElement clonedElement = cloneAbstractElement(element);
				clonedElement.setCardinality(null);
				
				// make copy of every element because we can't use any element twice
				List<AbstractElement> remainingElementsInGroup = StreamUtils.fromIterator(iterator)
						.collect(Collectors.toList());
				
				if (remainingElementsInGroup.isEmpty()) {
					// B is empty
					// context is needed to generate virtual alternatives
					throw new OptionalCardinalityWithoutContextException("no context in group", currentRule);
				}
				
				// make copy of first branch and add the cloned element
				List<AbstractElement> remainingElementsInGroupIncludingCurrent = new LinkedList<>(remainingElementsInGroup);
				remainingElementsInGroupIncludingCurrent.add(0, clonedElement);
						
				Group virtualPathRemaining = XtextFactory.eINSTANCE.createGroup();
				addElementsToCompoundElement(virtualPathRemaining, remainingElementsInGroup);
				
				Group virtualPathRemainingPlusCurrent = XtextFactory.eINSTANCE.createGroup();
				addElementsToCompoundElement(virtualPathRemainingPlusCurrent, remainingElementsInGroupIncludingCurrent);
				
				Alternatives virtualAlternatives = XtextFactory.eINSTANCE.createAlternatives();
				addElementsToCompoundElement(virtualAlternatives, Arrays.asList(virtualPathRemaining, virtualPathRemainingPlusCurrent));
				
				// get Guard for virtual alternatives
				HoistingGuard guard = findGuardForElementWithTrivialCardinality(virtualAlternatives, currentRule);
				groupGuard.add(guard);
				
				if (guard.hasTerminal()) {
					groupGuard.setHasTerminal();
				}
				
				// following elements are included in alternative, no need to check further
				break;
			} else {
				throw new IllegalArgumentException("unknown cardinality: " + cardinality);
			}
		}
		
		return groupGuard;
	}
	
	// TODO: make private
	public HoistingGuard findGuardForRule(AbstractRule rule) {
		log.info("finding guard for rule: " + rule.getName());
		HoistingGuard guard = ruleCache.get(rule.getName());
		if (guard == null) {
			log.info("not in cache");
			guard = findGuardForElement(rule.getAlternatives(), rule);
			ruleCache.put(rule.getName(), guard);
		}
		return guard;
	}
	
	private boolean pathHasTokenOrAction(AbstractElement path) {
		// we are only interested in whether or not there could be any tokens on this path
		// -> ignore cardinality
		
		if (Token.isToken(path)) {
			return true;
		} else if (isEnumRuleCall(path)) {
			return true;
		} else if (path instanceof JavaAction) {
			return true;
		} else if (isParserRuleCall(path)) {
			// can not be self recursive since ANTLR uses LL(*) and therefore does not support left recursion
			return pathHasTokenOrAction(((RuleCall) path).getRule().getAlternatives());
		} else if (path instanceof Assignment) {
			return pathHasTokenOrAction(((Assignment) path).getTerminal());
		} else if (path instanceof CompoundElement) {
			return ((CompoundElement) path).getElements().stream()
					.anyMatch(this::pathHasTokenOrAction);
		} else {
			// Actions, Predicates, ...
			return false;
		}
	}
	
	@SuppressWarnings("unused")
	private boolean pathHasHoistablePredicate(AbstractElement path) {
		// we are only interested in whether or not there could be any hoistable predicate on this path
		// -> ignore cardinality
		
		if (path instanceof AbstractSemanticPredicate) {
			return true;
		} else if (isParserRuleCall(path)) {
			// can not be self recursive since ANTLR uses LL(*) and therefore does not support left recursion
			return pathHasHoistablePredicate(((RuleCall) path).getRule().getAlternatives());
		} else if (path instanceof Assignment) {
			return pathHasHoistablePredicate(((Assignment) path).getTerminal());
		} else if (path instanceof Alternatives ||
		           path instanceof UnorderedGroup) {
			return ((CompoundElement) path).getElements().stream()
					.anyMatch(this::pathHasHoistablePredicate);
		} else if (path instanceof Group) {
			for (AbstractElement element : ((CompoundElement) path).getElements()) {
				if (pathHasHoistablePredicate(element)) {
					return true;
				}
				if (pathHasTokenOrAction(element)) {
					return false;
				}
			}
			return false;
		} else {
			// Tokens, EnumRule, Actions, JavaActions, ...
			return false;
		}
	}
	
	public HoistingGuard findHoistingGuard(AbstractElement element) {
		log.info("hoisting guard of: \n" + abstractElementToString(element));
		// should only be called for valid AST elements, so element can never be floating
		return findGuardForElement(element, containingParserRule(element));
	}
	
	private HoistingGuard findGuardForElement(AbstractElement element, AbstractRule currentRule) {
		if (isTrivialCardinality(element)) {
			return findGuardForElementWithTrivialCardinality(element, currentRule);
		} else if (isOneOrMoreCardinality(element)) {
			return findGuardForElementWithTrivialCardinality(element, currentRule);
		} else if (isOptionalCardinality(element)) {
			if (pathHasTokenOrAction(element)) {
				// there might be a token in this element
				// no context accessible to construct guard
				// this does only work when analyzing group
				
				// TODO: maybe generate warning and return terminal()
				throw new OptionalCardinalityWithoutContextException("optional cardinality is only supported in groups", currentRule);
			} else {
				// element with cardinality ? or * has no token or action
				// -> the path is accessible whether or not this element is guarded
				// -> we can assume it is unguarded
				return HoistingGuard.unguarded();
			}
		} else {
			throw new IllegalArgumentException("unknown cardinality: " + element.getCardinality());
		}
	}
	
	private HoistingGuard findGuardForElementWithTrivialCardinality(AbstractElement element, AbstractRule currentRule) {
		log.info(currentRule.getName() + ": " + abstractElementToShortString(element));
		
		if (element instanceof Alternatives) {
			return findGuardForAlternatives((Alternatives) element, currentRule);
		} else if (element instanceof Group) {
			HoistingGuard guard = groupCache.get(element);
			if (guard == null) {
				guard = findGuardForGroup((Group) element, currentRule);
				groupCache.put((Group) element, guard);
			}
			return guard;
		} else if (element instanceof AbstractSemanticPredicate) {
			return new PredicateGuard((AbstractSemanticPredicate) element);
		} else if (Token.isToken(element)) {
			return HoistingGuard.terminal();
		} else if (isParserRuleCall(element) ||
		           isEnumRuleCall(element)) {
			RuleCall call = (RuleCall) element;
			return findGuardForRule(call.getRule());
		} else if (element instanceof Action) {
			return HoistingGuard.unguarded();
		} else if (element instanceof JavaAction) {
			return HoistingGuard.action();
		} else if (element instanceof UnorderedGroup) {
			if (((UnorderedGroup) element).getElements().stream().allMatch(GrammarUtil::isOptionalCardinality)) {
				if (pathHasTokenOrAction(element)) {
					// if unordered group has tokens or actions we need the context which is not available here
					// only works when analyzing groups
					
					// TODO: maybe add warning and return unguarded
					throw new UnsupportedConstructException("unordered groups with hoisting-relevant elements and optional cardinalities are only supported in groups", currentRule);
				} else {
					// the path is accessible whether or not any guard is satisfied
					// -> assume it's unguarded
					return HoistingGuard.unguarded();
				}
			} else {
				if (pathHasTokenOrAction(element)) {
					// there is no context but it might still be possible to find a guard for this group
					// only works if none of the paths is empty or optional
					return findGuardForAlternatives((CompoundElement) element, currentRule);
				} else {
					// the path is accessible whether or not any guard is satisfied
					// -> assume it's unguarded
					return HoistingGuard.unguarded();
				}
			}
		} else if (element instanceof Assignment) {
			return findGuardForElement(((Assignment) element).getTerminal(), currentRule);
		} else {
			throw new UnsupportedConstructException("element not supported: " + element.toString(), currentRule);
		}
	}
}
