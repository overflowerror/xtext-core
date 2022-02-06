/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.tokenGuards;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.ContextConnective;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils.StreamUtils;

/**
 * @author overflow - Initial contribution and API
 * 
 * A TokenSequenceGuard represents a sequence of tokens as a TokenGuard.
 */
public class TokenSequenceGuard implements TokenGuard {
	private Collection<? extends TokenGuard> sequence;
	
	public TokenSequenceGuard(Collection<? extends TokenGuard> sequence) {
		Set<Integer> checkedPositions = new HashSet<>();
		// remove all guards from sequences who's positions are already in the sequence
		this.sequence = sequence.stream()
				.flatMap(g -> {
					// special case: reduce TokenSequenceGuards
					if (g instanceof TokenSequenceGuard) {
						return ((TokenSequenceGuard) g).sequence.stream()
								.filter(s -> !s.getPositions().stream()
										.allMatch(checkedPositions::contains))
								.peek(s -> checkedPositions.addAll(s.getPositions()));
					} else {
						Set<Integer> positions = g.getPositions();
						if (positions.stream()
								.allMatch(checkedPositions::contains)
						) {
							return Stream.empty();
						} else {
							checkedPositions.addAll(positions);
							return Stream.of(g);
						}
					}
				}).collect(StreamUtils.collectToLinkedHashSet());
	}
	
	public TokenSequenceGuard(TokenGuard ...guards) {
		this(Arrays.asList(guards));
	}

	@Override
	public TokenGuard reduce() {
		if (sequence.size() == 1) {
			return sequence.stream().findAny().get();
		} else {
			return this;
		}
	}
	
	@Override
	public String render() {
		if (sequence.size() == 1) {
			return sequence.stream().findAny().get().render();
		} else {
			return render(ContextConnective.DISJUNCTION);
		}
	}
	
	@Override
	public String render(ContextConnective connective) {
		if (sequence.size() == 1) {
			return sequence.stream().findAny().get().render(connective);
		} else {
			String result = sequence.stream()
				.map(g -> g.render(ContextConnective.DISJUNCTION))
				.collect(Collectors.joining(" || "));
			return connective.addParenthesesIfNot(result, ContextConnective.DISJUNCTION);
		}
	}
	
	@Override
	public String toString() {
		return "TokenSequenceGuard (\n" +
				sequence.stream()
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
		return sequence.stream()
				.map(TokenGuard::getPositions)
				.flatMap(Set::stream)
				.collect(Collectors.toSet());
	}
}
