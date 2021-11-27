/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.token;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + position;
		result = prime * result + ((rule == null) ? 0 : rule.getName().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TerminalRuleToken other = (TerminalRuleToken) obj;
		if (position != other.position)
			return false;
		if (rule == null) {
			if (other.rule != null)
				return false;
		} else if (!rule.getName().equals(other.rule.getName()))
			return false;
		return true;
	}
	
	
}
