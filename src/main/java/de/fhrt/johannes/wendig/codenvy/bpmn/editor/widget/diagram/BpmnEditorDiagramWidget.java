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
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.BpmnEditorCallback;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesCallback;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementJso.BpmnElementType;

public class BpmnEditorDiagramWidget extends Composite {

	public enum ElementType {
		UNKNOWN, START_EVENT, USER_TASK, SERVICE_TASK;
	}

	/*
	 * References
	 */
	private BpmnResource bpmnResource;
	private BpmnEditorCallback bpmnEditorCallback;
	private BpmnElementPropertiesCallback bpmnElementPropertiesCallback;

	/*
	 * Layout
	 */
	private HTMLPanel diagramHtmlPanel;
	private GQuery qSelectedItem;

	public BpmnEditorDiagramWidget(BpmnEditorCallback bpmnEditorCallback,
			BpmnElementPropertiesCallback bpmnElementPropertiesCallback,
			BpmnResource bpmnResource) {
		super();
		Log.info(BpmnEditorDiagramWidget.class, "constructor");
		this.bpmnEditorCallback = bpmnEditorCallback;
		this.bpmnElementPropertiesCallback = bpmnElementPropertiesCallback;
		this.bpmnResource = bpmnResource;

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
		diagramHtmlPanel = new HTMLPanel(bpmnResource.bpmnIoIndexHtmlFile()
				.getText());
		diagramHtmlPanel.setSize("100%", "100%");
		diagramHtmlPanel.addStyleName("bpmnDigramWidget-diagramHtmlPanel");
	}

	@Override
	protected void onAttach() {
		super.onAttach();
		Log.info(BpmnEditorDiagramWidget.class, "onAttach");

		ScriptInjector.fromString(bpmnResource.bpmnIoIndexJsFile().getText())
				.setWindow(ScriptInjector.TOP_WINDOW).inject();

		initJavascriptCallbacks();
	}

	/*
	 * Custom functions
	 */

	public void openDiagram(String xml) {
		Log.info(BpmnEditorDiagramWidget.class, "openDiagram");
		jsOpenDiagram(xml);
	}

	public void exportArtifacts() {
		Log.info(BpmnEditorDiagramWidget.class, "exportArtifacts");
		jsExportArtifacts();
	}

	public void changeAttrCamundaClass() {
		Log.info(BpmnEditorDiagramWidget.class, "changeAttrCamundaClass");
		if (null != qSelectedItem) {
			Log.info(BpmnEditorDiagramWidget.class,
					"changeAttrCamundaClass: qSelectedItem NOT NULL");
			qSelectedItem.attr("camunda:class", "test");
		} else {
			Log.info(BpmnEditorDiagramWidget.class,
					"changeAttrCamundaClass: qSelectedItem NULL");
		}
	}

	/*
	 * Javascript Callbacks
	 */

	public void jsCallbackSaveDiagram(String xml) {
		Log.info(BpmnEditorDiagramWidget.class, "jsCallbackSaveDiagram");
		bpmnEditorCallback.setCurrentXmlContent(xml);
		bpmnEditorCallback.setContentIsDirty();
	};

	public void jsCallbackSaveSVG(String svg) {
		Log.info(BpmnEditorDiagramWidget.class, "jsCallbackSaveSVG");
		bpmnEditorCallback.setCurrentSvgContent(svg);
		bpmnEditorCallback.setContentIsDirty();
	};

	/*
	 * Native JS-Functions
	 */
	private native void initJavascriptCallbacks()/*-{
													var self = this;
													var callbackSaveDiagramFn = $entry(function(val) {
													self.@de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget::jsCallbackSaveDiagram(Ljava/lang/String;)(val);
													});
													$wnd.setBpmnIo_callbackSaveDiagram(callbackSaveDiagramFn);

													var callbackSaveSvgFn = $entry(function(val) {
													self.@de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget::jsCallbackSaveSVG(Ljava/lang/String;)(val);
													});
													$wnd.setBpmnIo_callbackSaveSVG(callbackSaveSvgFn);
													
													var callbackElementSelected = $entry(function(val) {
													self.@de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget::jsCallbackElementSelected(Lde/fhrt/johannes/wendig/codenvy/bpmn/editor/widget/diagram/bpmnelements/BpmnDiagramElementJso;)(val);
													});
													$wnd.setBpmnIo_callback_elementSelected(callbackElementSelected);

													var callbackContainerSelected = $entry(function(val) {
													self.@de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget::jsCallbackContainerSelected(Lde/fhrt/johannes/wendig/codenvy/bpmn/editor/widget/diagram/bpmnelements/BpmnDiagramElementJso;)(val);
													});
													$wnd.setBpmnIo_callback_containerSelected(callbackContainerSelected);

													}-*/;

	private native void jsOpenDiagram(String xml)/*-{
													$wnd.bpmnIo_fktOpenDiagram(xml);
													}-*/;

	private native void jsExportArtifacts()/*-{
											$wnd.bpmnIo_fktExportArtifacts();
											}-*/;

	public void jsCallbackElementSelected(BpmnDiagramElementJso elem) {
		Log.info(BpmnEditorDiagramWidget.class, "jsCallbackElementSelected");
		Log.info(BpmnEditorDiagramWidget.class,
				"jsCallbackElementSelected: type=" + elem.getType());
		Log.info(BpmnEditorDiagramWidget.class,
				"jsCallbackElementSelected: id=" + elem.getAttr_id());

		bpmnElementPropertiesCallback.elementSelected(elem);
	};

	public void jsCallbackContainerSelected(BpmnDiagramElementJso elem) {
		Log.info(BpmnEditorDiagramWidget.class, "jsCallbackContainerSelected");
		Log.info(BpmnEditorDiagramWidget.class,
				"jsCallbackContainerSelected: type=" + elem.getType());
		Log.info(BpmnEditorDiagramWidget.class,
				"jsCallbackContainerSelected: id=" + elem.getAttr_id());

		bpmnElementPropertiesCallback.elementSelected(elem);
	};

	/*
	 * Getter
	 */

}
