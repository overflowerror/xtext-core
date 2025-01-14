/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.token;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;

/**
 * @author overflow - Initial contribution and API
 */
public class TerminalRuleToken extends Token {
	private RuleCall call;
	private TerminalRule rule;
	
	TerminalRuleToken(RuleCall call, TerminalRule rule) {
		this.call = call;
		this.rule = rule;
	}

	@Override
	public String negatedCondition() {
		return "input.LA(" + position + ") != " + rule.getName();
	}
	
	@Override
	public String toString() {
		return "TerminalToken(" + rule.getName() + ", " + position + ")\n";
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
	
	@Override
	public AbstractElement getElement() {
		return call;
	}
}
