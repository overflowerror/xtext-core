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
public class EndlessPrefixException extends TokenAnalysisAbortedException {
	private static final long serialVersionUID = 2670032012156746113L;

	public EndlessPrefixException() {
		super();
	}

	public EndlessPrefixException(String message, AbstractRule rule) {
		super(message, rule);
	}

	public EndlessPrefixException(String message, Throwable cause, AbstractRule rule) {
		super(message, cause, rule);
	}

	public EndlessPrefixException(String message, Throwable cause) {
		super(message, cause);
	}

	public EndlessPrefixException(String message) {
		super(message);
	}

	public EndlessPrefixException(Throwable cause, AbstractRule rule) {
		super(cause, rule);
	}

	public EndlessPrefixException(Throwable cause) {
		super(cause);
	}
}
