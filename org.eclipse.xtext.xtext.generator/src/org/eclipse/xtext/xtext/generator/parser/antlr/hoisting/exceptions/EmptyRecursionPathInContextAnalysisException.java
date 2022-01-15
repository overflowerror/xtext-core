/*******************************************************************************
 * Copyright (c) 2022 itemis AG (http://www.itemis.eu) and others.
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
public class EmptyRecursionPathInContextAnalysisException extends HoistingException {
	private static final long serialVersionUID = 3820353828411603508L;

	public EmptyRecursionPathInContextAnalysisException() {
		super();
	}

	public EmptyRecursionPathInContextAnalysisException(String message, AbstractRule rule) {
		super(message, rule);
	}

	public EmptyRecursionPathInContextAnalysisException(String message, Throwable cause, AbstractRule rule) {
		super(message, cause, rule);
	}

	public EmptyRecursionPathInContextAnalysisException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyRecursionPathInContextAnalysisException(String message) {
		super(message);
	}

	public EmptyRecursionPathInContextAnalysisException(Throwable cause, AbstractRule rule) {
		super(cause, rule);
	}

	public EmptyRecursionPathInContextAnalysisException(Throwable cause) {
		super(cause);
	}

}
