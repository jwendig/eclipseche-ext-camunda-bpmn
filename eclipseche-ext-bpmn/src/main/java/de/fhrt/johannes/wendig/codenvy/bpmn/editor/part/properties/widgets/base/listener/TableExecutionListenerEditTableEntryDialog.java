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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.base.listener;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.ExecutionListenerJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.ScriptJso;

public class TableExecutionListenerEditTableEntryDialog extends DialogBox {

	private Button btnOk;
	private Button btnBack;
	private VerticalPanel vpRoot;
	private Grid gridContent;

	private ListBox lboxEvent;
	private ListBox lboxType;

	private Label lbSelectedType;

	private TextBox tbClass;
	private TextBox tbExpression;
	private TextBox tbDelegateExpression;
	private TextBox tbFormat;
	private RadioButton rbResource;
	private RadioButton rbScript;
	private TextBox tbResource;
	private TextArea taScript;

	private TableExecutionListenerWidget widgetCallback;
	private ExecutionListenerJso currentExecutionListenerJso;

	public TableExecutionListenerEditTableEntryDialog(
			final TableExecutionListenerWidget widgetCallback,
			ExecutionListenerJso executionListenerModel) {
		super();
		this.widgetCallback = widgetCallback;
		this.currentExecutionListenerJso = executionListenerModel;

		initialize();

		for (int i = 0; i < lboxEvent.getItemCount(); i++) {
			if (lboxEvent.getItemText(i).equalsIgnoreCase(
					executionListenerModel.getAttr_event())) {
				lboxEvent.setSelectedIndex(i);
				break;
			}
		}

		String currentType = "";
		if (executionListenerModel.getAttr_class().length() > 0) {
			currentType = "Class";
			gridContent.getRowFormatter().setVisible(3, false);
			gridContent.getRowFormatter().setVisible(4, false);
		} else if (executionListenerModel.getAttr_expression().length() > 0) {
			currentType = "Expression";
			gridContent.getRowFormatter().setVisible(3, false);
			gridContent.getRowFormatter().setVisible(4, false);
		} else if (executionListenerModel.getAttr_delegateExpression().length() > 0) {
			currentType = "Delegate Expression";
			gridContent.getRowFormatter().setVisible(3, false);
			gridContent.getRowFormatter().setVisible(4, false);
		} else if (executionListenerModel.getChild_script() != null) {
			currentType = "Script";
			gridContent.getRowFormatter().setVisible(3, true);
			gridContent.getRowFormatter().setVisible(4, true);
		}

		for (int i = 0; i < lboxType.getItemCount(); i++) {
			if (lboxType.getItemText(i).equalsIgnoreCase(currentType)) {
				lboxType.setSelectedIndex(i);
				DomEvent.fireNativeEvent(Document.get().createChangeEvent(),
						lboxType);
				break;
			}
		}

		tbClass.setText(executionListenerModel.getAttr_class());
		tbExpression.setText(executionListenerModel.getAttr_expression());
		tbDelegateExpression.setText(executionListenerModel
				.getAttr_delegateExpression());
		if (executionListenerModel.getChild_script() != null) {
			tbFormat.setText(executionListenerModel.getChild_script()
					.getAttr_scriptFormat());
			tbResource.setText(executionListenerModel.getChild_script()
					.getAttr_resource());
			taScript.setText(executionListenerModel.getChild_script()
					.getAttr_script());

			if (executionListenerModel.getChild_script().getAttr_resource()
					.length() > 0) {
				rbResource.setValue(true);
				tbResource.setEnabled(true);
				taScript.setEnabled(false);
			} else {
				rbScript.setValue(true);
				taScript.setEnabled(true);
				tbResource.setEnabled(false);
			}
		}
	}

	private void initialize() {
		setTitle("Execution Listener Details");
		setText("Execution Listener Details");

		setAnimationEnabled(true);
		setGlassEnabled(true);
		setWidth("600px");
		setHeight("auto");

		vpRoot = new VerticalPanel();
		vpRoot.setWidth("100%");

		lboxEvent = new ListBox();
		lboxEvent.setWidth("100%");
		lboxEvent.addItem("start");
		lboxEvent.addItem("stop");

		lboxType = new ListBox();
		lboxType.setWidth("100%");
		lboxType.addItem("Class");
		lboxType.addItem("Script");
		lboxType.addItem("Expression");
		lboxType.addItem("Delegate Expression");

		lboxType.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				lbSelectedType.setText(lboxType.getSelectedItemText());
				tbClass.setText("");
				tbExpression.setText("");
				tbDelegateExpression.setText("");
				tbFormat.setText("");
				tbResource.setText("");
				taScript.setText("");

				switch (lboxType.getSelectedItemText()) {
				case "Class":
					gridContent.setWidget(2, 1, tbClass);
					gridContent.getRowFormatter().setVisible(3, false);
					gridContent.getRowFormatter().setVisible(4, false);
					break;
				case "Script":
					lbSelectedType.setText("Format");
					gridContent.setWidget(2, 1, tbFormat);
					gridContent.getRowFormatter().setVisible(3, true);
					gridContent.getRowFormatter().setVisible(4, true);
					break;
				case "Expression":
					gridContent.setWidget(2, 1, tbExpression);
					gridContent.getRowFormatter().setVisible(3, false);
					gridContent.getRowFormatter().setVisible(4, false);
					break;
				case "Delegate Expression":
					gridContent.setWidget(2, 1, tbDelegateExpression);
					gridContent.getRowFormatter().setVisible(3, false);
					gridContent.getRowFormatter().setVisible(4, false);
					break;
				}

			}
		});

		lbSelectedType = new Label("Class");

		tbClass = new TextBox();
		tbClass.setWidth("100%");
		tbExpression = new TextBox();
		tbExpression.setWidth("100%");
		tbDelegateExpression = new TextBox();
		tbDelegateExpression.setWidth("100%");
		tbFormat = new TextBox();
		tbFormat.setWidth("100%");

		tbResource = new TextBox();
		tbResource.setWidth("100%");

		ClickHandler rbHandler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (rbResource.getValue() == true) {
					tbResource.setEnabled(true);
					taScript.setEnabled(false);
					taScript.setText("");
				} else {
					taScript.setEnabled(true);
					tbResource.setEnabled(false);
					tbResource.setText("");
				}

			}
		};

		rbResource = new RadioButton("type");
		rbResource.addClickHandler(rbHandler);

		rbScript = new RadioButton("type");
		rbScript.addClickHandler(rbHandler);

		taScript = new TextArea();
		taScript.setWidth("100%");

		HorizontalPanel hPanelResource = new HorizontalPanel();
		hPanelResource.setWidth("100%");
		hPanelResource.add(rbResource);
		hPanelResource.add(tbResource);

		HorizontalPanel hPanelScript = new HorizontalPanel();
		hPanelScript.setWidth("100%");
		hPanelScript.add(rbScript);
		hPanelScript.add(taScript);

		gridContent = new Grid(5, 3);
		gridContent.setWidth("100%");
		gridContent.setText(0, 0, "Event");
		gridContent.setText(1, 0, "Type");
		gridContent.setWidget(2, 0, lbSelectedType);
		gridContent.setText(3, 0, "Resource");
		gridContent.setText(4, 0, "Script");

		gridContent.setWidget(0, 1, lboxEvent);
		gridContent.setWidget(1, 1, lboxType);
		gridContent.setWidget(2, 1, tbClass);
		gridContent.setWidget(3, 1, hPanelResource);
		gridContent.setWidget(4, 1, hPanelScript);

		gridContent.getColumnFormatter().setWidth(0, "150px");
		gridContent.getRowFormatter().setVisible(3, false);
		gridContent.getRowFormatter().setVisible(4, false);

		btnOk = new Button("Save");
		btnOk.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				currentExecutionListenerJso.setAttr_event(lboxEvent
						.getSelectedItemText());
				currentExecutionListenerJso.setAttr_class(tbClass.getText());
				currentExecutionListenerJso.setAttr_expression(tbExpression
						.getText());
				currentExecutionListenerJso
						.setAttr_delegateExpression(tbDelegateExpression
								.getText());

				if (lboxType.getSelectedItemText().equalsIgnoreCase("script")) {
					ScriptJso scriptJso = currentExecutionListenerJso
							.addChild_script(widgetCallback.getDelegate()
									.getCurrentBpmnIoModelerJso()
									.nativeGetModdle());
					scriptJso.setAttr_resource(tbResource.getText());
					scriptJso.setAttr_script(taScript.getText());
					scriptJso.setAttr_scriptFormat(tbFormat.getText());
				} else {
					currentExecutionListenerJso.removeChild_script();
					
				}

				// TODO: save script settings

				TableExecutionListenerEditTableEntryDialog.this.hide();

				widgetCallback.getDataProvider().refresh();
				widgetCallback.getDelegate().onContentChange();
			}
		});

		btnBack = new Button("Back");
		btnBack.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				TableExecutionListenerEditTableEntryDialog.this.hide();
			}
		});

		HorizontalPanel hpOptions = new HorizontalPanel();
		hpOptions.add(btnOk);
		hpOptions.add(btnBack);

		vpRoot.add(gridContent);
		vpRoot.add(hpOptions);

		setWidget(vpRoot);
	}
}
