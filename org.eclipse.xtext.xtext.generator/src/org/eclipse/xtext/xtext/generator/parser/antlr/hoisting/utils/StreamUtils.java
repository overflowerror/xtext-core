/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr.hoisting.utils;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author overflow - Initial contribution and API
 */
public class StreamUtils {
	public static <A, B, C> Stream<C> zip(Stream<A> stream1, Stream<B> stream2, BiFunction<A, B, C> combine) {
		Iterator<A> iter1 = stream1.iterator();
		Iterator<B> iter2 = stream2.iterator();
		
		Spliterator<C> spliterator = Spliterators.spliteratorUnknownSize(new Iterator<C>() {
			@Override
			public boolean hasNext() {
				return iter1.hasNext() && iter2.hasNext();
			}
			
			@Override
			public C next() {
				return combine.apply(iter1.next(), iter2.next());
			}
		}, Spliterator.NONNULL);
		
		return StreamSupport.stream(spliterator, false);
	}
	
	public static <A> Stream<A> fromIterator(Iterator<A> iterator) {
		return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.NONNULL), false);
	}
	
	public static <T> Collector<T, ?, LinkedHashSet<T>> collectToLinkedHashSet() {
		return Collector.of(
			(Supplier<LinkedHashSet<T>>) LinkedHashSet::new, 
			LinkedHashSet::add, 
			(a, b) -> {
				a.addAll(b);
				return a;
			}, Collector.Characteristics.IDENTITY_FINISH);
	}
}
