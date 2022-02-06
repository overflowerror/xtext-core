/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.hoistingGuards;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.ContextConnective;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.Guard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.tokenGuards.TokenGuard;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.guards.tokenGuards.TokenSequenceGuard;

/**
 * @author overflow - Initial contribution and API
 * 
 * PathGuards represent that conditions for single paths in alternatives.
 * 
 */
public class PathGuard implements HoistingGuard {
	private TokenGuard tokenGuard;
	private HoistingGuard hoistngGuard;
	
	public PathGuard(TokenGuard tokenGuard, HoistingGuard hoistingGuard) {
		this.tokenGuard = tokenGuard;
		this.hoistngGuard = hoistingGuard;
	}
	
	@Override
	public boolean isTrivial() {
		return hoistngGuard.isTrivial();
	}

	@Override
	public boolean hasTerminal() {
		// using the current method there is no way of handling predicates
		// after alternatives with empty paths the same way antlr does
		// => assume that alternative paths always contain tokens
		// the only case that works is when all paths are empty
		// => a MergedPathGuard is returned by findGuardForAlternatives
		return true;
	}
	
	@Override
	public String render() {
		return render(ContextConnective.DISJUNCTION);
	}
	
	@Override
	public String render(ContextConnective connective) {
		String result = "";
		
		result += tokenGuard.render(ContextConnective.DISJUNCTION);
		result += " || ";
		result += hoistngGuard.render(ContextConnective.DISJUNCTION);
		
		return connective.addParenthesesIfNot(result, ContextConnective.DISJUNCTION);
	}
	
	public static List<PathGuard> collapse(List<PathGuard> paths) {
		// we can collapse all paths of alternatives in paths
		// because the direct paths of this alternatives instance are already token-guarded
		// against all other paths (otherwise the token guard wouldn't be distinct)
		
		List<PathGuard> result = new LinkedList<>();
		
		for (PathGuard path : paths) {
			HoistingGuard guard = path.hoistngGuard;
			
			// TODO: allow merged paths
			if (guard instanceof MergedPathGuard) {
				guard = ((MergedPathGuard) guard).reduce();
			}
			
			if (guard instanceof AlternativesGuard) {
				result.addAll(((AlternativesGuard) guard).getPaths());
			} else if (guard instanceof GroupGuard) {
				// TODO: maybe allow nested groups?
				
				Pair<List<Guard>, AlternativesGuard> destructedPaths = ((GroupGuard) guard).deconstructPaths();
				if (destructedPaths == null) {
					result.add(path);
				} else {
					destructedPaths.getSecond().getPaths().stream()
						.forEach(p -> {
							// combine hoisting guards of current sub path with destructed path guards
							// construct new path guard and add to result
							GroupGuard groupGuard = new GroupGuard(destructedPaths.getFirst());
							groupGuard.add(p.hoistngGuard);
							result.add(new PathGuard(new TokenSequenceGuard(p.tokenGuard, path.tokenGuard), groupGuard));
						});
				}
			} else {
				result.add(path);
			}
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return "PathGuard (\n" +
				"\ttokenGuard:\n\t" + Arrays.stream(tokenGuard.toString().split("\n"))
					.map(l -> "\t" + l)
					.collect(Collectors.joining("\n")) + "\n" +
				"\thoistngGuard:\n\t" + Arrays.stream(hoistngGuard.toString().split("\n"))
					.map(l -> "\t" + l)
					.collect(Collectors.joining("\n")) + "\n" + 
				")\n";
	}
}
