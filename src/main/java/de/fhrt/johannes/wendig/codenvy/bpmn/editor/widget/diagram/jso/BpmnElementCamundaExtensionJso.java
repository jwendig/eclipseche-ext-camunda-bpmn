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

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.ExecutionListenerJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.FormFieldJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.PropertyJso;

public class BpmnElementCamundaExtensionJso extends AbstractBpmnElementJso
		implements ExecutionListenerJso, PropertyJso, FormFieldJso {

	public enum BpmnElementCamundaExtensionType {
		CAMUNDA_EXECUTION_LISTENER("camunda:ExecutionListener"), CAMUNDA_PROPERTIES(
				"camunda:Properties"), CAMUNDA_PROPERTY("camunda:Property"), CAMUNDA_FORMFIELD("camunda:FormField"), CAMUNDA_FORMDATA("camunda:FormData");

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

}
