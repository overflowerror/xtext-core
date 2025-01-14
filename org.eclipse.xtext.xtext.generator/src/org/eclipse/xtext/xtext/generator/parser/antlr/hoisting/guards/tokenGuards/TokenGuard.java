/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.tokenGuards;

import java.util.Set;

import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.Guard;

/**
 * @author overflow - Initial contribution and API
 * 
 * TokenGuards represent the tokens necessary for the given path. 
 * Usually only tokens that distinguish the current path from other alternative paths are used. 
 * 
 */
public interface TokenGuard extends Guard {
	@Override
	default boolean isTrivial() {
		return false;
	}
	
	Set<Integer> getPositions();
	
	TokenGuard reduce();
}
