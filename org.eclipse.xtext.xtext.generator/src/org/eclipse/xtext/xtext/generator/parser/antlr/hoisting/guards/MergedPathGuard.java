/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author overflow - Initial contribution and API
 */
public class MergedPathGuard implements HoistingGuard {
	private List<HoistingGuard> pathGuards = new LinkedList<>();
	
	public MergedPathGuard(HoistingGuard guard) {
		add(guard);
	}
	
	public void add(HoistingGuard guard) {
		pathGuards.add(guard);
	}
	
	public void add(MergedPathGuard mergedPathGuard) {
		pathGuards.addAll(mergedPathGuard.pathGuards);
	}
	
	HoistingGuard reduce() {
		if (pathGuards.size() == 1) {
			return pathGuards.get(0);
		} else {
			return this;
		}
	}
	
	@Override
	public boolean isTrivial() {
		return pathGuards.stream().anyMatch(Guard::isTrivial);
	}

	@Override
	public String render() {
		if (pathGuards.size() == 1) {
			return pathGuards.get(0).render();
		} else {
			return "(" + renderWithoutParentheses() + ")";
		}
	}
	
	String renderWithoutParentheses() {
		return pathGuards.stream()
				.map(Guard::render)
				.collect(Collectors.joining(" || "));
	}

	@Override
	public boolean hasTerminal() {
		// only need to check first element since all paths should be identical
		return pathGuards.get(0).hasTerminal();
	}
	
	@Override
	public String toString() {
		return "MergedPathGuard (\n" +
				pathGuards.stream()
					.map(Object::toString)
					.map(s -> Arrays.stream(s.split("\n"))
							.map(l -> "\t" + l)
							.collect(Collectors.joining("\n"))
					).map(s -> s + "\n")
					.collect(Collectors.joining("\n")) +
				")\n";
	}
}
