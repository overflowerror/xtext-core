/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.pathAnalysis;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.token.Token;

/**
 * @author overflow - Initial contribution and API
 */
public class TokenAnalysisPaths {
	private List<TokenAnalysisPath> tokenPaths = new LinkedList<>();
	private boolean isEmpty = false;
	
	public List<List<Token>> getTokenPaths() {
		return tokenPaths.stream()
				.map(TokenAnalysisPath::getTokenPath)
				.distinct()
				.collect(Collectors.toList());
	}
	
	public TokenAnalysisPaths(List<Integer> indexes) {
		tokenPaths.add(new TokenAnalysisPath(indexes));
	}
	
	public TokenAnalysisPaths(TokenAnalysisPaths prefix) {
		this.tokenPaths = prefix.tokenPaths.stream()
				.map(TokenAnalysisPath::new)
				.collect(Collectors.toList());
	}
	
	public boolean isDone() {
		return !isEmpty && tokenPaths.stream().allMatch(TokenAnalysisPath::isDone);
	}
	
	public void add(AbstractElement element) {
		tokenPaths.forEach(p -> p.add(element));
	}
	
	public TokenAnalysisPaths merge(TokenAnalysisPaths other) {
		if (isEmpty) {
			return other;
		} else {
			// TODO: implement hashCode and equals to check for duplicates right awaz
			this.tokenPaths.addAll(other.tokenPaths);
			return this;
		}
	}
	
	static public TokenAnalysisPaths empty(TokenAnalysisPaths prefix) {
		TokenAnalysisPaths empty = new TokenAnalysisPaths(prefix);
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
