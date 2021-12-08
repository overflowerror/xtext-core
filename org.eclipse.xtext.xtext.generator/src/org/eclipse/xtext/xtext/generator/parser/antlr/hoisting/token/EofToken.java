/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.token;

/**
 * @author overflow - Initial contribution and API
 */
public class EofToken implements Token {

	private int position;
	
	public EofToken(int position) {
		this.position = position;
	}
	
	@Override
	public String negatedCondition() {
		return "input.LA(" + position + ") != EOF";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + position;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EofToken other = (EofToken) obj;
		if (position != other.position)
			return false;
		return true;
	}

}
