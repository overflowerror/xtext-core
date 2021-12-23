/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting;

import org.eclipse.xtext.Grammar;

/**
 * @author overflow - Initial contribution and API
 */
public class HoistingConfiguration {
	private final int tokenLimit = 10;
	private boolean debug = false;
	
	public HoistingConfiguration(Grammar grammar) {
		// TODO: get config options from ecore object
	}
	
	public int getTokenLimit() {
		return tokenLimit;
	}

	public boolean isDebug() {
		return debug;
	}
	
}
