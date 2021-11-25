/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.hoisting;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.GlobalRegistries;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.HoistingGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.HoistingProcessor;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.TokenAnalysisAbortedException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author overflow - Initial contribution and API
 */
public class HoistingProcessorTest extends AbstractXtextTests {
	private final String MODEL_PREAMBLE = 
			"grammar org.eclipse.xtext.xbase.Xbase with org.eclipse.xtext.common.Terminals\n" +
			"import 'http://www.eclipse.org/emf/2002/Ecore' as ecore\n" +
			"generate myPack 'http://mypack'\n";
	
	private GlobalRegistries.GlobalStateMemento globalStateMemento;

	private HoistingProcessor hoistingProcessor;
	
	@Before
	@Override
	public void setUp() throws Exception {
		globalStateMemento = GlobalRegistries.makeCopyOfGlobalState();
		super.setUp();
		EPackage.Registry.INSTANCE.put(XMLTypePackage.eNS_URI, XMLTypePackage.eINSTANCE);
		with(XtextStandaloneSetup.class);
		
		hoistingProcessor = new HoistingProcessor();
	}

	@After
	@Override
	public void tearDown() throws Exception {
		super.tearDown();
		globalStateMemento.restoreGlobalState();
	}
	
	
	private AbstractRule getRule(Grammar grammar, String name) {
		return grammar.getRules().stream()
				.filter(r -> name.equals(r.getName()))
				.findFirst().get();
	}
	
	private String getSyntaxForKeywordToken(String keyword, int offset) {
		return "!\"" + keyword + "\".equals(input.LT(" + offset + ").getText())";
	}
	private String getSyntaxForTerminalToken(String terminal, int offset) {
		return "input.LT(" + offset + ").getType() != " + terminal;
	}
	
	@Test
	public void testEmptyRule() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S};";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findGuardForElement(rule.getAlternatives());
		assertTrue(guard.isTrivial());
		assertFalse(guard.hasTerminal());
	}
	
	@Test
	public void testPredicateNoTokens() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} $$ p0 $$?=>;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findGuardForElement(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertFalse(guard.hasTerminal());
		assertEquals("(p0)", guard.render());
	}
		
	@Test
	public void testPredicateKeyword() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} $$ p0 $$?=> 'a';";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findGuardForElement(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals("(p0)", guard.render());
	}
	
	@Test
	public void testKeywordPredicate_expectPredicateNotInGuard() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} 'a' $$ p0 $$?=>;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findGuardForElement(rule.getAlternatives());
		assertTrue(guard.isTrivial());
		assertTrue(guard.hasTerminal());
	}
	
	@Test
	public void testTerminalPredicate_expectPredicateNotInGuard() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} T $$ p0 $$?=>;\n" +
			"terminal T: 'a';";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findGuardForElement(rule.getAlternatives());
		assertTrue(guard.isTrivial());
		assertTrue(guard.hasTerminal());
	}

	@Test
	public void testConsecutivePredicatesKeyword() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} $$ p0 $$?=> $$ p1 $$?=> 'a';";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findGuardForElement(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals("((p0) && (p1))", guard.render());
	}
	
	@Test
	public void testParserRuleCall() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: A 's';\n" +
			"A: {A} $$ p0 $$?=> 'a';";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findGuardForElement(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals("(p0)", guard.render());
	}

	@Test
	public void testCardinalityPlusWithTokens() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: ($$ p0 $$?=> 'a')+ $$ p1 $$?=> 's';";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findGuardForElement(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals("(p0)", guard.render());
	}

	@Test
	public void testCardinalityQuestionmarkWithTokens() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: ($$ p0 $$?=> 'a')? $$ p1 $$?=> 's';";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findGuardForElement(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals("((" + getSyntaxForKeywordToken("s", 1) + " || (p1)) && (" + getSyntaxForKeywordToken("a", 1) + " || (p0)))", guard.render());
	}

	@Test
	public void testCardinalityStarWithTokens() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: ($$ p0 $$?=> 'a')* $$ p1 $$?=> 's';";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findGuardForElement(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals("((" + getSyntaxForKeywordToken("s", 1) + " || (p1)) && (" + getSyntaxForKeywordToken("a", 1) + " || (p0)))", guard.render());
	}
	
	@Test
	public void testAlternativeNoToken() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} $$ p0 $$?=> \n" +
			" | {S} $$ p1 $$?=> ;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findGuardForElement(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertFalse(guard.hasTerminal());
		assertEquals("((p0) || (p1))", guard.render());
	}
	
	@Test
	public void testAlternativeSimple() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} $$ p0 $$?=> 'a' \n" +
			" | {S} $$ p1 $$?=> 'b' ;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findGuardForElement(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals("((" + getSyntaxForKeywordToken("a", 1) + " || (p0)) && (" + getSyntaxForKeywordToken("b", 1) + " || (p1)))", guard.render());
	}

	@Test
	public void testAlternativeIdenticalPaths() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} $$ p0 $$?=> 'a' \n" +
			" | {S} $$ p1 $$?=> 'a' \n" +
			" | {S} $$ p2 $$?=> 'b' ;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findGuardForElement(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals("((" + getSyntaxForKeywordToken("a", 1) + " || ((p0) || (p1))) && (" + getSyntaxForKeywordToken("b", 1) + " || (p2)))", guard.render());
	}
	
	@Test
	public void testAlternativeUnguardedPath() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} $$ p0 $$?=> 'a' \n" +
			" | {S} 'b' ;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findGuardForElement(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals("(" + getSyntaxForKeywordToken("a", 1) + " || (p0))", guard.render());
	}
	
	@Test
	public void testNestedAlternativesWithSingleTokenDifference() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
				"S: $$ p0 $$?=> a=A \n" +
				" | $$ p1 $$?=> b=B ;\n" +
				"A: {A} $$ p2 $$?=> 'a' 'b' 'c' \n" +
				" | {A} $$ p3 $$?=> 'a' 'c' 'c' ;\n" +
				"B: {B}             'a' 'c' 'd' \n" +
				" | {B}             'a' 'b' 'd' ;\n";
		
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findGuardForElement(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals("((" + getSyntaxForKeywordToken("c", 3) + " || ((p0) && ((" + getSyntaxForKeywordToken("b", 2) + " || (p2)) && (" + getSyntaxForKeywordToken("c", 2) + " || (p3))))) && (" + getSyntaxForKeywordToken("d", 3) + " || (p1)))", guard.render());
	}
	
	@Test
	public void testNestedAlternativesWithNoSingleTokenDifference() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
				"S: $$ p0 $$?=> a=A \n" +
				" | $$ p1 $$?=> b=B ;\n" +
				"A: {A} 'a' 'b' 'b' \n" +
				" | {A} 'a' 'c' 'c' ;\n" +
				"B: {B} 'a' 'b' 'c' \n" +
				" | {B} 'a' 'c' 'b' ;\n";
		
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findGuardForElement(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		
		// order of paths in result depends on Set-order;
		// TODO: maybe change to List to make testing easier
		assertEquals("((((" + getSyntaxForKeywordToken("b", 2) + " || " + getSyntaxForKeywordToken("b", 3) + ") && (" + getSyntaxForKeywordToken("c", 2) + " || " + getSyntaxForKeywordToken("c", 3) + ")) || (p0)) && (((" + getSyntaxForKeywordToken("b", 2) + " || " + getSyntaxForKeywordToken("c", 3) + ") && (" + getSyntaxForKeywordToken("c", 2) + " || " + getSyntaxForKeywordToken("b", 3) + ")) || (p1)))", guard.render());
	}
	
	@Test(expected = TokenAnalysisAbortedException.class)
	public void testAlternativeEmptyAndNonEmptyPaths_expectTokenAnalysisAbortedException() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} $$ p0 $$?=> 'a' \n" +
			" | {S} $$ p1 $$?=> ;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		AbstractRule rule = getRule(grammar, "S");
		
		hoistingProcessor.findGuardForElement(rule.getAlternatives());
	}
	
	@Test(expected = TokenAnalysisAbortedException.class)
	public void testAlternativeWithPrefixPath_expectTokenAnalysisAbortedException() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} $$ p0 $$?=> 'a' 'b' \n" +
			" | {S} $$ p1 $$?=> 'a' 'b' 'c' ;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		AbstractRule rule = getRule(grammar, "S");
		
		hoistingProcessor.findGuardForElement(rule.getAlternatives());
	}
	
	@Test(expected = TokenAnalysisAbortedException.class)
	public void testAlternativeIdenticalPathsInTokenLimit_expectTokenAnalysisAbortedException() throws Exception {
		// this test shouldn't make problems for symbolic analysis
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} $$ p0 $$?=> 'a' 'b' 'c' 'd' 'e' 'f' 'g' 'h' 'i' 'j' 'k' '!' \n" +
			" | {S} $$ p1 $$?=> 'a' 'b' 'c' 'd' 'e' 'f' 'g' 'h' 'i' 'j' 'k' '?' ;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		AbstractRule rule = getRule(grammar, "S");
		
		hoistingProcessor.findGuardForElement(rule.getAlternatives());

	}
}