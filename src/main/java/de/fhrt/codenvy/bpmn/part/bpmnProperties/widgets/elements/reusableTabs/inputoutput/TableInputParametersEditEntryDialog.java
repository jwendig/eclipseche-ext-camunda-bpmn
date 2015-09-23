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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.inputoutput;

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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.InputParameterExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.ScriptExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.ScriptWidget;

public class TableInputParametersEditEntryDialog extends DialogBox {

	private Button btnOk;
	private Button btnBack;
	private VerticalPanel vpRoot;
	private Grid gridContent;

	private TextBox tbName;
	private ListBox lboxType;

	private Label lbSelectedType;

	private TextBox tbTextContent;

	private ScriptWidget swScript;
	private EditInputOutputParameterTableListWidget tableList;
	private EditInputOutputParameterTableMapWidget tableMap;

	private TableInputParametersWidget widgetCallback;
	private InputParameterExtensionElementChild currentInputParameterElement;

	public TableInputParametersEditEntryDialog(
			final TableInputParametersWidget widgetCallback,
			InputParameterExtensionElementChild inputParameterElement) {
		super();
		this.widgetCallback = widgetCallback;
		this.currentInputParameterElement = inputParameterElement;

		initialize();

		String currentType = "Text";
		if (inputParameterElement.getAttr_value() != null
				&& inputParameterElement.getAttr_value().length() > 0) {
			currentType = "Text";
		} else if (inputParameterElement.getListValueChilds().size() > 0) {
			currentType = "List";
		} else if (inputParameterElement.getMapEntryChilds().size() > 0) {
			currentType = "Map";
		} else if (inputParameterElement.getScriptChild() != null) {
			currentType = "Script";
		}

		for (int i = 0; i < lboxType.getItemCount(); i++) {
			if (lboxType.getItemText(i).equalsIgnoreCase(currentType)) {
				lboxType.setSelectedIndex(i);
				DomEvent.fireNativeEvent(Document.get().createChangeEvent(),
						lboxType);
				break;
			}
		}

		tbName.setText(inputParameterElement.getAttr_name());
		tbTextContent.setText(inputParameterElement.getAttr_value());

		if (currentInputParameterElement.getScriptChild() != null) {
			swScript.getTbFormat().setText(
					currentInputParameterElement.getScriptChild()
							.getAttr_scriptFormat());
			swScript.getTbResource().setText(
					currentInputParameterElement.getScriptChild()
							.getAttr_resource());
			swScript.getTaScript().setText(
					currentInputParameterElement.getScriptChild()
							.getAttr_script());

			if (currentInputParameterElement.getScriptChild()
					.getAttr_resource().length() > 0) {
				swScript.getRbResource().setValue(true);
				swScript.getTbResource().setEnabled(true);
				swScript.getTaScript().setEnabled(false);
			} else {
				swScript.getRbScript().setValue(true);
				swScript.getTaScript().setEnabled(true);
				swScript.getTbResource().setEnabled(false);
			}
		}

		tableList.update();
		tableMap.update();
	}

	private void initialize() {
		setTitle("Parameter Details");
		setText("Parameter Details");

		setAnimationEnabled(true);
		setGlassEnabled(true);
		setWidth("600px");
		setHeight("auto");

		vpRoot = new VerticalPanel();
		vpRoot.setWidth("100%");

		lboxType = new ListBox();
		lboxType.setWidth("100%");
		lboxType.addItem("Text");
		lboxType.addItem("Map");
		lboxType.addItem("List");
		lboxType.addItem("Script");

		lboxType.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				lbSelectedType.setText(lboxType.getSelectedItemText());
				tbTextContent.setText("");

				switch (lboxType.getSelectedItemText()) {
				case "Text":
					lbSelectedType.setText("Content");
					gridContent.setWidget(2, 1, tbTextContent);
					break;
				case "Script":
					lbSelectedType.setText("Script");
					gridContent.setWidget(2, 1, swScript);
					break;
				case "List":
					lbSelectedType.setText("Values");
					gridContent.setWidget(2, 1, tableList);
					break;
				case "Map":
					lbSelectedType.setText("Entries");
					gridContent.setWidget(2, 1, tableMap);
					break;
				}

			}
		});

		lbSelectedType = new Label("Content");

		tbName = new TextBox();
		tbName.setWidth("100%");
		tbTextContent = new TextBox();
		tbTextContent.setWidth("100%");

		swScript = new ScriptWidget();
		swScript.setWidth("100%");

		tableList = new EditInputOutputParameterTableListWidget(
				widgetCallback.getJsoAccess(), currentInputParameterElement);

		tableMap = new EditInputOutputParameterTableMapWidget(
				widgetCallback.getJsoAccess(), currentInputParameterElement);

		gridContent = new Grid(5, 2);
		gridContent.setWidth("100%");
		gridContent.setText(0, 0, "Name");
		gridContent.setText(1, 0, "Type");
		gridContent.setWidget(2, 0, lbSelectedType);

		gridContent.setWidget(0, 1, tbName);
		gridContent.setWidget(1, 1, lboxType);
		gridContent.setWidget(2, 1, tbTextContent);

		gridContent.getColumnFormatter().setWidth(0, "150px");

		btnOk = new Button("Save");
		btnOk.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				currentInputParameterElement.setAttr_name(tbName.getText());

				if (tbTextContent.getText().length() > 0) {
					currentInputParameterElement.setAttr_value(tbTextContent
							.getText());
				}

				if (lboxType.getSelectedItemText().equalsIgnoreCase("script")) {
					ScriptExtensionElementChild scriptJso = currentInputParameterElement
							.setScriptChild();
					scriptJso.setAttr_resource(swScript.getTbResource()
							.getText());
					scriptJso.setAttr_script(swScript.getTaScript().getText());
					scriptJso.setAttr_scriptFormat(swScript.getTbFormat()
							.getText());
				} else {
					currentInputParameterElement.removeScriptChild();
				}

				TableInputParametersEditEntryDialog.this.hide();

				widgetCallback.getDataProvider().refresh();
				widgetCallback.getJsoAccess().onContentChange();
			}
		});

		btnBack = new Button("Back");
		btnBack.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				TableInputParametersEditEntryDialog.this.hide();
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
