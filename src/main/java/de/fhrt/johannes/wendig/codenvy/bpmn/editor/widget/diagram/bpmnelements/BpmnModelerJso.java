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
import com.google.gwt.user.client.ui.Panel;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget;

public class BpmnModelerJso extends JavaScriptObject {

	private BpmnEditorDiagramWidget callback;

	protected BpmnModelerJso() {
	}

	/*
	 * handler functions
	 */

	public static BpmnModelerJso createInstance(String wrapperId,
			BpmnEditorDiagramWidget callback) {
		BpmnModelerJso instance = nativeCreateInstance(wrapperId, callback);
		instance.callback = callback;
		return instance;
	}

	private static native BpmnModelerJso nativeCreateInstance(String wrapperId,
			BpmnEditorDiagramWidget callback)/*-{
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

	public void updateData() {
		nativeUpdateData(callback);
	}

	private final native JavaScriptObject nativeUpdateData(
			BpmnEditorDiagramWidget callback)/*-{
												renderer.saveXML({
													format : true
												}, function(err, xml) {														
													callback.@de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget::jsCallbackSaveDiagram(Ljava/lang/String;)(xml);
												});
												
												renderer.saveSVG(function(err, svg) {														
													callback.@de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget::jsCallbackSaveSVG(Ljava/lang/String;)(svg);
												});
												}-*/;

}
