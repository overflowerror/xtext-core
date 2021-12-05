/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

/**
 * @author overflow - Initial contribution and API
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
						.findAny().get());
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
			return "(" + 
					elementGuards.stream()
						.map(Guard::render)
						.collect(Collectors.joining(" && ")) +
					")";
		}
	}

	@Override
	public boolean hasTerminal() {
		return hasTerminal;
	}
	
}
