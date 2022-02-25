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
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.NotATokenException;

/**
 * @author overflow - Initial contribution and API
 */
public abstract class Token {
	public abstract String negatedCondition();
	
	public abstract AbstractElement getElement();
	
	protected int position;
	private boolean inContext;
	
	public int getPosition() {
		return position;
	}
	
	public boolean isInContext() {
		return inContext;
	}
	
	
	public static boolean isToken(AbstractElement element) {
		if (element == null) {
			return true;
		} else if (element instanceof Keyword) {
			return true;
		} else if (element instanceof RuleCall) {
			return (((RuleCall) element).getRule() instanceof TerminalRule);
		} else if (element instanceof EnumLiteralDeclaration) {
			return true;
		} else {
			return false;
		}
	}
	
	public static Token fromElement(AbstractElement element, int position, boolean inContext) {
		
		Token token = null;
		
		if (element == null) {
			token = new EofToken();
		} else if (element instanceof Keyword) {
			token = new KeywordToken((Keyword) element);
		} else if (element instanceof RuleCall) {
			AbstractRule rule = ((RuleCall) element).getRule();
			if (rule instanceof TerminalRule) {
				token = new TerminalRuleToken((RuleCall) element, (TerminalRule) rule);
			}
		} else if (element instanceof EnumLiteralDeclaration) {
			token = new KeywordToken(((EnumLiteralDeclaration) element).getLiteral());
		}
		
		if (token == null) {
			throw new NotATokenException(element.eClass().getName());
		} else {
			token.position = position;
			token.inContext = inContext;
			return token;
		}
	}
}
