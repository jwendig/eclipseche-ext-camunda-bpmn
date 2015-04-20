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
package de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements;

import com.google.gwt.core.client.JsArray;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementExtensionJso.BpmnExtensionElementType;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementPropertyJso.BpmnPropertyElementType;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.DefaultJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.ProcessJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.ScriptTaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.ServiceTaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.StartEventJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.TaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.UserTaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.properties.DataObjectJso;

public class BpmnDiagramElementJso extends BpmnBaseElementJso implements
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

	protected BpmnDiagramElementJso() {
	}

	/*
	 * functions for extension elements
	 */
	private final native BpmnDiagramElementExtensionJso addExt_elemenemt(
			String bpmnExtensionElementType)/*-{
											console.log("js-native: addExt_elemenemt");
											return $wnd.bpmnIo_fktAddElementExtensionType(this,
											bpmnExtensionElementType);
											}-*/;

	@Override
	public final native boolean removeExt_elemenemt(
			BpmnDiagramElementExtensionJso extElement)/*-{
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

	private final native JsArray<BpmnDiagramElementExtensionJso> getExt_elements(
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

	@Override
	public final JsArray<BpmnDiagramElementExtensionJso> getExt_executionListeners() {
		JsArray<BpmnDiagramElementExtensionJso> extElements = getExt_elements(BpmnExtensionElementType.CAMUNDA_EXECUTION_LISTENER
				.toString());
		return extElements;
	}

	@Override
	public final BpmnDiagramElementExtensionJso addExt_executionListener() {
		BpmnDiagramElementExtensionJso newExtElement = addExt_elemenemt(BpmnExtensionElementType.CAMUNDA_EXECUTION_LISTENER
				.toString());
		return newExtElement;
	}

	/*
	 * functions for properties
	 */
	private final native JsArray<BpmnDiagramElementPropertyJso> getProperty_elements(
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
	public final native boolean removeProperty_element(
			BpmnDiagramElementPropertyJso propElement)/*-{
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

	private final native BpmnDiagramElementPropertyJso addProperty_elemenemt(
			String bpmnPropertyElementType)/*-{
											console.log("js-native: addExt_elemenemt");
											return $wnd.bpmnIo_fktAddElementPropertyType(this,
											bpmnPropertyElementType);
											}-*/;

	@Override
	public final JsArray<BpmnDiagramElementPropertyJso> getProperty_dataObjects() {
		JsArray<BpmnDiagramElementPropertyJso> extElements = getProperty_elements(BpmnPropertyElementType.BPMN_DATA_OBJECT
				.toString());
		return extElements;
	}

	@Override
	public final BpmnDiagramElementPropertyJso addProperty_dataObject() {
		BpmnDiagramElementPropertyJso newExtElement = addProperty_elemenemt(BpmnPropertyElementType.BPMN_DATA_OBJECT
				.toString());
		return newExtElement;
	}
}
