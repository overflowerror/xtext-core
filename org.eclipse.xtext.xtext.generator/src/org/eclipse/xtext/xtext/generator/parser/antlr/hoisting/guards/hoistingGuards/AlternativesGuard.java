/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.hoistingGuards;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.ContextConnective;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.Guard;

/**
 * @author overflow - Initial contribution and API
 * 
 * AlternativesGuards are the guard conditions of non-empty alternatives.
 */
public class AlternativesGuard implements HoistingGuard {
	private List<PathGuard> paths;
	
	public AlternativesGuard(PathGuard ...pathArray) {
		this(Arrays.asList(pathArray));
	}
	
	public AlternativesGuard(List<PathGuard> paths) {
		// collapsing nested alternatives might reduce output size
		// -> try both and use smaller one
		
		this.paths = paths;
		int lengthWithoutCollapse = render().length();
		this.paths = PathGuard.collapse(paths);
		int lengthWithCollapse = render().length();
		
		if (lengthWithoutCollapse < lengthWithCollapse)
			this.paths = paths;
	}
	
	
	// package private so PathGuard can access this method
	List<PathGuard> getPaths() {
		return paths;
	}
	
	@Override
	public boolean isTrivial() {
		// should never be true, otherwise findAlternativeGuard would 
		// produce unguarded path hoisting guard
		return paths.stream().allMatch(Guard::isTrivial);
	}

	@Override
	public String render(ContextConnective connective) {
		// there is at least one path that is not trivial
		List<HoistingGuard> relevantGuards = paths.stream()
				.filter(Predicate.not(Guard::isTrivial))
				.collect(Collectors.toList());
			
		if (relevantGuards.size() == 1) {
			return paths.get(0).render(connective);
		} else {
			String result = relevantGuards.stream()
					.map(g -> g.render(ContextConnective.CONJUNCTION))
					.collect(Collectors.joining(" && "));
			return connective.addParenthesesIfNot(result, ContextConnective.CONJUNCTION);
		}
	}
	
	@Override
	public String render() {
		// there is at least one path that is not trivial
		List<HoistingGuard> relevantGuards = paths.stream()
				.filter(Predicate.not(Guard::isTrivial))
				.collect(Collectors.toList());

		if (relevantGuards.size() == 1) {
			return paths.get(0).render();
		} else {
			return render(ContextConnective.CONJUNCTION);
		}
	}

	@Override
	public boolean hasTerminal() {
		// using the current method there is no way of handling predicates
		// after alternatives with empty paths the same way antlr does
		// => assume that the alternative always contains tokens
		// the only case that works is when all paths are empty
		// => a MergedPathGuard is returned by findGuardForAlternatives
		return true;
	}
	
	public static Collector<PathGuard, List<PathGuard>, AlternativesGuard> collector() {
		return Collector.of(
			LinkedList::new, 
			List::add,
			(l, r) -> {
				l.addAll(r);
				return l;
			},
			AlternativesGuard::new, 
			Collector.Characteristics.CONCURRENT
		);
	}
	
	@Override
	public String toString() {
		return "AlternativesGuard (\n" +
				paths.stream()
					.map(Object::toString)
					.map(s -> Arrays.stream(s.split("\n"))
							.map(l -> "\t" + l)
							.collect(Collectors.joining("\n"))
					).map(s -> s + "\n")
					.collect(Collectors.joining("\n")) +
				")\n";
	}
}
