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
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author overflow - Initial contribution and API
 */
public class AlternativeTokenSequenceGuard implements TokenGuard {
	private Collection<? extends TokenGuard> alternatives;
	
	public AlternativeTokenSequenceGuard(Collection<? extends TokenGuard> alternatives) {
		this.alternatives = alternatives;
	}
	
	public TokenGuard reduce() {
		if (alternatives.size() == 1) {
			return alternatives.stream().findAny().get();
		} else {
			return this;
		}
	}
	
	@Override
	public String render() {
		if (alternatives.size() != 1) {
			return "(" + 
					alternatives.stream()
						.map(TokenGuard::render)
						.collect(Collectors.joining(" && ")) + 
					")";
		} else {
			return alternatives.stream().findAny().get().render();
		}
	}
	
	@Override
	public String toString() {
		return "AlternativeTokenSequenceGuard (\n" +
				alternatives.stream()
					.map(Object::toString)
					.map(s -> Arrays.stream(s.split("\n"))
							.map(l -> "\t" + l)
							.collect(Collectors.joining("\n"))
					).map(s -> s + "\n")
					.collect(Collectors.joining("\n")) +
				")\n";
	}


	@Override
	public Set<Integer> getPositions() {
		if (alternatives.isEmpty()) {
			return new HashSet<>();
		}
		
		Set<Set<Integer>> positions = alternatives.stream()
				.map(TokenGuard::getPositions)
				.collect(Collectors.toSet());
		return positions.stream().findAny().get().stream()
				.filter(p -> positions.stream()
						.allMatch(s -> s.contains(p)))
				.collect(Collectors.toSet());
	}
}