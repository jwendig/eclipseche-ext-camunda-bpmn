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

import static com.google.gwt.query.client.GQuery.$;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RenderableStamper;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

import de.fhrt.johannes.wendig.codenvy.bpmn.BpmnResource;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.BpmnEditorCallback;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesCallback;

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
	private SplitLayoutPanel baseSplitLayoutPanel;
	private Grid optionsGridPanel;
	private HTMLPanel diagramHtmlPanel;

	private Label lbSelectedItem;
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

		initOptionsGridPanel();
		initDiagramHtmlPanel();

		initBaseSplitLayoutPanel();

		initWidget(baseSplitLayoutPanel);
		setStyleName("gwt-bpmnDigramWidget");

	}

	private void loadCss() {
		bpmnResource.getBpmnDiagramJsCss().ensureInjected();
		bpmnResource.getBpmnAppCss().ensureInjected();
		bpmnResource.getBpmnFontCss().ensureInjected();
	}

	private void initBaseSplitLayoutPanel() {
		baseSplitLayoutPanel = new SplitLayoutPanel();
		baseSplitLayoutPanel.setSize("100%", "100%");
		baseSplitLayoutPanel.add(diagramHtmlPanel);
		baseSplitLayoutPanel.addSouth(new ScrollPanel(optionsGridPanel), 150);
	}

	private void initOptionsGridPanel() {
		optionsGridPanel = new Grid(2, 3);
		optionsGridPanel.setSize("100%", "100%");
		optionsGridPanel.addStyleName("bpmnDigramWidget-optionsGridPanel");

		lbSelectedItem = new Label("Select an BPMN-Element");
		optionsGridPanel.setWidget(0, 0, lbSelectedItem);

		Button btnTestNodeManipulation = new Button("Set Camunda Class");
		optionsGridPanel.setWidget(0, 1, btnTestNodeManipulation);
		btnTestNodeManipulation.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				changeAttrCamundaClass();

			}
		});
	}

	private void initDiagramHtmlPanel() {
		diagramHtmlPanel = new HTMLPanel(bpmnResource.bpmnIoIndexHtmlFile()
				.getText());
		diagramHtmlPanel.setSize("100%", "100%");
		diagramHtmlPanel.addStyleName("bpmnDigramWidget-diagramHtmlPanel");
	}

	@Override
	public void initializeClaimedElement() {
		super.initializeClaimedElement();
		Log.info(BpmnEditorDiagramWidget.class, "initializeClaimedElement");
	}

	@Override
	public SafeHtml render(RenderableStamper stamper) {
		Log.info(BpmnEditorDiagramWidget.class, "render");
		return super.render(stamper);
	}

	@Override
	public void render(RenderableStamper stamper, SafeHtmlBuilder builder) {
		super.render(stamper, builder);
		Log.info(BpmnEditorDiagramWidget.class, "render");
	}

	@Override
	protected void initWidget(Widget widget) {
		super.initWidget(widget);
		Log.info(BpmnEditorDiagramWidget.class, "initWidget");
	}

	@Override
	protected void onAttach() {
		super.onAttach();
		Log.info(BpmnEditorDiagramWidget.class, "onAttach");

		ScriptInjector.fromString(bpmnResource.bpmnIoIndexJsFile().getText())
				.setWindow(ScriptInjector.TOP_WINDOW).inject();

		initJavascriptCallbacks();
		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
			public void execute() {
				initBpmnDiagramListener();
			}
		});
	}

	/*
	 * Custom functions
	 */

	public void openDiagram(String xml) {
		Log.info(BpmnEditorDiagramWidget.class, "openDiagram");
		// currentXmlContent = xml;
		jsOpenDiagram(xml);
		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
			public void execute() {
				initBpmnDiagramListener();
			}
		});
	}

	public void exportArtifacts() {
		Log.info(BpmnEditorDiagramWidget.class, "exportArtifacts");
		jsExportArtifacts();
	}

	private void initBpmnDiagramListener() {
		Log.info(BpmnEditorDiagramWidget.class, "setBpmnDiagramListener");
		$(".djs-element, .bpmnDigramWidget-diagramHtmlPanel", diagramHtmlPanel).click(new Function() {
			public boolean f(Event e) {
				Log.info(
						BpmnEditorDiagramWidget.class,
						"Element-Clicked (class='" + $(e).attr("class")
								+ "', data-element-id='"
								+ $(e).attr("data-element-id") + "' )");
				lbSelectedItem.setText("Selected BPMN-Item: "
						+ $(e).attr("data-element-id"));

				qSelectedItem = $(e);

				String dataElementId = $(e).attr("data-element-id");
				ElementType type;
				if (dataElementId.contains("ServiceTask")) {
					type = ElementType.SERVICE_TASK;
				} else if (dataElementId.contains("UserTask")) {
					type = ElementType.USER_TASK;
				} else if (dataElementId.contains("StartEvent")) {
					type = ElementType.START_EVENT;
				} else {
					type = ElementType.UNKNOWN;
				}

				bpmnElementPropertiesCallback.elementSelected(type);
				return true;
			}
		});
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
		initBpmnDiagramListener();

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

													}-*/;

	private native void jsOpenDiagram(String xml)/*-{
													$wnd.bpmnIo_openDiagram(xml);
													}-*/;

	private native void jsExportArtifacts()/*-{
											$wnd.bpmnIo_exportArtifacts();
											}-*/;

	/*
	 * Getter
	 */

}
