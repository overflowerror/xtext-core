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
	
	TokenAnalysisPath(List<Integer> indexes) {
		this.remainingIndexes = new LinkedList<>(indexes);
	}
	
	TokenAnalysisPath(TokenAnalysisPath prefix) {
		this(prefix.remainingIndexes);
		path = new LinkedList<>(prefix.path);
		position = prefix.position;
	}

	int getPosition() {
		return position - 1;
	}
	
	boolean isDone() {
		return remainingIndexes.isEmpty();
	}
	
	private void shift() {
		position++;
		int size = remainingIndexes.size();
		for (int i = 0; i < size; i++) {
			remainingIndexes.set(i, remainingIndexes.get(i) - 1);
		}
	}
	
	boolean add(AbstractElement element, boolean inContext) {
		if (isDone())
			return false;
		
		if (remainingIndexes.get(0) <= 0) {
			path.add(Token.fromElement(element, position, inContext));
			remainingIndexes.remove(0);
			shift();
			return true;
		} else {
			shift();
			return false;
		}
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + position;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenAnalysisPath other = (TokenAnalysisPath) obj;
		if (!path.equals(other.path))
			return false;
		if (position != other.position)
			return false;
		return true;
	}
	
}
