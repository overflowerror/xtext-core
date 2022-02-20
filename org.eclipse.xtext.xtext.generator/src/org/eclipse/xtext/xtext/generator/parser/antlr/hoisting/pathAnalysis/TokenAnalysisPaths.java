/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.pathAnalysis;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.token.Token;

/**
 * @author overflow - Initial contribution and APILinkedHashSet
 */
public class TokenAnalysisPaths {
	private List<TokenAnalysisPath> tokenPaths = new ArrayList<>(10);
	private boolean isEmpty = false;
	private boolean hasProgress = false;
	private boolean hasCandidates = false;
	
	public TokenAnalysisPaths(List<Integer> indexes) {
		tokenPaths.add(new TokenAnalysisPath(indexes));
	}
	
	public TokenAnalysisPaths(TokenAnalysisPaths prefix) {
		this.tokenPaths = prefix.tokenPaths.stream()
				.map(TokenAnalysisPath::new)
				.collect(Collectors.toList());
		this.hasProgress = prefix.hasProgress;
	}
	
	public List<List<Token>> getTokenPaths() {
		return tokenPaths.stream()
				.map(TokenAnalysisPath::getTokenPath)
				.distinct()
				.collect(Collectors.toList());
	}
	
	public boolean isDone() {
		return !isEmpty && tokenPaths.stream().allMatch(TokenAnalysisPath::isDone);
	}
	
	public boolean hasProgress() {
		return hasProgress;
	}
	
	public boolean hasCandidates() {
		return hasCandidates;
	}
	
	public void resetProgress() {
		hasProgress = false;
		hasCandidates = false;
	}
	
	public void add(AbstractElement element) {
		hasCandidates = true;
		tokenPaths.forEach(p -> hasProgress = p.add(element) || hasProgress);
	}
	
	private boolean addAllDistinct(TokenAnalysisPaths other) {
		boolean changes = false;
		for(TokenAnalysisPath path : other.tokenPaths) {
			if (!tokenPaths.contains(path)) {
				changes = true;
				tokenPaths.add(path);
			}
		}
		return changes;
	}
	
	public TokenAnalysisPaths merge(TokenAnalysisPaths other) {
		if (isEmpty) {
			return other.clone();
		} else if (other.isEmpty) {
			return this.clone();
		} else {
			// set hasProgress if other has progress and progress is merged
			if (addAllDistinct(other)) {
				this.hasProgress |= other.hasProgress;
			}
			this.hasCandidates |= other.hasCandidates;
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
	
	@Override
	public TokenAnalysisPaths clone() {
		TokenAnalysisPaths clone = new TokenAnalysisPaths(this);
		clone.isEmpty = this.isEmpty;
		return clone;
	}
}
