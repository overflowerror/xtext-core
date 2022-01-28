/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.DisambiguatingSemanticPredicate;
import org.eclipse.xtext.GatedSemanticPredicate;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.JavaAction;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.common.base.Strings;

/**
 * @author overflow - Initial contribution and API
 */
public class DebugUtils {
	private static void abstractElementToString(AbstractElement element, StringBuilder builder, int indentation, List<String> calledRules) {
		String indentationString = Strings.repeat(" ", indentation);
		
		builder.append(indentationString);
		
		if (element == null) {
			builder.append("null");
			return;
		}
		
		new XtextSwitch<Boolean>(){
			@Override
			public Boolean caseGroup(Group object) {
				builder.append("Group (\n");
				object.getElements().forEach(e -> {
					abstractElementToString(e, builder, indentation + 1, calledRules);
				});
				builder.append(indentationString);
				builder.append(")");
				return true;
			};
			@Override
			public Boolean caseAlternatives(Alternatives object) {
				builder.append("Alternatives (\n");
				object.getElements().forEach(e -> {
					abstractElementToString(e, builder, indentation + 1, calledRules);
				});
				builder.append(indentationString);
				builder.append(")");
				return true;
			};
			@Override
			public Boolean caseUnorderedGroup(UnorderedGroup object) {
				builder.append("Unordered Group (\n");
				object.getElements().forEach(e -> {
					abstractElementToString(e, builder, indentation + 1, calledRules);
				});
				builder.append(indentationString);
				builder.append(")");
				return true;
			};
			@Override
			public Boolean caseRuleCall(RuleCall object) {
				AbstractRule rule = object.getRule();
				if (rule instanceof ParserRule) {
					builder.append("ParserRule (").append(rule.getName()).append(", \n");
					if (calledRules.contains(rule.getName())) {
						builder.append(indentationString).append(" [recursive]\n");
					} else {
						List<String> localRuleCalls = new ArrayList<>(calledRules);
						localRuleCalls.add(rule.getName());
						abstractElementToString(rule.getAlternatives(), builder, indentation + 1, localRuleCalls);
					}
					builder.append(indentationString);
					builder.append(")");
				} else {
					builder.append(rule.eClass().getName()).append(" (").append(rule.getName()).append(")");
				}
				return true;
			};
			
			@Override
			public Boolean caseAssignment(Assignment object) {
				builder.append("Assignment (");
				builder.append(object.getFeature());
				builder.append(",\n");
				abstractElementToString(object.getTerminal(), builder, indentation + 1, calledRules);
				builder.append(indentationString);
				builder.append(")");
				return true;
			};
			
			@Override
			public Boolean defaultCase(EObject object) {
				abstractElementToShortString((AbstractElement) object, builder);
				return false;
			};
		}.doSwitch(element);
		
		builder.append(Objects.toString(element.getCardinality(), ""));
		
		builder.append("\n");
	}
	
	public static String abstractElementToString(AbstractElement element) {
		StringBuilder builder = new StringBuilder();
		abstractElementToString(element, builder, 0, Arrays.asList(containingRuleSafe(element)));
		return builder.toString();
	}
	
	private static void abstractElementToShortString(AbstractElement element, StringBuilder builder) {
		if (element == null) {
			builder.append("null");
			return;
		}
		
		new XtextSwitch<Boolean>(){
			@Override
			public Boolean caseKeyword(Keyword object) {
				builder.append("Keyword (").append(object.getValue()).append(")");
				return true;
			};
			@Override
			public Boolean caseGroup(Group object) {
				builder.append("Group (");
				builder.append(object.getElements().size());
				builder.append(")");
				return true;
			};
			@Override
			public Boolean caseAlternatives(Alternatives object) {
				builder.append("Alternatives (");
				builder.append(object.getElements().size());
				builder.append(")");
				return true;
			};
			@Override
			public Boolean caseUnorderedGroup(UnorderedGroup object) {
				builder.append("UnorderedGroup (");
				builder.append(object.getElements().size());
				builder.append(")");
				return true;
			};
			@Override
			public Boolean caseRuleCall(RuleCall object) {
				AbstractRule rule = object.getRule();
				if (rule instanceof ParserRule) {
					builder.append("ParserRule (").append(rule.getName()).append(")");
				} else {
					builder.append(rule.eClass().getName()).append(" (").append(rule.getName()).append(")");
				}
				return true;
			};
			@Override
			public Boolean caseJavaAction(JavaAction object) {
				builder.append("JavaAction (").append(object.getCode().getSource()).append(")");
				return true;
			};
			@Override
			public Boolean caseGatedSemanticPredicate(GatedSemanticPredicate object) {
				builder.append("GatedSemanticPredicate (").append(object.getCode().getSource()).append(")");
				return true;
			};
			@Override
			public Boolean caseDisambiguatingSemanticPredicate(DisambiguatingSemanticPredicate object) {
				builder.append("DisambiguatingSemanticPredicate (").append(object.getCode().getSource()).append(")");
				return true;
			};
			@Override
			public Boolean caseAssignment(Assignment object) {
				builder.append("Assignment (");
				builder.append(object.getFeature());
				builder.append(")");
				return true;
			};
			@Override
			public Boolean defaultCase(EObject object) {
				builder.append("unknown element: ").append(object.eClass().getName());
				return false;
			};
		}.doSwitch(element);
		
		builder.append(Objects.toString(element.getCardinality(), ""));
	}
	
	public static String abstractElementToShortString(AbstractElement element) {
		StringBuilder builder = new StringBuilder();
		abstractElementToShortString(element, builder);
		return builder.toString();
	}
	
	public static String containingRuleSafe(AbstractElement element) {
		AbstractRule rule = GrammarUtil.containingRule(element);
		if (rule == null) {
			return "{floating}";
		} else {
			return rule.getName();
		}
	}
}
