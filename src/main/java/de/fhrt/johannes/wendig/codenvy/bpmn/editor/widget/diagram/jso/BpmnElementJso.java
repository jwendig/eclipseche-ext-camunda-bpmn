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

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.BpmnElementCamundaExtensionJso.BpmnElementCamundaExtensionField;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.BpmnElementCamundaExtensionJso.BpmnElementCamundaExtensionType;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.BpmnElementPropertyJso.BpmnPropertyElementType;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.DefaultJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.ProcessJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.ScriptTaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.ServiceTaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.StartEventJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.TaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.UserTaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.ConnectorJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.ExecutionListenerJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.FormFieldJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.InputParameterJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.OutputParameterJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.TaskListenerJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.childs.PropertyJso;

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

	/*
	 * functions for extension elements
	 */
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

	private static final native BpmnElementCamundaExtensionJso nativeAddCamundaExtElementToExistingCamundaExtElementByFieldName(
			BpmnElementCamundaExtensionJso baseElement,
			JavaScriptObject moddle, String bpmnExtensionElementType,
			String fieldName)/*-{
								var ext = moddle.create(bpmnExtensionElementType);
								baseElement.get(fieldName).push(ext);
								
								return ext;
								
								
								}-*/;

	private final native boolean nativeRemoveCamundaExtElement(
			BpmnElementCamundaExtensionJso extElement)/*-{
														console.log("js-native: removeExt_elemenemt");
														var extElementIndex = this.extensionElements.values.indexOf(extElement);
														if (extElementIndex > -1) {
															console.log("js-native: removeExt_elemenemt: extElement found at index:" + extElementIndex);
															this.extensionElements.values.splice(extElementIndex, 1);
														
															if(this.extensionElements.values.length == 0){
																delete this.extensionElements;
															}
														
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
														
															if(baseElement.values.length == 0){
																baseElement = undefined;
															}
														
															if(this.extensionElements && this.extensionElements.values.length == 0){
																delete this.extensionElements;
															}
														
															return true;
														}else{
															console.log("js-native: nativeRemoveCamundaExtElementFromExistingCamundaExtElement: elemToRemove not found");
															return false;
														}
														}-*/;

	private final static native boolean nativeRemoveCamundaExtElementFromExistingCamundaExtElementByFieldName(
			BpmnElementCamundaExtensionJso baseElement,
			BpmnElementCamundaExtensionJso elemToRemove, String fieldName)/*-{
																			console.log("js-native: nativeRemoveCamundaExtElementFromExistingCamundaExtElementByFieldName");
																			
																			var elemToRemoveIndex = baseElement[fieldName].indexOf(elemToRemove);
																			if (elemToRemoveIndex > -1) {
																				console.log("js-native: nativeRemoveCamundaExtElementFromExistingCamundaExtElementByFieldName: elemToRemove found at index:" + elemToRemoveIndex);
																				baseElement[fieldName].splice(elemToRemoveIndex, 1);
																				
																				if(baseElement[fieldName].length == 0){
																					baseElement[fieldName] = undefined;
																				}
																				
																				return true;
																			}else{
																				console.log("js-native: nativeRemoveCamundaExtElementFromExistingCamundaExtElementByFieldName: elemToRemove not found");
																				return false;
																			}
																			}-*/;

	private final native JsArray<BpmnElementCamundaExtensionJso> nativeGetCamundaExtElementsByType(
			String bpmnExtensionElementType) /*-{
												console.log("js-native: nativeGetCamundaExtElementsByType");
												if (!this.extensionElements || this.extensionElements.values == 'undefined') {
												console
												.log("js-native: nativeGetCamundaExtElementsByType: no extensionElementsAvailable");
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

	@Override
	public final boolean removeCamundaExt_taskListener(TaskListenerJso element) {
		return nativeRemoveCamundaExtElement((BpmnElementCamundaExtensionJso) element);
	}

	@Override
	public final List<TaskListenerJso> getCamundaExt_taskListeners() {
		JsArray<BpmnElementCamundaExtensionJso> extElements = nativeGetCamundaExtElementsByType(BpmnElementCamundaExtensionType.CAMUNDA_TASK_LISTENER
				.toString());
		List<TaskListenerJso> list = new ArrayList<TaskListenerJso>();
		for (int i = 0; i < extElements.length(); i++) {
			list.add(extElements.get(i));
		}

		return list;
	}

	@Override
	public final TaskListenerJso addCamundaExt_taskListener(
			JavaScriptObject moddle) {
		TaskListenerJso newExtElement = nativeAddCamundaExtElement(moddle,
				BpmnElementCamundaExtensionType.CAMUNDA_TASK_LISTENER
						.toString());
		return newExtElement;
	}

	/*
	 * functions for formFields
	 */

	@Override
	public final List<FormFieldJso> getCamundaExt_formField() {
		List<FormFieldJso> list = new ArrayList<FormFieldJso>();

		JsArray<BpmnElementCamundaExtensionJso> baseElements = nativeGetCamundaExtElementsByType(BpmnElementCamundaExtensionType.CAMUNDA_FORMDATA
				.toString());
		for (int i = 0; i < baseElements.length(); i++) {
			JsArray<BpmnElementCamundaExtensionJso> nestedElements = BpmnElementCamundaExtensionJso
					.nativeGetPropertyListFromProperties(baseElements.get(i),
							BpmnElementCamundaExtensionType.CAMUNDA_FORMFIELD
									.toString());
			for (int k = 0; k < nestedElements.length(); k++) {
				list.add(nestedElements.get(k));
			}
		}

		return list;
	}

	@Override
	public final FormFieldJso addCamundaExt_formField(JavaScriptObject moddle) {
		BpmnElementCamundaExtensionJso baseElement = null;
		JsArray<BpmnElementCamundaExtensionJso> baseElements = nativeGetCamundaExtElementsByType(BpmnElementCamundaExtensionType.CAMUNDA_FORMDATA
				.toString());

		if (baseElements.length() == 0) {
			baseElement = nativeAddCamundaExtElement(moddle,
					BpmnElementCamundaExtensionType.CAMUNDA_FORMDATA.toString());
		} else {
			baseElement = baseElements.get(0);
		}
		FormFieldJso propertry = nativeAddCamundaExtElementToExistingCamundaExtElement(
				baseElement, moddle,
				BpmnElementCamundaExtensionType.CAMUNDA_FORMFIELD.toString());

		return propertry;
	}

	@Override
	public final boolean removeCamundaExt_formField(FormFieldJso element) {
		JsArray<BpmnElementCamundaExtensionJso> baseElements = nativeGetCamundaExtElementsByType(BpmnElementCamundaExtensionType.CAMUNDA_FORMDATA
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
	 * input parameters
	 */

	@Override
	public final boolean removeCamundaExt_inputParameter(
			InputParameterJso element) {
		JsArray<BpmnElementCamundaExtensionJso> baseElements = nativeGetCamundaExtElementsByType(BpmnElementCamundaExtensionType.CAMUNDA_INPUT_OUTPUT
				.toString());
		boolean isDeleted = false;
		for (int i = 0; i < baseElements.length(); i++) {
			isDeleted = nativeRemoveCamundaExtElementFromExistingCamundaExtElementByFieldName(
					baseElements.get(i),
					(BpmnElementCamundaExtensionJso) element,
					BpmnElementCamundaExtensionField.CAMUNDA_INPUT_PARAMETERS
							.toString());
			if (isDeleted) {
				return true;
			}
		}

		return false;
	}

	@Override
	public final List<InputParameterJso> getCamundaExt_inputParameters() {
		List<InputParameterJso> list = new ArrayList<InputParameterJso>();

		JsArray<BpmnElementCamundaExtensionJso> baseElements = nativeGetCamundaExtElementsByType(BpmnElementCamundaExtensionType.CAMUNDA_INPUT_OUTPUT
				.toString());
		for (int i = 0; i < baseElements.length(); i++) {
			JsArray<BpmnElementCamundaExtensionJso> nestedElements = BpmnElementCamundaExtensionJso
					.nativeGetPropertyListFromPropertiesByFieldName(
							baseElements.get(i),
							BpmnElementCamundaExtensionType.CAMUNDA_INPUT_PARAMETER
									.toString(),
							BpmnElementCamundaExtensionField.CAMUNDA_INPUT_PARAMETERS
									.toString());
			for (int k = 0; k < nestedElements.length(); k++) {
				list.add(nestedElements.get(k));
			}
		}

		return list;
	}

	@Override
	public final InputParameterJso addCamundaExt_inputParameter(
			JavaScriptObject moddle) {
		BpmnElementCamundaExtensionJso baseElement = null;
		JsArray<BpmnElementCamundaExtensionJso> baseElements = nativeGetCamundaExtElementsByType(BpmnElementCamundaExtensionType.CAMUNDA_INPUT_OUTPUT
				.toString());

		if (baseElements.length() == 0) {
			baseElement = nativeAddCamundaExtElement(moddle,
					BpmnElementCamundaExtensionType.CAMUNDA_INPUT_OUTPUT
							.toString());
		} else {
			baseElement = baseElements.get(0);
		}
		InputParameterJso inputParameterJso = nativeAddCamundaExtElementToExistingCamundaExtElementByFieldName(
				baseElement, moddle,
				BpmnElementCamundaExtensionType.CAMUNDA_INPUT_PARAMETER
						.toString(),
				BpmnElementCamundaExtensionField.CAMUNDA_INPUT_PARAMETERS
						.toString());

		return inputParameterJso;
	}

	@Override
	public final boolean removeCamundaExt_outputParameter(
			OutputParameterJso element) {
		JsArray<BpmnElementCamundaExtensionJso> baseElements = nativeGetCamundaExtElementsByType(BpmnElementCamundaExtensionType.CAMUNDA_INPUT_OUTPUT
				.toString());
		boolean isDeleted = false;
		for (int i = 0; i < baseElements.length(); i++) {
			isDeleted = nativeRemoveCamundaExtElementFromExistingCamundaExtElementByFieldName(
					baseElements.get(i),
					(BpmnElementCamundaExtensionJso) element,
					BpmnElementCamundaExtensionField.CAMUNDA_OUTPUT_PARAMETERS
							.toString());
			if (isDeleted) {
				return true;
			}
		}

		return false;
	}

	@Override
	public final List<OutputParameterJso> getCamundaExt_outputParameters() {
		List<OutputParameterJso> list = new ArrayList<OutputParameterJso>();

		JsArray<BpmnElementCamundaExtensionJso> baseElements = nativeGetCamundaExtElementsByType(BpmnElementCamundaExtensionType.CAMUNDA_INPUT_OUTPUT
				.toString());
		for (int i = 0; i < baseElements.length(); i++) {
			JsArray<BpmnElementCamundaExtensionJso> nestedElements = BpmnElementCamundaExtensionJso
					.nativeGetPropertyListFromPropertiesByFieldName(
							baseElements.get(i),
							BpmnElementCamundaExtensionType.CAMUNDA_OUTPUT_PARAMETER
									.toString(),
							BpmnElementCamundaExtensionField.CAMUNDA_OUTPUT_PARAMETERS
									.toString());
			for (int k = 0; k < nestedElements.length(); k++) {
				list.add(nestedElements.get(k));
			}
		}

		return list;
	}

	@Override
	public final OutputParameterJso addCamundaExt_outputParameter(
			JavaScriptObject moddle) {
		BpmnElementCamundaExtensionJso baseElement = null;
		JsArray<BpmnElementCamundaExtensionJso> baseElements = nativeGetCamundaExtElementsByType(BpmnElementCamundaExtensionType.CAMUNDA_INPUT_OUTPUT
				.toString());

		if (baseElements.length() == 0) {
			baseElement = nativeAddCamundaExtElement(moddle,
					BpmnElementCamundaExtensionType.CAMUNDA_INPUT_OUTPUT
							.toString());
		} else {
			baseElement = baseElements.get(0);
		}
		OutputParameterJso inputParameterJso = nativeAddCamundaExtElementToExistingCamundaExtElementByFieldName(
				baseElement, moddle,
				BpmnElementCamundaExtensionType.CAMUNDA_OUTPUT_PARAMETER
						.toString(),
				BpmnElementCamundaExtensionField.CAMUNDA_OUTPUT_PARAMETERS
						.toString());

		return inputParameterJso;
	}
	
	/*
	 * real properties ...
	 */

	private final native JsArray<BpmnElementPropertyJso> getBpmnElementsByType(
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
	public final native boolean removeBpmnElement(
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

	private final native BpmnElementPropertyJso nativeAddBpmnElement(
			JavaScriptObject moddle, String bpmnPropertyElementType)/*-{
																	var ext = moddle.create(bpmnPropertyElementType);
																	this.flowElements = this.flowElements	|| [];
																	this.flowElements.push(ext);

																	return ext;
																	
																	}-*/;

	@Override
	public final JsArray<BpmnElementPropertyJso> getBpmnDataObjects() {
		JsArray<BpmnElementPropertyJso> extElements = getBpmnElementsByType(BpmnPropertyElementType.BPMN_DATA_OBJECT
				.toString());
		return extElements;
	}

	@Override
	public final BpmnElementPropertyJso addBpmnDataObject(
			JavaScriptObject moddle) {
		BpmnElementPropertyJso newExtElement = nativeAddBpmnElement(moddle,
				BpmnPropertyElementType.BPMN_DATA_OBJECT.toString());
		return newExtElement;
	}
}
