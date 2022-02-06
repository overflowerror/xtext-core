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
import java.util.HashSet;
import java.util.Set;

import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.ContextConnective;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.token.Token;

/**
 * @author overflow - Initial contribution and API
 */
public class SingleTokenGuard implements TokenGuard {
	private Token token;
	
	public SingleTokenGuard(Token token) {
		this.token = token;
	}
	
	@Override
	public TokenGuard reduce() {
		return this;
	}

	@Override
	public String render() {
		return token.negatedCondition();
	}
	
	@Override
	public String render(ContextConnective connective) {
		return render();
	}
	
	@Override
	public String toString() {
		return "SingleTokenGuard (\n" +
				"\t" + token + "\n" +
				")\n";
	}
	
	@Override
	public Set<Integer> getPositions() {
		return new HashSet<>(Arrays.asList(token.getPosition()));
	}
}
