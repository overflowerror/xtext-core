/**
 */
package org.eclipse.xtext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.JavaAction#getCode <em>Code</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.XtextPackage#getJavaAction()
 * @model
 * @generated
 */
public interface JavaAction extends AbstractElement {
	/**
	 * Returns the value of the '<em><b>Code</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' containment reference.
	 * @see #setCode(JavaCode)
	 * @see org.eclipse.xtext.XtextPackage#getJavaAction_Code()
	 * @model containment="true"
	 * @generated
	 */
	JavaCode getCode();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.JavaAction#getCode <em>Code</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Code</em>' containment reference.
	 * @see #getCode()
	 * @generated
	 */
	void setCode(JavaCode value);

} // JavaAction
