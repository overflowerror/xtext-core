/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.xtext.AbstractElement;

/**
 * @author overflow - Initial contribution and API
 */
public class TokenAnalysisPaths {
	private Set<TokenAnalysisPath> tokenPaths = new HashSet<>();
	private boolean isEmpty = false;
	
	public Set<List<Token>> getTokenPaths() {
		return tokenPaths.stream()
				.map(TokenAnalysisPath::getTokenPath)
				.collect(Collectors.toSet());
	}
	
	private TokenAnalysisPaths() {
	}
	
	public TokenAnalysisPaths(List<Integer> indexes) {
		tokenPaths.add(new TokenAnalysisPath(indexes));
	}
	
	public TokenAnalysisPaths(TokenAnalysisPaths prefix) {
		this.tokenPaths = prefix.tokenPaths.stream()
				.map(TokenAnalysisPath::new)
				.collect(Collectors.toSet());
	}
	
	public boolean isDone() {
		return tokenPaths.stream().allMatch(TokenAnalysisPath::isDone);
	}
	
	public void add(AbstractElement element) {
		tokenPaths.forEach(p -> p.add(element));
	}
	
	public TokenAnalysisPaths merge(TokenAnalysisPaths other) {
		if (isEmpty) {
			return other;
		} else {
			this.tokenPaths.addAll(other.tokenPaths);
			return this;
		}
	}
	
	static public TokenAnalysisPaths empty() {
		TokenAnalysisPaths empty = new TokenAnalysisPaths();
		empty.isEmpty = true;
		return empty;
	}
	
	@Override
	public String toString() {
		if (isEmpty) {
			return "TokenAnalysisPaths(empty)";
		} else {
			return "TokenAnalysisPaths(" + isDone() + ", \n  "
					+ tokenPaths.stream().map(TokenAnalysisPath::toString).collect(Collectors.joining(",\n  "))
					+ "\n)";
		}
	}
}
