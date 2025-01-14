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
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.GlobalRegistries;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.HoistingProcessor;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.EndlessPrefixException;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.TokenAnalysisAbortedException;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.hoistingGuards.HoistingGuard;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
	
	private String keyword(String keyword, int offset) {
		return "!\"" + keyword + "\".equals(input.LT(" + offset + ").getText())";
	}
	
	@SuppressWarnings("unused")
	private String terminal(String terminal, int offset) {
		return "input.LA(" + offset + ") != " + terminal;
	}
	
	private String eof(int offset) {
		return "input.LA(" + offset + ") != EOF";
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
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
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
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertFalse(guard.hasTerminal());
		assertEquals("p0", guard.render());
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
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals("p0", guard.render());
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
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
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
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertTrue(guard.isTrivial());
		assertTrue(guard.hasTerminal());
	}
	
	@Test
	public void testPredicateTerminal_expectPredicateInGuard() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} $$ p0 $$?=> T ;\n" +
			"terminal T: 'a';";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals("p0", guard.render());
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
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals("(p0) && (p1)", guard.render());
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
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals("p0", guard.render());
	}
	
	@Test
	public void testEnumRuleCallPredicate_expectPredicateNotInGuard() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: e=E $$ p0 $$?=> 's';\n" +
			"enum E: A='a' | B='b';";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertTrue(guard.isTrivial());
		assertTrue(guard.hasTerminal());
	}

	@Test
	public void testGroupInGroup_expectMinimalParentheses() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: $$ p0 $$?=> ($$ p1 $$?=> ($$ p2 $$?=> 'a')); ";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals("(p0) && (p1) && (p2)", guard.render());
	}
	
	@Test
	public void testCardinalityPlusPredicate_expectPredicateAfterGroupNotInGuard() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: ($$ p0 $$?=> 'a')+ $$ p1 $$?=> ;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals("p0", guard.render());
	}

	@Test
	public void testCardinalityQuestionmarkWithContext() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: ($$ p0 $$?=> 'a')? $$ p1 $$?=> 's';";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(keyword("a", 1) + " || (p0)", guard.render());
	}
	
	@Test
	public void testCardinalityQuestionmarkWithoutContext_expectNoContextCheck() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: ($$ p0 $$?=> 'a')?;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(keyword("a", 1) + " || (p0)", guard.render());
	}

	@Test
	public void testCardinalityQuestionmarkWithExternalContext_expectContextCheck() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: A 'b';\n" +
			"A: ($$ p0 $$?=> 'a')?;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "A");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(keyword("a", 1) + " || (p0)", guard.render());
	}
	
	@Test
	public void testCardinalityStarWithContext() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: ($$ p0 $$?=> 'a')* $$ p1 $$?=> 's';";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(keyword("a", 1) + " || (p0)", guard.render());
	}
	
	@Test
	public void testCardinalityStarWithoutContextWithoutPredicates_expectUnguarded() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: ('a')*;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertTrue(guard.isTrivial());
		assertFalse(guard.hasTerminal());
	}
	
	@Test
	public void testCardinalityStarWithoutContext_expectContextCheck() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: ($$ p0 $$?=> 'a')* ;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(keyword("a", 1) + " || (p0)", guard.render());
	}
	

	@Test
	public void testUnorderedGroup() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: (($$ p0 $$?=> 'a') & ($$ p1 $$?=> 'b')) $$ p2 $$?=> 's';";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals("(" + keyword("a", 1) + " || (p0)) && (" + keyword("b", 1) + " || (p1))", guard.render());
	}
	
	@Test
	public void testUnorderedGroupWithEmptyPathsWithoutContextWithoutPredicates_expectUnguarded() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: ('a')? & ('b');";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertTrue(guard.isTrivial());
		assertFalse(guard.hasTerminal());
	}
	
	@Test
	public void testUnorderedGroupWithNoEmptyPathsWithoutContext() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: ($$ p0 $$?=> 'a') & ($$ p1 $$?=> 'b');";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + keyword("a", 1) + " || (p0)) && " + 
				"(" + keyword("b", 1) + " || (p1))", 
			guard.render());
	}
	
	// predicates in unordered group with optional paths are currently not supported by the algorithm
	@Ignore
	@Test
	public void testUnorderedGroupWithEmptyPathsWithoutContext_expectTokenAnalysisAbortedException() throws Exception {		
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: ($$ p0 $$?=> 'a')? & ($$ p1 $$?=> 'b');";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + keyword("a", 1) + " || (p0)) && " + 
				"(" + keyword("b", 1) + " || (p1))",
			guard.render());
	}
	
	// predicates in unordered group with optional paths are currently not supported by the algorithm
	@Ignore
	@Test
	public void testUnorderedGroupWithoutMandatoryContentWithContext() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: (($$ p0 $$?=> 'a')? & ($$ p1 $$?=> 'b')?) $$ p2 $$?=> 's';";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + keyword("a", 1) + " || (p0)) && " + 
				"(" + keyword("b", 1) + " || (p1))",
			guard.render());
	}
	
	// predicates in unordered group with optional paths are currently not supported by the algorithm
	@Ignore
	@Test
	public void testUnorderedGroupWithoutMandatoryContentWithoutContext_expectNoEofCheck() throws Exception {
		// no eof check needed since that case is covered by the two alternatives
		
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: ($$ p0 $$?=> 'a')? & ($$ p1 $$?=> 'b')?;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + keyword("a", 1) + " || (p0)) && " + 
				"(" + keyword("b", 1) + " || (p1))",
			guard.render());
	}
	
	@Test
	public void testUnorderedGroup_bugGroupsChangeDuringHoisting_expectNoChange() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: (($$ p0 $$?=> 'a') & ($$ p1 $$?=> 'b')) $$ p2 $$?=> 's';";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + keyword("a", 1) + " || (p0)) && " + 
				"(" + keyword("b", 1) + " || (p1))",
			guard.render());
		
		// check sizes of groups in unordered group
		Group group = (Group) rule.getAlternatives();
		assertEquals(3, group.getElements().size());
		UnorderedGroup unorderedGroup = (UnorderedGroup) group.getElements().get(0);
		assertEquals(2, unorderedGroup.getElements().size());
		group = (Group) unorderedGroup.getElements().get(0);
		assertEquals(2, group.getElements().size());
		group = (Group) unorderedGroup.getElements().get(1);
		assertEquals(2, group.getElements().size());
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
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertFalse(guard.hasTerminal());
		assertEquals("(p0) || (p1)", guard.render());
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
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals("(" + keyword("a", 1) + " || (p0)) && (" + keyword("b", 1) + " || (p1))", guard.render());
	}
	
	@Test
	public void testAlternativesWithPrefixPathsAndNonEofContext_expectGuardBasedOnContext() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: a=A 's' ;\n" +
			"A: {A} $$ p0 $$?=> 'a' \n" +
			" | {A} $$ p1 $$?=> 'a' 'b' ;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "A");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + keyword("s", 2) + " || (p0)) && " + 
				"(" + keyword("b", 2) + " || (p1))",
			guard.render());
	}

	@Test
	public void testAlternativeWithDifferentEnumRule() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: $$ p0 $$?=> e1=E1 \n" +
			" | $$ p1 $$?=> e2=E2 ;\n" +
			"enum E1: A='a' | B='b'; \n" +
		    "enum E2: C='c' | D='d';";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + 
					"(" + keyword("a", 1) + " && " + keyword("b", 1) + ") || " + 
					"(p0)" + 
				") && (" + 
					"(" + keyword("c", 1) + " && " + keyword("d", 1) + ") || " + 
					"(p1)" + 
				")",
			guard.render());
	}
	
	@Test
	public void testAlternativeWithSameEnumRule() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: $$ p0 $$?=> e=E 'a' \n" +
			" | $$ p1 $$?=> e=E 'b' ;\n" +
			"enum E: A='a' | B='b'; ";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + keyword("a", 2) + " || (p0)) && " + 
				"(" + keyword("b", 2) + " || (p1))",
			guard.render());
	}
	
	@Test
	public void testAlternativeIdenticalPaths() throws Exception {
		// @formatter:off
		String model =
			// boundary check: the 10th token should be handled correctly
			MODEL_PREAMBLE +
			"S: {S} $$ p0 $$?=> 'a' 'b' 'c' 'd' 'e' 'f' 'g' 'h' 'i' 'j' \n" +
			" | {S} $$ p1 $$?=> 'a' 'b' 'c' 'd' 'e' 'f' 'g' 'h' 'i' 'j' \n" +
			" | {S} $$ p2 $$?=> 'a' 'b' 'c' 'd' 'e' 'f' 'g' 'h' 'i' 'k' ;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + keyword("j", 10) + " || (p0) || (p1)) && " + 
				"(" + keyword("k", 10) + " || (p2))",
			guard.render());
	}
	
	@Test
	public void testAlternativeIdenticalPaths_bugChangesToEcoreOjects_expectNoChange() throws Exception {
		// @formatter:off
		String model =
			// boundary check: the 10th token should be handled correctly
			MODEL_PREAMBLE +
			"S: {S} $$ p0 $$?=> 'a' \n" +
			" | {S} $$ p1 $$?=> 'a' \n" +
			" | {S} $$ p2 $$?=> 'b' ;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + keyword("a", 1) + " || (p0) || (p1)) && " + 
				"(" + keyword("b", 1) + " || (p2))",
			guard.render());
		
		// number of elements in Alternatives object has to stay the same
		// even though the identical paths are collapsed during the hoisting process
		assertEquals(3, ((Alternatives) rule.getAlternatives()).getElements().size());
	}
	
	@Test
	public void testAlternativeUnguarded() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} 'a' \n" +
			" | {S} 'b' ;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertTrue(guard.isTrivial());
		assertTrue(guard.hasTerminal());
	}
	
	@Test
	public void testUnorderedGroupInAlternatives_bugUnknownElementInTokenAnalysis_expectNoException() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} $$ p0 $$?=> 'a' \n" +
			" | {S} $$ p1 $$?=> ('b' & 'c');";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + 
					keyword("a", 1) + " || (p0)" + 
				") && (" + 
					"(" + 
						keyword("b", 1) + " && " + keyword("c", 1) + 
					") || (p1)" + 
				")",
			guard.render());
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
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(keyword("a", 1) + " || (p0)", guard.render());
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
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + 
					"(" + 
						"(" + 
							keyword("b", 2) + " || " + 
							keyword("b", 3) + 
						") && (" + 
							keyword("c", 2) + " || " + 
							keyword("c", 3) + 
						")" + 
					") || (p0)" + 
				") && (" + 
					"(" + 
						"(" + 
							keyword("b", 2) + " || " + 
							keyword("c", 3) + 
						") && (" + 
							keyword("c", 2) + " || " + 
							keyword("b", 3) + 
						")" + 
					") || (p1)" + 
				")",
			guard.render());
	}
	
	@Test
	public void testNestedAlternativesWithCollapsablePathsWithSingleDifferencePosition() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
				"S: $$ p0 $$?=> a=A \n" +
				" | $$ p1 $$?=> 'a' 'b' 'd' ;\n" +
				"A: {A} $$ p2 $$?=> 'a' 'b' 'b' \n" +
				" | {A} $$ p3 $$?=> 'a' 'b' 'c' ;";
		
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		
		assertEquals(
				"(" + 
					keyword("b", 3) + " || " + 
					"((p0) && (p2))" + 
				") && (" + 
					keyword("c", 3) + " || " + 
					"((p0) && (p3))" + 
				") && (" + 
					keyword("d", 3) + " || " + 
					"(p1))",
			guard.render());
	}
	
	@Test
	public void testNestedAlternativesWithCollapsablePathsWithMultipleDifferencePosition() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
				"S: $$ p0 $$?=> a=A \n" +
				" | $$ p1 $$?=> 'a' 'b' ;\n" +
				"A: {A} $$ p2 $$?=> 'b' 'a' \n" +
				" | {A} $$ p3 $$?=> 'b' 'b' ;";
		
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		
		// collapsed version is actually not optimal
		//assertEquals("(" + keyword("a", 2) + " || " + keyword("b", 1) + " || ((p0) && (p2))) && (" + keyword("b", 2) + " || " + keyword("b", 1) + " || ((p0) && (p3))) && (" + keyword("a", 1) + " || (p1))", guard.render());
		assertEquals(
				"(" + 
					keyword("b", 1) + " || " +
					"(" +
						"(p0) && (" +
							keyword("a", 2) + " || " +
							"(p2)" + 
						") && (" + 
							keyword("b", 2) + " || " +
							"(p3)" + 
						")" +
					")" +
				") && (" + 
					keyword("a", 1) + " || " + 
					"(p1)" + 
				")",
			guard.render());
	}
	
	// currently not able to find optimal solution
	// for that we would not to collapse alternatives before constructing guards
	@Test
	public void testRecursiveRuleCallingAlternative_expectCorrectGuard() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
				"S: $$ p0 $$?=> a=A \n" +
				" | $$ p1 $$?=> 'a' 'b' 'd' ;\n" +
				"A: $$ p2 $$?=> 'a' a=A \n" +
				" | $$ p3 $$?=> 'b' 'c' ;\n";
		
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		
		// algorithm is currently not optimal
		
		// optimal result:
		//assertEquals("(" + keyword("a", 1) + " || (" + keyword("c", 3) + " && " + eof(3) + ") || ((p0) && (p2))) && (" + keyword("c", 1) + " || ((p0) && (p3))) && (" + keyword("d", 3) + " || (p1))", guard.render());
		
		// still valid but non-optimal:
		assertEquals(
				"(" + 
					"(" +
						keyword("a", 3) + " && " +
						keyword("b", 3) + " && " +
						keyword("c", 3) + " && " +
						eof(3) + 
					") || (" +
						"(p0) && (" +
							keyword("a", 1) + " || " +
							"(p2)" +
						") && (" +
							keyword("b", 1) + " || " +
							"(p3)" +
						")" +
					")" + 
				") && (" +
					keyword("d", 3) + " || " +
					"(p1)" +
				")",
			guard.render());
	}
	
	@Test
	public void testAlternativeEmptyAndNonEmptyPaths_expectEofCheck() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} $$ p0 $$?=> 'a' \n" +
			" | {S} $$ p1 $$?=> ;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertEquals("(" + keyword("a", 1) + " || (p0)) && (" + eof(1) + " || (p1))", guard.render());
	}
	
	@Test
	public void testAlternativeWithPrefixPath_expectEofCheck() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} $$ p0 $$?=> 'a' 'b' \n" +
			" | {S} $$ p1 $$?=> 'a' 'b' 'c' ;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertEquals(
				"(" + eof(3) + " || (p0)) && " + 
				"(" + keyword("c", 3) + " || (p1))",
			guard.render());
	}
	
	@Test
	public void testAlternativeWithPrefixPathAndContextWithSimilarities_expectLookAheadContextCheck() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: a=A 'c' 'd' ;\n" +
			"A: {A} $$ p0 $$?=> 'a' 'b' \n" +
			" | {A} $$ p1 $$?=> 'a' 'b' 'c' ;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "A");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertEquals(
				"(" + keyword("d", 4) + " || (p0)) && " + 
				"(" + keyword("c", 4) + " || (p1))",
			guard.render());
	}
	
	@Test
	public void testAlternativeWithPrefixPathAndMultipleContexts_expectNonTrivialContextCheck() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: a=A 'c' \n" +
			" | a=A 'd' ;\n" +
			"A: {A} $$ p0 $$?=> 'a' \n" +
			" | {A} $$ p1 $$?=> 'a' 'b' ;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "A");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertEquals(
				"(" + 
					"(" + 
						keyword("c", 2) + " && " + 
						keyword("d", 2) + 
					") || (p0)" + 
				") && (" + 
					keyword("b", 2) + " || " + 
					"(p1)" + 
				")",
			guard.render());
	}
	
	@Test(expected = TokenAnalysisAbortedException.class)
	public void testAlternativeWithPrefixPathAndContextIsNotDistinct_expectTokenAnalysisAbortedException() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: a=A 'b' 'b' 'b' 'b' 'b' 'b' 'b' 'b' 'b';\n" +
			"A: {A} $$ p0 $$?=> 'a' \n" +
			" | {A} $$ p1 $$?=> 'a' 'b' ;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "A");
		
		hoistingProcessor.findHoistingGuard(rule.getAlternatives());
	}
	
	@Test(expected = TokenAnalysisAbortedException.class)
	public void testAlternativeIdenticalPathsInTokenLimit_expectTokenAnalysisAbortedException() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} $$ p0 $$?=> 'a' 'b' 'c' 'd' 'e' 'f' 'g' 'h' 'i' 'j' 'k' '!' \n" +
			" | {S} $$ p1 $$?=> 'a' 'b' 'c' 'd' 'e' 'f' 'g' 'h' 'i' 'j' 'k' '?' ;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");

		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
	}
	
	@Test
	public void testNestedAlternativesWithIdenticalPrefix_bugPathIdentityCheckDoesNotConsiderContext_expectContextCheckInResult() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} $$ p0 $$?=> (\n" +
			"      'a' \n" +
			"    | 'a' 'b' \n" +
			"   ) \n" +
			" | {S} $$ p1 $$?=> (\n" +
			"      'a' \n" + 
			"    | 'a' 'c' \n" + 
			"   ) \n" +
			" | {S} $$ p2 $$?=> 'd' ;\n";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + keyword("a", 1) + " || " + eof(2) + " || (p0) || (p1)) && " + 
				"(" + keyword("b", 2) + " || (p0)) && " + 
				"(" + keyword("c", 2) + " || (p1)) && " +
				"(" + keyword("d", 1) + " || (p2))",
			guard.render()
		);
	}
	
	@Test
	public void testNestedAlternativesWithIdenticalPrefix_parentElementShouldNotBeChanged_expectContextCheckInResult() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} $$ p0 $$?=> ('a')? \n" +
			" | {S} $$ p1 $$?=> ('b')? ;\n";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + eof(1) + " || (p0) || (p1)) && " + 
				"(" + keyword("a", 1) + " || (p0)) && " + 
				"(" + keyword("b", 1) + " || (p1))",
			guard.render()
		);
		
		// check sizes of groups and cardinalities of keywords
		Alternatives alternatives = (Alternatives) rule.getAlternatives();
		assertEquals(2, alternatives.getElements().size());
		Group group = (Group) alternatives.getElements().get(0);
		assertEquals(3, group.getElements().size());
		Keyword keyword = (Keyword) group.getElements().get(2);
		assertEquals("?", keyword.getCardinality());
		group = (Group) alternatives.getElements().get(1);
		assertEquals(3, group.getElements().size());
		keyword = (Keyword) group.getElements().get(2);
		assertEquals("?", keyword.getCardinality());
	}
	
	// symbolic analysis not yet implemented
	//@Test
	public void testAlternativesIdenticalPathsWithSymbolicAnalysis() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} $$ p0 $$?=> C 'z' 'y' 'x' \n" +
			" | {S} $$ p1 $$?=> C 'z' 'y' 'x' ;\n" +
			"C: {C} ('a')* ;";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals("((p0) || (p1))", guard.render());
	}
	
	@Test
	public void testCardinalitiesDirectContext_expectCorrectResult() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} a+=A+ ;\n" +
			"A: $$ p0 $$?=> 'a' \n" +
			" | $$ p1 $$?=> 'a' 'b' ;\n";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "A");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + 
					"(" + 
						keyword("a", 2) + " && " + 
						eof(2) + 
					") || (p0)" + 
				") && (" + 
					keyword("b", 2) + " || " + 
					"(p1)" + 
				")",
			guard.render());
	}
	
	@Test
	public void testCardinalitiesInGroupContext_expectCorrectResult() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} ('a' a+=A)+ ;\n" +
			"A: $$ p0 $$?=> 'b' \n" +
			" | $$ p1 $$?=> 'b' 'b' ;\n";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "A");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + 
					"(" + 
						keyword("a", 2) + " && " + 
						eof(2) + 
					") || (p0)" + 
				") && (" + 
					keyword("b", 2) + " || " + 
					"(p1)" + 
				")", guard.render());
	}
	
	@Test
	public void testCardinalitiesIndirectContext_expectCorrectResult() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: {S} (a+=A)+ ;\n" +
			"A: $$ p0 $$?=> 'a' \n" +
			" | $$ p1 $$?=> 'a' 'b' ;\n";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "A");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + 
					"(" + 
						keyword("a", 2) + " && " + 
						eof(2) + 
					") || (p0)" + 
				") && (" + 
					keyword("b", 2) + " || " + 
					"(p1)" + 
				")",
			guard.render());
	}
	
	@Test
	public void testRecursiveContextWithIntermediate_expectCorrectResult() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: a=A ;\n" +
			"A: $$ p0 $$?=> 'a' \n" +
			" | $$ p1 $$?=> 'a' s=S ;\n";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "A");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + eof(2) + " || (p0)) && " + 
				"(" + keyword("a", 2) + " || (p1))",
			guard.render());
	}
	
	@Test
	public void testRecursiveContextNoIntermediate_expectCorrectResult() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: $$ p0 $$?=> 'a' \n" +
			" | $$ p1 $$?=> 'a' s=S ;\n";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + eof(2) + " || (p0)) && " + 
				"(" + keyword("a", 2) + " || (p1))",
			guard.render());
	}
	
	@Test
	public void testRepeatablyQuantifiedContextWithEmptyPath_bug_expectCorrectResult() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: A C+ ;\n" +
			"A: $$ p0 $$?=> 'a' " + 
			" | $$ p1 $$?=> 'a' 'b' ;\n" +
			"C: 'c'? ;\n";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "A");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + 
					"(" + 
						eof(2) + " && " + 
						keyword("c", 2) + 
					") || (p0)" + 
				") && (" + 
					keyword("b", 2) + " || " + 
					"(p1)" + 
				")",
			guard.render());
	}
	
	@Test
	public void testRecursiveContextWithEmptyPath_bug_expectCorrectResult() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: a=A c=C ;\n" +
			"A: $$ p0 $$?=> 'a' " + 
			" | $$ p1 $$?=> 'a' 'b' ;\n" +
			"C: {C} \n" +
			" | 'c' C ;\n";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "A");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + 
					"(" + 
						eof(2) + " && " + 
						keyword("c", 2) + 
					") || (p0)" + 
				") && (" + 
					keyword("b", 2) + " || " + 
					"(p1)" + 
				")",
			guard.render());
	}
	
	@Test
	public void testStartRuleRecursiveRuleWithOptionalContext_bug_expectCorrectResult() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"S: a=A c+=C+ ;\n" +
			"A: $$ p0 $$?=> 'a' " + 
			" | $$ p1 $$?=> 'a' s=S ;\n" +
			"C: $$ p2 $$?=> \n" +
			" | $$ p3 $$?=> 'c' ;\n";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "A");
		
		HoistingGuard guard = hoistingProcessor.findHoistingGuard(rule.getAlternatives());
		assertFalse(guard.isTrivial());
		assertTrue(guard.hasTerminal());
		assertEquals(
				"(" + 
					"(" + 
						eof(2) + " && " + 
						keyword("c", 2) + 
					") || (p0)" + 
				") && (" + 
					keyword("a", 2) + " || " + 
					"(p1)" + 
				")",
			guard.render());
	}
	
	@Test(expected = EndlessPrefixException.class)
	public void testRecursionInNestedAlternatives_bugEndlessLoop_expectEndlessPrefixException() throws Exception {
		// @formatter:off
		String model =
			MODEL_PREAMBLE +
			"hoistingDebug\n" +
			"S: $$ p0 $$?=> a=A 's'\n" + 
			" | $$ p1 $$?=> a=A 't';\n" +
			"A: $$ p2 $$?=> b=B 'u'\n" + 
			" | $$ p3 $$?=> b=B 'v';\n" +
			"B: $$ p4 $$?=> 'a' 'b' 'c'\n" + 
			" | $$ p5 $$?=> 'z' s=S;\n";
		// @formatter:off
		XtextResource resource = getResourceFromString(model);
		Grammar grammar = ((Grammar) resource.getContents().get(0));
		hoistingProcessor.init(grammar);
		AbstractRule rule = getRule(grammar, "S");
		
		hoistingProcessor.findHoistingGuard(rule.getAlternatives());
	}
}
