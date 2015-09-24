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

import com.google.gwt.core.client.JsArray;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.ExecutionListenerExtensionElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.FailedJobRetryTimeCycleExtensionElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.TaskListenerExtensionElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.ConstraintExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.FormFieldExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.InputOutputParameterExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.InputParameterExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.ListValueExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.MapEntryExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.OutputParameterExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.PropertyExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.ScriptExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.enums.BpmnIoExtensionChildElementType;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.enums.BpmnIoExtensionElementArrayType;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoExtensionElementJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoModdleJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoModelerJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoModelingJso;

public class BpmnIoExtensionElementWrapper implements
		ExecutionListenerExtensionElement, TaskListenerExtensionElement,
		FormFieldExtensionElementChild, ScriptExtensionElementChild,
		PropertyExtensionElementChild, ConstraintExtensionElementChild,
		InputParameterExtensionElementChild,
		OutputParameterExtensionElementChild,
		InputOutputParameterExtensionElementChild,
		ListValueExtensionElementChild, MapEntryExtensionElementChild,
		FailedJobRetryTimeCycleExtensionElement {
	private BpmnIoExtensionElementJso element;
	private BpmnIoModelerJso modeler;
	private BpmnIoModelingJso modeling;
	private BpmnIoModdleJso moddle;

	public BpmnIoExtensionElementWrapper(BpmnIoExtensionElementJso element,
			BpmnIoModelerJso modeler) {
		super();
		this.element = element;
		this.modeler = modeler;
		this.modeling = modeler.nativeGetBpmnIoModelingJso();
		this.moddle = modeler.nativeGetBpmnIoModdleJso();
	}

	public BpmnIoExtensionElementJso getElement() {
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
		element.setAttribute("id", id);
	}

	@Override
	public String getAttr_name() {
		return element.getStringAttribute("name");
	}

	@Override
	public void setAttr_name(String name) {
		element.setAttribute("name", name);
	}

	@Override
	public String getAttr_class() {
		return element.getStringAttribute("class");
	}

	@Override
	public void setAttr_class(String clazz) {
		element.setAttribute("class", clazz);
	}

	@Override
	public String getAttr_delegateExpression() {
		return element.getStringAttribute("delegateExpression");
	}

	@Override
	public void setAttr_delegateExpression(String delegateExpression) {
		element.setAttribute("delegateExpression", delegateExpression);
	}

	@Override
	public String getAttr_expression() {
		return element.getStringAttribute("expression");
	}

	@Override
	public void setAttr_expression(String expression) {
		element.setAttribute("expression", expression);
	}

	@Override
	public String getAttr_event() {
		return element.getStringAttribute("event");
	}

	@Override
	public void setAttr_event(String event) {
		element.setAttribute("event", event);
	}

	@Override
	public String getAttr_label() {
		return element.getStringAttribute("label");
	}

	@Override
	public void setAttr_label(String label) {
		element.setAttribute("label", label);

	}

	@Override
	public String getAttr_type() {
		return element.getStringAttribute("type");
	}

	@Override
	public void setAttr_type(String type) {
		element.setAttribute("type", type);

	}

	@Override
	public String getAttr_defaultValue() {
		return element.getStringAttribute("defaultValue");
	}

	@Override
	public void setAttr_defaultValue(String defaultValue) {
		element.setAttribute("defaultValue", defaultValue);

	}

	@Override
	public String getAttr_value() {
		return element.getStringAttribute("value");
	}

	@Override
	public void setAttr_value(String value) {
		element.setAttribute("value", value);

	}

	@Override
	public String getAttr_scriptFormat() {
		return element.getStringAttribute("scriptFormat");
	}

	@Override
	public void setAttr_scriptFormat(String scriptFormat) {
		element.setAttribute("scriptFormat", scriptFormat);
	}

	@Override
	public String getAttr_resource() {
		return element.getStringAttribute("resource");
	}

	@Override
	public void setAttr_resource(String resource) {
		element.setAttribute("resource", resource);
	}

	@Override
	public String getAttr_script() {
		return element.getStringAttribute("script");
	}

	@Override
	public void setAttr_script(String script) {
		element.setAttribute("script", script);
	}

	@Override
	public String getAttr_config() {
		return element.getStringAttribute("config");
	}

	@Override
	public void setAttr_config(String config) {
		element.setAttribute("config", config);
	}

	@Override
	public String getAttr_key() {
		return element.getStringAttribute("key");
	}

	@Override
	public void setAttr_key(String key) {
		element.setAttribute("key", key);
	}

	@Override
	public String getAttr_body() {
		return element.getStringAttribute("body");
	}

	@Override
	public void setAttr_body(String body) {
		element.setAttribute("body", body);
	}

	/*
	 * child elements
	 */

	@Override
	public ScriptExtensionElementChild getScriptChild() {
		BpmnIoExtensionElementJso scriptChild = element
				.getChildElement(BpmnIoExtensionChildElementType.CAMUNDA_SCRIPT
						.getKey());
		if (null == scriptChild) {
			return null;
		}

		return new BpmnIoExtensionElementWrapper(scriptChild, modeler);
	}

	@Override
	public ScriptExtensionElementChild setScriptChild() {
		BpmnIoExtensionElementJso scriptChild = (BpmnIoExtensionElementJso) moddle
				.create(BpmnIoExtensionChildElementType.CAMUNDA_SCRIPT
						.getType());
		element.setChildElement(
				BpmnIoExtensionChildElementType.CAMUNDA_SCRIPT.getKey(),
				scriptChild);
		return new BpmnIoExtensionElementWrapper(scriptChild, modeler);
	}

	@Override
	public void removeScriptChild() {
		element.clearChildElement(BpmnIoExtensionChildElementType.CAMUNDA_SCRIPT
				.getKey());
	}

	@Override
	public List<PropertyExtensionElementChild> getChildsProperties() {
		List<PropertyExtensionElementChild> executionListenerElements = new ArrayList<PropertyExtensionElementChild>();
		JsArray<BpmnIoExtensionElementJso> array = element
				.getChildElementsFromParent(
						BpmnIoExtensionChildElementType.CAMUNDA_PROPERTY
								.getKey(),
						BpmnIoExtensionChildElementType.CAMUNDA_PROPERTY
								.getType());
		for (int i = 0; i < array.length(); i++) {
			executionListenerElements.add(new BpmnIoExtensionElementWrapper(
					array.get(i), modeler));
		}

		return executionListenerElements;
	}

	@Override
	public PropertyExtensionElementChild addChildProperty() {
		BpmnIoExtensionElementJso propertyJso = (BpmnIoExtensionElementJso) moddle
				.create(BpmnIoExtensionChildElementType.CAMUNDA_PROPERTY
						.getType());
		element.addChildElementToParent(
				BpmnIoExtensionElementArrayType.CAMUNDA_PROPERTIES.getType(),
				BpmnIoExtensionChildElementType.CAMUNDA_PROPERTY.getKey(),
				propertyJso, moddle);
		return new BpmnIoExtensionElementWrapper(propertyJso, modeler);
	}

	@Override
	public void removeChildProperty(
			PropertyExtensionElementChild extensionElement) {
		element.removeChildElementFromParent(
				BpmnIoExtensionChildElementType.CAMUNDA_PROPERTY.getKey(),
				(BpmnIoExtensionElementJso) extensionElement.getElement());
	}

	@Override
	public List<ConstraintExtensionElementChild> getChildsContraints() {
		List<ConstraintExtensionElementChild> executionListenerElements = new ArrayList<ConstraintExtensionElementChild>();
		JsArray<BpmnIoExtensionElementJso> array = element
				.getChildElementsFromParent(
						BpmnIoExtensionChildElementType.CAMUNDA_CONSTRAINT
								.getKey(),
						BpmnIoExtensionChildElementType.CAMUNDA_CONSTRAINT
								.getType());
		for (int i = 0; i < array.length(); i++) {
			executionListenerElements.add(new BpmnIoExtensionElementWrapper(
					array.get(i), modeler));
		}

		return executionListenerElements;
	}

	@Override
	public ConstraintExtensionElementChild addChildContraint() {
		BpmnIoExtensionElementJso propertyJso = (BpmnIoExtensionElementJso) moddle
				.create(BpmnIoExtensionChildElementType.CAMUNDA_CONSTRAINT
						.getType());
		element.addChildElementToParent(
				BpmnIoExtensionElementArrayType.CAMUNDA_VALIDATION.getType(),
				BpmnIoExtensionChildElementType.CAMUNDA_CONSTRAINT.getKey(),
				propertyJso, moddle);
		return new BpmnIoExtensionElementWrapper(propertyJso, modeler);
	}

	@Override
	public void removeChildConstraint(
			ConstraintExtensionElementChild constraintExtensionElement) {
		element.removeChildElementFromParent(
				BpmnIoExtensionChildElementType.CAMUNDA_CONSTRAINT.getKey(),
				(BpmnIoExtensionElementJso) constraintExtensionElement
						.getElement());
	}

	@Override
	public List<ListValueExtensionElementChild> getListValueChilds() {
		List<ListValueExtensionElementChild> executionListenerElements = new ArrayList<ListValueExtensionElementChild>();
		JsArray<BpmnIoExtensionElementJso> array = element
				.getChildElementsFromParent(
						BpmnIoExtensionChildElementType.CAMUNDA_LIST_VALUE
								.getKey(),
						BpmnIoExtensionChildElementType.CAMUNDA_LIST_VALUE
								.getType());
		for (int i = 0; i < array.length(); i++) {
			executionListenerElements.add(new BpmnIoExtensionElementWrapper(
					array.get(i), modeler));
		}

		return executionListenerElements;
	}

	@Override
	public ListValueExtensionElementChild addListValueChild() {
		BpmnIoExtensionElementJso propertyJso = (BpmnIoExtensionElementJso) moddle
				.create(BpmnIoExtensionChildElementType.CAMUNDA_LIST_VALUE
						.getType());
		element.addChildElementToParent(
				BpmnIoExtensionElementArrayType.CAMUNDA_LIST.getType(),
				BpmnIoExtensionChildElementType.CAMUNDA_LIST_VALUE.getKey(),
				propertyJso, moddle);
		return new BpmnIoExtensionElementWrapper(propertyJso, modeler);
	}

	@Override
	public void removeListValueChild(
			ListValueExtensionElementChild listValueElement) {
		element.removeChildElementFromParent(
				BpmnIoExtensionChildElementType.CAMUNDA_LIST_VALUE.getKey(),
				(BpmnIoExtensionElementJso) listValueElement.getElement());
	}

	@Override
	public List<MapEntryExtensionElementChild> getMapEntryChilds() {
		List<MapEntryExtensionElementChild> executionListenerElements = new ArrayList<MapEntryExtensionElementChild>();
		JsArray<BpmnIoExtensionElementJso> array = element
				.getChildElementsFromParent(
						BpmnIoExtensionChildElementType.CAMUNDA_MAP_ENTRY
								.getKey(),
						BpmnIoExtensionChildElementType.CAMUNDA_MAP_ENTRY
								.getType());
		for (int i = 0; i < array.length(); i++) {
			executionListenerElements.add(new BpmnIoExtensionElementWrapper(
					array.get(i), modeler));
		}

		return executionListenerElements;
	}

	@Override
	public MapEntryExtensionElementChild addMapEntryChild() {
		BpmnIoExtensionElementJso propertyJso = (BpmnIoExtensionElementJso) moddle
				.create(BpmnIoExtensionChildElementType.CAMUNDA_MAP_ENTRY
						.getType());
		element.addChildElementToParent(
				BpmnIoExtensionElementArrayType.CAMUNDA_MAP.getType(),
				BpmnIoExtensionChildElementType.CAMUNDA_MAP_ENTRY.getKey(),
				propertyJso, moddle);
		return new BpmnIoExtensionElementWrapper(propertyJso, modeler);
	}

	@Override
	public void removeMapEntryChild(
			MapEntryExtensionElementChild mapEntryElement) {
		element.removeChildElementFromParent(
				BpmnIoExtensionChildElementType.CAMUNDA_MAP_ENTRY.getKey(),
				(BpmnIoExtensionElementJso) mapEntryElement.getElement());

	}
}
