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

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.ExecutionListenerJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.FormFieldJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.PropertyJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.ConstraintJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.TaskListenerJso;

public class BpmnElementCamundaExtensionJso extends AbstractBpmnElementJso
		implements ExecutionListenerJso, PropertyJso, FormFieldJso,
		ConstraintJso, TaskListenerJso {

	public enum BpmnElementCamundaExtensionType {
		CAMUNDA_EXECUTION_LISTENER("camunda:ExecutionListener"), CAMUNDA_PROPERTIES(
				"camunda:Properties"), CAMUNDA_PROPERTY("camunda:Property"), CAMUNDA_FORMFIELD(
				"camunda:FormField"), CAMUNDA_FORMDATA("camunda:FormData"), CAMUNDA_CONSTRAINT(
				"camunda:Constraint"), CAMUNDA_TASK_LISTENER("camunda:TaskListener");

		private final String bpmnIoTypeDefinition;

		private BpmnElementCamundaExtensionType(
				final String bpmnIoTypeDefinition) {
			this.bpmnIoTypeDefinition = bpmnIoTypeDefinition;
		}

		@Override
		public String toString() {
			return bpmnIoTypeDefinition;
		}

		public static BpmnElementCamundaExtensionType findByBpmnIoTypeDefinition(
				String bpmnIoTypeDefinition) {
			for (BpmnElementCamundaExtensionType t : values()) {
				if (t.bpmnIoTypeDefinition.equals(bpmnIoTypeDefinition)) {
					return t;
				}
			}
			return null;
		}
	}

	public enum BpmnElementCamundaExtensionArray {
		CAMUNDA_PROPERTIES("properties"), CAMUNDA_VALIDATIONS("validations");

		private final String arrayName;

		private BpmnElementCamundaExtensionArray(final String arrayName) {
			this.arrayName = arrayName;
		}

		@Override
		public String toString() {
			return arrayName;
		}

		public static BpmnElementCamundaExtensionArray findByBpmnIoTypeDefinition(
				String properties) {
			for (BpmnElementCamundaExtensionArray t : values()) {
				if (t.arrayName.equals(properties)) {
					return t;
				}
			}
			return null;
		}
	}

	protected BpmnElementCamundaExtensionJso() {
	}

	public static final native JsArray<BpmnElementCamundaExtensionJso> nativeGetPropertyListFromProperties(
			BpmnElementCamundaExtensionJso element, String type)/*-{
																console.log("js-native: nativeGetPropertyListFromProperties");
																			if (!element.values || element.values == 'undefined') {
																			console
																			.log("js-native: nativeGetPropertyListFromProperties: no elements");
																			return [];
																			}

																			return element.values.filter(function(e) {
																			return e.$instanceOf(type);
																			});
																}-*/;

	@Override
	public final native String getAttr_event()/*-{
												return this.event;
												}-*/;

	@Override
	public final native void setAttr_event(String event)/*-{
														this.event = event;
														}-*/;

	@Override
	public final native String getAttr_value()/*-{
												return this.value;
												}-*/;

	@Override
	public final native void setAttr_value(String value)/*-{
														this.value = value;
														}-*/;

	@Override
	public final native String getAttr_label() /*-{
												return this.label;
												}-*/;

	@Override
	public final native void setAttr_label(String label) /*-{
															this.label = label;
															}-*/;

	@Override
	public final native String getAttr_defaultValue() /*-{
														return this.defaultValue;
														}-*/;

	@Override
	public final native void setAttr_defaultValue(String defaultValue)/*-{
																		this.defaultValue = defaultValue;
																		}-*/;

	private final native BpmnElementCamundaExtensionJso nativeAddCamundaExtElementToArray(
			JavaScriptObject moddle, String bpmnExtensionElementType,
			String arrayName)/*-{
								console.log("js-native: nativeAddCamundaExtElement");
								
								var ext = moddle.create(bpmnExtensionElementType);
								this[arrayName] = this[arrayName] || moddle.create('camunda:Properties');
								this[arrayName].get('values').push(ext);
								return ext;
								
								}-*/;

	private final native JsArray<BpmnElementCamundaExtensionJso> nativeGetElementsByTypeFromArray(
			String arrayName, String bpmnExtensionElementType) /*-{
																console.log("js-native: nativeGetCamundaExtElementsByType");
																if (!this[arrayName] || this[arrayName].values == 'undefined') {
																console
																.log("js-native: nativeGetCamundaExtElementsByType: no elements in array: " + arrayName);
																return [];
																}
																console.log("js-native: nativeGetCamundaExtElementsByType: size of array (" + arrayName + ")  = " + this[arrayName].values.length);

																return this[arrayName].values.filter(function(e) {
																return e.$instanceOf(bpmnExtensionElementType);
																});
																}-*/;

	private final native boolean nativeRemoveElementFromArray(
			BpmnElementCamundaExtensionJso elemToRemove, String arrayName)/*-{
																			console.log("js-native: nativeRemoveCamundaExtElement");
																			var elementIndex = this[arrayName].values.indexOf(elemToRemove);
																			if (elementIndex > -1) {
																			console.log("js-native: nativeRemoveCamundaExtElement: elemToRemove found at index:" + elementIndex);
																			this[arrayName].values.splice(elementIndex, 1);
																			
																			return true;
																			}else{
																			console.log("js-native: nativeRemoveCamundaExtElement: elemToRemove not found");
																			return false;
																			}
																			}-*/;

	@Override
	public final List<PropertyJso> getProperties() {
		Log.info(BpmnElementCamundaExtensionJso.class,
				"getProperties: current element=" + getType());
		List<PropertyJso> list = new ArrayList<PropertyJso>();
		JsArray<BpmnElementCamundaExtensionJso> baseElements2 = nativeGetElementsByTypeFromArray(
				BpmnElementCamundaExtensionArray.CAMUNDA_PROPERTIES.toString(),
				BpmnElementCamundaExtensionType.CAMUNDA_PROPERTY.toString());
		for (int i = 0; i < baseElements2.length(); i++) {
			list.add(baseElements2.get(i));
		}

		return list;
	}

	@Override
	public final PropertyJso addProperty(JavaScriptObject moddle) {
		Log.info(BpmnElementCamundaExtensionJso.class, "addProperty");

		return nativeAddCamundaExtElementToArray(moddle,
				BpmnElementCamundaExtensionType.CAMUNDA_PROPERTY.toString(),
				BpmnElementCamundaExtensionArray.CAMUNDA_PROPERTIES.toString());
	}

	@Override
	public final boolean removeProperty(PropertyJso propertyJso) {
		return nativeRemoveElementFromArray(
				(BpmnElementCamundaExtensionJso) propertyJso,
				BpmnElementCamundaExtensionArray.CAMUNDA_PROPERTIES.toString());

	}

	@Override
	public final native String getAttr_config() /*-{
												return this.config;
												}-*/;

	@Override
	public final native void setAttr_config(String config) /*-{
															this.config = config;
															}-*/;

	@Override
	public final List<ConstraintJso> getContraints() {
		Log.info(BpmnElementCamundaExtensionJso.class,
				"getContraints: current element=" + getType());
		List<ConstraintJso> list = new ArrayList<ConstraintJso>();
		JsArray<BpmnElementCamundaExtensionJso> baseElements2 = nativeGetElementsByTypeFromArray(
				BpmnElementCamundaExtensionArray.CAMUNDA_VALIDATIONS.toString(),
				BpmnElementCamundaExtensionType.CAMUNDA_CONSTRAINT.toString());
		for (int i = 0; i < baseElements2.length(); i++) {
			list.add(baseElements2.get(i));
		}

		return list;
	}

	@Override
	public final ConstraintJso addConstraint(JavaScriptObject moddle) {
		Log.info(BpmnElementCamundaExtensionJso.class, "addConstraint");

		return nativeAddCamundaExtElementToArray(moddle,
				BpmnElementCamundaExtensionType.CAMUNDA_CONSTRAINT.toString(),
				BpmnElementCamundaExtensionArray.CAMUNDA_VALIDATIONS.toString());
	}

	@Override
	public final boolean removeConstraint(ConstraintJso propertyJso) {
		return nativeRemoveElementFromArray(
				(BpmnElementCamundaExtensionJso) propertyJso,
				BpmnElementCamundaExtensionArray.CAMUNDA_VALIDATIONS.toString());
	}

}
