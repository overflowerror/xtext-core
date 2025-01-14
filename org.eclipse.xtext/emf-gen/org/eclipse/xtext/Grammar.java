/**
 */
package org.eclipse.xtext;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Grammar</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.xtext.Grammar#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.xtext.Grammar#getUsedGrammars <em>Used Grammars</em>}</li>
 *   <li>{@link org.eclipse.xtext.Grammar#isDefinesHiddenTokens <em>Defines Hidden Tokens</em>}</li>
 *   <li>{@link org.eclipse.xtext.Grammar#getHiddenTokens <em>Hidden Tokens</em>}</li>
 *   <li>{@link org.eclipse.xtext.Grammar#getMetamodelDeclarations <em>Metamodel Declarations</em>}</li>
 *   <li>{@link org.eclipse.xtext.Grammar#getRules <em>Rules</em>}</li>
 *   <li>{@link org.eclipse.xtext.Grammar#getInitBlock <em>Init Block</em>}</li>
 *   <li>{@link org.eclipse.xtext.Grammar#getTokenLimit <em>Token Limit</em>}</li>
 *   <li>{@link org.eclipse.xtext.Grammar#isDebug <em>Debug</em>}</li>
 * </ul>
 *
 * @see org.eclipse.xtext.XtextPackage#getGrammar()
 * @model
 * @generated
 */
public interface Grammar extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.xtext.XtextPackage#getGrammar_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.Grammar#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Used Grammars</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.xtext.Grammar}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Grammars</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Grammars</em>' reference list.
	 * @see org.eclipse.xtext.XtextPackage#getGrammar_UsedGrammars()
	 * @model
	 * @generated
	 */
	EList<Grammar> getUsedGrammars();

	/**
	 * Returns the value of the '<em><b>Defines Hidden Tokens</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defines Hidden Tokens</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defines Hidden Tokens</em>' attribute.
	 * @see #setDefinesHiddenTokens(boolean)
	 * @see org.eclipse.xtext.XtextPackage#getGrammar_DefinesHiddenTokens()
	 * @model
	 * @generated
	 */
	boolean isDefinesHiddenTokens();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.Grammar#isDefinesHiddenTokens <em>Defines Hidden Tokens</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defines Hidden Tokens</em>' attribute.
	 * @see #isDefinesHiddenTokens()
	 * @generated
	 */
	void setDefinesHiddenTokens(boolean value);

	/**
	 * Returns the value of the '<em><b>Hidden Tokens</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.xtext.AbstractRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hidden Tokens</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hidden Tokens</em>' reference list.
	 * @see org.eclipse.xtext.XtextPackage#getGrammar_HiddenTokens()
	 * @model
	 * @generated
	 */
	EList<AbstractRule> getHiddenTokens();

	/**
	 * Returns the value of the '<em><b>Metamodel Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.AbstractMetamodelDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metamodel Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metamodel Declarations</em>' containment reference list.
	 * @see org.eclipse.xtext.XtextPackage#getGrammar_MetamodelDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractMetamodelDeclaration> getMetamodelDeclarations();

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.xtext.AbstractRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see org.eclipse.xtext.XtextPackage#getGrammar_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractRule> getRules();

	/**
	 * Returns the value of the '<em><b>Init Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Block</em>' containment reference.
	 * @see #setInitBlock(InitBlock)
	 * @see org.eclipse.xtext.XtextPackage#getGrammar_InitBlock()
	 * @model containment="true"
	 * @generated
	 */
	InitBlock getInitBlock();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.Grammar#getInitBlock <em>Init Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Block</em>' containment reference.
	 * @see #getInitBlock()
	 * @generated
	 */
	void setInitBlock(InitBlock value);

	/**
	 * Returns the value of the '<em><b>Token Limit</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Token Limit</em>' attribute.
	 * @see #setTokenLimit(int)
	 * @see org.eclipse.xtext.XtextPackage#getGrammar_TokenLimit()
	 * @model default="10"
	 * @generated
	 */
	int getTokenLimit();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.Grammar#getTokenLimit <em>Token Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Token Limit</em>' attribute.
	 * @see #getTokenLimit()
	 * @generated
	 */
	void setTokenLimit(int value);

	/**
	 * Returns the value of the '<em><b>Debug</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Debug</em>' attribute.
	 * @see #setDebug(boolean)
	 * @see org.eclipse.xtext.XtextPackage#getGrammar_Debug()
	 * @model
	 * @generated
	 */
	boolean isDebug();

	/**
	 * Sets the value of the '{@link org.eclipse.xtext.Grammar#isDebug <em>Debug</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Debug</em>' attribute.
	 * @see #isDebug()
	 * @generated
	 */
	void setDebug(boolean value);

} // Grammar
