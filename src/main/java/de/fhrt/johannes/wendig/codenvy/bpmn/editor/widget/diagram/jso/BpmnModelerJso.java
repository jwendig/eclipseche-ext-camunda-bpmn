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

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.BpmnRootPropertyJso.BpmnRootPropertyType;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.root.DataStoreJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.root.ErrorJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.root.MessageJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.root.SignalJso;

public class BpmnModelerJso extends JavaScriptObject {

	protected BpmnModelerJso() {
	}

	/*
	 * handler functions
	 */

	public final static native BpmnModelerJso nativeCreateInstance(
			String wrapperId, BpmnEditorDiagramWidget callback)/*-{
																var renderer = $wnd.bpmnIo_fkt_createNewModeler(wrapperId);
																
																renderer.updateData = function(){
																	renderer.saveXML({
																		format : true
																	}, function(err, xml) {														
																		callback.@de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget::jsCallbackSaveDiagram(Ljava/lang/String;)(xml);
																	});
																	
																	renderer.saveSVG(function(err, svg) {														
																		callback.@de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget::jsCallbackSaveSVG(Ljava/lang/String;)(svg);
																	});
																};
																
																renderer.on('element.click', function(event) {
																	var element = event.element;
																	var moddle = renderer.get('moddle');
																
																	// do not allow on root element
																	if (!element.parent) {
																	callback.@de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget::jsCallbackContainerSelected(Lde/fhrt/johannes/wendig/codenvy/bpmn/editor/widget/diagram/jso/BpmnElementJso;)(element.businessObject);
																	return;
																	}
																
																	callback.@de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget::jsCallbackElementSelected(Lde/fhrt/johannes/wendig/codenvy/bpmn/editor/widget/diagram/jso/BpmnElementJso;)(element.businessObject);
																});
																																														
																renderer.on('commandStack.changed', function() {
																	renderer.saveXML({
																		format : true
																	}, function(err, xml) {														
																		callback.@de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget::jsCallbackSaveDiagram(Ljava/lang/String;)(xml);
																	});
																	
																	renderer.saveSVG(function(err, svg) {														
																		callback.@de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget::jsCallbackSaveSVG(Ljava/lang/String;)(svg);
																	});
																});
																
																return renderer;
																}-*/;

	public final native void nativeOpenDiagram(String xml)/*-{
															this.importXML(xml, function(err) {

															if (err) {
																console.error(err);
															} else {
																console.log("openDiagram: success");
															}

															});
															}-*/;

	public final native JavaScriptObject nativeGetModdle()/*-{
															return this.get('moddle');
															}-*/;

	public final native void nativeUpdateData()/*-{
												this.updateData();
												}-*/;

	/*
	 * Functions to create bpmn-properties
	 */

	private final native BpmnRootPropertyJso nativeAddRootElement(
			JavaScriptObject moddle, String bpmnRootElementType)/*-{
																console.log("js-native: nativeAddRoot_element");
																		var ext = moddle.create(bpmnRootElementType);

																		this.definitions = this.definitions	|| [];
																		this.definitions.get('rootElements').push(ext);
																		
																		return ext;
																		
																		}-*/;

	private final native boolean nativeRemoveRootElement(
			BpmnRootPropertyJso extElement)/*-{
											console.log("js-native: removeRoot_elemenemt");
											var extElementIndex = this.definitions.rootElements.indexOf(extElement);
											if (extElementIndex > -1) {
											console.log("js-native: removeRoot_elemenemt: extElement found at index:" + extElementIndex);
											this.definitions.rootElements.splice(extElementIndex, 1);
											
											return true;
											}else{
											console.log("js-native: removeRoot_elemenemt: extElement not found");
											return false;
											}
											}-*/;

	private final native JsArray<BpmnRootPropertyJso> nativeGetRootElementsByType(
			String bpmnRootElementType) /*-{
												console.log("js-native: getRoot_elements");
												if (!this.definitions || this.definitions.rootElements == 'undefined') {
												console
												.log("js-native: getRoot_elements: no root elements");
												return [];
												}

												return this.definitions.rootElements.filter(function(e) {
												return e.$instanceOf(bpmnRootElementType);
												});
												}-*/;

	/*
	 * functions for errors
	 */
	public final boolean removeRootElementErrors(ErrorJso element) {
		return nativeRemoveRootElement((BpmnRootPropertyJso) element);
	}

	public final List<ErrorJso> getRootElementsErrors() {
		JsArray<BpmnRootPropertyJso> extElements = nativeGetRootElementsByType(BpmnRootPropertyType.BPMN_ERROR
				.toString());
		List<ErrorJso> list = new ArrayList<ErrorJso>();
		for (int i = 0; i < extElements.length(); i++) {
			list.add(extElements.get(i));
		}

		return list;
	}

	public final ErrorJso addRootElementError(JavaScriptObject moddle) {
		BpmnRootPropertyJso newExtElement = nativeAddRootElement(moddle,
				BpmnRootPropertyType.BPMN_ERROR.toString());
		return newExtElement;
	}

	/*
	 * functions for signals
	 */
	public final boolean removeRootElementSignal(SignalJso element) {
		return nativeRemoveRootElement((BpmnRootPropertyJso) element);
	}

	public final List<SignalJso> getRootElementsSignals() {
		JsArray<BpmnRootPropertyJso> extElements = nativeGetRootElementsByType(BpmnRootPropertyType.BPMN_SIGNAL
				.toString());
		List<SignalJso> list = new ArrayList<SignalJso>();
		for (int i = 0; i < extElements.length(); i++) {
			list.add(extElements.get(i));
		}

		return list;
	}

	public final SignalJso addRootElementSignalJso(JavaScriptObject moddle) {
		BpmnRootPropertyJso newExtElement = nativeAddRootElement(moddle,
				BpmnRootPropertyType.BPMN_SIGNAL.toString());
		return newExtElement;
	}

	/*
	 * functions for data-stores
	 */
	public final boolean removeRootElementDataStore(DataStoreJso element) {
		return nativeRemoveRootElement((BpmnRootPropertyJso) element);
	}

	public final List<DataStoreJso> getRootElementsDataStores() {
		JsArray<BpmnRootPropertyJso> extElements = nativeGetRootElementsByType(BpmnRootPropertyType.BPMN_DATASTORE
				.toString());
		List<DataStoreJso> list = new ArrayList<DataStoreJso>();
		for (int i = 0; i < extElements.length(); i++) {
			list.add(extElements.get(i));
		}

		return list;
	}

	public final DataStoreJso addRootElementDataStore(JavaScriptObject moddle) {
		BpmnRootPropertyJso newExtElement = nativeAddRootElement(moddle,
				BpmnRootPropertyType.BPMN_DATASTORE.toString());
		return newExtElement;
	}

	/*
	 * functions for messages
	 */
	public final boolean removeRootElementMessage(MessageJso element) {
		return nativeRemoveRootElement((BpmnRootPropertyJso) element);
	}

	public final List<MessageJso> getRootElementsMessages() {
		JsArray<BpmnRootPropertyJso> extElements = nativeGetRootElementsByType(BpmnRootPropertyType.BPMN_MESSAGE
				.toString());
		List<MessageJso> list = new ArrayList<MessageJso>();
		for (int i = 0; i < extElements.length(); i++) {
			list.add(extElements.get(i));
		}

		return list;
	}

	public final MessageJso addRootElementMessage(JavaScriptObject moddle) {
		BpmnRootPropertyJso newExtElement = nativeAddRootElement(moddle,
				BpmnRootPropertyType.BPMN_MESSAGE.toString());
		return newExtElement;
	}

	/*
	 * Getter & setter for attritubes
	 */

	public final native String getAttr_targetNamespace()/*-{
														return this.definitions.targetNamespace;
														}-*/;

	public final native void setAttr_targetNamespace(String targetNamespace)/*-{
																				this.definitions.targetNamespace = targetNamespace;
																				}-*/;

}
