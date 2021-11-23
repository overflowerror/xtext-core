/**
 */
package org.eclipse.xtext;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Init Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.InitBlock#getCode <em>Code</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.XtextPackage#getInitBlock()
 * @model
 * @generated
 */
public interface InitBlock extends EObject {
	/**
	 * Returns the value of the '<em><b>Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' containment reference.
	 * @see #setCode(JavaCode)
	 * @see org.eclipse.xtext.XtextPackage#getInitBlock_Code()
	 * @model containment="true"
	 * @generated
	 */
	JavaCode getCode();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.InitBlock#getCode <em>Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' containment reference.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(JavaCode value);

} // InitBlock
