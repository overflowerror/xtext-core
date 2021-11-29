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
public class UnsupportedConstructException extends HoistingException {
	private static final long serialVersionUID = 637006930813191613L;

	public UnsupportedConstructException() {
		super();
	}

	public UnsupportedConstructException(String message, AbstractRule rule) {
		super(message, rule);
	}

	public UnsupportedConstructException(String message, Throwable cause, AbstractRule rule) {
		super(message, cause, rule);
	}

	public UnsupportedConstructException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnsupportedConstructException(String message) {
		super(message);
	}

	public UnsupportedConstructException(Throwable cause, AbstractRule rule) {
		super(cause, rule);
	}

	public UnsupportedConstructException(Throwable cause) {
		super(cause);
	}
	
}
