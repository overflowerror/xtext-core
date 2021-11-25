/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;

/**
 * @author overflow - Initial contribution and API
 */
public interface Token {
	String negatedCondition();
	
	static boolean isToken(AbstractElement element) {
		if (element instanceof Keyword) {
			return true;
		} else if (element instanceof RuleCall) {
			return (((RuleCall) element).getRule() instanceof TerminalRule);
		} else {
			return false;
		}
	}
	
	static Token fromElement(AbstractElement element, int position) {
		if (element instanceof Keyword) {
			return new KeywordToken((Keyword) element, position);
		} else if (element instanceof RuleCall) {
			AbstractRule rule = ((RuleCall) element).getRule();
			if (rule instanceof TerminalRule) {
				return new TerminalRuleToken((TerminalRule) rule, position);
			}
		}
		
		throw new NotATokenException();
	}
}