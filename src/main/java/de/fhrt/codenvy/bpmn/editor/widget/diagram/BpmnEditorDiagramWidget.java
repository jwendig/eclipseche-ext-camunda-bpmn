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
package de.fhrt.codenvy.bpmn.editor.widget.diagram;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;

import de.fhrt.codenvy.bpmn.BpmnResource;
import de.fhrt.codenvy.bpmn.editor.BpmnEditorView;
import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.BpmnModelerJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoElementJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoModelerJso;

public class BpmnEditorDiagramWidget extends Composite {

	public enum ElementType {
		UNKNOWN, START_EVENT, USER_TASK, SERVICE_TASK;
	}

	/*
	 * References
	 */
	private BpmnResource bpmnResource;
	private BpmnEditorView bpmnEditorView;
	private BpmnIoModelerJso bpmnIoModelerJso;
	private String diagramHtmlWrapperId;

	/*
	 * Layout
	 */

	private BpmnEditorSourceWidget cmWidget;
	private HTMLPanel diagramHtmlPanel;

	public BpmnEditorDiagramWidget(BpmnEditorView bpmnEditorView,
			BpmnResource bpmnResource, int viewNumber) {
		super();
		Log.info(BpmnEditorDiagramWidget.class, "constructor");
		this.bpmnEditorView = bpmnEditorView;
		this.bpmnResource = bpmnResource;

		diagramHtmlWrapperId = "bpmnIoCanvas_" + viewNumber++;

		loadCss();

		initDiagramSourceWidget();
		initDiagramHtmlPanel();
		initWidget(initRootLayout());

		diagramHtmlPanel.addStyleName("gwt-bpmnDigramWidget");
		cmWidget.addStyleName("gwt-bpmnSourceWidget");
	}

	private TabLayoutPanel initRootLayout() {
		TabLayoutPanel root = new TabLayoutPanel(0, Unit.PX);
		root.setSize("100%", "100%");
		root.add(diagramHtmlPanel, "Design");
		root.add(cmWidget, "Source");
		root.addStyleName("bpmnDigramWidget-tabLayoutPanel");
		root.addSelectionHandler(new SelectionHandler<Integer>() {

			@Override
			public void onSelection(SelectionEvent<Integer> event) {
				if (event.getSelectedItem() == 1) {
					Timer t = new Timer() {
						@Override
						public void run() {
							cmWidget.refresh();
						}
					};
					t.schedule(10);
				}
			}
		});
		return root;
	}

	private void initDiagramSourceWidget() {
		ScriptInjector.fromString(bpmnResource.codemirrorModeXml().getText())
				.setWindow(ScriptInjector.TOP_WINDOW).inject();

		cmWidget = new BpmnEditorSourceWidget("xml", "codenvy");
		cmWidget.setEnabled(false);
	}

	private void loadCss() {
		bpmnResource.getBpmnDiagramJsCss().ensureInjected();
		bpmnResource.getBpmnAppCss().ensureInjected();
		bpmnResource.getBpmnFontCss().ensureInjected();
		bpmnResource.getBpmnDiagramJsCustomCss().ensureInjected();
		bpmnResource.getBpmnEditorCustomCss().ensureInjected();
		bpmnResource.getBpmnPropertiesTabCss().ensureInjected();
	}

	private void initDiagramHtmlPanel() {
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
				.setWindow(ScriptInjector.TOP_WINDOW).setRemoveTag(false).inject();

		bpmnIoModelerJso = BpmnIoModelerJso.nativeCreateInstance(
				diagramHtmlWrapperId, this);
	}

	public void jsCallbackSaveDiagram(String xml) {
		Log.info(BpmnEditorDiagramWidget.class, "jsCallbackSaveDiagram");
		Log.info(BpmnEditorDiagramWidget.class, "jsCallbackSaveDiagram: xml = "
				+ xml);
		bpmnEditorView.setCurrentXmlContent(xml);
		bpmnEditorView.setContentIsDirty();
		cmWidget.setValue(xml);
	};

	public void jsCallbackSaveSVG(String svg) {
		Log.info(BpmnEditorDiagramWidget.class, "jsCallbackSaveSVG");
		bpmnEditorView.setCurrentSvgContent(svg);
		bpmnEditorView.setContentIsDirty();
	};

	public void jsCallbackElementSelected(BpmnIoElementJso elem) {
		Log.info(BpmnEditorDiagramWidget.class, "jsCallbackElementSelected");
		bpmnEditorView.bpmnElementSelected(bpmnIoModelerJso, elem);
	};

	public void openDiagram(String xml) {
		cmWidget.setValue(xml);
		bpmnIoModelerJso.nativeOpenDiagram(xml);
	}

	public BpmnIoModelerJso getBpmnIoModelerJso() {
		return bpmnIoModelerJso;
	};

}
