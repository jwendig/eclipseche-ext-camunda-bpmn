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

import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.ExecutionListenerExtensionElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.flowElements.DataObjectFlowElement;

public class BpmnIoElementJso extends JavaScriptObject {

	protected BpmnIoElementJso() {
	}

	public final native String getType() /*-{
											return this.businessObject.$type;
											}-*/;

	public final native Object getObjectAttribute(String key)/*-{
																return this.businessObject[key];
																}-*/;

	public final native String getStringAttribute(String key)/*-{
																return this.businessObject[key];
																}-*/;

	public final native boolean getBooleanAttribute(String key)/*-{
																return this.businessObject[key];
																}-*/;

	public final native BpmnIoChildElementJso getChildElement(String field)/*-{
																			return this.businessObject[field];
																			}-*/;

	public final native void addFlowElement(BpmnIoFlowElementJso flowElement)/*-{
																				this.businessObject.flowElements = this.businessObject.flowElements	|| [];
																				this.businessObject.flowElements.push(flowElement);
																				}-*/;

	public final native void removeFlowElement(BpmnIoFlowElementJso flowElement)/*-{
																				var flowElementIndex = this.businessObject.flowElements.indexOf(flowElement);
																				if (flowElementIndex > -1) {
																					this.businessObject.flowElements.splice(flowElementIndex, 1);
																				}
																				
																				}-*/;

	public final native JsArray<BpmnIoFlowElementJso> getFlowElements(
			String type)/*-{
						console.log("js-native: getProperty_elements");
						if (!this.businessObject.flowElements) {
							return [];
						}

						return this.businessObject.flowElements.filter(function(e) {
							return e.$instanceOf(type);
						});
						}-*/;

	public final native void addExtensionElement(
			BpmnIoExtensionElementJso extensionElement, BpmnIoModdleJso moddle)/*-{
																				var that = this;
																				this.businessObject.extensionElements = this.businessObject.extensionElements	|| moddle.create('bpmn:ExtensionElements');
																				this.businessObject.extensionElements.get('values').push(extensionElement);
																				}-*/;

	public final native void removeExtensionElement(
			BpmnIoExtensionElementJso extensionElement)/*-{
														var extensionElementsIndex = this.businessObject.extensionElements.values.indexOf(extensionElement);
														if (extensionElementsIndex > -1) {
															this.businessObject.extensionElements.values.splice(extensionElementsIndex, 1);
														}
														
														if(this.businessObject.extensionElements.values.length == 0){
																this.businessObject.extensionElements = undefined;
														}

														}-*/;

	public final native JsArray<BpmnIoExtensionElementJso> getExtensionElements(
			String elementType)/*-{
						var that = this;
			
						if (!this.businessObject.extensionElements) {
							return [];
						}

						return this.businessObject.extensionElements.get('values').filter(function(e) {
							return e.$instanceOf(elementType);
						});
						}-*/;

	public final native void addExtensionElementToParent(String parentType,
			String parentField, BpmnIoExtensionElementJso extensionElement,
			BpmnIoModdleJso moddle)/*-{
									var parents, parent;
									var that = this;
									this.businessObject.extensionElements = this.businessObject.extensionElements || moddle.create('bpmn:ExtensionElements');
									parents = this.businessObject.extensionElements.get('values').filter(function(e) {
										return e.$instanceOf(parentType);
									});
									
									if(parents.length == 0){
										parent = moddle.create(parentType);
										this.businessObject.extensionElements.get('values').push(parent);
									}else{
										parent = parents[0];
									}
									parent.get(parentField).push(extensionElement);
									}-*/;

	public final native void removeExtensionElementFromParent(
			String parentType, String parentField,
			BpmnIoExtensionElementJso extensionElement)/*-{
														var parents, parent, elementIndex;
														var extElements = this.businessObject.extensionElements;
														var that = this;																		
														parents = this.businessObject.extensionElements.get('values').filter(function(e) {
														return e.$instanceOf(parentType);
														}); 
														
														if(parents.length > 0){
														parent = parents[0];
														elementIndex = parent.get(parentField).indexOf(extensionElement);
														if (elementIndex > -1) {
														parent.get(parentField).splice(elementIndex, 1);
														}
														}
														
														if(parent.get(parentField).length == 0){
														elementIndex = this.businessObject.extensionElements.values.indexOf(parent);
														if (elementIndex > -1) {
														this.businessObject.extensionElements.values.splice(elementIndex, 1);
														}
														}
														
														if(this.businessObject.extensionElements.values.length == 0){
														this.businessObject.extensionElements = undefined;
														}
														
														}-*/;
	
	public final native void removeExtensionElementFromParent(
			String parentType, String parentField, String[] parentFieldsForParentDeleteCheck,
			BpmnIoExtensionElementJso extensionElement)/*-{
														var parents, parent, elementIndex, deleteParent = true;
														var extElements = this.businessObject.extensionElements;
														var that = this;																		
														parents = this.businessObject.extensionElements.get('values').filter(function(e) {
															return e.$instanceOf(parentType);
														}); 
														
														if(parents.length > 0){
															parent = parents[0];
															elementIndex = parent.get(parentField).indexOf(extensionElement);
															if (elementIndex > -1) {
																parent.get(parentField).splice(elementIndex, 1);
															}
														}
														
														parentFieldsForParentDeleteCheck.forEach(function(value, index, array) {
														    var xx=parent.get(value);
														  	if(parent.get(value) != undefined && parent.get(value).length > 0){
														  		deleteParent = false;
														  	}
														});
														
														if(deleteParent){
															elementIndex = this.businessObject.extensionElements.values.indexOf(parent);
															if (elementIndex > -1) {
																this.businessObject.extensionElements.values.splice(elementIndex, 1);
															}
														}
														
														if(this.businessObject.extensionElements.values.length == 0){
														this.businessObject.extensionElements = undefined;
														}
														
														}-*/;

	public final native JsArray<BpmnIoExtensionElementJso> getExtensionElementFromParent(
			String parentType, String parentField, String elementType)/*-{
																			var parents, parent, elementIndex;
																			var that = this;	
																			if(this.businessObject.extensionElements != undefined){																	
																				parents = this.businessObject.extensionElements.get('values').filter(function(e) {
																					return e.$instanceOf(parentType);
																				}); 
																				
																				if(parents.length > 0){
																					parent = parents[0];
																					return parent.get(parentField).filter(function(e) {
																						return e.$instanceOf(elementType);
																					}); 
																				}
																			}
																			return [];
																			
																			}-*/;
}
