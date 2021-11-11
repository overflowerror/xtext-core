/**
 */
package org.eclipse.xtext;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Code</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.JavaCode#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.XtextPackage#getJavaCode()
 * @model
 * @generated
 */
public interface JavaCode extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' attribute.
	 * The default value is <code>"source"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' attribute.
	 * @see #setSource(String)
	 * @see org.eclipse.xtext.XtextPackage#getJavaCode_Source()
	 * @model default="source"
	 * @generated
	 */
	String getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.JavaCode#getSource <em>Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' attribute.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(String value);

} // JavaCode
