/*******************************************************************************
 * Copyright (c) 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.hoisting

import org.eclipse.xtext.tests.AbstractXtextTests
import org.eclipse.xtext.XtextStandaloneSetup
import org.junit.Test
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule
import com.google.inject.Guice
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions
import org.eclipse.xtext.generator.InMemoryFileSystemAccess
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess
import com.google.inject.Injector
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrDebugProductionGrammarGenerator
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrDebugContentAssistGrammarGenerator

/**
 * @author overflow - Initial contribution and API
 */
class HoistingGeneratorBenchmark extends AbstractXtextTests {
	
	val REPETITIONS = 1000
	
	override void setUp() throws Exception {
		super.setUp()
		with(XtextStandaloneSetup)
	}
	
	
	
	@Test
	def void testFullTranslationBenchmark() {
		for (var i = 0; i < REPETITIONS; i++) {
			'''
				grammar com.foo.bar with org.eclipse.xtext.common.Terminals
				import "http://www.eclipse.org/emf/2002/Ecore" as ecore
				generate myPack 'http://mypack'
				
				setup $$
					java.util.Stack<String> symbolTable = new java.util.Stack<String>();
				$$
				
				Statements:
				            defs+=VarDef+
				;
				
				VarDef: 
				        $$ !symbolTable.contains( input.LT( 1 ).getText() ) $$?=>
				        name=ID '=' value=Expr
				        $$ symbolTable.push(((org.xtext.example.mydsl.myDsl.VarDef) current).getName()); $$
				;
				
				Expr: 
				      $$ symbolTable.contains( input.LT( 0 ).getText() ) $$?=>
				      var=ID
				    | builtin=ID '(' args += Expr ( args += Expr ',' )* ')'
				    | num=INT
				;
			'''.doFullTranslateRun
		}
	}
	
	protected def void doFullTranslateRun(CharSequence xtextGrammar) {
		val grammar = super.getModel(xtextGrammar.toString) as Grammar
		val injector = Guice.createInjector(new DefaultGeneratorModule)
		val inMem = new InMemFSA
		val options = new AntlrOptions
		injector.getInstance(AntlrDebugProductionGrammarGenerator).generate(grammar, options, inMem)
		injector.getInstance(AntlrDebugContentAssistGrammarGenerator).generate(grammar, options, inMem)
	}
	
	static class InMemFSA extends InMemoryFileSystemAccess implements IXtextGeneratorFileSystemAccess {
		
		override getPath() {
			"./"
		}
		
		override isOverwrite() {
			true
		}
		
		override initialize(Injector injector) {
			injector.injectMembers(this)
		}
		
	}
}