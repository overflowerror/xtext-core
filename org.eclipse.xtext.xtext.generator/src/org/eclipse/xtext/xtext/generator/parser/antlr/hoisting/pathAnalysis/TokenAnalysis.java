/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.pathAnalysis;

import static org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils.DebugUtils.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractSemanticPredicate;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.JavaAction;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.HoistingConfiguration;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.SymbolicAnalysisFailedException;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.TokenAnalysisAbortedException;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.exceptions.UnsupportedConstructException;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.token.Token;
import org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils.MutablePrimitiveWrapper;

import static org.eclipse.xtext.GrammarUtil.*;

/**
 * @author overflow - Initial contribution and API
 */
public class TokenAnalysis {
	private HoistingConfiguration config;
	
	private Logger log = Logger.getLogger(TokenAnalysis.class);
	
	public TokenAnalysis(HoistingConfiguration config) {
		this.config = config;
	}
	
	private TokenAnalysisPaths getTokenForIndexesAlternatives(CompoundElement path, TokenAnalysisPaths prefix, boolean needsLength) throws TokenAnalysisAbortedException {
		if (prefix.isDone()) {
			return prefix;
		}
		
		TokenAnalysisPaths result;
		if (isOptionalCardinality(path)) {
			result = prefix;
			if (needsLength) {
				// analysis is not done but there are no more mandatory tokens
				throw new TokenAnalysisAbortedException("needed path length not satisfied due to optional cardinality");
			}
		} else {
			result = TokenAnalysisPaths.empty(prefix);
		}
		
		boolean loop = isMultipleCardinality(path);
		
		do {
			boolean allDone = true;
			
			for (AbstractElement element : path.getElements()) {
				TokenAnalysisPaths current = new TokenAnalysisPaths(prefix);
				current = getTokenForIndexes(element, current, needsLength); // will check for needsLength
				
				if (!current.isDone()) {
					allDone = false;
				}
				
				result = result.merge(current);
			}
			
			if (allDone) {
				break;
			}
			
			prefix = result;
			
			// repeat until all further extensions of prefix are done 
		} while(loop);
	
		return result;
	}
	
	private TokenAnalysisPaths getTokenForIndexesGroup(Group path, TokenAnalysisPaths prefix, boolean needsLength) throws TokenAnalysisAbortedException {
		if (prefix.isDone()) {
			return prefix;
		}
		
		TokenAnalysisPaths result; 
		TokenAnalysisPaths current = new TokenAnalysisPaths(prefix);
		
		if (isOptionalCardinality(path)) {
			result = prefix;
			if (needsLength) {
				// analysis is not done but there are no more mandatory tokens
				throw new TokenAnalysisAbortedException("needed path length not satisfied due to optional cardinality");
			}
		} else {
			result = TokenAnalysisPaths.empty(prefix);
		}
		
		boolean loop = isMultipleCardinality(path);
		
		do {
			for (AbstractElement element : path.getElements()) {
				current = getTokenForIndexes(element, current, false);
				
				if (current.isDone()) {
					// no need to look further
					
					return result.merge(current);
				}
			}
			
			if (needsLength && !current.isDone()) {
				// analysis is not done but there are no more mandatory tokens
				throw new TokenAnalysisAbortedException("needed path length not satisfied");
			}
			
			result = result.merge(current);
			current = new TokenAnalysisPaths(result);
		} while(loop);
		
		// if cardinality is trivial or ? return result
		return result;
	}
	
	private TokenAnalysisPaths getTokenForIndexesDefault(AbstractElement path, TokenAnalysisPaths prefix, boolean needsLength) throws TokenAnalysisAbortedException {
		if (prefix.isDone()) {
			return prefix;
		}
		
		TokenAnalysisPaths result;
		
		if (isOptionalCardinality(path)) {
			result = prefix;
			if (needsLength) {
				throw new TokenAnalysisAbortedException("needed path length not satisfied due to optional cardinality");
			}
		} else {
			result = TokenAnalysisPaths.empty(prefix);
		}
		
		TokenAnalysisPaths current = new TokenAnalysisPaths(prefix);
		
		boolean loop = isMultipleCardinality(path);
		do {
			if (Token.isToken(path)) {
				current.add(path);
			} else if (isParserRuleCall(path) ||
			           isEnumRuleCall(path)) {
				// path doesn't need length, because we're going to check that anyway in this function
				current = getTokenForIndexes(((RuleCall) path).getRule().getAlternatives(), current, false);
			} else if (path instanceof Assignment) {
				current = getTokenForIndexes(((Assignment) path).getTerminal(), current, false);
			} else {
				throw new UnsupportedConstructException("unknown element: " + path.eClass().getName());
			}
			
			// add path to result
			result = result.merge(current);
			
			// if current path is done return result
			// precondition: either !needsLength or result empty
			//               result is only non-empty if ? cardinality
			//               but then needsLength can't be true.
			if (current.isDone()) {
				return result;
			}
			
			if (needsLength) {
				throw new TokenAnalysisAbortedException("needed path length not satisfied");
			}
		} while(loop);
		
		return result;
	}
	
	private TokenAnalysisPaths getTokenForIndexes(AbstractElement path, TokenAnalysisPaths prefix, boolean needsLength) throws TokenAnalysisAbortedException {
		if (path instanceof Alternatives) {
			return getTokenForIndexesAlternatives((Alternatives) path, prefix, needsLength);
		} else if (path instanceof Group) {
			return getTokenForIndexesGroup((Group) path, prefix, needsLength);
		} else if (path instanceof UnorderedGroup) {
			// clone unordered group
			// set cardinality accordingly
			// use code for alternatives
			
			CompoundElement clonedUnorderedGroup = (CompoundElement) cloneAbstractElement(path);
			if (isOptionalCardinality(path) || 
				((UnorderedGroup) path).getElements().stream().allMatch(GrammarUtil::isOptionalCardinality)
			){
				clonedUnorderedGroup.setCardinality("*");
			} else {
				clonedUnorderedGroup.setCardinality("+");
			}
			
			// getTokenForIndexesAlternatives only needs a CompoundElement so we can give it
			// the modified unordered group
			return getTokenForIndexesAlternatives(clonedUnorderedGroup, prefix, needsLength);
		} else if (path instanceof Action ||
		           path instanceof AbstractSemanticPredicate ||
		           path instanceof JavaAction
				) {
			return prefix;
		} else {
			return getTokenForIndexesDefault(path, prefix, needsLength);
		}
	}
	
	private List<List<Token>> getTokenForIndexes(AbstractElement path, List<Integer> indexes) throws TokenAnalysisAbortedException {
		return getTokenForIndexes(path, new TokenAnalysisPaths(indexes), true).getTokenPaths();
	}
	
	private boolean arePathsIdenticalSymbolic(AbstractElement path1, AbstractElement path2) throws SymbolicAnalysisFailedException {
		// ignore symbolic analysis for the moment
		// TODO
		throw new SymbolicAnalysisFailedException(); 
	}
	
	private List<Integer> range(int i, int j) {
		return IntStream.rangeClosed(i, j).boxed().collect(Collectors.toList());
	}
	
	private boolean arePathsIdenticalFallback(AbstractElement path1, AbstractElement path2) {
		// + 1, because otherwise identical paths of length token limit can't be checked
		for (int i = 0; i < config.getTokenLimit() + 1; i++) {
			Set<List<Token>> tokenListSet1;
			Set<List<Token>> tokenListSet2;
			
			List<Integer> range = range(0,  i);
			
			try {
				tokenListSet1 = new HashSet<>(getTokenForIndexes(path1, range));
			} catch (TokenAnalysisAbortedException e) {
				tokenListSet1 = null;
			}
			
			try {
				tokenListSet2 = new HashSet<>(getTokenForIndexes(path2, range));
			} catch (TokenAnalysisAbortedException e) {
				tokenListSet2 = null;
			}
			
			if (tokenListSet1 == null && tokenListSet2 == null) {
				return true;
			}
			if (tokenListSet1 == null || tokenListSet2 == null) {
				// the paths have different length
				return false;
			}
			if (!tokenListSet1.equals(tokenListSet2)) {
				return false;
			}
		}
		
		// we can't analyze the paths any further
		// TODO maybe assume paths are equal and show warning instead of exception
		throw new TokenAnalysisAbortedException("token limit exhausted while looking for identical paths");
	}
	
	public boolean arePathsIdentical(AbstractElement path1, AbstractElement path2) {
		try {
			return arePathsIdenticalSymbolic(path1, path2);
		} catch (SymbolicAnalysisFailedException e) {
			return arePathsIdenticalFallback(path1, path2);
		}
	}
	
	
	private void tokenCombinations(Function<List<Integer>, Boolean> callback) {
		MutablePrimitiveWrapper<Integer> limit = new MutablePrimitiveWrapper<>(config.getTokenLimit());
		
		for (int i = 1; i <= limit.get(); i++) {
			if (tokenCombinations(0, 0, i, callback, limit)) {
				return;
			}
		}
		// we tried all possible combinations
		// TODO: can only happen if no symbolic analysis is implemented
		// -> abort
		if (limit.get().equals(config.getTokenLimit())) {
			throw new TokenAnalysisAbortedException("token limit exhausted while searching for minimal differences");
		} else {
			throw new TokenAnalysisAbortedException("path length exhausted while searching for minimal differences");
		}
	}
	private boolean tokenCombinations(long prefix, int prefixLength, int ones, Function<List<Integer>, Boolean> callback, MutablePrimitiveWrapper<Integer> limit) {
		if (ones == 0) {
			List<Integer> indexes = new ArrayList<>(limit.get());
			for (int i = 0; i < limit.get(); i++) {
				if ((prefix & (1 << i)) > 0) {
					indexes.add(i);
				}
			}
			return callback.apply(indexes);
		} else if (prefixLength + ones > limit.get()) {
			// prefix is too long
			return false;
		} else {
			for (int i = prefixLength; i < limit.get() - ones + 1; i++) {
				long current = prefix | (1 << i);
				try {
					if (tokenCombinations(current, i + 1, ones - 1, callback, limit)) {
						return true;
					}
				} catch (TokenAnalysisAbortedException e) {
					// tokens exhausted; abort current prefix
					// set limit for calling functions so this index is not checked again
					limit.set(i);
					return false;
				}
			}
			return false;
		}
	}
	
	public List<List<List<Token>>> findMinimalPathDifference(List<AbstractElement> paths) throws TokenAnalysisAbortedException {
		// first dimension of result corresponds to the paths
		// the second dimension are the alternatives of the path
		// the third dimension are tokens of the alternative of the path
		
		List<List<List<Token>>> result = paths.stream()
				.map(p -> (List<List<Token>>) null)
				.collect(Collectors.toList());
		
		paths.forEach(p -> {
			log.info("\n" + abstractElementToString(p));
		});
		
		tokenCombinations(indexList -> {
			log.info("current index list: " + indexList);
			
			// will throw TokenAnalysisAborted if any path is too short
			List<List<List<Token>>> tokenListsForPaths = paths.stream()
					//.peek(p -> log.info("next path: " + p))
					.map(p -> getTokenForIndexes(p, indexList))
					.collect(Collectors.toList());

			log.info("token lists: " + tokenListsForPaths);
			
			int size = result.size();
			for (int i = 0; i < size; i++) {
				if (result.get(i) != null) {
					continue;
				}
				
				List<List<Token>> tokenListOfCurrentPath = tokenListsForPaths.get(i);
				if (!tokenListOfCurrentPath.stream()
					.anyMatch(tokenList -> tokenListsForPaths.stream()
							.filter(s -> s != tokenListOfCurrentPath)
							// does any other path contain a similar token list (= alternative)
							.anyMatch(s -> s.contains(tokenList))
					)
				) {
					// token list set is unique for path i
					result.set(i, tokenListOfCurrentPath);
				}
				
			}
			
			return result.stream()
					.allMatch(Objects::nonNull);
		});
		
		return result;
	}
}
