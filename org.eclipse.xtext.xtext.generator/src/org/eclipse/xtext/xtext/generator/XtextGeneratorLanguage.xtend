/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.common.base.Joiner
import com.google.common.collect.Lists
import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Module
import com.google.inject.Provider
import java.io.File
import java.util.Collections
import java.util.HashMap
import java.util.List
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.DiagnosticChain
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EValidator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.ReferencedMetamodel
import org.eclipse.xtext.XtextPackage
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtext.util.internal.Log
import org.eclipse.xtext.xtext.RuleNames
import org.eclipse.xtext.xtext.generator.model.GuiceModuleAccess
import org.eclipse.xtext.xtext.generator.model.StandaloneSetupAccess
import org.eclipse.xtext.xtext.generator.model.project.IXtextProjectConfig

/**
 * Configuration for an Xtext language. Use this class if you need to specify exactly which generator
 * fragments you want to include, or alternatively {@link StandardLanguage} to work with the standard
 * fragments.
 * 
 * <p>The most important property is {@code name}, which should be set to the language name exactly
 * as specified in the grammar file. If the default grammar resolution based on the name does not
 * work in your particular scenario, set the {@code grammarUri} property instead. Furthermore,
 * use {@code fileExtensions} to specify the file extensions for your language.</p>
 * 
 * <p>Generator fragments can be added with the {@code fragment} property. See {@link StandardLanguage}
 * for a list of useful fragments.</p>
 * 
 * @noextend This class should not be extended by clients.
 */
@Log
class XtextGeneratorLanguage extends CompositeGeneratorFragment2 implements IXtextGeneratorLanguage {
	
	String grammarUri
	
	String name
	
	Boolean generateXtendStubs
	
	@Accessors(PUBLIC_GETTER)
	Grammar grammar
	
	@Accessors(PUBLIC_GETTER)
	RuleNames ruleNames
	
	@Accessors(PUBLIC_GETTER)
	List<String> fileExtensions
	
	@Accessors(PUBLIC_GETTER)
	List<String> referencedResources = newArrayList()
	
	@Accessors
	ResourceSet resourceSet
	
	@Accessors
	Module guiceModule = [] 
	
	@Accessors
	val runtimeGenSetup = new StandaloneSetupAccess
	
	@Accessors
	val runtimeGenModule = new GuiceModuleAccess
	
	@Accessors
	val ideGenModule = new GuiceModuleAccess
	
	@Accessors
	val eclipsePluginGenModule = new GuiceModuleAccess
	
	@Accessors
	val webGenModule = new GuiceModuleAccess
	
	@Inject Provider<ResourceSet> resourceSetProvider
	
	@Inject IXtextProjectConfig projectConfig
	
	@Inject CodeConfig codeConfig
	
	@Inject XtextGeneratorResourceSetInitializer resourceSetInitializer
	
	/**
	 * The URI of the grammar file. Use this property if the automatic grammar resolution based on {@link #setName(String)}
	 * does not work in your particular scenario.
	 */
	def void setGrammarUri(String uri) {
		this.grammarUri = uri
	}
	
	def String getGrammarUri() {
		grammarUri ?: new File(projectConfig.runtime.src.path, name.replace('.', '/') + ".xtext").toURI.toString
	}
	
	/**
	 * The language name exactly as specified in the grammar.
	 */
	def void setName(String name) {
		this.name = name
	}
	
	/**
	 * Either a single file extension or a comma-separated list of extensions for which the language
	 * shall be registered.
	 */
	def void setFileExtensions(String fileExtensions) {
		this.fileExtensions = fileExtensions.trim.split('\\s*,\\s*').toList
	}
	
	/**
	 * Add a resource to be included in the resource set that will be used to load the grammar file.
	 * This is often necessary if additional Ecore models are referenced by the grammar.
	 */
	def void addReferencedResource(String referencedResource) {
		this.referencedResources += referencedResource
	}
	
	override getFileExtensions() {
		if (fileExtensions === null || fileExtensions.empty) {
			fileExtensions = GrammarUtil.getSimpleName(grammar).toLowerCase
			LOG.info("No explicit fileExtensions configured. Using '*." + fileExtensions + "'.")
		}
		return fileExtensions
	}
	
	/**
	 * @deprecated Use {@link CodeConfig#setPreferXtendStubs(boolean)} instead
	 */
	@Deprecated
	def void setGenerateXtendStubs(Boolean generateXtendStubs) {
		this.generateXtendStubs = generateXtendStubs
	}
	
	/**
	 * @deprecated Use {@link CodeConfig#isPreferXtendStubs()} instead
	 */
	@Deprecated
	override isGenerateXtendStubs() {
		if (generateXtendStubs !== null) generateXtendStubs.booleanValue else codeConfig.preferXtendStubs
	}
	
	override initialize(Injector injector) {
		fragments.addAll(0, implicitFragments)
		injector.injectMembers(this)
		if (resourceSet === null)
			resourceSet = resourceSetProvider.get()
		resourceSetInitializer.initialize(resourceSet, referencedResources)
		
		if (!resourceSet.resources.isEmpty) {
			installIndex()
			for (var i = 0, var size = resourceSet.resources.size; i < size; i++) {
				val res = resourceSet.resources.get(i)
				if (res.getContents().isEmpty())
					XtextGeneratorLanguage.LOG.error("Error loading '" + res.getURI() + "'")
				else if (!res.getErrors().isEmpty())
					XtextGeneratorLanguage.LOG.error("Error loading '" + res.getURI() + "':\n" + Joiner.on('\n').join(res.getErrors()))	
			}
			EcoreUtil.resolveAll(resourceSet)
		}
		if (getGrammarUri === null) {
			throw new IllegalStateException("No grammarUri or language name given")
		}
		val resource = resourceSet.getResource(URI.createURI(getGrammarUri), true) as XtextResource
		if (resource.contents.isEmpty) {
			throw new IllegalArgumentException("Couldn't load grammar for '" + getGrammarUri + "'.")
		}
		if (!resource.errors.isEmpty) {
			XtextGeneratorLanguage.LOG.error(resource.errors)
			throw new IllegalStateException("Problem parsing '" + getGrammarUri + "':\n" + Joiner.on('\n').join(resource.getErrors()))
		}

		val grammar = resource.contents.get(0) as Grammar
		validateGrammar(grammar)
		initialize(grammar)
		super.initialize(injector)
	}
	
	protected def List<? extends IXtextGeneratorFragment> getImplicitFragments() {
		val fragments = newArrayList
		fragments += new ImplicitFragment
		return fragments
	}
	
	def void initialize(Grammar grammar) {
		this.grammar = grammar
		this.ruleNames = RuleNames.getRuleNames(grammar, true)
	}
	
	private def void installIndex() {
		val index = new ResourceDescriptionsData(Collections.emptyList)
		val resources = Lists.newArrayList(resourceSet.resources)
		for (resource : resources) {
			index(resource, resource.URI, index)
		}
		ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(resourceSet, index)
	}

	private def void index(Resource resource, URI uri, ResourceDescriptionsData index) {
		val serviceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(uri)
		if (serviceProvider !== null) {
			val resourceDescription = serviceProvider.resourceDescriptionManager.getResourceDescription(resource)
			if (resourceDescription !== null) {
				index.addDescription(uri, resourceDescription)
			}
		}
	}
	
	protected def void validateGrammar(Grammar grammar) {
		validateAllImports(grammar)
		val validator = EValidator.Registry.INSTANCE.getEValidator(XtextPackage.eINSTANCE)
		if (validator !== null) {
			val chain = new DiagnosticChain() {

				override add(Diagnostic diagnostic) {
					if (diagnostic.severity == Diagnostic.ERROR) {
						val grammarName = "Validation Error in " + grammar.name + ": "
						if (diagnostic.exception === null)
							throw new IllegalStateException(grammarName + diagnostic.message)
						else
							throw new IllegalStateException(grammarName + diagnostic.message, diagnostic.exception)
					}
				}

				override addAll(Diagnostic diagnostic) {
					add(diagnostic)
				}

				override merge(Diagnostic diagnostic) {
					throw new UnsupportedOperationException
				}
			}
			validator.validate(grammar, chain, null)
			val iterator = grammar.eAllContents
			while (iterator.hasNext) {
				validator.validate(iterator.next, chain, new HashMap);
			}
		}
	}
	
	protected def void validateAllImports(Grammar grammar) {
		for (amd : GrammarUtil.allMetamodelDeclarations(grammar)) {
			if (amd instanceof ReferencedMetamodel)
				validateReferencedMetamodel(amd)
		}
	}

	protected def void validateReferencedMetamodel(ReferencedMetamodel ref) {
		if (ref.EPackage !== null && !ref.EPackage.eIsProxy) {
			return
		}
		val eref = XtextPackage.Literals.ABSTRACT_METAMODEL_DECLARATION__EPACKAGE
		val nodes = NodeModelUtils.findNodesForFeature(ref, eref)
		val refName = if (nodes.empty) '(unknown)' else NodeModelUtils.getTokenText(nodes.get(0))
		val grammarName = GrammarUtil.getGrammar(ref).name
		val msg = "The EPackage " + refName + " in grammar " + grammarName + " could not be found. "
			+ "You might want to register that EPackage in your workflow file."
		throw new IllegalStateException(msg)
	}
}
