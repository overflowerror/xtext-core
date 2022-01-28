/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils;

import java.util.function.Function;

/**
 * @author overflow - Initial contribution and API
 */
public class MutableWrapper<T> {
	private T value;
	
	public MutableWrapper() {
	}	
	
	public MutableWrapper(T value) {
		this.value = value;
	}
	
	public T get() {
		return value;
	}
	
	public void set(T value) {
		this.value = value;
	}
	
	public void mutate(Function<T, T> f) {
		this.value = f.apply(this.value);
	}
}
