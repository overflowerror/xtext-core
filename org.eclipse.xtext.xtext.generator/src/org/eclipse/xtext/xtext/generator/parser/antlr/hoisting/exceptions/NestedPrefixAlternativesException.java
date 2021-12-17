/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions;

import org.eclipse.xtext.AbstractRule;

/**
 * @author overflow - Initial contribution and API
 */
public class NestedPrefixAlternativesException extends TokenAnalysisAbortedException {
	private static final long serialVersionUID = -1309434841547765441L;

	public NestedPrefixAlternativesException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NestedPrefixAlternativesException(String message, AbstractRule rule) {
		super(message, rule);
		// TODO Auto-generated constructor stub
	}

	public NestedPrefixAlternativesException(String message, Throwable cause, AbstractRule rule) {
		super(message, cause, rule);
		// TODO Auto-generated constructor stub
	}

	public NestedPrefixAlternativesException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NestedPrefixAlternativesException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NestedPrefixAlternativesException(Throwable cause, AbstractRule rule) {
		super(cause, rule);
		// TODO Auto-generated constructor stub
	}

	public NestedPrefixAlternativesException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
