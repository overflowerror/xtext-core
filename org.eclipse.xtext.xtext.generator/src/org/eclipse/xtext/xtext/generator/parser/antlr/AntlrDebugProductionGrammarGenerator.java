/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.parser.antlr;

import org.eclipse.xtext.Grammar;

import com.google.inject.Inject;

public class AntlrDebugProductionGrammarGenerator extends AntlrGrammarGenerator {
	@Inject
	private DebugGrammarNaming naming;

	@Override
	protected GrammarNaming getGrammarNaming() {
		return naming;
	}
	
	@Override
	protected String compileParserImports(Grammar it, AntlrOptions options) {
		return "";
	}
}
