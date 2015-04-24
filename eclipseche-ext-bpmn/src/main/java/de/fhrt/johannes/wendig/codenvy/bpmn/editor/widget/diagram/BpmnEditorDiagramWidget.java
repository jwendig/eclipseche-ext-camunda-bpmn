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
package de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

import de.fhrt.johannes.wendig.codenvy.bpmn.BpmnResource;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.BpmnEditorView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesCallback;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.BpmnElementJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.BpmnModelerJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.BpmnElementJso.BpmnElementType;

public class BpmnEditorDiagramWidget extends Composite {

	public enum ElementType {
		UNKNOWN, START_EVENT, USER_TASK, SERVICE_TASK;
	}

	/*
	 * References
	 */
	private BpmnResource bpmnResource;
	private BpmnEditorView bpmnEditorView;
	private BpmnModelerJso bpmnIoModelerJso;
	private String diagramHtmlWrapperId;

	/*
	 * Layout
	 */
	private HTMLPanel diagramHtmlPanel;
	private GQuery qSelectedItem;

	public BpmnEditorDiagramWidget(BpmnEditorView bpmnEditorView,
			BpmnResource bpmnResource, int viewNumber) {
		super();
		Log.info(BpmnEditorDiagramWidget.class, "constructor");
		this.bpmnEditorView = bpmnEditorView;
		this.bpmnResource = bpmnResource;

		diagramHtmlWrapperId = "bpmnIoCanvas_" + viewNumber++;

		loadCss();

		initDiagramHtmlPanel();

		initWidget(diagramHtmlPanel);
		setStyleName("gwt-bpmnDigramWidget");

	}

	private void loadCss() {
		bpmnResource.getBpmnDiagramJsCss().ensureInjected();
		bpmnResource.getBpmnAppCss().ensureInjected();
		bpmnResource.getBpmnFontCss().ensureInjected();
		bpmnResource.getBpmnPropertiesTabCss().ensureInjected();
		bpmnResource.getBpmnDiagramJsCustomCss().ensureInjected();
	}

	private void initDiagramHtmlPanel() {
		// diagramHtmlPanel = new HTMLPanel(bpmnResource.bpmnIoIndexHtmlFile()
		// .getText());
		diagramHtmlPanel = new HTMLPanel(
				"<div class=\"canvas bpmnDigramWidget-diagramHtmlPanel-wrapper\" id=\""
						+ diagramHtmlWrapperId + "\"></div>");
		diagramHtmlPanel.setSize("100%", "100%");
		diagramHtmlPanel.addStyleName("bpmnDigramWidget-diagramHtmlPanel");
	}

	@Override
	protected void onAttach() {
		super.onAttach();
		Log.info(BpmnEditorDiagramWidget.class, "onAttach");

		ScriptInjector.fromString(bpmnResource.bpmnIoIndexJsFile().getText())
				.setWindow(ScriptInjector.TOP_WINDOW).inject();

		bpmnIoModelerJso = BpmnModelerJso.nativeCreateInstance(
				diagramHtmlWrapperId, this);
	}

	/*
	 * Javascript Callbacks
	 */

	public void jsCallbackSaveDiagram(String xml) {
		Log.info(BpmnEditorDiagramWidget.class, "jsCallbackSaveDiagram");
		Log.info(BpmnEditorDiagramWidget.class, "jsCallbackSaveDiagram: xml = "
				+ xml);
		bpmnEditorView.setCurrentXmlContent(xml);
		bpmnEditorView.setContentIsDirty();
	};

	public void jsCallbackSaveSVG(String svg) {
		Log.info(BpmnEditorDiagramWidget.class, "jsCallbackSaveSVG");
		bpmnEditorView.setCurrentSvgContent(svg);
		bpmnEditorView.setContentIsDirty();
	};

	public void jsCallbackElementSelected(BpmnElementJso elem) {
		Log.info(BpmnEditorDiagramWidget.class, "jsCallbackElementSelected");
		Log.info(BpmnEditorDiagramWidget.class,
				"jsCallbackElementSelected: type=" + elem.getType());
		Log.info(BpmnEditorDiagramWidget.class,
				"jsCallbackElementSelected: id=" + elem.getAttr_id());

		bpmnEditorView.bpmnElementSelected(elem);
	};

	public void jsCallbackContainerSelected(BpmnElementJso elem) {
		Log.info(BpmnEditorDiagramWidget.class, "jsCallbackContainerSelected");
		Log.info(BpmnEditorDiagramWidget.class,
				"jsCallbackContainerSelected: type=" + elem.getType());
		Log.info(BpmnEditorDiagramWidget.class,
				"jsCallbackContainerSelected: id=" + elem.getAttr_id());

		bpmnEditorView.bpmnElementSelected(elem);
	};

	/*
	 * Getter
	 */
	public BpmnModelerJso getBpmnIoModelerJso() {
		return bpmnIoModelerJso;
	}
}
