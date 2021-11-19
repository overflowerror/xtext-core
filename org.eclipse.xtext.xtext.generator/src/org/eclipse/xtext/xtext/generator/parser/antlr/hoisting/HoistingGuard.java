/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting;

/**
 * @author overflow - Initial contribution and API
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
		return new HoistingGuard() {
			@Override
			public String render() {
				return "true";
			}
			
			@Override
			public boolean isTrivial() {
				return true;
			}
			
			@Override
			public boolean hasTerminal() {
				return false;
			}
		};
	}
	
	static public HoistingGuard terminal() {
		return new HoistingGuard() {
			@Override
			public String render() {
				return "true";
			}
			
			@Override
			public boolean isTrivial() {
				return true;
			}
			
			@Override
			public boolean hasTerminal() {
				return true;
			}
		};
	}

	static HoistingGuard action() {
		// technically not a terminal, but it behaves the same
		return terminal();
	}
}
