/*******************************************************************************
 * Copyright (c) 2012-2015 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements;

public class CamundaElementJso extends AbstractBpmnJso {
	protected CamundaElementJso() {
	}

	public final native String getAttr_assignee() /*-{
														return this.businessObject.assignee;
														}-*/;

	public final native void setAttr_assignee(String assignee) /*-{
																		this.businessObject.assignee = assignee;
																		}-*/;

	public final native boolean getAttr_asyncAfter() /*-{
														return this.businessObject.asyncAfter;
														}-*/;

	public final native void setAttr_asyncAfter(boolean asyncAfter) /*-{
																	this.businessObject.asyncAfter = asyncAfter;
																	}-*/;

	public final native boolean getAttr_asyncBefore() /*-{
														return this.businessObject.asyncBefore;
														}-*/;

	public final native void setAttr_asyncBefore(boolean asyncBefore) /*-{
																		this.businessObject.asyncBefore = asyncBefore;
																		}-*/;

	public final native String getAttr_calledElementBinding() /*-{
																return this.businessObject.calledElementBinding;
																}-*/;

	public final native void setAttr_calledElementBinding(
			String calledElementBinding) /*-{
											this.businessObject.calledElementBinding = calledElementBinding;
											}-*/;

	public final native int getAttr_calledElementVersion() /*-{
																return this.businessObject.calledElementVersion;
																}-*/;

	public final native void setAttr_calledElementVersion(
			int calledElementVersion) /*-{
											this.businessObject.calledElementVersion = calledElementVersion;
											}-*/;

	public final native String getAttr_candidateGroups() /*-{
																return this.businessObject.candidateGroups;
																}-*/;

	public final native void setAttr_candidateGroups(String candidateGroups) /*-{
																						this.businessObject.candidateGroups = candidateGroups;
																						}-*/;

	public final native String getAttr_candidateStarterGroups() /*-{
																return this.businessObject.candidateStarterGroups;
																}-*/;

	public final native void setAttr_candidateStarterGroups(
			String candidateStarterGroups) /*-{
											this.businessObject.candidateStarterGroups = candidateStarterGroups;
											}-*/;

	public final native String getAttr_candidateStarterUsers() /*-{
																return this.businessObject.candidateStarterUsers;
																}-*/;

	public final native void setAttr_candidateStarterUsers(
			String candidateStarterUsers) /*-{
											this.businessObject.candidateStarterUsers = candidateStarterUsers;
											}-*/;

	public final native String getAttr_candidateUsers() /*-{
																return this.businessObject.candidateUsers;
																}-*/;

	public final native void setAttr_candidateUsers(String candidateUsers) /*-{
																					this.businessObject.candidateUsers = candidateUsers;
																					}-*/;

	public final native String getAttr_caseBinding() /*-{
														return this.businessObject.caseBinding;
														}-*/;

	public final native void setAttr_caseBinding(String caseBinding) /*-{
																			this.businessObject.caseBinding = caseBinding;
																			}-*/;

	public final native String getAttr_caseRef() /*-{
													return this.businessObject.caseRef;
													}-*/;

	public final native void setAttr_caseRef(String caseRef) /*-{
																this.businessObject.caseRef = caseRef;
																}-*/;

	public final native int getAttr_caseVersion() /*-{
													return this.businessObject.caseVersion;
													}-*/;

	public final native void setAttr_caseVersion(int caseVersion) /*-{
																	this.businessObject.caseVersion = caseVersion;
																	}-*/;

	public final native String getAttr_class() /*-{
												return this.businessObject['class'];
												}-*/;

	public final native void setAttr_class(String clazz) /*-{
															this.businessObject['class'] = clazz;
															}-*/;

	public final native String getAttr_collection() /*-{
													return this.businessObject.collection;
													}-*/;

	public final native void setAttr_collection(String collection) /*-{
																	this.businessObject.collection = collection;
																	}-*/;

	public final native String getAttr_delegateExpression() /*-{
															return this.businessObject.delegateExpression;
															}-*/;

	public final native void setAttr_delegateExpression(
			String delegateExpression) /*-{
										this.businessObject.delegateExpression = delegateExpression;
										}-*/;

	public final native String getAttr_dueDate() /*-{
															return this.businessObject.dueDate;
															}-*/;

	public final native void setAttr_dueDate(String dueDate) /*-{
																			this.businessObject.dueDate = dueDate;
																			}-*/;

	public final native String getAttr_elementVariable() /*-{
															return this.businessObject.elementVariable;
															}-*/;

	public final native void setAttr_elementVariable(String elementVariable) /*-{
																				this.businessObject.elementVariable = elementVariable;
																				}-*/;

	public final native boolean getAttr_exclusive() /*-{
													return this.businessObject.exclusive;
													}-*/;

	public final native void setAttr_exclusive(boolean exclusive) /*-{
																	this.businessObject.exclusive = exclusive;
																	}-*/;

	public final native String getAttr_expression() /*-{
													return this.businessObject.expression;
													}-*/;

	public final native void setAttr_expression(String expression) /*-{
																	this.businessObject.expression = expression;
																	}-*/;

	public final native String getAttr_formHandlerClass() /*-{
															return this.businessObject.formHandlerClass;
															}-*/;

	public final native void setAttr_formHandlerClass(String formHandlerClass) /*-{
																				this.businessObject.formHandlerClass = formHandlerClass;
																				}-*/;

	public final native String getAttr_formKey() /*-{
													return this.businessObject.formKey;
													}-*/;

	public final native void setAttr_formKey(String formKey) /*-{
																this.businessObject.formKey = formKey;
																}-*/;

	public final native String getAttr_initiator() /*-{
													return this.businessObject.initiator;
													}-*/;

	public final native void setAttr_initiator(String initiator) /*-{
																	this.businessObject.initiator = initiator;
																	}-*/;

	public final native String getAttr_priority() /*-{
													return this.businessObject.priority;
													}-*/;

	public final native void setAttr_priority(String priority) /*-{
																this.businessObject.priority = priority;
																}-*/;

	public final native String getAttr_resource() /*-{
													return this.businessObject.resource;
													}-*/;

	public final native void setAttr_resource(String resource) /*-{
																this.businessObject.resource = resource;
																}-*/;

	public final native String getAttr_resultVariable() /*-{
														return this.businessObject.resultVariable;
														}-*/;

	public final native void setAttr_resultVariable(String resultVariable) /*-{
																			this.businessObject.resultVariable = resultVariable;
																			}-*/;

	public final native String getAttr_type() /*-{
														return this.businessObject.type;
														}-*/;

	public final native void setAttr_type(String type) /*-{
																			this.businessObject.type = type;
																			}-*/;

	/*
	 * asdsad
	 */

	public final native boolean getAttrIsExecutable() /*-{
														return this.businessObject.isExecutable;
														}-*/;

	public final native void setAttrIsExecutable(boolean isExecutable) /*-{
																		this.businessObject.isExecutable = isExecutable;
																		}-*/;

}
