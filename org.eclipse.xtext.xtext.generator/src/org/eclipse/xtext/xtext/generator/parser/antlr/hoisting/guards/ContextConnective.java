/*******************************************************************************
 * Copyright (c) 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards;

/**
 * @author overflow - Initial contribution and API
 */
public enum ContextConnective {
	DISJUNCTION, CONJUNCTION;
	
	public String addParenthesesIfNot(String str, ContextConnective connective) {
		if (this != connective) {
			return "(" + str + ")";
		} else {
			return str;
		}
	}
}
