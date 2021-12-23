/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.pathAnalysis;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.token.Token;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils.StreamUtils;

/**
 * @author overflow - Initial contribution and APILinkedHashSet
 */
public class TokenAnalysisPaths {
	private LinkedHashSet<TokenAnalysisPath> tokenPaths = new LinkedHashSet<>();
	private boolean isEmpty = false;
	private boolean hasProgress = false;
	
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
				.collect(StreamUtils.collectToLinkedHashSet());
		this.hasProgress = prefix.hasProgress;
	}
	
	public boolean isDone() {
		return !isEmpty && tokenPaths.stream().allMatch(TokenAnalysisPath::isDone);
	}
	
	public boolean hasProgress() {
		return hasProgress;
	}
	
	public void resetProgress() {
		hasProgress = false;
	}
	
	public void add(AbstractElement element) {
		tokenPaths.forEach(p -> hasProgress = p.add(element) || hasProgress);
	}
	
	public TokenAnalysisPaths merge(TokenAnalysisPaths other) {
		if (isEmpty) {
			return other;
		} else {
			// set hasProgress if other has progress and progress is merged
			if (this.tokenPaths.addAll(other.tokenPaths)) {
				this.hasProgress |= other.hasProgress;
			}
			return this;
		}
	}
	
	static public TokenAnalysisPaths empty(TokenAnalysisPaths prefix) {
		TokenAnalysisPaths empty = new TokenAnalysisPaths(prefix);
		empty.isEmpty = true;
		return empty;
	}
	
	public int getMinPosition() {
		return tokenPaths.stream().map(TokenAnalysisPath::getPosition).mapToInt(Integer::intValue).min().getAsInt();
	}
	
	public int getMaxPosition() {
		return tokenPaths.stream().map(TokenAnalysisPath::getPosition).mapToInt(Integer::intValue).max().getAsInt();
	}
	
	public int getSize() {
		return tokenPaths.size();
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
