/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace.node;

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.xtend.lib.macro.Active;
import org.eclipse.xtext.generator.trace.node.TracedAccessorsProcessor;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Active(TracedAccessorsProcessor.class)
@SuppressWarnings("all")
public @interface TracedAccessors {
  public Class<? extends EFactory>[] value();
}
