/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting;

import org.eclipse.xtext.AbstractSemanticPredicate;
import org.eclipse.xtext.xtext.generator.parser.antlr.JavaCodeUtils;

/**
 * @author overflow - Initial contribution and API
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
		return "(" + JavaCodeUtils.getSource(element.getCode()).trim() + ")";
	}

	@Override
	public boolean hasTerminal() {
		return false;
	}

}
