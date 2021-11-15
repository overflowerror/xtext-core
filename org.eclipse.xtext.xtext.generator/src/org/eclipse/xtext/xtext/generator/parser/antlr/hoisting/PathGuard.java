/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author overflow - Initial contribution and API
 */
public class PathGuard implements HoistingGuard {
	private Collection<TokenGuard> tokenGuards;
	private HoistingGuard hoistngGuard;
	
	public PathGuard(Collection<TokenGuard> tokenGuards, HoistingGuard hoistingGuard) {
		this.tokenGuards = tokenGuards;
		this.hoistngGuard = hoistingGuard;
	}
	
	@Override
	public boolean isTrivial() {
		return hoistngGuard.isTrivial();
	}

	@Override
	public boolean hasTerminal() {
		// empty paths are only allowed when all paths are empty
		// in that case a MergedPathGuard is returned.
		return true;
	}
	
	@Override
	public String render() {
		// TODO
		return null;
	}
}
