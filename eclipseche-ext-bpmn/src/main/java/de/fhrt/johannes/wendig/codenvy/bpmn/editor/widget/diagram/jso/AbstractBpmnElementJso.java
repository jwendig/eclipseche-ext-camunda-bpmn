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
package de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.DefaultJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.ProcessJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.ScriptTaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.ServiceTaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.StartEventJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.TaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.UserTaskJso;

public abstract class AbstractBpmnElementJso extends JavaScriptObject {

	protected AbstractBpmnElementJso() {
	}

	/*
	 * functions default
	 */
	// @Override
	public final native String getType() /*-{
											return this.$type;
											}-*/;

	// @Override
	public final native String getBusinessObject() /*-{
													return this.businessObject;
													}-*/;

	// @Override
	public final native String getAttr_id() /*-{
											return this.id;
											}-*/;

	// @Override
	public final native void setAttr_id(String id) /*-{
													this.id = id;
													}-*/;

	// @Override
	public final native String getAttr_name() /*-{
												return this.name;
												}-*/;

	// @Override
	public final native void setAttr_name(String name) /*-{
														this.name = name;
														}-*/;

	/*
	 * process-element only
	 */
	// @Override
	public final native boolean getAttr_isExecutable() /*-{
														return this.isExecutable;
														}-*/;

	// @Override
	public final native void setAttr_isExecutable(boolean isExecutable) /*-{
																		this.isExecutable = isExecutable;
																		}-*/;

	/*
	 * functions for different bpmn-elements
	 */
	// @Override
	public final native String getAttr_assignee() /*-{
														return this.assignee;
														}-*/;

	// @Override
	public final native void setAttr_assignee(String assignee) /*-{
																		this.assignee = assignee;
																		}-*/;

	// @Override
	public final native boolean getAttr_asyncAfter() /*-{
														return this.asyncAfter;
														}-*/;

	// @Override
	public final native void setAttr_asyncAfter(boolean asyncAfter) /*-{
																	this.asyncAfter = asyncAfter;
																	}-*/;

	// @Override
	public final native boolean getAttr_asyncBefore() /*-{
														return this.asyncBefore;
														}-*/;

	// @Override
	public final native void setAttr_asyncBefore(boolean asyncBefore) /*-{
																		this.asyncBefore = asyncBefore;
																		}-*/;

	// @Override
	public final native String getAttr_calledElementBinding() /*-{
																return this.calledElementBinding;
																}-*/;

	// @Override
	public final native void setAttr_calledElementBinding(
			String calledElementBinding) /*-{
											this.calledElementBinding = calledElementBinding;
											}-*/;

	// @Override
	public final native int getAttr_calledElementVersion() /*-{
																return this.calledElementVersion;
																}-*/;

	// @Override
	public final native void setAttr_calledElementVersion(
			int calledElementVersion) /*-{
											this.calledElementVersion = calledElementVersion;
											}-*/;

	// @Override
	public final native String getAttr_candidateGroups() /*-{
																return this.candidateGroups;
																}-*/;

	// @Override
	public final native void setAttr_candidateGroups(String candidateGroups) /*-{
																						this.candidateGroups = candidateGroups;
																						}-*/;

	// @Override
	public final native String getAttr_candidateStarterGroups() /*-{
																return this.candidateStarterGroups;
																}-*/;

	// @Override
	public final native void setAttr_candidateStarterGroups(
			String candidateStarterGroups) /*-{
											this.candidateStarterGroups = candidateStarterGroups;
											}-*/;

	// @Override
	public final native String getAttr_candidateStarterUsers() /*-{
																return this.candidateStarterUsers;
																}-*/;

	// @Override
	public final native void setAttr_candidateStarterUsers(
			String candidateStarterUsers) /*-{
											this.candidateStarterUsers = candidateStarterUsers;
											}-*/;

	// @Override
	public final native String getAttr_candidateUsers() /*-{
																return this.candidateUsers;
																}-*/;

	// @Override
	public final native void setAttr_candidateUsers(String candidateUsers) /*-{
																					this.candidateUsers = candidateUsers;
																					}-*/;

	// @Override
	public final native String getAttr_caseBinding() /*-{
														return this.caseBinding;
														}-*/;

	// @Override
	public final native void setAttr_caseBinding(String caseBinding) /*-{
																			this.caseBinding = caseBinding;
																			}-*/;

	// @Override
	public final native String getAttr_caseRef() /*-{
													return this.caseRef;
													}-*/;

	// @Override
	public final native void setAttr_caseRef(String caseRef) /*-{
																this.caseRef = caseRef;
																}-*/;

	// @Override
	public final native int getAttr_caseVersion() /*-{
													return this.caseVersion;
													}-*/;

	// @Override
	public final native void setAttr_caseVersion(int caseVersion) /*-{
																	this.caseVersion = caseVersion;
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
													return this.collection;
													}-*/;

	// @Override
	public final native void setAttr_collection(String collection) /*-{
																	this.collection = collection;
																	}-*/;

	// @Override
	public final native String getAttr_delegateExpression() /*-{
															return this.delegateExpression;
															}-*/;

	// @Override
	public final native void setAttr_delegateExpression(
			String delegateExpression) /*-{
										this.delegateExpression = delegateExpression;
										}-*/;

	// @Override
	public final native String getAttr_dueDate() /*-{
															return this.dueDate;
															}-*/;

	// @Override
	public final native void setAttr_dueDate(String dueDate) /*-{
																			this.dueDate = dueDate;
																			}-*/;

	// @Override
	public final native String getAttr_elementVariable() /*-{
															return this.elementVariable;
															}-*/;

	// @Override
	public final native void setAttr_elementVariable(String elementVariable) /*-{
																				this.elementVariable = elementVariable;
																				}-*/;

	// @Override
	public final native boolean getAttr_exclusive() /*-{
													return this.exclusive;
													}-*/;

	// @Override
	public final native void setAttr_exclusive(boolean exclusive) /*-{
																	this.exclusive = exclusive;
																	}-*/;

	// @Override
	public final native String getAttr_expression() /*-{
													return this.expression;
													}-*/;

	// @Override
	public final native void setAttr_expression(String expression) /*-{
																	this.expression = expression;
																	}-*/;

	// @Override
	public final native String getAttr_formHandlerClass() /*-{
															return this.formHandlerClass;
															}-*/;

	// @Override
	public final native void setAttr_formHandlerClass(String formHandlerClass) /*-{
																				this.formHandlerClass = formHandlerClass;
																				}-*/;

	// @Override
	public final native String getAttr_formKey() /*-{
													return this.formKey;
													}-*/;

	// @Override
	public final native void setAttr_formKey(String formKey) /*-{
																this.formKey = formKey;
																}-*/;

	// @Override
	public final native String getAttr_initiator() /*-{
													return this.initiator;
													}-*/;

	// @Override
	public final native void setAttr_initiator(String initiator) /*-{
																	this.initiator = initiator;
																	}-*/;

	// @Override
	public final native String getAttr_priority() /*-{
													return this.priority;
													}-*/;

	// @Override
	public final native void setAttr_priority(String priority) /*-{
																this.priority = priority;
																}-*/;

	// @Override
	public final native String getAttr_resource() /*-{
													return this.resource;
													}-*/;

	// @Override
	public final native void setAttr_resource(String resource) /*-{
																this.resource = resource;
																}-*/;

	// @Override
	public final native String getAttr_resultVariable() /*-{
														return this.resultVariable;
														}-*/;

	// @Override
	public final native void setAttr_resultVariable(String resultVariable) /*-{
																			this.resultVariable = resultVariable;
																			}-*/;

	// @Override
	public final native String getAttr_type() /*-{
														return this.type;
														}-*/;

	// @Override
	public final native void setAttr_type(String type) /*-{
																			this.type = type;
																			}-*/;

	// @Override
	public final native String getAttr_errorCode() /*-{
													return this.errorCode;
													}-*/;

	// @Override
	public final native void setAttr_errorCode(String errorCode) /*-{
																	this.errorCode = errorCode;
																	}-*/;

}
