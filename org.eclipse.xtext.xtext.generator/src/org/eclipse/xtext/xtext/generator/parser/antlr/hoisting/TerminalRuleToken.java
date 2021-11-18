/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting;

import org.eclipse.xtext.TerminalRule;

/**
 * @author overflow - Initial contribution and API
 */
public class TerminalRuleToken implements Token {
	private TerminalRule rule;
	private int position;
	
	public TerminalRuleToken(TerminalRule rule, int position) {
		this.rule = rule;
		this.position = position;
	}

	@Override
	public String negatedCondition() {
		return "input.LT(" + position + ").getType() != " + rule.getName();
	}
	
	@Override
	public String toString() {
		return "terminal " + rule.getName();
	}
}
