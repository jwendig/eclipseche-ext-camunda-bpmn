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

public class BpmnIoExtensionElementJso extends JavaScriptObject {

	protected BpmnIoExtensionElementJso() {
	}

	public final native String getType() /*-{
											return this.$type;
											}-*/;

	public final native Object getObjectAttribute(String key)/*-{
																return this[key];
																}-*/;

	public final native String getStringAttribute(String key)/*-{
																return this[key];
																}-*/;

	public final native boolean getBooleanAttribute(String key)/*-{
																return this[key];
																}-*/;

	public final native void setAttribute(String key, Object value)/*-{
																	this[key] = value;
																	}-*/;

	public final native void setChildElement(String key,
			BpmnIoExtensionElementJso extensionChildElement)/*-{
																				this[key] = extensionChildElement;
																				}-*/;

	public final native BpmnIoExtensionElementJso getChildElement(String key)/*-{
																				return this[key];
																				}-*/;

	public final native void clearChildElement(String field)/*-{
															this[field] = undefined;
															}-*/;


	public final native void addChildElementToParent(String parentType,
			String parentField,
			BpmnIoExtensionElementJso extensionChildElement,
			BpmnIoModdleJso moddle)/*-{
									var that = this;
									this[parentField] = this[parentField] || moddle.create(parentType);
									this[parentField].get('values').push(extensionChildElement);
									}-*/;

	public final native void removeChildElementFromParent(String parentField,
			BpmnIoExtensionElementJso extensionChildElement)/*-{
															var that = this, elementIndex;
															
															elementIndex = this[parentField].get('values').indexOf(extensionChildElement);
															if (elementIndex > -1) {
															this[parentField].get('values').splice(elementIndex, 1);
															}
															
															if(this[parentField].get('values').length == 0){
															this[parentField] = undefined;
															}
															
															}-*/;

	public final native JsArray<BpmnIoExtensionElementJso> getChildElementsFromParent(
			String parentField, String childType)/*-{
														var that = this;
														if(this[parentField] == undefined){
															return [];
														}
														
														return this[parentField].get('values').filter(function(e) {
															return e.$instanceOf(childType);
														});
														}-*/;
}
