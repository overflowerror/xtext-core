/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
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
public interface Guard {
	boolean isTrivial();
	/**
	 * should only be used for the root guard when rendering.
	 * 
	 * assume context connective matches inner connective
	 */
	String render();
	
	/**
	 * don't render parentheses if inner connective matches context
	 */
	String render(ContextConnective connective);
}
