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
import java.util.stream.Collectors;

/**
 * @author overflow - Initial contribution and API
 */
public class TokenSequenceGuard implements TokenGuard {
	private Collection<? extends TokenGuard> sequence;
	
	public TokenSequenceGuard(Collection<? extends TokenGuard> sequence) {
		this.sequence = sequence;
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
}
