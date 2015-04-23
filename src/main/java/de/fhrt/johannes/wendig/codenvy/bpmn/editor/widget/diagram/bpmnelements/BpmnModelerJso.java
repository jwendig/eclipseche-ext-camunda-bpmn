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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.ui.Panel;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementExtensionJso.BpmnExtensionElementType;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementPropertyJso.BpmnPropertyElementType;

public class BpmnModelerJso extends JavaScriptObject {

	protected BpmnModelerJso() {
	}

	/*
	 * handler functions
	 */

	public final static native BpmnModelerJso nativeCreateInstance(
			String wrapperId, BpmnEditorDiagramWidget callback)/*-{
																var renderer = $wnd.bpmnIo_fkt_createNewModeler(wrapperId);
																
																renderer.on('element.click', function(event) {
																	var element = event.element;
																	var moddle = renderer.get('moddle');
																
																	// do not allow on root element
																	if (!element.parent) {
																	callback.@de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget::jsCallbackContainerSelected(Lde/fhrt/johannes/wendig/codenvy/bpmn/editor/widget/diagram/bpmnelements/BpmnDiagramElementJso;)(element.businessObject);
																	return;
																	}
																
																	callback.@de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget::jsCallbackElementSelected(Lde/fhrt/johannes/wendig/codenvy/bpmn/editor/widget/diagram/bpmnelements/BpmnDiagramElementJso;)(element.businessObject);
																});
																
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

	private final native BpmnDiagramElementPropertyJso nativeAddRoot_element(
			JavaScriptObject moddle, String bpmnRootElementType)/*-{
																console.log("js-native: nativeAddRoot_element");
																		var ext = moddle.create(bpmnRootElementType);

																		this.definitions = this.definitions	|| [];
																		this.definitions.get('rootElements').push(ext);
																		
																		return ext;
																		
																		}-*/;

	// @Override
	public final native boolean nativeRemoveRootElement(
			BpmnDiagramElementPropertyJso extElement)/*-{
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

	private final native JsArray<BpmnDiagramElementPropertyJso> nativeGetRootElementsByType(
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

	// @Override
	public final JsArray<BpmnDiagramElementPropertyJso> getRootElements_errors() {
		JsArray<BpmnDiagramElementPropertyJso> extElements = nativeGetRootElementsByType(BpmnPropertyElementType.BPMN_ERROR
				.toString());
		return extElements;
	}

	// @Override
	public final BpmnDiagramElementPropertyJso addRootElement_error(
			JavaScriptObject moddle) {
		BpmnDiagramElementPropertyJso newExtElement = nativeAddRoot_element(
				moddle, BpmnPropertyElementType.BPMN_ERROR.toString());
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
