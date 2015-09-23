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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.elements;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.ExecutionListenerExtensionElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.TaskListenerExtensionElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.FormFieldExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.InputParameterExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.PropertyExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.flowElements.DataObjectFlowElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.rootElements.DataStoreRootElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.rootElements.ErrorRootElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.rootElements.MessageRootElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.rootElements.SignalRootElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.uiElements.ProcessElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.uiElements.StartEventElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.uiElements.TaskElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.uiElements.UserTaskElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.enums.BpmnIoChildElementType;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.enums.BpmnIoExtensionChildElementType;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.enums.BpmnIoExtensionElementArrayType;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.enums.BpmnIoExtensionElementType;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.enums.BpmnIoFlowElementType;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.enums.BpmnIoRootElementType;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoElementJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoExtensionElementJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoFlowElementJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoModdleJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoModelerJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoModelingJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoRootElementJso;

public class BpmnIoElementWrapper implements ProcessElement, StartEventElement,
		TaskElement, UserTaskElement {
	private BpmnIoElementJso element;
	private BpmnIoModelerJso modeler;
	private BpmnIoModelingJso modeling;
	private BpmnIoModdleJso moddle;

	public BpmnIoElementWrapper(BpmnIoElementJso element,
			BpmnIoModelerJso modeler) {
		super();
		this.element = element;
		this.modeler = modeler;
		this.modeling = modeler.nativeGetBpmnIoModelingJso();
		this.moddle = modeler.nativeGetBpmnIoModdleJso();
	}

	public BpmnIoElementJso getElement() {
		return element;
	}

	public BpmnIoModelerJso getModeler() {
		return modeler;
	}

	@Override
	public String getType() {
		return element.getType();
	}

	@Override
	public String getAttr_id() {
		return element.getStringAttribute("id");
	}

	@Override
	public void setAttr_id(String id) {
		modeling.updateProperty(element, "id", id);
	}

	@Override
	public String getAttr_name() {
		return element.getStringAttribute("name");
	}

	@Override
	public void setAttr_name(String name) {
		modeling.updateProperty(element, "name", name);
	}

	@Override
	public boolean getAttr_isExecutable() {
		return element.getBooleanAttribute("isExecutable");
	}

	@Override
	public void setAttr_isExecutable(boolean isExecutable) {
		modeling.updateProperty(element, "isExecutable", isExecutable);
	}

	@Override
	public String getAttr_candidateStarterGroups() {
		return element.getStringAttribute("candidateStarterGroups");
	}

	@Override
	public void setAttr_candidateStarterGroups(String candidateStarterGroups) {
		modeling.updateProperty(element, "candidateStarterGroups",
				candidateStarterGroups);
	}

	@Override
	public String getAttr_candidateStarterUsers() {
		return element.getStringAttribute("candidateStarterUsers");
	}

	@Override
	public void setAttr_candidateStarterUsers(String candidateStarterUsers) {
		modeling.updateProperty(element, "candidateStarterUsers",
				candidateStarterUsers);
	}

	@Override
	public boolean getAttr_asyncAfter() {
		return element.getBooleanAttribute("asyncAfter");
	}

	@Override
	public void setAttr_asyncAfter(boolean asyncAfter) {
		modeling.updateProperty(element, "asyncAfter", asyncAfter);
	}

	@Override
	public boolean getAttr_asyncBefore() {
		return element.getBooleanAttribute("asyncBefore");
	}

	@Override
	public void setAttr_asyncBefore(boolean asyncBefore) {
		modeling.updateProperty(element, "asyncBefore", asyncBefore);

	}

	@Override
	public boolean getAttr_exclusive() {
		return element.getBooleanAttribute("exclusive");
	}

	@Override
	public void setAttr_exclusive(boolean exclusive) {
		modeling.updateProperty(element, "exclusive", exclusive);

	}

	@Override
	public String getAttr_formHandlerClass() {
		return element.getStringAttribute("formHandlerClass");
	}

	@Override
	public void setAttr_formHandlerClass(String formHandlerClass) {
		modeling.updateProperty(element, "formHandlerClass", formHandlerClass);

	}

	@Override
	public String getAttr_formKey() {
		return element.getStringAttribute("formKey");
	}

	@Override
	public void setAttr_formKey(String formKey) {
		modeling.updateProperty(element, "formKey", formKey);

	}

	@Override
	public String getAttr_initiator() {
		return element.getStringAttribute("initiator");
	}

	@Override
	public void setAttr_initiator(String initiator) {
		modeling.updateProperty(element, "initiator", initiator);

	}

	@Override
	public String getAttr_assignee() {
		return element.getStringAttribute("assignee");
	}

	@Override
	public void setAttr_assignee(String assignee) {
		modeling.updateProperty(element, "assignee", assignee);

	}

	@Override
	public String getAttr_candidateGroups() {
		return element.getStringAttribute("candidateGroups");
	}

	@Override
	public void setAttr_candidateGroups(String candidateGroups) {
		modeling.updateProperty(element, "candidateGroups", candidateGroups);

	}

	@Override
	public String getAttr_candidateUsers() {
		return element.getStringAttribute("candidateUsers");
	}

	@Override
	public void setAttr_candidateUsers(String candidateUsers) {
		modeling.updateProperty(element, "candidateUsers", candidateUsers);

	}

	@Override
	public String getAttr_dueDate() {
		return element.getStringAttribute("dueDate");
	}

	@Override
	public void setAttr_dueDate(String dueDate) {
		modeling.updateProperty(element, "dueDate", dueDate);

	}

	@Override
	public String getAttr_followUpDate() {
		return element.getStringAttribute("followUpDate");
	}

	@Override
	public void setAttr_followUpDate(String followUpDate) {
		modeling.updateProperty(element, "followUpDate", followUpDate);

	}

	@Override
	public boolean getAttr_isForCompensation() {
		return element.getBooleanAttribute("isForCompensation");
	}

	@Override
	public void setAttr_isForCompensation(boolean isForCompensation) {
		modeling.updateProperty(element, "isForCompensation", isForCompensation);

	}

	@Override
	public String getAttr_priority() {
		return element.getStringAttribute("priority");
	}

	@Override
	public void setAttr_priority(String priority) {
		modeling.updateProperty(element, "priority", priority);

	}

	@Override
	public void setStandardLoopCharacteristics(boolean enabled) {
		if (enabled) {
			JavaScriptObject elem = moddle
					.create(BpmnIoChildElementType.BPMN_STANDARD_LOOP_CHARACTERISTICS
							.getType());
			modeling.updateProperty(element,
					BpmnIoChildElementType.BPMN_STANDARD_LOOP_CHARACTERISTICS
							.getField(), elem);
		} else {
			modeling.updateProperty(element,
					BpmnIoChildElementType.BPMN_STANDARD_LOOP_CHARACTERISTICS
							.getField(), null);
		}

	}

	@Override
	public boolean getStandardLoopCharacteristics() {
		if (element
				.getObjectAttribute(BpmnIoChildElementType.BPMN_STANDARD_LOOP_CHARACTERISTICS
						.getField()) == null) {
			return false;
		}

		return true;
	}

	/*
	 * flow-Elements
	 */

	@Override
	public DataObjectFlowElement addDataObjectFlowElement() {
		BpmnIoFlowElementJso dataPropertyJso = (BpmnIoFlowElementJso) moddle
				.create(BpmnIoFlowElementType.BPMN_DATA_OBJECT.toString());
		element.addFlowElement(dataPropertyJso);
		return new BpmnIoFlowElementWrapper(dataPropertyJso, modeler);
	}

	@Override
	public void removeDataObjectFlowElement(DataObjectFlowElement propElement) {
		element.removeFlowElement((BpmnIoFlowElementJso) propElement
				.getElement());
	}

	@Override
	public List<DataObjectFlowElement> getDataObjectsFlowElements() {
		List<DataObjectFlowElement> dataFlowElements = new ArrayList<DataObjectFlowElement>();
		JsArray<BpmnIoFlowElementJso> jsos = element
				.getFlowElements(BpmnIoFlowElementType.BPMN_DATA_OBJECT
						.toString());
		for (int i = 0; i < jsos.length(); i++) {
			dataFlowElements.add(new BpmnIoFlowElementWrapper(jsos.get(i),
					modeler));
		}
		return dataFlowElements;
	}

	/*
	 * extensionElements
	 */

	@Override
	public ExecutionListenerExtensionElement addExtensionElementExecutionListener() {
		BpmnIoExtensionElementJso executionListenerJso = (BpmnIoExtensionElementJso) moddle
				.create(BpmnIoExtensionElementType.CAMUNDA_EXECUTION_LISTENER
						.toString());
		element.addExtensionElement(executionListenerJso, moddle);
		return new BpmnIoExtensionElementWrapper(executionListenerJso, modeler);
	}

	@Override
	public void removeExtensionElementExecutionListener(
			ExecutionListenerExtensionElement extensionElement) {
		element.removeExtensionElement((BpmnIoExtensionElementJso) extensionElement
				.getElement());
	}

	@Override
	public List<ExecutionListenerExtensionElement> getExecutionListenerExtensionElements() {
		List<ExecutionListenerExtensionElement> executionListenerElements = new ArrayList<ExecutionListenerExtensionElement>();
		JsArray<BpmnIoExtensionElementJso> jsos = element
				.getExtensionElements(BpmnIoExtensionElementType.CAMUNDA_EXECUTION_LISTENER
						.toString());
		for (int i = 0; i < jsos.length(); i++) {
			executionListenerElements.add(new BpmnIoExtensionElementWrapper(
					jsos.get(i), modeler));
		}
		return executionListenerElements;
	}

	@Override
	public TaskListenerExtensionElement addExtensionElementTaskListener() {
		BpmnIoExtensionElementJso executionListenerJso = (BpmnIoExtensionElementJso) moddle
				.create(BpmnIoExtensionElementType.CAMUNDA_TASK_LISTENER
						.toString());
		element.addExtensionElement(executionListenerJso, moddle);
		return new BpmnIoExtensionElementWrapper(executionListenerJso, modeler);
	}

	@Override
	public void removeTaskListenerExtensionElement(
			TaskListenerExtensionElement extensionElement) {
		element.removeExtensionElement((BpmnIoExtensionElementJso) extensionElement
				.getElement());
	}

	@Override
	public List<TaskListenerExtensionElement> getTaskListenerExtensionElements() {
		List<TaskListenerExtensionElement> executionListenerElements = new ArrayList<TaskListenerExtensionElement>();
		JsArray<BpmnIoExtensionElementJso> jsos = element
				.getExtensionElements(BpmnIoExtensionElementType.CAMUNDA_TASK_LISTENER
						.toString());
		for (int i = 0; i < jsos.length(); i++) {
			executionListenerElements.add(new BpmnIoExtensionElementWrapper(
					jsos.get(i), modeler));
		}
		return executionListenerElements;
	}

	@Override
	public PropertyExtensionElementChild addExtensionChildElementProperty() {
		BpmnIoExtensionElementJso executionListenerJso = (BpmnIoExtensionElementJso) moddle
				.create(BpmnIoExtensionChildElementType.CAMUNDA_PROPERTY
						.getType());
		element.addExtensionElementToParent(
				BpmnIoExtensionElementArrayType.CAMUNDA_PROPERTIES.getType(),
				BpmnIoExtensionElementArrayType.CAMUNDA_PROPERTIES.getField(),
				executionListenerJso, moddle);
		return new BpmnIoExtensionElementWrapper(executionListenerJso, modeler);
	}

	@Override
	public void removeExtensionChildElementPropety(
			PropertyExtensionElementChild propertyElement) {
		element.removeExtensionElementFromParent(
				BpmnIoExtensionElementArrayType.CAMUNDA_PROPERTIES.getType(),
				BpmnIoExtensionElementArrayType.CAMUNDA_PROPERTIES.getField(),
				(BpmnIoExtensionElementJso) propertyElement.getElement());
	}

	@Override
	public List<PropertyExtensionElementChild> getExtensionChildElementsPropety() {
		List<PropertyExtensionElementChild> executionListenerElements = new ArrayList<PropertyExtensionElementChild>();
		JsArray<BpmnIoExtensionElementJso> childs = element
				.getExtensionElementFromParent(
						BpmnIoExtensionElementArrayType.CAMUNDA_PROPERTIES
								.getType(),
						BpmnIoExtensionElementArrayType.CAMUNDA_PROPERTIES
								.getField(),
						BpmnIoExtensionChildElementType.CAMUNDA_PROPERTY
								.getType());

		for (int i = 0; i < childs.length(); i++) {
			executionListenerElements.add(new BpmnIoExtensionElementWrapper(
					childs.get(i), modeler));
		}

		return executionListenerElements;
	}

	@Override
	public List<FormFieldExtensionElementChild> getExtensionChildElementsFormField() {
		List<FormFieldExtensionElementChild> executionListenerElements = new ArrayList<FormFieldExtensionElementChild>();
		JsArray<BpmnIoExtensionElementJso> childs = element
				.getExtensionElementFromParent(
						BpmnIoExtensionElementArrayType.CAMUNDA_FORMDATA
								.getType(),
						BpmnIoExtensionElementArrayType.CAMUNDA_FORMDATA
								.getField(),
						BpmnIoExtensionChildElementType.CAMUNDA_FORMFIELD
								.getType());

		for (int i = 0; i < childs.length(); i++) {
			executionListenerElements.add(new BpmnIoExtensionElementWrapper(
					childs.get(i), modeler));
		}

		return executionListenerElements;
	}

	@Override
	public FormFieldExtensionElementChild addExtensionChildElementFormField() {
		BpmnIoExtensionElementJso executionListenerJso = (BpmnIoExtensionElementJso) moddle
				.create(BpmnIoExtensionChildElementType.CAMUNDA_FORMFIELD
						.getType());
		element.addExtensionElementToParent(
				BpmnIoExtensionElementArrayType.CAMUNDA_FORMDATA.getType(),
				BpmnIoExtensionElementArrayType.CAMUNDA_FORMDATA.getField(),
				executionListenerJso, moddle);
		return new BpmnIoExtensionElementWrapper(executionListenerJso, modeler);
	}

	@Override
	public void removeExtensionChildElementFormField(
			FormFieldExtensionElementChild formFieldChild) {

		element.removeExtensionElementFromParent(
				BpmnIoExtensionElementArrayType.CAMUNDA_FORMDATA.getType(),
				BpmnIoExtensionElementArrayType.CAMUNDA_FORMDATA.getField(),
				(BpmnIoExtensionElementJso) formFieldChild.getElement());
	}

	@Override
	public void removeExtensionChildElementInputParameter(
			InputParameterExtensionElementChild inputParameterElement) {
		element.removeExtensionElementFromParent(
				BpmnIoExtensionElementArrayType.CAMUNDA_INPUT.getType(),
				BpmnIoExtensionElementArrayType.CAMUNDA_INPUT.getField(),
				(BpmnIoExtensionElementJso) inputParameterElement.getElement());
	}

	@Override
	public List<InputParameterExtensionElementChild> getExtensionChildElementsInputParameters() {
		List<InputParameterExtensionElementChild> executionListenerElements = new ArrayList<InputParameterExtensionElementChild>();
		JsArray<BpmnIoExtensionElementJso> childs = element
				.getExtensionElementFromParent(
						BpmnIoExtensionElementArrayType.CAMUNDA_INPUT.getType(),
						BpmnIoExtensionElementArrayType.CAMUNDA_INPUT
								.getField(),
						BpmnIoExtensionChildElementType.CAMUNDA_INPUT_PARAMETER
								.getType());

		for (int i = 0; i < childs.length(); i++) {
			executionListenerElements.add(new BpmnIoExtensionElementWrapper(
					childs.get(i), modeler));
		}

		return executionListenerElements;
	}

	@Override
	public InputParameterExtensionElementChild addExtensionChildElementInputParameter() {
		BpmnIoExtensionElementJso executionListenerJso = (BpmnIoExtensionElementJso) moddle
				.create(BpmnIoExtensionChildElementType.CAMUNDA_INPUT_PARAMETER
						.getType());
		element.addExtensionElementToParent(
				BpmnIoExtensionElementArrayType.CAMUNDA_INPUT.getType(),
				BpmnIoExtensionElementArrayType.CAMUNDA_INPUT.getField(),
				executionListenerJso, moddle);
		return new BpmnIoExtensionElementWrapper(executionListenerJso, modeler);
	}

	/*
	 * rootElements
	 */

	@Override
	public DataStoreRootElement addRootElementDataStore() {
		BpmnIoRootElementJso dataStoreElement = (BpmnIoRootElementJso) moddle
				.create(BpmnIoRootElementType.BPMN_DATASTORE.toString());
		modeler.addRootElement(dataStoreElement);
		return new BpmnIoRootElementWrapper(dataStoreElement, modeler);
	}

	@Override
	public void removeRootElementDataStore(DataStoreRootElement dataStoreElement) {
		modeler.removeRootElement((BpmnIoRootElementJso) dataStoreElement
				.getElement());
	}

	@Override
	public List<DataStoreRootElement> getRootElementsDataStore() {
		List<DataStoreRootElement> rootElements = new ArrayList<DataStoreRootElement>();
		JsArray<BpmnIoRootElementJso> rootElementsJso = modeler
				.getRootElements(BpmnIoRootElementType.BPMN_DATASTORE
						.toString());

		for (int i = 0; i < rootElementsJso.length(); i++) {
			rootElements.add(new BpmnIoRootElementWrapper(rootElementsJso
					.get(i), modeler));
		}
		return rootElements;
	}

	@Override
	public ErrorRootElement addRootElementError() {
		BpmnIoRootElementJso dataStoreElement = (BpmnIoRootElementJso) moddle
				.create(BpmnIoRootElementType.BPMN_ERROR.toString());
		modeler.addRootElement(dataStoreElement);
		return new BpmnIoRootElementWrapper(dataStoreElement, modeler);
	}

	@Override
	public void removeRootElementError(ErrorRootElement errorElement) {
		modeler.removeRootElement((BpmnIoRootElementJso) errorElement
				.getElement());
	}

	@Override
	public List<ErrorRootElement> getRootElementsError() {
		List<ErrorRootElement> rootElements = new ArrayList<ErrorRootElement>();
		JsArray<BpmnIoRootElementJso> rootElementsJso = modeler
				.getRootElements(BpmnIoRootElementType.BPMN_ERROR.toString());

		for (int i = 0; i < rootElementsJso.length(); i++) {
			rootElements.add(new BpmnIoRootElementWrapper(rootElementsJso
					.get(i), modeler));
		}
		return rootElements;
	}

	@Override
	public MessageRootElement addRootElementMessage() {
		BpmnIoRootElementJso dataStoreElement = (BpmnIoRootElementJso) moddle
				.create(BpmnIoRootElementType.BPMN_MESSAGE.toString());
		modeler.addRootElement(dataStoreElement);
		return new BpmnIoRootElementWrapper(dataStoreElement, modeler);
	}

	@Override
	public void removeRootElementMessage(MessageRootElement messageElement) {
		modeler.removeRootElement((BpmnIoRootElementJso) messageElement
				.getElement());

	}

	@Override
	public List<MessageRootElement> getRootElementsMessage() {
		List<MessageRootElement> rootElements = new ArrayList<MessageRootElement>();
		JsArray<BpmnIoRootElementJso> rootElementsJso = modeler
				.getRootElements(BpmnIoRootElementType.BPMN_MESSAGE.toString());

		for (int i = 0; i < rootElementsJso.length(); i++) {
			rootElements.add(new BpmnIoRootElementWrapper(rootElementsJso
					.get(i), modeler));
		}
		return rootElements;
	}

	@Override
	public SignalRootElement addRootElementSignal() {
		BpmnIoRootElementJso dataStoreElement = (BpmnIoRootElementJso) moddle
				.create(BpmnIoRootElementType.BPMN_SIGNAL.toString());
		modeler.addRootElement(dataStoreElement);
		return new BpmnIoRootElementWrapper(dataStoreElement, modeler);
	}

	@Override
	public void removeRootElementSignal(SignalRootElement signalElement) {
		modeler.removeRootElement((BpmnIoRootElementJso) signalElement
				.getElement());

	}

	@Override
	public List<SignalRootElement> getRootElementsSignal() {
		List<SignalRootElement> rootElements = new ArrayList<SignalRootElement>();
		JsArray<BpmnIoRootElementJso> rootElementsJso = modeler
				.getRootElements(BpmnIoRootElementType.BPMN_SIGNAL.toString());

		for (int i = 0; i < rootElementsJso.length(); i++) {
			rootElements.add(new BpmnIoRootElementWrapper(rootElementsJso
					.get(i), modeler));
		}
		return rootElements;
	}
}
