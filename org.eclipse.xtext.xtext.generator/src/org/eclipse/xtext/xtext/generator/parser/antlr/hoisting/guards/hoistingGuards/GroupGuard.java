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
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.ContextConnective;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.Guard;

/**
 * @author overflow - Initial contribution and API
 * 
 * GroupGuards represent the conditions for group elements.
 * 
 */
public class GroupGuard implements HoistingGuard {
	private List<Guard> elementGuards = new LinkedList<>();
	private boolean hasTerminal = false;
	
	public GroupGuard() {
	}
	
	GroupGuard(Collection<Guard> guards) {
		guards.forEach(g -> add(g));
	}
	
	public void add(Guard guard) {
		if (guard.isTrivial()) {
			return;
		}
		
		if (guard instanceof GroupGuard) {
			((GroupGuard) guard).elementGuards.forEach(this::add);
		} else {
			elementGuards.add(guard);
		}
	}
	
	public void setHasTerminal() {
		hasTerminal = true;
	}
	
	Pair<List<Guard>, AlternativesGuard> deconstructPaths() {
		// there can be at most 1 AlternativesGuard since they always have tokens
		// if alternatives don't have token the result will be a MergedPathGuard
		
		if (!elementGuards.stream().anyMatch(g -> g instanceof AlternativesGuard)) {
			return null;
		} else {
			return Tuples.pair(
					elementGuards.stream()
						.filter(g -> !(g instanceof AlternativesGuard))
						.collect(Collectors.toList()), 
					elementGuards.stream()
						.filter(g -> g instanceof AlternativesGuard)
						.map(g -> (AlternativesGuard) g)
						.findFirst().get());
		}
	}
	
	@Override
	public boolean isTrivial() {
		return elementGuards.isEmpty();
	}

	@Override
	public String render() {
		if (elementGuards.size() == 1) {
			return elementGuards.get(0).render();
		} else {
			return render(ContextConnective.CONJUNCTION);
		}
	}
	
	@Override
	public String render(ContextConnective connective) {
		if (elementGuards.size() == 1) {
			return elementGuards.get(0).render(connective);
		} else {
			String result = elementGuards.stream()
				.map(g -> g.render(ContextConnective.CONJUNCTION))
				.collect(Collectors.joining(" && "));
			return connective.addParenthesesIfNot(result, ContextConnective.CONJUNCTION);
		}
	}

	@Override
	public boolean hasTerminal() {
		return hasTerminal;
	}

	@Override
	public String toString() {
		return "GroupGuard (\n" +
				elementGuards.stream()
					.map(Object::toString)
					.map(s -> Arrays.stream(s.split("\n"))
							.map(l -> "\t" + l)
							.collect(Collectors.joining("\n"))
					).map(s -> s + "\n")
					.collect(Collectors.joining("\n")) +
				")\n";
	}
	
}
