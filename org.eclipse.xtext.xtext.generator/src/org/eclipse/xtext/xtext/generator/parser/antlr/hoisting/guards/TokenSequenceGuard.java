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
import java.util.stream.Stream;

import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils.StreamUtils;

/**
 * @author overflow - Initial contribution and API
 */
public class TokenSequenceGuard implements TokenGuard {
	private Collection<? extends TokenGuard> sequence;
	
	public TokenSequenceGuard(Collection<? extends TokenGuard> sequence) {
		Set<Integer> checkedPositions = new HashSet<>();
		this.sequence = sequence.stream()
				.flatMap(g -> {
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
		boolean addParentheses = sequence.size() != 1;
		String result = "";
		
		if (addParentheses) {
			result += "(";
		}
		
		result += renderWithoutParenthesis();

		if (addParentheses) {
			result += ")";
		}
		
		return result;
	}
	
	public String renderWithoutParenthesis() {
		return sequence.stream()
				.map(TokenGuard::render)
				.collect(Collectors.joining(" || "));
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
