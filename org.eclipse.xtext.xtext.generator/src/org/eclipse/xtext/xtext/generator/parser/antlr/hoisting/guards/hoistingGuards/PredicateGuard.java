/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.hoistingGuards;

import org.eclipse.xtext.AbstractSemanticPredicate;
import org.eclipse.xtext.xtext.generator.parser.antlr.JavaCodeUtils;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.ContextConnective;

/**
 * @author overflow - Initial contribution and API
 * 
 * PredicateGuards represent the atomic guard condition of a predicate.
 * 
 */
public class PredicateGuard implements HoistingGuard {

	private AbstractSemanticPredicate element;
	
	public PredicateGuard(AbstractSemanticPredicate element) {
		this.element = element;
	}

	@Override
	public boolean isTrivial() {
		return false;
	}

	@Override
	public String render() {
		// no parentheses if this is the root element
		return JavaCodeUtils.getSource(element.getCode());
	}
	
	@Override
	public String render(ContextConnective connective) {
		return "(" + render() + ")";
	}


	@Override
	public boolean hasTerminal() {
		return false;
	}

	@Override
	public String toString() {
		return "PredicateGuard (\n" +
				"\t" + JavaCodeUtils.getSource(element.getCode()) + "\n" +
				")\n";
	}
	
}
