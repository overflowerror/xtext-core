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
public class HoistingException extends RuntimeException {
	private static final long serialVersionUID = 6074715133295241743L;

	private AbstractRule rule;
	
	public HoistingException() {
		super();
	}

	public HoistingException(String message, Throwable cause) {
		super(message, cause);
	}

	public HoistingException(String message, Throwable cause, AbstractRule rule) {
		super(message, cause);
		this.rule = rule;
	}

	public HoistingException(String message) {
		super(message);
	}
	
	public HoistingException(String message, AbstractRule rule) {
		super(message);
		this.rule = rule;
	}

	public HoistingException(Throwable cause) {
		super(cause);
	}
	
	public HoistingException(Throwable cause, AbstractRule rule) {
		super(cause);
		this.rule = rule;
	}
	
	@Override
	public String getMessage() {
		if (rule == null) {
			return super.getMessage();
		} else {
			return rule.getName() + ": " + super.getMessage();
		}
	}
}
