/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author overflow - Initial contribution and API
 */
public class AlternativesGuard implements HoistingGuard {
	private List<PathGuard> paths;
	
	private AlternativesGuard(List<PathGuard> paths) {
		this.paths = paths;
	}
	
	@Override
	public boolean isTrivial() {
		return paths.stream().anyMatch(Guard::isTrivial);
	}

	@Override
	public String render() {
		return "(" + paths.stream()
					.map(Guard::render)
					.collect(Collectors.joining(" || ")) +
				")";
	}

	@Override
	public boolean hasTerminal() {
		// empty paths are only allowed when all paths are empty
		// in that case a MergedPathGuard ist returned.
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
}
