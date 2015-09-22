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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.jso;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import de.fhrt.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget;

public class BpmnIoModelerJso extends JavaScriptObject {

	protected BpmnIoModelerJso() {
	}

	public final native String getAttr_targetNamespace()/*-{
														return this.definitions.targetNamespace;
														}-*/;

	public final native void setAttr_targetNamespace(String targetNamespace)/*-{
																			this.definitions.targetNamespace = targetNamespace;
																			}-*/;

	public final native void addRootElement(BpmnIoRootElementJso rootElement)/*-{
																				this.definitions = this.definitions	|| [];
																				this.definitions.get('rootElements').push(rootElement);
																				}-*/;

	public final native void removeRootElement(BpmnIoRootElementJso rootElement)/*-{
																				var rootElementIndex = this.definitions.rootElements.indexOf(rootElement);
																				if (rootElementIndex > -1) {
																				this.definitions.rootElements.splice(rootElementIndex, 1);
																				}
																				}-*/;

	public final native JsArray<BpmnIoRootElementJso> getRootElements(
			String rootElementType) /*-{
												if (!this.definitions || this.definitions.rootElements == 'undefined') {
													return [];
												}

												return this.definitions.rootElements.filter(function(e) {
													return e.$instanceOf(rootElementType);
												});
												}-*/;

	/*
	 * handler functions
	 */

	public final static native BpmnIoModelerJso nativeCreateInstance(
			String wrapperId, BpmnEditorDiagramWidget callback)/*-{
																var renderer = $wnd.bpmnIo_fkt_createNewModeler(wrapperId);
																
																renderer.updateData = function(){
																	renderer.saveXML({
																		format : true
																	}, function(err, xml) {														
																		callback.@de.fhrt.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget::jsCallbackSaveDiagram(Ljava/lang/String;)(xml);
																	});
																	
																	renderer.saveSVG(function(err, svg) {														
																		callback.@de.fhrt.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget::jsCallbackSaveSVG(Ljava/lang/String;)(svg);
																	});
																};
																
																renderer.on('element.click', function(event) {
																	var element = event.element;
																	callback.@de.fhrt.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget::jsCallbackElementSelected(Lde/fhrt/codenvy/bpmn/part/bpmnProperties/jso/BpmnIoElementJso;)(element);
																});
																																														
																renderer.on('commandStack.changed', function() {
																	renderer.saveXML({
																		format : true
																	}, function(err, xml) {														
																		callback.@de.fhrt.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget::jsCallbackSaveDiagram(Ljava/lang/String;)(xml);
																	});
																	
																	renderer.saveSVG(function(err, svg) {														
																		callback.@de.fhrt.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget::jsCallbackSaveSVG(Ljava/lang/String;)(svg);
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

	public final native void nativeUpdateData()/*-{
												this.updateData();
												}-*/;

	public final native BpmnIoModdleJso nativeGetBpmnIoModdleJso()/*-{
																	return this.get('moddle');
																	}-*/;

	public final native BpmnIoModelingJso nativeGetBpmnIoModelingJso()/*-{
																		return this.get('modeling');
																		}-*/;

}
