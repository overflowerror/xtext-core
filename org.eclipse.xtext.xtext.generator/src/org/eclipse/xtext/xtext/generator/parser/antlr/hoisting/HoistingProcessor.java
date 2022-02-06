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
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import static org.eclipse.emf.ecore.util.EcoreUtil.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.AbstractSemanticPredicate;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.JavaAction;
import org.eclipse.xtext.JavaCode;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.util.Tuples;

import static org.eclipse.xtext.GrammarUtil.*;

import org.eclipse.xtext.xtext.generator.parser.antlr.JavaCodeUtils;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.NestedIdenticalPathException;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.TokenAnalysisAbortedException;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.UnsupportedConstructException;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.Guard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.hoistingGuards.AlternativesGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.hoistingGuards.GroupGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.hoistingGuards.HoistingGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.hoistingGuards.MergedPathGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.hoistingGuards.PathGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.hoistingGuards.PredicateGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.tokenGuards.AlternativeTokenSequenceGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.tokenGuards.SingleTokenGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.tokenGuards.TokenGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.tokenGuards.TokenSequenceGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.pathAnalysis.TokenAnalysis;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.token.Token;
import static org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils.DebugUtils.*;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils.StreamUtils;

import com.google.inject.Singleton;

/**
 * @author overflow - Initial contribution and API
 */
@Singleton
public class HoistingProcessor {
	private Map<String, HoistingGuard> elementCache = new HashMap<>();
	
	private Logger log = Logger.getLogger(this.getClass());
	
	private HoistingConfiguration config;
	private TokenAnalysis analysis;
	
	public void init(Grammar grammar) {
		config = new HoistingConfiguration(grammar);
		analysis = new TokenAnalysis(config, grammar);
	}
	
	private HoistingGuard findGuardForOptionalCardinalityWithoutContext(AbstractElement element, AbstractRule currentRule, boolean skipCache) {
		HoistingGuard pathGuard = findGuardForElementWithTrivialCardinality(element, currentRule, skipCache);
		
		if (pathGuard.isTrivial()) {
			// path can be skipped
			return HoistingGuard.unguarded();
		}
		
		// prepare virtual cardinality
		String cardinality;
		if (isMultipleCardinality(element)) {
			cardinality = "+";
		} else {
			// would be ? cardinality
			cardinality = null;
		}
		
		// identity analysis can be skipped
		
		try {
			return new AlternativesGuard(
				new PathGuard(
					new AlternativeTokenSequenceGuard(
						analysis.findMinimalPathDifference(element, cardinality).stream()
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
			throw new TokenAnalysisAbortedException(e, currentRule);
		}
	}

	private AbstractElement getNopElement() {
		JavaCode virtualJavaCodeForAction = XtextFactory.eINSTANCE.createJavaCode();
		virtualJavaCodeForAction.setSource(JavaCodeUtils.formatCodeForGrammar("/* nop */"));
		
		JavaAction virtualNopJavaAction = XtextFactory.eINSTANCE.createJavaAction();
		virtualNopJavaAction.setCode(virtualJavaCodeForAction);
		
		return virtualNopJavaAction;
	}
	
	private CompoundElement flattenPaths(AbstractElement original, List<AbstractElement> paths, List<? extends HoistingGuard> guards) {
		// we need to preserve parent for context analysis
		// but we are not allowed to change the tree
		// -> clone parent
		EObject clonedParent = copy(original.eContainer());
		CompoundElement flattened = XtextFactory.eINSTANCE.createAlternatives();
		
		if (clonedParent instanceof CompoundElement) {
			setElementsOfCompoundElement((CompoundElement) clonedParent, 
					((CompoundElement) clonedParent).getElements().stream()
						.map(e -> {
							if (e == original) {
								return flattened;
							} else {
								return e;
							}
						}));
		} else {
			EcoreUtil2.setEParent(flattened, clonedParent);
		}
		
		Stream<AbstractElement> pathsStream = paths.stream();
		
		if (original instanceof UnorderedGroup) {
			// in case original element is UnorderedGroup add original after each path
			// so token analysis can fetches all possible paths correctly
			
			pathsStream = pathsStream
				.map(p -> {
					Group virtualGroup = XtextFactory.eINSTANCE.createGroup();
					setElementsOfCompoundElement(virtualGroup, Arrays.asList(p, copy(original)));
					return virtualGroup;
				});
		}
		
		setElementsOfCompoundElement(flattened,
			StreamUtils.zip(
				pathsStream
					.map(analysis::getAllPossiblePaths)
					.map(l1 -> l1.stream()
						.map(l2 -> l2.stream()
							.map(EcoreUtil::copy)
							// remove cardinality; token analysis already handled that
							.peek(e -> e.setCardinality(null))
							.collect(Collectors.toList())
						).collect(Collectors.toList())
					),
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
					virtualJavaCodeForPredicate.setSource(JavaCodeUtils.formatGuardForGrammar(guard));
				
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
	
	private HoistingGuard findGuardForAlternatives(CompoundElement alternatives, AbstractRule currentRule, boolean skipCache) {
		if (config.isDebug())
			log.info("find guard for alternative");
		
		List<AbstractElement> paths = new ArrayList<>(alternatives.getElements());
		List<MergedPathGuard> guards = paths.stream()
				.map(p -> findGuardForElement(p, currentRule, skipCache))
				.map(MergedPathGuard::new)
				.collect(Collectors.toList());
		
		if (guards.stream().allMatch(Guard::isTrivial)) {
			// all paths are trivial
			
			// if there is a terminal on all branches set has terminal to true
			// else we might need to consider the following tokens in the path
			if (guards.stream().allMatch(HoistingGuard::hasTerminal)) {
				return HoistingGuard.terminal();
			} else {
				return HoistingGuard.unguarded();
			}
		}

		if (config.isDebug())
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
		
		if (config.isDebug())
			log.info("paths:" + paths);
		
		if (config.isDebug())
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
							.map(TokenGuard::reduce)
							.collect(Collectors.toList())
						)
						.map(AlternativeTokenSequenceGuard::new)
						.map(TokenGuard::reduce),
					guards.stream(),
					(TokenGuard tokenGuard, MergedPathGuard pathGuard) -> Tuples.pair(tokenGuard, pathGuard)
				).map(p -> new PathGuard(p.getFirst(), p.getSecond()))
				.collect(AlternativesGuard.collector());
			} catch(NestedIdenticalPathException e) {
				// nested identical paths
				// -> flatten paths to alternative and try again
				// this is very inefficient
				log.warn("nested identical paths detected");
				log.warn("avoid these since they can't be handled efficiently");
				
				if (config.isDebug())
					log.info(abstractElementToString(alternatives));
				
				CompoundElement flattened = flattenPaths(alternatives, paths, guards);
				
				if (config.isDebug())
					log.info(abstractElementToString(flattened));
				
				log.info(flattened.getElements().size());
				// TODO: value configurable?
				if (flattened.getElements().size() > 100) {
					throw new NestedIdenticalPathException("nested identical paths can't be analysed because of too many paths");
				}
				
				return findGuardForAlternatives(flattened, currentRule, true);
			} catch(TokenAnalysisAbortedException e) {
				throw new TokenAnalysisAbortedException(e.getMessage(), e, currentRule);
			}
		} else {
			return guards.get(0);
		}
	}
	
	private HoistingGuard findGuardForUnorderedGroup(UnorderedGroup element, AbstractRule currentRule, boolean skipCache) {
		// Unordered group (A & B) is the same as (A | B)+ or (A | B)* (if A and B are optional)
		// but the cardinality doesn't matter for hoisting
		// if A and B are optional the guard for the alternatives need to check the context
		// if not the alternatives are actual alternatives
		
		return findGuardForAlternatives(element, currentRule, skipCache);
	}
	
	private HoistingGuard findGuardForGroup(Group group, AbstractRule currentRule, boolean skipCache) {
		GroupGuard groupGuard = new GroupGuard();
		
		for(AbstractElement element : group.getElements()) {
			HoistingGuard guard = findGuardForElement(element, currentRule, skipCache);
			groupGuard.add(guard);
			
			// no need to consider the following elements if the current one has a terminal
			// following elements can't be hoisted anyway
			if (guard.hasTerminal()) {
				groupGuard.setHasTerminal();
				break;
			}
		}
		
		return groupGuard;
	}
	
	public HoistingGuard findGuardForRule(AbstractRule rule) {
		// public so the AntlrGrammarGenerator can access it if debug mode is enabled
		
		if (config.isDebug())
			log.info("finding guard for rule: " + rule.getName());
		return findGuardForElement(rule.getAlternatives(), rule, false);
	}
	
	public HoistingGuard findHoistingGuardIgnoreCardinality(AbstractElement element) {
		if (config.isDebug())
			log.info("hoisting (trivial) guard of: \n" + abstractElementToString(element));
		
		AbstractRule rule = containingParserRule(element);
		if (element instanceof UnorderedGroup) {
			return findGuardForAlternatives(((CompoundElement) element), rule, false);
		} else {
			return findGuardForElementWithTrivialCardinality(element, rule, false);
		}
	}
	
	public HoistingGuard findHoistingGuard(AbstractElement element) {
		if (config.isDebug())
			log.info("hoisting guard of: \n" + abstractElementToString(element));
		
		return findGuardForElement(element, containingParserRule(element), false);
	}
	
	private HoistingGuard findGuardForElement(AbstractElement element, AbstractRule currentRule, boolean skipCache) {
		String path = null; 
		HoistingGuard guard;

		if (!skipCache) {
			path = getPathOfElement(element);
			guard = elementCache.get(path);
			if (guard != null) {
				if (config.isDebug())
					log.info("from cache: " + path);
				return guard;
			}
		}
		
		if (
			isTrivialCardinality(element) || 
			isOneOrMoreCardinality(element)
		) {
			guard = findGuardForElementWithTrivialCardinality(element, currentRule, skipCache);
		} else if (isOptionalCardinality(element)) {
			guard = findGuardForOptionalCardinalityWithoutContext(element, currentRule, skipCache);
		} else {
			throw new IllegalArgumentException("unknown cardinality: " + element.getCardinality());
		}
		
		if (!skipCache) {
			elementCache.put(path, guard);
		}
		return guard;
	}
	
	private HoistingGuard findGuardForElementWithTrivialCardinality(AbstractElement element, AbstractRule currentRule, boolean skipCache) {
		if (config.isDebug())
			log.info(currentRule.getName() + ": " + abstractElementToShortString(element));
		
		if (element instanceof Alternatives) {
			return findGuardForAlternatives((Alternatives) element, currentRule, skipCache);
		} else if (element instanceof Group) {
			return findGuardForGroup((Group) element, currentRule, skipCache);
		} else if (element instanceof AbstractSemanticPredicate) {
			// TODO: change to GatedSemanticPredicate
			return new PredicateGuard((AbstractSemanticPredicate) element);	
		} else if (Token.isToken(element)) {
			return HoistingGuard.terminal();
		} else if (
			isParserRuleCall(element) ||
			isEnumRuleCall(element)
		) {
			RuleCall call = (RuleCall) element;
			return findGuardForRule(call.getRule());
		} else if (element instanceof Action) {
			// this is an Xtext action, not a JavaAction
			return HoistingGuard.unguarded();
		} else if (element instanceof JavaAction) {
			return HoistingGuard.action();
		} else if (element instanceof UnorderedGroup) {
			return findGuardForUnorderedGroup((UnorderedGroup) element, currentRule, skipCache);
		} else if (element instanceof Assignment) {
			return findGuardForElement(((Assignment) element).getTerminal(), currentRule, skipCache);
		} else {
			throw new UnsupportedConstructException("element not supported: " + element.toString(), currentRule);
		}
	}
}
