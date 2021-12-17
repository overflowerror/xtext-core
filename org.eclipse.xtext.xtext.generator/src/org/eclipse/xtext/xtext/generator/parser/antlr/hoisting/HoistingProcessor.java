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

import static org.eclipse.emf.ecore.util.EcoreUtil.*;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.AbstractSemanticPredicate;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.JavaAction;
import org.eclipse.xtext.JavaCode;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.util.Tuples;

import static org.eclipse.xtext.GrammarUtil.*;

import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.NestedPrefixAlternativesException;
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
	
	public void init(Grammar grammar) {
		analysis = new TokenAnalysis(config, grammar);
	}
	
	private HoistingGuard findGuardForOptionalCardinalityWithoutContext(AbstractElement element, AbstractRule currentRule) {
		HoistingGuard pathGuard = findGuardForElementWithTrivialCardinality(element, currentRule);
		
		if (pathGuard.isTrivial()) {
			// path can be skipped
			return HoistingGuard.unguarded();
		}
		
		// set cardinality so the token analyse works
		element = copy(element);
		if (isMultipleCardinality(element)) {
			element.setCardinality("+");
		} else {
			// would be ? cardinality
			element.setCardinality(null);
		}
		
		// identity analysis can be skipped
		
		try {
			return new AlternativesGuard(
				new PathGuard(
					new AlternativeTokenSequenceGuard(
						analysis.findMinimalPathDifference(element).stream()
							.map(s -> s.stream()
									.map(SingleTokenGuard::new)
									.collect(Collectors.toList())
							)
							.map(TokenSequenceGuard::new)
							.collect(Collectors.toList())
					),
					pathGuard
				)
			);
		} catch(TokenAnalysisAbortedException e) {
			throw new TokenAnalysisAbortedException(e.getMessage(), e, currentRule);
		}
	}

	private AbstractElement getNopElement() {
		JavaCode virtualJavaCodeForAction = XtextFactory.eINSTANCE.createJavaCode();
		virtualJavaCodeForAction.setSource("$$ /* nop */ $$");
		
		JavaAction virtualNopJavaAction = XtextFactory.eINSTANCE.createJavaAction();
		virtualNopJavaAction.setCode(virtualJavaCodeForAction);
		
		return virtualNopJavaAction;
	}
	
	private CompoundElement flattenPaths(CompoundElement original, List<AbstractElement> paths, List<? extends HoistingGuard> guards) {
		// work on copy of original to preserve eParent
		CompoundElement flattened = copy(original);
		setElementsOfCompoundElement(flattened,
			StreamUtils.zip(
				paths.stream()
					.map(analysis::getAllPossiblePaths),
				guards.stream()
					.map(HoistingGuard.class::cast),
				(List<List<AbstractElement>> e, HoistingGuard g) -> Tuples.pair(e, g)
			).filter(t -> t.getFirst() != null)
			.flatMap(t -> {
				HoistingGuard guard = t.getSecond();
				
				// we can reuse objects since setElementsOfCompundElement
				// will create copy anyway
				AbstractElement nop = getNopElement();
				AbstractSemanticPredicate renderedVirtualPredicate;
				
				if (!guard.isTrivial()) {
					JavaCode virtualJavaCodeForPredicate = XtextFactory.eINSTANCE.createJavaCode();
					virtualJavaCodeForPredicate.setSource("$$ " + guard.render() + " $$");
				
					renderedVirtualPredicate = XtextFactory.eINSTANCE.createGatedSemanticPredicate();
					renderedVirtualPredicate.setCode(virtualJavaCodeForPredicate);
				} else {
					renderedVirtualPredicate = null;
				}
				
				return t.getFirst()
					.stream()
					.map(a -> {
						List<AbstractElement> groupElements = new ArrayList<>(a.size() + 2);
						
						if (renderedVirtualPredicate != null) {
							groupElements.add(renderedVirtualPredicate);
						}

						// virtual action to prevent hoisting
						groupElements.add(nop);
						
						groupElements.addAll(a);


						Group virtualGroup = XtextFactory.eINSTANCE.createGroup();
						setElementsOfCompoundElement(virtualGroup, groupElements);
								
						return virtualGroup;
					});
			})
		);
		return flattened;
	}
	
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
			} catch(NestedPrefixAlternativesException e) {
				// nested prefix alternatives
				// -> flatten paths to alternative and try again
				// this is very inefficient
				log.warn("nested prefix alternatives detected");
				log.warn("avoid these since they can't be handled efficiency");
				log.info(abstractElementToString(alternatives));
				
				CompoundElement flattened = flattenPaths(alternatives, paths, guards);
				log.info(abstractElementToString(flattened));
				
				return findGuardForAlternatives(flattened, currentRule);
			} catch(TokenAnalysisAbortedException e) {
				throw new TokenAnalysisAbortedException(e.getMessage(), e, currentRule);
			}
		} else {
			return guards.get(0);
		}
	}
	
	private HoistingGuard findGuardForUnorderedGroup(UnorderedGroup element, AbstractRule currentRule) {
		// Unordered group (A & B) is the same as (A | B)+ or (A | B)* (is A and B are optional)
		// but the cardinality doesn't matter for hoisting
		// if A and B are optional the guard for the alternatives need to check the context
		// if not the alternatives are actual alternatives
		
		// TODO: check if hasTerminal is valid
		
		return findGuardForAlternatives(element, currentRule);
	}
	
	private HoistingGuard findGuardForGroup(Group group, AbstractRule currentRule) {
		log.info("find guard for group");
		
		GroupGuard groupGuard = new GroupGuard();
		
		Iterator<AbstractElement> iterator = group.getElements().iterator();
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
				// though not technically necessary, rewrite tree to context checks are not needed 
				
				// rewrite cardinality to alternatives
				// A? B -> A B | B
				// A* B -> A+ B | B -> A B (see above)
				
				// we need a clone of the element because we need to set the cardinality without changing the
				// original syntax tree
				AbstractElement clonedElement = copy(element);
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
				setElementsOfCompoundElement(virtualPathRemaining, remainingElementsInGroup);
				
				Group virtualPathRemainingPlusCurrent = XtextFactory.eINSTANCE.createGroup();
				setElementsOfCompoundElement(virtualPathRemainingPlusCurrent, remainingElementsInGroupIncludingCurrent);
				
				Alternatives virtualAlternatives = XtextFactory.eINSTANCE.createAlternatives();
				setElementsOfCompoundElement(virtualAlternatives, Arrays.asList(virtualPathRemaining, virtualPathRemainingPlusCurrent));
				
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
	
	public HoistingGuard findHoistingGuardIgnoreCardinality(AbstractElement element) {
		log.info("hoisting (trivial) guard of: \n" + abstractElementToString(element));
		// should only be called for valid AST elements, so element can never be floating
		
		AbstractRule rule = containingParserRule(element);
		if (element instanceof UnorderedGroup) {
			return findGuardForAlternatives(((CompoundElement) element), rule);
		} else {
			return findGuardForElementWithTrivialCardinality(element, rule);
		}
	}
	
	public HoistingGuard findHoistingGuard(AbstractElement element) {
		log.info("hoisting guard of: \n" + abstractElementToString(element));
		// should only be called for valid AST elements, so element can never be floating
		return findGuardForElement(element, containingParserRule(element));
	}
	
	private HoistingGuard findGuardForElement(AbstractElement element, AbstractRule currentRule) {
		if (isTrivialCardinality(element) ||
			isOneOrMoreCardinality(element)
		) {
			return findGuardForElementWithTrivialCardinality(element, currentRule);
		} else if (isOptionalCardinality(element)) {
			return findGuardForOptionalCardinalityWithoutContext(element, currentRule);
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
			return findGuardForUnorderedGroup((UnorderedGroup) element, currentRule);
		} else if (element instanceof Assignment) {
			return findGuardForElement(((Assignment) element).getTerminal(), currentRule);
		} else {
			if (!pathHasHoistablePredicate(currentRule.getAlternatives())) {
				// unsupported construct but rule doesn't contain hoistable predicates
				return HoistingGuard.unguarded();
			} else {
				throw new UnsupportedConstructException("element not supported: " + element.toString(), currentRule);
			}
		}
	}
}
