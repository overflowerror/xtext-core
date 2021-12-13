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
public class TokenAnalysisPath {
	private List<Token> path = new LinkedList<>();
	private List<Integer> remainingIndexes;
	private int position = 1;
	
	public TokenAnalysisPath(List<Integer> indexes) {
		this.remainingIndexes = new LinkedList<>(indexes);
	}
	
	public TokenAnalysisPath(TokenAnalysisPath prefix) {
		this(prefix.remainingIndexes);
		path = new LinkedList<>(prefix.path);
		position = prefix.position;
	}

	int getPosition() {
		return position - 1;
	}
	
	public boolean isDone() {
		return remainingIndexes.isEmpty();
	}
	
	private void shift() {
		position++;
		int size = remainingIndexes.size();
		for (int i = 0; i < size; i++) {
			remainingIndexes.set(i, remainingIndexes.get(i) - 1);
		}
	}
	
	public void add(AbstractElement element) {
		if (isDone())
			return;
		
		if (remainingIndexes.get(0) <= 0) {
			path.add(Token.fromElement(element, position));
			remainingIndexes.remove(0);
		}
		shift();
	}
	
	public List<Token> getTokenPath() {
		return path;
	}
	
	@Override
	public String toString() {
		return "(" + position + ", " + isDone() + ",\n    (" + 
				path.stream().map(Token::toString).collect(Collectors.joining(", ")) + "),\n    (" +
				remainingIndexes.stream().map(Object::toString).collect(Collectors.joining(", ")) + ")\n  )";
	}
}
