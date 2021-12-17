/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr;

import org.eclipse.xtext.JavaCode;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.Guard;

/**
 * @author overflow - Initial contribution and API
 */
public class JavaCodeUtils {
	static public String getSource(JavaCode code) {
		String source = code.getSource();
		return source.substring(2, source.length() - 2);
	}
	
	static public String formatCodeForGrammar(String code) {
		return "$$ " + code + " $$";
	}
	
	static public String formatPredicateForGrammar(String predicate) {
		return formatCodeForGrammar(
				// remove parentheses
				predicate.substring(1, predicate.length() - 1)
			);
	}
	
	static public String formatGuardForGrammar(Guard guard) {
		return formatPredicateForGrammar(guard.render());
	}
}
