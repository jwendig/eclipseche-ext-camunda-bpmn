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

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.BpmnElementCamundaExtensionJso.BpmnElementCamundaExtensionType;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.BpmnElementPropertyJso.BpmnPropertyElementType;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.DefaultJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.ProcessJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.ScriptTaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.ServiceTaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.StartEventJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.TaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.UserTaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.ExecutionListenerJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.PropertyJso;

public class BpmnElementJso extends AbstractBpmnElementJso implements
		DefaultJso, ProcessJso, UserTaskJso, ServiceTaskJso, ScriptTaskJso,
		TaskJso, StartEventJso {

	public enum BpmnElementType {
		DEFAULT("UNDEFINED"), PROCESS("bpmn:Process"), SCRIPT_TASK(
				"bpmn:ScriptTask"), SERVICE_TASK("bpmn:ServiceTask"), START_EVENT(
				"bpmn:StartEvent"), TASK("bpmn:Task"), USER_TASK(
				"bpmn:UserTask");

		private final String bpmnIoTypeDefinition;

		private BpmnElementType(final String bpmnIoTypeDefinition) {
			this.bpmnIoTypeDefinition = bpmnIoTypeDefinition;
		}

		@Override
		public String toString() {
			return bpmnIoTypeDefinition;
		}

		public static BpmnElementType findByBpmnIoTypeDefinition(
				String bpmnIoTypeDefinition) {
			for (BpmnElementType t : values()) {
				if (t.bpmnIoTypeDefinition.equals(bpmnIoTypeDefinition)) {
					return t;
				}
			}
			return DEFAULT;
		}
	}

	protected BpmnElementJso() {
	}

	private final native BpmnElementCamundaExtensionJso nativeAddCamundaExtElement(
			JavaScriptObject moddle, String bpmnExtensionElementType)/*-{
																		var ext = moddle.create(bpmnExtensionElementType);

																		this.extensionElements = this.extensionElements	|| moddle.create('bpmn:ExtensionElements');
																		this.extensionElements.get('values').push(ext);
																		
																		return ext;
																		
																		
																		}-*/;

	private static final native BpmnElementCamundaExtensionJso nativeAddCamundaExtElementToExistingCamundaExtElement(
			BpmnElementCamundaExtensionJso baseElement,
			JavaScriptObject moddle, String bpmnExtensionElementType)/*-{
																		var ext = moddle.create(bpmnExtensionElementType);
																		baseElement.get('values').push(ext);
																		
																		return ext;
																		
																		
																		}-*/;

	private final native boolean nativeRemoveCamundaExtElement(
			BpmnElementCamundaExtensionJso extElement)/*-{
														console.log("js-native: removeExt_elemenemt");
														var extElementIndex = this.extensionElements.values.indexOf(extElement);
														if (extElementIndex > -1) {
														console.log("js-native: removeExt_elemenemt: extElement found at index:" + extElementIndex);
														this.extensionElements.values.splice(extElementIndex, 1);
														
														return true;
														}else{
														console.log("js-native: removeExt_elemenemt: extElement not found");
														return false;
														}
														}-*/;

	private final static native boolean nativeRemoveCamundaExtElementFromExistingCamundaExtElement(
			BpmnElementCamundaExtensionJso baseElement,
			BpmnElementCamundaExtensionJso elemToRemove)/*-{
														console.log("js-native: nativeRemoveCamundaExtElementFromExistingCamundaExtElement");
														
														var elemToRemoveIndex = baseElement.values.indexOf(elemToRemove);
														if (elemToRemoveIndex > -1) {
															console.log("js-native: nativeRemoveCamundaExtElementFromExistingCamundaExtElement: elemToRemove found at index:" + elemToRemoveIndex);
															baseElement.values.splice(elemToRemoveIndex, 1);
														
															return true;
														}else{
															console.log("js-native: nativeRemoveCamundaExtElementFromExistingCamundaExtElement: elemToRemove not found");
															return false;
														}
														}-*/;

	private final native JsArray<BpmnElementCamundaExtensionJso> nativeGetCamundaExtElementsByType(
			String bpmnExtensionElementType) /*-{
												console.log("js-native: getExt_executionListeners");
												if (!this.extensionElements || this.extensionElements.values == 'undefined') {
												console
												.log("js-native: getExt_executionListeners: no extensionElementsAvailable");
												return [];
												}

												return this.extensionElements.values.filter(function(e) {
												return e.$instanceOf(bpmnExtensionElementType);
												});
												}-*/;

	/*
	 * functions for extension elements
	 */

	@Override
	public final boolean removeCamundaExt_executionListener(
			ExecutionListenerJso element) {
		return nativeRemoveCamundaExtElement((BpmnElementCamundaExtensionJso) element);
	}

	@Override
	public final List<ExecutionListenerJso> getCamundaExt_executionListeners() {
		JsArray<BpmnElementCamundaExtensionJso> extElements = nativeGetCamundaExtElementsByType(BpmnElementCamundaExtensionType.CAMUNDA_EXECUTION_LISTENER
				.toString());
		List<ExecutionListenerJso> list = new ArrayList<ExecutionListenerJso>();
		for (int i = 0; i < extElements.length(); i++) {
			list.add(extElements.get(i));
		}

		return list;
	}

	@Override
	public final ExecutionListenerJso addCamundaExt_executionListener(
			JavaScriptObject moddle) {
		ExecutionListenerJso newExtElement = nativeAddCamundaExtElement(moddle,
				BpmnElementCamundaExtensionType.CAMUNDA_EXECUTION_LISTENER
						.toString());
		return newExtElement;
	}

	/*
	 * functions for properties
	 */

	@Override
	public final List<PropertyJso> getCamundaExt_property() {
		List<PropertyJso> list = new ArrayList<PropertyJso>();

		JsArray<BpmnElementCamundaExtensionJso> baseElements = nativeGetCamundaExtElementsByType(BpmnElementCamundaExtensionType.CAMUNDA_PROPERTIES
				.toString());
		for (int i = 0; i < baseElements.length(); i++) {
			JsArray<BpmnElementCamundaExtensionJso> nestedElements = BpmnElementCamundaExtensionJso
					.nativeGetPropertyListFromProperties(baseElements.get(i),
							BpmnElementCamundaExtensionType.CAMUNDA_PROPERTY
									.toString());
			for (int k = 0; k < nestedElements.length(); k++) {
				list.add(nestedElements.get(k));
			}
		}

		return list;
	}

	@Override
	public final PropertyJso addCamundaExt_property(JavaScriptObject moddle) {
		BpmnElementCamundaExtensionJso baseElement = null;
		JsArray<BpmnElementCamundaExtensionJso> baseElements = nativeGetCamundaExtElementsByType(BpmnElementCamundaExtensionType.CAMUNDA_PROPERTIES
				.toString());

		if (baseElements.length() == 0) {
			baseElement = nativeAddCamundaExtElement(moddle,
					BpmnElementCamundaExtensionType.CAMUNDA_PROPERTIES
							.toString());
		} else {
			baseElement = baseElements.get(0);
		}
		PropertyJso propertry = nativeAddCamundaExtElementToExistingCamundaExtElement(
				baseElement, moddle,
				BpmnElementCamundaExtensionType.CAMUNDA_PROPERTY.toString());

		return propertry;
	}

	@Override
	public final boolean removeCamundaExt_property(PropertyJso element) {
		JsArray<BpmnElementCamundaExtensionJso> baseElements = nativeGetCamundaExtElementsByType(BpmnElementCamundaExtensionType.CAMUNDA_PROPERTIES
				.toString());
		boolean isDeleted = false;
		for (int i = 0; i < baseElements.length(); i++) {
			isDeleted = nativeRemoveCamundaExtElementFromExistingCamundaExtElement(
					baseElements.get(i),
					(BpmnElementCamundaExtensionJso) element);
			if (isDeleted) {
				return true;
			}
		}

		return false;
	}

	/*
	 * real properties ...
	 */

	private final native JsArray<BpmnElementPropertyJso> getBpmnProperty_elements(
			String bpmnPropertyElementType) /*-{
											console.log("js-native: getProperty_elements");
											if (!this.flowElements) {
											console
											.log("js-native: getProperty_elements: no flowElements available");
											return [];
											}

											return this.flowElements.filter(function(e) {
											return e.$instanceOf(bpmnPropertyElementType);
											});
											}-*/;

	@Override
	public final native boolean removeBpmnProperty_element(
			BpmnElementPropertyJso propElement)/*-{
														console.log("js-native: removeProperty_elemenemt");
														var propElementIndex = this.flowElements.indexOf(propElement);
														if (propElementIndex > -1) {
														console.log("js-native: removeProperty_elemenemt: propElement found at index:" + propElementIndex);
														this.flowElements.splice(propElementIndex, 1);
														
														return true;
														}else{
														console.log("js-native: removeProperty_elemenemt: propElement not found");
														return false;
														}
														}-*/;

	private final native BpmnElementPropertyJso nativeAddBpmnProperty_element(
			JavaScriptObject moddle, String bpmnPropertyElementType)/*-{
																	var ext = moddle.create(bpmnPropertyElementType);
																	this.flowElements = this.flowElements	|| [];
																	this.flowElements.push(ext);

																	return ext;
																	
																	}-*/;

	@Override
	public final JsArray<BpmnElementPropertyJso> getBpmnProperty_dataObjects() {
		JsArray<BpmnElementPropertyJso> extElements = getBpmnProperty_elements(BpmnPropertyElementType.BPMN_DATA_OBJECT
				.toString());
		return extElements;
	}

	@Override
	public final BpmnElementPropertyJso addProperty_dataObject(
			JavaScriptObject moddle) {
		BpmnElementPropertyJso newExtElement = nativeAddBpmnProperty_element(
				moddle, BpmnPropertyElementType.BPMN_DATA_OBJECT.toString());
		return newExtElement;
	}
}