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
import org.eclipse.xtext.AbstractSemanticPredicate;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.JavaAction;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.util.Tuples;
import static org.eclipse.xtext.GrammarUtil.*;

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
	private HoistingGuard findGuardForAlternatives(Alternatives alternatives) {
		log.info("find guard for alternative");
		
		List<AbstractElement> paths = alternatives.getElements();
		List<MergedPathGuard> guards = paths.stream()
				.map(this::findGuardForElement)
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
		
		log.info("paths:" + paths);
		
		log.info("minimal path difference");
		
		// if all paths are empty the above step will eliminate all paths
		// -> size = 1
		if (size > 1) {
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
		} else {
			return guards.get(0);
		}
	}
	
	private HoistingGuard findGuardForGroup(Group group) {
		log.info("find guard for group");
		
		GroupGuard groupGuard = new GroupGuard();
		
		Iterator<AbstractElement> iterator = new ArrayList<>(group.getElements()).iterator();
		while (iterator.hasNext()) {
			AbstractElement element = iterator.next();
			
			String cardinality = element.getCardinality();
			if (cardinality == null ||
			    cardinality.equals("") ||
			    cardinality.equals("+")) {
				
				HoistingGuard guard = findGuardForElementWithTrivialCardinality(element);
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
				HoistingGuard guard = findGuardForElementWithTrivialCardinality(virtualAlternatives);
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
	
	// issue: groupCache can't be Concurrent because of possible recursive calls to computeIfAbent
	// solution: atomic section
	public synchronized HoistingGuard findGuardForRule(ParserRule rule) {
		HoistingGuard guard = ruleCache.get(rule.getName());
		if (guard == null) {
			guard = findGuardForElement(rule.getAlternatives());
			ruleCache.put(rule.getName(), guard);
		}
		return guard;
	}
	
	private boolean pathHasToken(AbstractElement path) {
		// we are only interested in whether or not there could be any tokens on this path
		// -> ignore cardinality
		
		if (Token.isToken(path)) {
			return true;
		} else if (isParserRuleCall(path)) {
			return pathHasToken(((RuleCall) path).getRule().getAlternatives());
		} else if (path instanceof Assignment) {
			return pathHasToken(((Assignment) path).getTerminal());
		} else if (path instanceof Group) {
			return ((Group) path).getElements().stream()
					.anyMatch(this::pathHasToken);
		} else if (path instanceof Alternatives) {
			return ((Alternatives) path).getElements().stream()
					.anyMatch(this::pathHasToken);
		} else {
			// Actions, JavaActions, Predicates, ...
			return false;
		}
	}
	
	public HoistingGuard findGuardForElement(AbstractElement element) {
		String cardinality = element.getCardinality();
		if (cardinality == null || cardinality.equals("")) {
			return findGuardForElementWithTrivialCardinality(element);
		} else if (cardinality.equals("+")) {
			return findGuardForElementWithTrivialCardinality(element);
		} else if (cardinality.equals("?") ||
		           cardinality.equals("*")) {
			if (pathHasToken(element)) {
				// there might be a token in this element
				// no context accessible to construct guard
				// this does only work when analyzing group
				// TODO: generate warning
				// this is not a terminal, but there is no point constructing guards past this point
				return HoistingGuard.terminal();
			} else {
				// element with cardinality ? or * has no token
				// -> we can assume it is unguarded
				return HoistingGuard.unguarded();
			}
		} else {
			throw new IllegalArgumentException("unknown cardinality: " + cardinality);
		}
	}
	
	private HoistingGuard findGuardForElementWithTrivialCardinality(AbstractElement element) {
		log.info("finding guard for element: " + element.toString());
		
		if (element instanceof Alternatives) {
			return findGuardForAlternatives((Alternatives) element);
		} else if (element instanceof Group) {
			// issue: groupCache can't be Concurrent because of possible recursive calls to computeIfAbent
			// solution: atomic section
			synchronized (groupCache) {
				HoistingGuard guard = groupCache.get(element);
				if (guard == null) {
					guard = findGuardForGroup((Group) element);
					groupCache.put((Group) element, guard);
				}
				return guard;
			}
		} else if (element instanceof AbstractSemanticPredicate) {
			return new PredicateGuard((AbstractSemanticPredicate) element);
		} else if (Token.isToken(element)) {
			return HoistingGuard.terminal();
		} else if (isParserRuleCall(element)) {
			RuleCall call = (RuleCall) element;
			return findGuardForRule((ParserRule) call.getRule());
		} else if (element instanceof Action) {
			return HoistingGuard.unguarded();
		} else if (element instanceof JavaAction) {
			return HoistingGuard.action();
		} else if (element instanceof UnorderedGroup) {
			// TODO: No support for Unordered Groups yet.
			throw new UnsupportedOperationException("unordered groups are not yet supported");
		} else if (element instanceof Assignment) {
			return findGuardForElement(((Assignment) element).getTerminal());
		} else {
			throw new UnsupportedOperationException("element not supported: " + element.toString());
		}
	}
}
