/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr;

import org.eclipse.xtext.JavaCode;

/**
 * @author overflow - Initial contribution and API
 */
public class JavaCodeUtils {
	static public String getSource(JavaCode code) {
		String source = code.getSource();
		return source.substring(2, source.length() - 2);
	}
}
