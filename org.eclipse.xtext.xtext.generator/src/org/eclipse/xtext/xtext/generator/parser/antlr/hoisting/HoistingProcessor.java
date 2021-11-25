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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.AbstractSemanticPredicate;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.DisambiguatingSemanticPredicate;
import org.eclipse.xtext.GatedSemanticPredicate;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.JavaAction;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.XtextSwitch;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils.StreamUtils;

import com.google.common.base.Strings;
import com.google.common.collect.Streams;

/**
 * @author overflow - Initial contribution and API
 */
public class HoistingProcessor {
	private Map<String, HoistingGuard> ruleCache = new HashMap<>();
	private Map<Group, HoistingGuard> groupCache = new HashMap<>();
	
	private Logger log = Logger.getLogger(this.getClass());
	
	private static final int TOKEN_ANALYSIS_LIMIT = 5;
	
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
			
			// add path to result
			result = result.merge(current);
			
			// if current path is done return result
			// precondition: either !needsLength or result empty
			//               result is only non-empty if ? cardinality
			//               but then needsLength can't be true.
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
		           path instanceof AbstractSemanticPredicate ||
		           path instanceof JavaAction
				) {
			return prefix;
		} else {
			return getTokenForIndexesDefault(path, prefix, needsLength);
		}
	}
	
	private List<List<Token>> getTokenForIndexes(AbstractElement path, List<Integer> indexes) throws TokenAnalysisAbortedException {
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
				tokenListSet1 = new HashSet<>(getTokenForIndexes(path1, range));
			} catch (TokenAnalysisAbortedException e) {
				tokenListSet1 = null;
			}
			
			try {
				tokenListSet2 = new HashSet<>(getTokenForIndexes(path2, range));
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
				return false;
			}
		}
		
		// we can't analyze the paths any further
		// TODO maybe assume paths are equal and show warning instead of exception
		throw new TokenAnalysisAbortedException();
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
		// we tried all possible combinations
		// -> abort
		throw new TokenAnalysisAbortedException();
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
				try {
					if (tokenCombinations(current, i + 1, ones - 1, callback)) {
						return true;
					}
				} catch (TokenAnalysisAbortedException e) {
					// tokens exhausted; abort current prefix
					// TODO: add cache for current position in tokenCombinations-call
					//       we don't need to check this index in the future
					log.info("tokens exhausted");
					return false;
				}
			}
			return false;
		}
	}
	
	private void abstractElementToString(AbstractElement element, StringBuilder builder, int indentation) {
		String indentationString = Strings.repeat(" ", indentation);
		
		if (element == null) {
			builder.append(indentationString).append("null");
			return;
		}
		
		new XtextSwitch<Boolean>(){
			@Override
			public Boolean caseKeyword(Keyword object) {
				builder.append(indentationString);
				builder.append("Keyword (").append(object.getValue()).append(")");
				return true;
			};
			@Override
			public Boolean caseGroup(Group object) {
				builder.append(indentationString);
				builder.append("Group (\n");
				object.getElements().forEach(e -> {
					abstractElementToString(e, builder, indentation + 1);
				});
				builder.append(indentationString);
				builder.append(")");
				return true;
			};
			@Override
			public Boolean caseAlternatives(Alternatives object) {
				builder.append(indentationString);
				builder.append("Alternatives (\n");
				object.getElements().forEach(e -> {
					abstractElementToString(e, builder, indentation + 1);
				});
				builder.append(indentationString);
				builder.append(")");
				return true;
			};
			@Override
			public Boolean caseRuleCall(RuleCall object) {
				AbstractRule rule = object.getRule();
				if (rule instanceof ParserRule) {
					builder.append(indentationString);
					builder.append("ParserRule ").append(rule.getName()).append(" (\n");
					abstractElementToString(rule.getAlternatives(), builder, indentation + 1);
					builder.append(indentationString);
					builder.append(")");
				} else {
					builder.append(indentationString);
					builder.append(rule.eClass().getName()).append(" ").append(rule.getName());
				}
				return true;
			};
			@Override
			public Boolean caseJavaAction(JavaAction object) {
				builder.append(indentationString);
				builder.append("JavaAction (").append(object.getCode().getSource()).append(")");
				return true;
			};
			@Override
			public Boolean caseGatedSemanticPredicate(GatedSemanticPredicate object) {
				builder.append(indentationString);
				builder.append("GatedSemanticPredicate (").append(object.getCode().getSource()).append(")");
				return true;
			};
			@Override
			public Boolean caseDisambiguatingSemanticPredicate(DisambiguatingSemanticPredicate object) {
				builder.append(indentationString);
				builder.append("DisambiguatingSemanticPredicate (").append(object.getCode().getSource()).append(")");
				return true;
			};
			@Override
			public Boolean caseAssignment(Assignment object) {
				builder.append(indentationString);
				builder.append("Assignment (\n");
				abstractElementToString(object.getTerminal(), builder, indentation + 1);
				builder.append(indentationString);
				builder.append(")");
				return true;
			};
			@Override
			public Boolean defaultCase(EObject object) {
				builder.append("unknown element: ").append(object.eClass().getName());
				return false;
			};
		}.doSwitch(element);
		
		builder.append(Objects.toString(element.getCardinality(), ""));
		builder.append("\n");
	}
	
	private String abstractElementToString(AbstractElement element) {
		StringBuilder builder = new StringBuilder();
		abstractElementToString(element, builder, 0);
		return builder.toString();
	}
	
	private List<List<List<Token>>> findMinimalPathDifference(List<AbstractElement> paths) throws TokenAnalysisAbortedException {
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
					.map(p -> getTokenForIndexes(p, indexList))
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
	
	private EObject cloneEObject(EObject element) {
		EObject clone = XtextFactory.eINSTANCE.create(element.eClass());
		for (EStructuralFeature feature : element.eClass().getEAllStructuralFeatures()) {
			Object value = element.eGet(feature);
			if (value instanceof EObject) {
				// if value is EObject a deep copy is needed since an EObject can only be 
				// referenced by one other EObject.

				value = cloneEObject((EObject) value);
			}
			clone.eSet(feature, value);
		}
		return clone;
	}
	
	private AbstractElement cloneAbstractElement(AbstractElement element) {
		return (AbstractElement) cloneEObject(element);
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
				// A* B -> A+ B | B
				
				// we need a deep clone of all elements because otherwise we would destroy the original tree
				// the reason is that by default ecore doesn't allow an EObject to used used twice as a reference
				
				AbstractElement clonedElement = cloneAbstractElement(element);
				if (cardinality.equals("?")) {
					clonedElement.setCardinality(null);
				} else {
					// for the * cardinality the empty case is covered by the alternative
					clonedElement.setCardinality("+");
				}
				
				// make copy of every element because we can't use any element twice
				List<AbstractElement> remainingElementsInGroup = StreamUtils.fromIterator(iterator)
						.map(this::cloneAbstractElement)
						.collect(Collectors.toList());
				
				// make copy of first branch and add the cloned element
				List<AbstractElement> remainingElementsInGroupIncludingCurrent = Streams.concat(
						Stream.of(clonedElement),
						remainingElementsInGroup.stream()
							.map(this::cloneAbstractElement)
					).collect(Collectors.toList());
				
				// construct alternatives
				
				EStructuralFeature compoundElementElementsFeature = XtextPackage.Literals.COMPOUND_ELEMENT.getEStructuralFeature(XtextPackage.COMPOUND_ELEMENT__ELEMENTS);
				
				Group virtualPathRemaining = XtextFactory.eINSTANCE.createGroup();
				virtualPathRemaining.eSet(compoundElementElementsFeature, remainingElementsInGroup);
				
				Group virtualPathRemainingPlusCurrent = XtextFactory.eINSTANCE.createGroup();
				virtualPathRemainingPlusCurrent.eSet(compoundElementElementsFeature, remainingElementsInGroupIncludingCurrent);
				
				Alternatives virtualAlternatives = XtextFactory.eINSTANCE.createAlternatives();
				virtualAlternatives.eSet(compoundElementElementsFeature, Arrays.asList(virtualPathRemaining, virtualPathRemainingPlusCurrent));
				
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
		} else if (isParserRule(path)) {
			return pathHasToken(((RuleCall) path).getRule().getAlternatives());
		} else if (path instanceof Assignment) {
			return pathHasToken(((Assignment) path).getTerminal());
		} else if (path instanceof Group) {
			return ((Group) path).getElements().stream().anyMatch(this::pathHasToken);
		} else if (path instanceof Alternatives) {
			return ((Alternatives) path).getElements().stream().anyMatch(this::pathHasToken);
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
		} else if (isParserRule(element)) {
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
