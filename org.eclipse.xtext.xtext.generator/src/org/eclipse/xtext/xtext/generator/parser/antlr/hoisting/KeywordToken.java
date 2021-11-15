/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting;

import org.eclipse.xtext.Keyword;

/**
 * @author overflow - Initial contribution and API
 */
public class KeywordToken extends Token {
	private Keyword keyword;
	private int position;
	
	public KeywordToken(Keyword keyword, int position) {
		this.keyword = keyword;
		this.position = position;
	}
}
