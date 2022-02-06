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
class HoistingGeneratorTest extends AbstractXtextTests {
	
	override void setUp() throws Exception {
		super.setUp()
		with(XtextStandaloneSetup)
	}
	
	@Test
	def void testRenderingOfGuardConditionInAlternativesInProductionGrammar() {
		'''
			grammar com.foo.bar 
			import "http://www.eclipse.org/emf/2002/Ecore" as ecore
			generate myPack 'http://mypack'
			
			S: $$ p0 $$?=> 'a'
			 | $$ p1 $$?=> 'b';
		'''.assertTranslatesToProductionGrammar('''
			grammar DebugInternalbar;
			
			options {
			}
			
			@lexer::header {
			package com.foo.parser.antlr.internal;
			
			// Hack: Use our own Lexer superclass by means of import. 
			// Currently there is no other way to specify the superclass for the lexer.
			import org.eclipse.xtext.parser.antlr.Lexer;
			}
			
			@parser::header {
			package com.foo.parser.antlr.internal;
			}
			
			@parser::members {
			
			 	private barGrammarAccess grammarAccess;
			
			    public InternalbarParser(TokenStream input, barGrammarAccess grammarAccess) {
			        this(input);
			        this.grammarAccess = grammarAccess;
			        registerRules(grammarAccess.getGrammar());
			    }
			
			    @Override
			    protected String getFirstRuleName() {
			    	return "S";
			   	}
			
			   	@Override
			   	protected barGrammarAccess getGrammarAccess() {
			   		return grammarAccess;
			   	}
			   	
			   	// no init block
			
			}
			
			@rulecatch {
			    catch (RecognitionException re) {
			        recover(input,re);
			        appendSkippedTokens();
			    }
			}
			
			// Entry rule entryRuleS
			entryRuleS returns [EObject current=null]:
				{ newCompositeNode(grammarAccess.getSRule()); }
				iv_ruleS=ruleS
				{ $current=$iv_ruleS.current; }
				EOF;
			
			// Rule S
			ruleS returns [EObject current=null]
			@init {
				enterRule();
			}
			@after {
				leaveRule();
			}:
				(
					{p0}?=>
						(
							(
							)
							otherlv_1='a'
							{
								newLeafNode(otherlv_1, grammarAccess.getSAccess().getAKeyword_0_1());
							}
						)
					    |
					{p1}?=>
						(
							(
							)
							otherlv_3='b'
							{
								newLeafNode(otherlv_3, grammarAccess.getSAccess().getBKeyword_1_1());
							}
						)
				)
			;
		''')
	}
	
	@Test
	def void testRenderingOfGuardConditionInNonTrivialCardinalitityInProductionGrammar() {
		'''
			grammar com.foo.bar 
			import "http://www.eclipse.org/emf/2002/Ecore" as ecore
			generate myPack 'http://mypack'
			
			S: ($$ p0 $$?=> 'a')*;
		'''.assertTranslatesToProductionGrammar('''
			grammar DebugInternalbar;
			
			options {
			}
			
			@lexer::header {
			package com.foo.parser.antlr.internal;
			
			// Hack: Use our own Lexer superclass by means of import. 
			// Currently there is no other way to specify the superclass for the lexer.
			import org.eclipse.xtext.parser.antlr.Lexer;
			}
			
			@parser::header {
			package com.foo.parser.antlr.internal;
			}
			
			@parser::members {
			
			 	private barGrammarAccess grammarAccess;
			
			    public InternalbarParser(TokenStream input, barGrammarAccess grammarAccess) {
			        this(input);
			        this.grammarAccess = grammarAccess;
			        registerRules(grammarAccess.getGrammar());
			    }
			
			    @Override
			    protected String getFirstRuleName() {
			    	return "S";
			   	}
			
			   	@Override
			   	protected barGrammarAccess getGrammarAccess() {
			   		return grammarAccess;
			   	}
			   	
			   	// no init block
			
			}
			
			@rulecatch {
			    catch (RecognitionException re) {
			        recover(input,re);
			        appendSkippedTokens();
			    }
			}
			
			// Entry rule entryRuleS
			entryRuleS returns [EObject current=null]:
				{ newCompositeNode(grammarAccess.getSRule()); }
				iv_ruleS=ruleS
				{ $current=$iv_ruleS.current; }
				EOF;
			
			// Rule S
			ruleS returns [EObject current=null]
			@init {
				enterRule();
			}
			@after {
				leaveRule();
			}:
				(
					{p0}?=>
					(
					)
					otherlv_1='a'
					{
						newLeafNode(otherlv_1, grammarAccess.getSAccess().getAKeyword_1());
					}
				)*
			;
		''')	
	}
	
	@Test
	def void testRenderingOfSetupBlockInProductionGrammar() {
		'''
			grammar com.foo.bar 
			import "http://www.eclipse.org/emf/2002/Ecore" as ecore
			generate myPack 'http://mypack'
			
			setup $$ s0 $$
			
			S: 'a';
		'''.assertTranslatesToProductionGrammar('''
			grammar DebugInternalbar;
			
			options {
			}
			
			@lexer::header {
			package com.foo.parser.antlr.internal;
			
			// Hack: Use our own Lexer superclass by means of import. 
			// Currently there is no other way to specify the superclass for the lexer.
			import org.eclipse.xtext.parser.antlr.Lexer;
			}
			
			@parser::header {
			package com.foo.parser.antlr.internal;
			}
			
			@parser::members {
			
			 	private barGrammarAccess grammarAccess;
			
			    public InternalbarParser(TokenStream input, barGrammarAccess grammarAccess) {
			        this(input);
			        this.grammarAccess = grammarAccess;
			        registerRules(grammarAccess.getGrammar());
			    }
			
			    @Override
			    protected String getFirstRuleName() {
			    	return "S";
			   	}
			
			   	@Override
			   	protected barGrammarAccess getGrammarAccess() {
			   		return grammarAccess;
			   	}
			   	
			   	// init block
			   	s0
			
			}
			
			@rulecatch {
			    catch (RecognitionException re) {
			        recover(input,re);
			        appendSkippedTokens();
			    }
			}
			
			// Entry rule entryRuleS
			entryRuleS returns [String current=null]:
				{ newCompositeNode(grammarAccess.getSRule()); }
				iv_ruleS=ruleS
				{ $current=$iv_ruleS.current.getText(); }
				EOF;
			
			// Rule S
			ruleS returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
			@init {
				enterRule();
			}
			@after {
				leaveRule();
			}:
				kw='a'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getSAccess().getAKeyword());
				}
			;
		''')
	}
	
	@Test
	def void testRenderingOfGuardConditionInAlternativesInContentAssistGrammar() {
		'''
			grammar com.foo.bar 
			import "http://www.eclipse.org/emf/2002/Ecore" as ecore
			generate myPack 'http://mypack'
			
			S: $$ p0 $$?=> 'a'
			 | $$ p1 $$?=> 'b';
		'''.assertTranslatesToContentAssistGrammar('''
			grammar DebugInternalbar;
			
			options {
			}
			
			@lexer::header {
			package com.foo.parser.antlr.internal;
			
			// Hack: Use our own Lexer superclass by means of import. 
			// Currently there is no other way to specify the superclass for the lexer.
			import org.eclipse.xtext.parser.antlr.Lexer;
			}
			
			@parser::header {
			package com.foo.parser.antlr.internal;
			}
			@parser::members {
				private barGrammarAccess grammarAccess;
			
				public void setGrammarAccess(barGrammarAccess grammarAccess) {
					this.grammarAccess = grammarAccess;
				}
			
				@Override
				protected Grammar getGrammar() {
					return grammarAccess.getGrammar();
				}
			
				@Override
				protected String getValueForTokenName(String tokenName) {
					return tokenName;
				}
				
			   	// no init block
			}
			
			// Entry rule entryRuleS
			entryRuleS
			:
			{ before(grammarAccess.getSRule()); }
				 ruleS
			{ after(grammarAccess.getSRule()); } 
				 EOF 
			;
			
			// Rule S
			ruleS 
				@init {
					int stackSize = keepStackSize();
				}
				:
				(
					{ before(grammarAccess.getSAccess().getAlternatives()); }
					(
						rule__S__Alternatives
					)
					{ after(grammarAccess.getSAccess().getAlternatives()); }
				)
			;
			finally {
				restoreStackSize(stackSize);
			}
			
			rule__S__Alternatives
				@init {
					int stackSize = keepStackSize();
				}
			:
				{p0}?=>(
					{ before(grammarAccess.getSAccess().getGroup_0()); }
					(
						rule__S__Group_0__0
					)
					{ after(grammarAccess.getSAccess().getGroup_0()); }
				)
				|
				{p1}?=>(
					{ before(grammarAccess.getSAccess().getGroup_1()); }
					(
						rule__S__Group_1__0
					)
					{ after(grammarAccess.getSAccess().getGroup_1()); }
				)
			;
			finally {
				restoreStackSize(stackSize);
			}
			
			rule__S__Group_0__0
				@init {
					int stackSize = keepStackSize();
				}
			:
				rule__S__Group_0__0__Impl
				rule__S__Group_0__1
			;
			finally {
				restoreStackSize(stackSize);
			}
			
			rule__S__Group_0__0__Impl
				@init {
					int stackSize = keepStackSize();
				}
			:
			(
				{ before(grammarAccess.getSAccess().getGatedSemanticPredicate_0_0()); }
				(
				)
				{ after(grammarAccess.getSAccess().getGatedSemanticPredicate_0_0()); }
			)
			;
			finally {
				restoreStackSize(stackSize);
			}
			
			rule__S__Group_0__1
				@init {
					int stackSize = keepStackSize();
				}
			:
				rule__S__Group_0__1__Impl
			;
			finally {
				restoreStackSize(stackSize);
			}
			
			rule__S__Group_0__1__Impl
				@init {
					int stackSize = keepStackSize();
				}
			:
			(
				{ before(grammarAccess.getSAccess().getAKeyword_0_1()); }
				'a'
				{ after(grammarAccess.getSAccess().getAKeyword_0_1()); }
			)
			;
			finally {
				restoreStackSize(stackSize);
			}
			
			
			rule__S__Group_1__0
				@init {
					int stackSize = keepStackSize();
				}
			:
				rule__S__Group_1__0__Impl
				rule__S__Group_1__1
			;
			finally {
				restoreStackSize(stackSize);
			}
			
			rule__S__Group_1__0__Impl
				@init {
					int stackSize = keepStackSize();
				}
			:
			(
				{ before(grammarAccess.getSAccess().getGatedSemanticPredicate_1_0()); }
				(
				)
				{ after(grammarAccess.getSAccess().getGatedSemanticPredicate_1_0()); }
			)
			;
			finally {
				restoreStackSize(stackSize);
			}
			
			rule__S__Group_1__1
				@init {
					int stackSize = keepStackSize();
				}
			:
				rule__S__Group_1__1__Impl
			;
			finally {
				restoreStackSize(stackSize);
			}
			
			rule__S__Group_1__1__Impl
				@init {
					int stackSize = keepStackSize();
				}
			:
			(
				{ before(grammarAccess.getSAccess().getBKeyword_1_1()); }
				'b'
				{ after(grammarAccess.getSAccess().getBKeyword_1_1()); }
			)
			;
			finally {
				restoreStackSize(stackSize);
			}
			
		''')
	}
	
	@Test
	def void testRenderingOfGuardConditionInNonTrivialCardinalitityInContentAssistGrammar() {
		'''
			grammar com.foo.bar 
			import "http://www.eclipse.org/emf/2002/Ecore" as ecore
			generate myPack 'http://mypack'
			
			S: ($$ p0 $$?=> 'a')*;
		'''.assertTranslatesToContentAssistGrammar('''
			grammar DebugInternalbar;
			
			options {
			}
			
			@lexer::header {
			package com.foo.parser.antlr.internal;
			
			// Hack: Use our own Lexer superclass by means of import. 
			// Currently there is no other way to specify the superclass for the lexer.
			import org.eclipse.xtext.parser.antlr.Lexer;
			}
			
			@parser::header {
			package com.foo.parser.antlr.internal;
			}
			@parser::members {
				private barGrammarAccess grammarAccess;
			
				public void setGrammarAccess(barGrammarAccess grammarAccess) {
					this.grammarAccess = grammarAccess;
				}
			
				@Override
				protected Grammar getGrammar() {
					return grammarAccess.getGrammar();
				}
			
				@Override
				protected String getValueForTokenName(String tokenName) {
					return tokenName;
				}
				
			   	// no init block
			}
			
			// Entry rule entryRuleS
			entryRuleS
			:
			{ before(grammarAccess.getSRule()); }
				 ruleS
			{ after(grammarAccess.getSRule()); } 
				 EOF 
			;
			
			// Rule S
			ruleS 
				@init {
					int stackSize = keepStackSize();
				}
				:
				(
					{ before(grammarAccess.getSAccess().getGroup()); }
					(
						{p0}?=>
						rule__S__Group__0
					)
				*
					{ after(grammarAccess.getSAccess().getGroup()); }
				)
			;
			finally {
				restoreStackSize(stackSize);
			}
			
			rule__S__Group__0
				@init {
					int stackSize = keepStackSize();
				}
			:
				rule__S__Group__0__Impl
				rule__S__Group__1
			;
			finally {
				restoreStackSize(stackSize);
			}
			
			rule__S__Group__0__Impl
				@init {
					int stackSize = keepStackSize();
				}
			:
			(
				{ before(grammarAccess.getSAccess().getGatedSemanticPredicate_0()); }
				(
				)
				{ after(grammarAccess.getSAccess().getGatedSemanticPredicate_0()); }
			)
			;
			finally {
				restoreStackSize(stackSize);
			}
			
			rule__S__Group__1
				@init {
					int stackSize = keepStackSize();
				}
			:
				rule__S__Group__1__Impl
			;
			finally {
				restoreStackSize(stackSize);
			}
			
			rule__S__Group__1__Impl
				@init {
					int stackSize = keepStackSize();
				}
			:
			(
				{ before(grammarAccess.getSAccess().getAKeyword_1()); }
				'a'
				{ after(grammarAccess.getSAccess().getAKeyword_1()); }
			)
			;
			finally {
				restoreStackSize(stackSize);
			}
			
		''')	
	}
	
	@Test
	def void testRenderingOfSetupBlockInContentAssistGrammar() {
		'''
			grammar com.foo.bar 
			import "http://www.eclipse.org/emf/2002/Ecore" as ecore
			generate myPack 'http://mypack'
			
			setup $$ s0 $$
			
			S: 'a';
		'''.assertTranslatesToContentAssistGrammar('''
			grammar DebugInternalbar;
			
			options {
			}
			
			@lexer::header {
			package com.foo.parser.antlr.internal;
			
			// Hack: Use our own Lexer superclass by means of import. 
			// Currently there is no other way to specify the superclass for the lexer.
			import org.eclipse.xtext.parser.antlr.Lexer;
			}
			
			@parser::header {
			package com.foo.parser.antlr.internal;
			}
			@parser::members {
				private barGrammarAccess grammarAccess;
			
				public void setGrammarAccess(barGrammarAccess grammarAccess) {
					this.grammarAccess = grammarAccess;
				}
			
				@Override
				protected Grammar getGrammar() {
					return grammarAccess.getGrammar();
				}
			
				@Override
				protected String getValueForTokenName(String tokenName) {
					return tokenName;
				}
				
			   	// init block
			   	s0
			}
			
			// Entry rule entryRuleS
			entryRuleS
			:
			{ before(grammarAccess.getSRule()); }
				 ruleS
			{ after(grammarAccess.getSRule()); } 
				 EOF 
			;
			
			// Rule S
			ruleS 
				@init {
					int stackSize = keepStackSize();
				}
				:
				(
					{ before(grammarAccess.getSAccess().getAKeyword()); }
					'a'
					{ after(grammarAccess.getSAccess().getAKeyword()); }
				)
			;
			finally {
				restoreStackSize(stackSize);
			}
		''')
	}
	
	protected def void assertTranslatesToProductionGrammar(CharSequence xtextGrammar, String expectedDebugGrammar) {
		val grammar = super.getModel(xtextGrammar.toString) as Grammar
		val injector = Guice.createInjector(new DefaultGeneratorModule)
		val inMem = new InMemFSA
		val options = new AntlrOptions
		injector.getInstance(AntlrDebugProductionGrammarGenerator).generate(grammar, options, inMem)
		assertEquals(expectedDebugGrammar, inMem.allFiles.values.head.toString)
	}
	
	protected def void assertTranslatesToContentAssistGrammar(CharSequence xtextGrammar, String expectedDebugGrammar) {
		val grammar = super.getModel(xtextGrammar.toString) as Grammar
		val injector = Guice.createInjector(new DefaultGeneratorModule)
		val inMem = new InMemFSA
		val options = new AntlrOptions
		injector.getInstance(AntlrDebugContentAssistGrammarGenerator).generate(grammar, options, inMem)
		assertEquals(expectedDebugGrammar, inMem.allFiles.values.head.toString)
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