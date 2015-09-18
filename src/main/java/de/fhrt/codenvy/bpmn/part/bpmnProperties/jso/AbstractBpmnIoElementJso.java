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
package de.fhrt.codenvy.bpmn.part.bpmnProperties.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.DefaultJso;
import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.ProcessJso;
import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.ScriptTaskJso;
import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.ServiceTaskJso;
import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.StartEventJso;
import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.TaskJso;
import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.UserTaskJso;

public abstract class AbstractBpmnIoElementJso extends JavaScriptObject {

	protected AbstractBpmnIoElementJso() {
	}

	/*
	 * functions default
	 */
	// @Override
	public final native String getType() /*-{
											return this.businessObject.$type;
											}-*/;

	// @Override
	public final native String getAttr_id() /*-{
											return this.businessObject.id;
											}-*/;

	// @Override
	public final native void setAttr_id(String id) /*-{
													this.businessObject.id = id;
													}-*/;

	// @Override
	public final native String getAttr_name() /*-{
												return this.businessObject.name;
												}-*/;

	// @Override
	public final native void setAttr_name(String name) /*-{
														this.businessObject.name = name;
														}-*/;

	/*
	 * process-element only
	 */
	// @Override
	public final native boolean getAttr_isExecutable() /*-{
														return this.businessObject.isExecutable;
														}-*/;

	// @Override
	public final native void setAttr_isExecutable(boolean isExecutable) /*-{
																		this.businessObject.isExecutable = isExecutable;
																		}-*/;

	/*
	 * functions for different bpmn-elements
	 */
	// @Override
	public final native String getAttr_assignee() /*-{
														return this.businessObject.assignee;
														}-*/;

	// @Override
	public final native void setAttr_assignee(String assignee) /*-{
																		this.businessObject.assignee = assignee;
																		}-*/;

	// @Override
	public final native boolean getAttr_asyncAfter() /*-{
														return this.businessObject.asyncAfter;
														}-*/;

	// @Override
	public final native void setAttr_asyncAfter(boolean asyncAfter) /*-{
																	this.businessObject.asyncAfter = asyncAfter;
																	}-*/;

	// @Override
	public final native boolean getAttr_asyncBefore() /*-{
														return this.businessObject.asyncBefore;
														}-*/;

	// @Override
	public final native void setAttr_asyncBefore(boolean asyncBefore) /*-{
																		this.businessObject.asyncBefore = asyncBefore;
																		}-*/;

	// @Override
	public final native String getAttr_calledElementBinding() /*-{
																return this.businessObject.calledElementBinding;
																}-*/;

	// @Override
	public final native void setAttr_calledElementBinding(
			String calledElementBinding) /*-{
											this.businessObject.calledElementBinding = calledElementBinding;
											}-*/;

	// @Override
	public final native int getAttr_calledElementVersion() /*-{
																return this.businessObject.calledElementVersion;
																}-*/;

	// @Override
	public final native void setAttr_calledElementVersion(
			int calledElementVersion) /*-{
											this.businessObject.calledElementVersion = calledElementVersion;
											}-*/;

	// @Override
	public final native String getAttr_candidateGroups() /*-{
																return this.businessObject.candidateGroups;
																}-*/;

	// @Override
	public final native void setAttr_candidateGroups(String candidateGroups) /*-{
																						this.businessObject.candidateGroups = candidateGroups;
																						}-*/;

	// @Override
	public final native String getAttr_candidateStarterGroups() /*-{
																return this.businessObject.candidateStarterGroups;
																}-*/;

	// @Override
	public final native void setAttr_candidateStarterGroups(
			String candidateStarterGroups) /*-{
											this.businessObject.candidateStarterGroups = candidateStarterGroups;
											}-*/;

	// @Override
	public final native String getAttr_candidateStarterUsers() /*-{
																return this.businessObject.candidateStarterUsers;
																}-*/;

	// @Override
	public final native void setAttr_candidateStarterUsers(
			String candidateStarterUsers) /*-{
											this.businessObject.candidateStarterUsers = candidateStarterUsers;
											}-*/;

	// @Override
	public final native String getAttr_candidateUsers() /*-{
																return this.businessObject.candidateUsers;
																}-*/;

	// @Override
	public final native void setAttr_candidateUsers(String candidateUsers) /*-{
																					this.businessObject.candidateUsers = candidateUsers;
																					}-*/;

	// @Override
	public final native String getAttr_caseBinding() /*-{
														return this.businessObject.caseBinding;
														}-*/;

	// @Override
	public final native void setAttr_caseBinding(String caseBinding) /*-{
																			this.businessObject.caseBinding = caseBinding;
																			}-*/;

	// @Override
	public final native String getAttr_caseRef() /*-{
													return this.businessObject.caseRef;
													}-*/;

	// @Override
	public final native void setAttr_caseRef(String caseRef) /*-{
																this.businessObject.caseRef = caseRef;
																}-*/;

	// @Override
	public final native int getAttr_caseVersion() /*-{
													return this.businessObject.caseVersion;
													}-*/;

	// @Override
	public final native void setAttr_caseVersion(int caseVersion) /*-{
																	this.businessObject.caseVersion = caseVersion;
																	}-*/;

	// @Override
	public final native String getAttr_class() /*-{
												return this['class'];
												}-*/;

	// @Override
	public final native void setAttr_class(String clazz) /*-{
															this['class'] = clazz;
															}-*/;

	// @Override
	public final native String getAttr_collection() /*-{
													return this.businessObject.collection;
													}-*/;

	// @Override
	public final native void setAttr_collection(String collection) /*-{
																	this.businessObject.collection = collection;
																	}-*/;

	// @Override
	public final native String getAttr_delegateExpression() /*-{
															return this.businessObject.delegateExpression;
															}-*/;

	// @Override
	public final native void setAttr_delegateExpression(
			String delegateExpression) /*-{
										this.businessObject.delegateExpression = delegateExpression;
										}-*/;

	// @Override
	public final native String getAttr_dueDate() /*-{
															return this.businessObject.dueDate;
															}-*/;

	// @Override
	public final native void setAttr_dueDate(String dueDate) /*-{
																			this.businessObject.dueDate = dueDate;
																			}-*/;

	// @Override
	public final native String getAttr_elementVariable() /*-{
															return this.businessObject.elementVariable;
															}-*/;

	// @Override
	public final native void setAttr_elementVariable(String elementVariable) /*-{
																				this.businessObject.elementVariable = elementVariable;
																				}-*/;

	// @Override
	public final native boolean getAttr_exclusive() /*-{
													return this.businessObject.exclusive;
													}-*/;

	// @Override
	public final native void setAttr_exclusive(boolean exclusive) /*-{
																	this.businessObject.exclusive = exclusive;
																	}-*/;

	// @Override
	public final native String getAttr_expression() /*-{
													return this.businessObject.expression;
													}-*/;

	// @Override
	public final native void setAttr_expression(String expression) /*-{
																	this.businessObject.expression = expression;
																	}-*/;

	// @Override
	public final native String getAttr_formHandlerClass() /*-{
															return this.businessObject.formHandlerClass;
															}-*/;

	// @Override
	public final native void setAttr_formHandlerClass(String formHandlerClass) /*-{
																				this.businessObject.formHandlerClass = formHandlerClass;
																				}-*/;

	// @Override
	public final native String getAttr_formKey() /*-{
													return this.businessObject.formKey;
													}-*/;

	// @Override
	public final native void setAttr_formKey(String formKey) /*-{
																this.businessObject.formKey = formKey;
																}-*/;

	// @Override
	public final native String getAttr_followUpDate() /*-{
														return this.businessObject.followUpDate;
														}-*/;

	// @Override
	public final native void setAttr_followUpDate(String followUpDate) /*-{
																		this.businessObject.followUpDate = followUpDate;
																		}-*/;

	// @Override
	public final native String getAttr_initiator() /*-{
													return this.businessObject.initiator;
													}-*/;

	// @Override
	public final native void setAttr_initiator(String initiator) /*-{
																	this.businessObject.initiator = initiator;
																	}-*/;

	// @Override
	public final native boolean getAttr_isForCompensation() /*-{
															return this.businessObject.isForCompensation;
															}-*/;

	// @Override
	public final native void setAttr_isForCompensation(boolean isForCompensation) /*-{
																					this.businessObject.isForCompensation = isForCompensation;
																					}-*/;

	// @Override
	public final native String getAttr_priority() /*-{
													return this.businessObject.priority;
													}-*/;

	// @Override
	public final native void setAttr_priority(String priority) /*-{
																this.businessObject.priority = priority;
																}-*/;

	// @Override
	public final native String getAttr_resource() /*-{
													return this.businessObject.resource;
													}-*/;

	// @Override
	public final native void setAttr_resource(String resource) /*-{
																this.businessObject.resource = resource;
																}-*/;

	// @Override
	public final native String getAttr_resultVariable() /*-{
														return this.businessObject.resultVariable;
														}-*/;

	// @Override
	public final native void setAttr_resultVariable(String resultVariable) /*-{
																			this.businessObject.resultVariable = resultVariable;
																			}-*/;

	// @Override
	public final native String getAttr_type() /*-{
														return this.businessObject.type;
														}-*/;

	// @Override
	public final native void setAttr_type(String type) /*-{
																			this.businessObject.type = type;
																			}-*/;

	// @Override
	public final native String getAttr_errorCode() /*-{
													return this.businessObject.errorCode;
													}-*/;

	// @Override
	public final native void setAttr_errorCode(String errorCode) /*-{
																	this.businessObject.errorCode = errorCode;
																	}-*/;

}
