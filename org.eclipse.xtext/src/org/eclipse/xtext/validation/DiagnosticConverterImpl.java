/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextSyntaxDiagnostic;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.LineAndColumn;
import org.eclipse.xtext.validation.Issue.IssueImpl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DiagnosticConverterImpl implements IDiagnosticConverter {

	protected static class IssueLocation {
		
		public IssueLocation() {}
		
		/**
		 * 1-based line number.
		 */
		public Integer lineNumber;
		/**
		 * 1-based column.
		 * @since 2.9
		 */
		public Integer column;
		/**
		 * 0-based offset.
		 */
		public Integer offset;
		public Integer length;
		
		/**
		 * 1-based line number.
		 * @since 2.19
		 */
		public Integer endLineNumber;
		/**
		 * 1-based column.
		 * @since 2.19
		 */
		public Integer endColumn;
	}
	
	@Override
	public void convertResourceDiagnostic(Diagnostic diagnostic, Severity severity,	IAcceptor<Issue> acceptor) {
		IssueImpl issue = new Issue.IssueImpl();
		issue.setSyntaxError(diagnostic instanceof XtextSyntaxDiagnostic);
		issue.setSeverity(severity);
		issue.setLineNumber(diagnostic.getLine());
		issue.setColumn(diagnostic.getColumn());
		issue.setMessage(diagnostic.getMessage());
		// set default value
		issue.setEndColumn(-1);
		
		
		if (diagnostic instanceof org.eclipse.xtext.diagnostics.Diagnostic) {
			org.eclipse.xtext.diagnostics.Diagnostic xtextDiagnostic = (org.eclipse.xtext.diagnostics.Diagnostic) diagnostic;
			issue.setOffset(xtextDiagnostic.getOffset());
			issue.setLength(xtextDiagnostic.getLength());
		}
		if (diagnostic instanceof AbstractDiagnostic) {
			AbstractDiagnostic castedDiagnostic = (AbstractDiagnostic)diagnostic;
			issue.setUriToProblem(castedDiagnostic.getUriToProblem());
			issue.setCode(castedDiagnostic.getCode());
			issue.setData(castedDiagnostic.getData());
			issue.setEndLineNumber(castedDiagnostic.getEndLine());
			issue.setEndColumn(castedDiagnostic.getEndColumn());
			
		}
		issue.setType(CheckType.FAST);
		acceptor.accept(issue);
	}

	@Override
	public void convertValidatorDiagnostic(org.eclipse.emf.common.util.Diagnostic diagnostic,
			IAcceptor<Issue> acceptor) {
		Severity severity = getSeverity(diagnostic);
		if (severity == null)
			return;
		IssueImpl issue = new Issue.IssueImpl();
		issue.setSeverity(severity);
		// set default value
		issue.setColumn(-1);
		issue.setEndColumn(-1);
		IssueLocation locationData = getLocationData(diagnostic);
		if (locationData != null) {
			issue.setLineNumber(locationData.lineNumber);
			issue.setColumn(locationData.column);
			issue.setOffset(locationData.offset);
			issue.setLength(locationData.length);
			issue.setEndLineNumber(locationData.endLineNumber);
			issue.setEndColumn(locationData.endColumn);
		}
		final EObject causer = getCauser(diagnostic);
		if (causer != null)
			issue.setUriToProblem(EcoreUtil.getURI(causer));

		issue.setCode(getIssueCode(diagnostic));
		issue.setType(getIssueType(diagnostic));
		issue.setData(getIssueData(diagnostic));
		
		//		marker.put(IXtextResourceChecker.DIAGNOSTIC_KEY, diagnostic);
		issue.setMessage(diagnostic.getMessage());
		//		marker.put(IMarker.PRIORITY, Integer.valueOf(IMarker.PRIORITY_LOW));
		acceptor.accept(issue);
	}
	
	/**
	 * @since 2.4
	 */
	protected CheckType getIssueType(org.eclipse.emf.common.util.Diagnostic diagnostic) {
		if (diagnostic instanceof AbstractValidationDiagnostic) {
			AbstractValidationDiagnostic diagnosticImpl = (AbstractValidationDiagnostic) diagnostic;
			return diagnosticImpl.getCheckType();
		} else {
			// default to FAST
			return CheckType.FAST;
		}
	}
	
	/**
	 * @since 2.4
	 */
	protected String[] getIssueData(org.eclipse.emf.common.util.Diagnostic diagnostic) {
		if (diagnostic instanceof AbstractValidationDiagnostic) {
			AbstractValidationDiagnostic diagnosticImpl = (AbstractValidationDiagnostic) diagnostic;
			return diagnosticImpl.getIssueData();
		} else {
			// replace any EObjects by their URIs
			EObject causer = getCauser(diagnostic);
			List<String> issueData = newArrayList();
			for (Object object : diagnostic.getData()) {
				if (object != causer && object instanceof EObject) {
					EObject eObject = (EObject)object;
					issueData.add(EcoreUtil.getURI(eObject).toString());
				} else if (object instanceof String) {
					issueData.add( (String) object);
				}
		    }
			return issueData.toArray(new String[issueData.size()]);
		}
	}
	
	/**
	 * @since 2.4
	 */
	protected String getIssueCode(org.eclipse.emf.common.util.Diagnostic diagnostic) {
		if (diagnostic instanceof AbstractValidationDiagnostic) {
			AbstractValidationDiagnostic diagnosticImpl = (AbstractValidationDiagnostic) diagnostic;
			return diagnosticImpl.getIssueCode();
		} else {
			return diagnostic.getSource() + "." + diagnostic.getCode();
		}
	}
	
	/**
	 * @since 2.4
	 */
	protected Severity getSeverity(org.eclipse.emf.common.util.Diagnostic diagnostic) {
		if (diagnostic.getSeverity() == org.eclipse.emf.common.util.Diagnostic.OK)
			return null;
		switch (diagnostic.getSeverity()) {
			case org.eclipse.emf.common.util.Diagnostic.WARNING:
				return Severity.WARNING;
			case org.eclipse.emf.common.util.Diagnostic.INFO:
				return Severity.INFO;
			default :
				return Severity.ERROR;
		}
	}

	protected EObject getCauser(org.eclipse.emf.common.util.Diagnostic diagnostic) {
		// causer is the first element see Diagnostician.getData
		if (diagnostic.getData().isEmpty())
			return null;
		Object causer = diagnostic.getData().get(0);
		return causer instanceof EObject ? (EObject) causer : null;
	}

	/**
	 * @return the location data for the given diagnostic.
	 *         <ol>
	 *         <li>First: line number,</li>
	 *         <li>Second: Offset of first char (inclusive), and</li>
	 *         <li>Third: Offset of last char (exclusive).</li>
	 *         </ol>
	 */
	protected IssueLocation getLocationData(org.eclipse.emf.common.util.Diagnostic diagnostic) {
		EObject causer = getCauser(diagnostic);
		if (causer != null) {
			if (diagnostic instanceof RangeBasedDiagnostic) {
				RangeBasedDiagnostic castedDiagnostic = (RangeBasedDiagnostic) diagnostic;
				INode parserNode = NodeModelUtils.getNode(causer);
				IssueLocation result = new IssueLocation();
				if (parserNode != null) {
					LineAndColumn lineAndColumn = NodeModelUtils.getLineAndColumn(parserNode, castedDiagnostic.getOffset());
					result.lineNumber = lineAndColumn.getLine();
					result.column = lineAndColumn.getColumn();
					LineAndColumn endLineAndColumn = NodeModelUtils.getLineAndColumn(parserNode, castedDiagnostic.getOffset() + castedDiagnostic.getLength());
					result.endLineNumber = endLineAndColumn.getLine();
					result.endColumn = endLineAndColumn.getColumn();
				}
				result.offset = castedDiagnostic.getOffset();
				result.length = castedDiagnostic.getLength();
				return result;
			} else if (diagnostic instanceof FeatureBasedDiagnostic) {
				 FeatureBasedDiagnostic castedDiagnostic = (FeatureBasedDiagnostic) diagnostic;
				 return getLocationData(causer, castedDiagnostic.getFeature(), castedDiagnostic.getIndex());
			} else {
				// feature is the second element see Diagnostician.getData
				List<?> data = diagnostic.getData();
				Object feature = data.size() > 1 ? data.get(1) : null;
				EStructuralFeature structuralFeature = resolveStructuralFeature(causer, feature);
				return getLocationData(causer, structuralFeature, 0);
			}
		}
		return null;
	}

	protected IssueLocation getLocationData(EObject obj, EStructuralFeature structuralFeature) {
		return getLocationData(obj, structuralFeature, 0);
	}
	
	/**
	 * @return the location data for the given diagnostic.
	 */
	protected IssueLocation getLocationData(EObject obj, EStructuralFeature structuralFeature, int index) {
		INode parserNode = NodeModelUtils.getNode(obj);
		if (parserNode != null) {
			if (structuralFeature != null) {
				List<INode> nodes = NodeModelUtils.findNodesForFeature(obj, structuralFeature);
				if (index < 0) // insignificant index
					index = 0;
				if (nodes.size()>index)
					parserNode = nodes.get(index);
			}
			return getLocationForNode(parserNode);
		} else if (obj.eContainer() != null) {
			EObject container = obj.eContainer();
			EStructuralFeature containingFeature = obj.eContainingFeature();
			return getLocationData(container, containingFeature,
					containingFeature.isMany() ? ((EList<?>) container.eGet(containingFeature)).indexOf(obj)
							: ValidationMessageAcceptor.INSIGNIFICANT_INDEX);
		}
		IssueLocation result = new IssueLocation();
		result.lineNumber = 1;
		result.column = 1;
		result.offset = 0;
		result.length = 0;
		result.endLineNumber = 1;
		result.endColumn = 1;
		return result;
	}

	protected IssueLocation getLocationForNode(INode node) {
		ITextRegionWithLineInformation nodeRegion = node.getTextRegionWithLineInformation();
		IssueLocation result = new IssueLocation();
		result.lineNumber = nodeRegion.getLineNumber();
		result.offset = nodeRegion.getOffset();
		result.column = NodeModelUtils.getLineAndColumn(node, result.offset).getColumn();
		result.length = nodeRegion.getLength();
		result.endLineNumber = nodeRegion.getEndLineNumber();
		result.endColumn = NodeModelUtils.getLineAndColumn(node, result.offset + result.length).getColumn();
		return result;
	}

	protected EStructuralFeature resolveStructuralFeature(EObject ele, Object feature) {
		if (feature instanceof EStructuralFeature) {
			return (EStructuralFeature) feature;
		} 
		return null;
	}

}
