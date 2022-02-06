/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.hoistingGuards;

import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.ContextConnective;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.Guard;

/**
 * @author overflow - Initial contribution and API
 * 
 * A HoistingGuard is a condition that has to be true for a certain path to accessible.
 * 
 */
public interface HoistingGuard extends Guard {
	default String renderPredicate() {
		if (isTrivial()) {
			return "";
		} else {
			return "{" + render() + "}?=>";
		}
	}
	
	default String renderDescription() {
		if (isTrivial()) {
			return "trivial";
		} else {
			return render();
		}
	}
	
	boolean hasTerminal();
	
	static public HoistingGuard unguarded() {
		return new UnguardedPathHoistingGuard();
	}
	
	static public HoistingGuard terminal() {
		return new TerminalHoistingGuard();
	}
	
	static class UnguardedPathHoistingGuard implements HoistingGuard {
		@Override
		public String render() {
			return "true";
		}
		
		@Override
		public String render(ContextConnective connective) {
			return render();
		}
		
		@Override
		public boolean isTrivial() {
			return true;
		}
		
		@Override
		public boolean hasTerminal() {
			return false;
		}
	}
	
	static class TerminalHoistingGuard implements HoistingGuard {
		@Override
		public String render() {
			return "true";
		}
		
		@Override
		public String render(ContextConnective connective) {
			return render();
		}
		
		@Override
		public boolean isTrivial() {
			return true;
		}
		
		@Override
		public boolean hasTerminal() {
			return true;
		}
	}

	static HoistingGuard action() {
		// technically not a terminal, but it behaves the same
		return new TerminalHoistingGuard();
	}
}
