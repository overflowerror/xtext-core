/**
 * Copyright (c) 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.hoisting;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrDebugContentAssistGrammarGenerator;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrDebugProductionGrammarGenerator;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrOptions;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author overflow - Initial contribution and API
 */
@Ignore
@SuppressWarnings("all")
public class HoistingGeneratorBenchmark extends AbstractXtextTests {
  public static class InMemFSA extends InMemoryFileSystemAccess implements IXtextGeneratorFileSystemAccess {
    @Override
    public String getPath() {
      return "./";
    }
    
    @Override
    public boolean isOverwrite() {
      return true;
    }
    
    @Override
    public void initialize(final Injector injector) {
      injector.injectMembers(this);
    }
  }
  
  private final int REPETITIONS = 1000;
  
  @Override
  public void setUp() throws Exception {
    super.setUp();
    this.with(XtextStandaloneSetup.class);
  }
  
  @Test
  public void testFullTranslationBenchmark() {
    for (int i = 0; (i < this.REPETITIONS); i++) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("grammar com.foo.bar with org.eclipse.xtext.common.Terminals");
      _builder.newLine();
      _builder.append("import \"http://www.eclipse.org/emf/2002/Ecore\" as ecore");
      _builder.newLine();
      _builder.append("generate myPack \'http://mypack\'");
      _builder.newLine();
      _builder.newLine();
      _builder.append("setup $$");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("java.util.Stack<String> symbolTable = new java.util.Stack<String>();");
      _builder.newLine();
      _builder.append("$$");
      _builder.newLine();
      _builder.newLine();
      _builder.append("Statements:");
      _builder.newLine();
      _builder.append("            ");
      _builder.append("defs+=VarDef+");
      _builder.newLine();
      _builder.append(";");
      _builder.newLine();
      _builder.newLine();
      _builder.append("VarDef: ");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("$$ !symbolTable.contains( input.LT( 1 ).getText() ) $$?=>");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("name=ID \'=\' value=Expr");
      _builder.newLine();
      _builder.append("        ");
      _builder.append("$$ symbolTable.push(((org.xtext.example.mydsl.myDsl.VarDef) current).getName()); $$");
      _builder.newLine();
      _builder.append(";");
      _builder.newLine();
      _builder.newLine();
      _builder.append("Expr: ");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("$$ symbolTable.contains( input.LT( 0 ).getText() ) $$?=>");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("var=ID");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("| builtin=ID \'(\' args += Expr ( args += Expr \',\' )* \')\'");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("| num=INT");
      _builder.newLine();
      _builder.append(";");
      _builder.newLine();
      this.doFullTranslateRun(_builder);
    }
  }
  
  protected void doFullTranslateRun(final CharSequence xtextGrammar) {
    try {
      EObject _model = super.getModel(xtextGrammar.toString());
      final Grammar grammar = ((Grammar) _model);
      DefaultGeneratorModule _defaultGeneratorModule = new DefaultGeneratorModule();
      final Injector injector = Guice.createInjector(_defaultGeneratorModule);
      final HoistingGeneratorBenchmark.InMemFSA inMem = new HoistingGeneratorBenchmark.InMemFSA();
      final AntlrOptions options = new AntlrOptions();
      injector.<AntlrDebugProductionGrammarGenerator>getInstance(AntlrDebugProductionGrammarGenerator.class).generate(grammar, options, inMem);
      injector.<AntlrDebugContentAssistGrammarGenerator>getInstance(AntlrDebugContentAssistGrammarGenerator.class).generate(grammar, options, inMem);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
