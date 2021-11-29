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
public class TokenAnalysisAbortedException extends HoistingException {
	private static final long serialVersionUID = 4303267001950479292L;

	public TokenAnalysisAbortedException() {
		super();
	}

	public TokenAnalysisAbortedException(String message, AbstractRule rule) {
		super(message, rule);
	}

	public TokenAnalysisAbortedException(String message, Throwable cause, AbstractRule rule) {
		super(message, cause, rule);
	}

	public TokenAnalysisAbortedException(String message, Throwable cause) {
		super(message, cause);
	}

	public TokenAnalysisAbortedException(String message) {
		super(message);
	}

	public TokenAnalysisAbortedException(Throwable cause, AbstractRule rule) {
		super(cause, rule);
	}

	public TokenAnalysisAbortedException(Throwable cause) {
		super(cause);
	}

}
