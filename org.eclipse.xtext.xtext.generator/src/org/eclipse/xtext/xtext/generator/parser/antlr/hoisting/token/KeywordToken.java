/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.token;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Keyword;

/**
 * @author overflow - Initial contribution and API
 */
public class KeywordToken implements Token {
	private Keyword keyword;
	private int position;
	
	public KeywordToken(Keyword keyword, int position) {
		this.keyword = keyword;
		this.position = position;
	}

	@Override
	public String negatedCondition() {
		return "!\"" + keyword.getValue().replace("\"", "\\\"") + "\".equals(input.LT(" + position + ").getText())";
	}
	
	@Override
	public String toString() {
		return "keywordToken(" + keyword.getValue() + ", " + position + ")\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyword == null) ? 0 : keyword.getValue().hashCode());
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
		KeywordToken other = (KeywordToken) obj;
		if (keyword == null) {
			if (other.keyword != null)
				return false;
		} else if (!keyword.getValue().equals(other.keyword.getValue()))
			return false;
		if (position != other.position)
			return false;
		return true;
	}
	
	@Override
	public AbstractElement getElement() {
		return keyword;
	}
	
}
