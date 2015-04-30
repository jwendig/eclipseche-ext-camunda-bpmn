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
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.InputParameterJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.TaskListenerJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.childs.ConstraintJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.childs.ListJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.childs.ListValueJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.childs.MapEntryJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.childs.MapJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.childs.PropertyJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.childs.ScriptJso;

public class BpmnElementCamundaExtensionJso extends AbstractBpmnElementJso
		implements ExecutionListenerJso, PropertyJso, FormFieldJso,
		ConstraintJso, TaskListenerJso, ScriptJso, InputParameterJso, MapJso,
		ListJso {

	public enum BpmnElementCamundaExtensionType {
		CAMUNDA_EXECUTION_LISTENER("camunda:ExecutionListener"), CAMUNDA_PROPERTIES(
				"camunda:Properties"), CAMUNDA_PROPERTY("camunda:Property"), CAMUNDA_FORMFIELD(
				"camunda:FormField"), CAMUNDA_FORMDATA("camunda:FormData"), CAMUNDA_CONSTRAINT(
				"camunda:Constraint"), CAMUNDA_TASK_LISTENER(
				"camunda:TaskListener"), CAMUNDA_SCRIPT("camunda:Script"), CAMUNDA_INPUT_OUTPUT(
				"camunda:InputOutput"), CAMUNDA_INPUT_PARAMETER(
				"camunda:InputParameter"), CAMUNDA_MAP("camunda:Map"), CAMUNDA_LIST(
				"camunda:List");

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

	public enum BpmnElementCamundaExtensionField {
		CAMUNDA_PROPERTIES("properties"), CAMUNDA_VALIDATIONS("validations"), CAMUNDA_SCRIPT(
				"script"), CAMUNDA_INPUT_PARAMETERS("inputParameters"), CAMUNDA_MAP(
				"map"), CAMUNDA_LIST("list");

		private final String arrayName;

		private BpmnElementCamundaExtensionField(final String arrayName) {
			this.arrayName = arrayName;
		}

		@Override
		public String toString() {
			return arrayName;
		}

		public static BpmnElementCamundaExtensionField findByBpmnIoTypeDefinition(
				String properties) {
			for (BpmnElementCamundaExtensionField t : values()) {
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

	public static final native JsArray<BpmnElementCamundaExtensionJso> nativeGetPropertyListFromPropertiesByArray(
			BpmnElementCamundaExtensionJso element, String type,
			String arrayName)/*-{
								console.log("js-native: nativeGetPropertyListFromProperties");
								if (!element[arrayName] || element[arrayName] == 'undefined') {
								console
								.log("js-native: nativeGetPropertyListFromProperties: no elements");
								return [];
								}

								return element[arrayName].filter(function(e) {
								return e.$instanceOf(type);
								});
								}-*/;

	private final native BpmnElementCamundaExtensionJso nativeAddCamundaExtElementAsChild(
			JavaScriptObject moddle, String bpmnExtensionElementType,
			String field)/*-{
								console.log("js-native: nativeAddCamundaExtElementAsChild");
								
								var ext = moddle.create(bpmnExtensionElementType);
								this[field] = ext;
								return ext;
								
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

	private final native void nativeRemoveChildElement(String field)/*-{
																			console.log("js-native: nativeRemoveChildElement");
																			this[field] = undefined;
																			}-*/;

	private final native boolean nativeRemoveChildElementFromArray(
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
	public final native String getAttr_config() /*-{
												return this.config;
												}-*/;

	@Override
	public final native void setAttr_config(String config) /*-{
															this.config = config;
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

	@Override
	public final native String getAttr_scriptFormat() /*-{
														return this.scriptFormat;
														}-*/;

	@Override
	public final native void setAttr_scriptFormat(String scriptFormat)/*-{
																		this.scriptFormat = scriptFormat;
																		}-*/;

	@Override
	public final native String getAttr_script() /*-{
												return this.script;
												}-*/;

	@Override
	public final native void setAttr_script(String script) /*-{
															this.script = script;
															}-*/;

	@Override
	public final List<PropertyJso> getProperties() {
		Log.info(BpmnElementCamundaExtensionJso.class,
				"getProperties: current element=" + getType());
		List<PropertyJso> list = new ArrayList<PropertyJso>();
		JsArray<BpmnElementCamundaExtensionJso> baseElements2 = nativeGetElementsByTypeFromArray(
				BpmnElementCamundaExtensionField.CAMUNDA_PROPERTIES.toString(),
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
				BpmnElementCamundaExtensionField.CAMUNDA_PROPERTIES.toString());
	}

	@Override
	public final boolean removeProperty(PropertyJso propertyJso) {
		return nativeRemoveChildElementFromArray(
				(BpmnElementCamundaExtensionJso) propertyJso,
				BpmnElementCamundaExtensionField.CAMUNDA_PROPERTIES.toString());

	}

	@Override
	public final List<ConstraintJso> getContraints() {
		Log.info(BpmnElementCamundaExtensionJso.class,
				"getContraints: current element=" + getType());
		List<ConstraintJso> list = new ArrayList<ConstraintJso>();
		JsArray<BpmnElementCamundaExtensionJso> baseElements2 = nativeGetElementsByTypeFromArray(
				BpmnElementCamundaExtensionField.CAMUNDA_VALIDATIONS.toString(),
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
				BpmnElementCamundaExtensionField.CAMUNDA_VALIDATIONS.toString());
	}

	@Override
	public final boolean removeConstraint(ConstraintJso propertyJso) {
		return nativeRemoveChildElementFromArray(
				(BpmnElementCamundaExtensionJso) propertyJso,
				BpmnElementCamundaExtensionField.CAMUNDA_VALIDATIONS.toString());
	}

	@Override
	public final ScriptJso addChild_script(JavaScriptObject moddle) {
		return nativeAddCamundaExtElementAsChild(moddle,
				BpmnElementCamundaExtensionType.CAMUNDA_SCRIPT.toString(),
				BpmnElementCamundaExtensionField.CAMUNDA_SCRIPT.toString());
	}

	@Override
	public final boolean removeChild_script() {
		nativeRemoveChildElement(BpmnElementCamundaExtensionField.CAMUNDA_SCRIPT
				.toString());
		return true;

	}

	@Override
	public final native ScriptJso getChild_script() /*-{
													return this.script;
													}-*/;

	@Override
	public final native MapJso getChild_map() /*-{
												return this.map;
												}-*/;

	@Override
	public final MapJso addChild_map(JavaScriptObject moddle) {
		return nativeAddCamundaExtElementAsChild(moddle,
				BpmnElementCamundaExtensionType.CAMUNDA_MAP.toString(),
				BpmnElementCamundaExtensionField.CAMUNDA_MAP.toString());
	}

	@Override
	public final boolean removeChild_map() {
		nativeRemoveChildElement(BpmnElementCamundaExtensionField.CAMUNDA_MAP
				.toString());
		return true;
	}

	@Override
	public final native ListJso getChild_list() /*-{
												return this.list;
												}-*/;

	@Override
	public final ListJso addChild_list(JavaScriptObject moddle) {
		return nativeAddCamundaExtElementAsChild(moddle,
				BpmnElementCamundaExtensionType.CAMUNDA_LIST.toString(),
				BpmnElementCamundaExtensionField.CAMUNDA_LIST.toString());
	}

	@Override
	public final boolean removeChild_list() {
		nativeRemoveChildElement(BpmnElementCamundaExtensionField.CAMUNDA_LIST
				.toString());
		return true;
	}

	@Override
	public final List<ListValueJso> getListValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final ListValueJso addListValue(JavaScriptObject moddle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final boolean removeListValue(ListValueJso propertyJso) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public final List<MapEntryJso> getMapEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final MapEntryJso addMapEntry(JavaScriptObject moddle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final boolean removeMapEntry(MapEntryJso propertyJso) {
		// TODO Auto-generated method stub
		return false;
	}
}
