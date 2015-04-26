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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.startevent.formfields;

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

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.ExecutionListenerJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.FormFieldJso;

public class TableFormFieldsEditTableEntryDialog extends DialogBox {

	private Button btnOk;
	private Button btnBack;
	private VerticalPanel vpRoot;
	private Grid gridContent;

	private ListBox lboxType;

	private TextBox tbId;
	private TextBox tbLabel;
	private TextBox tbDefaultValue;

	private TableFormFieldsWidget widgetCallback;
	private FormFieldJso currentFormFieldJso;

	public TableFormFieldsEditTableEntryDialog(
			final TableFormFieldsWidget widgetCallback) {
		super();
		this.widgetCallback = widgetCallback;

		setTitle("Form Field Details");
		setText("Form Field Details");

		setAnimationEnabled(true);
		setGlassEnabled(true);
		setWidth("600px");
		setHeight("auto");

		vpRoot = new VerticalPanel();
		vpRoot.setWidth("100%");

		lboxType = new ListBox();
		lboxType.setWidth("100%");
		lboxType.addItem("string");
		lboxType.addItem("long");
		lboxType.addItem("boolean");
		lboxType.addItem("date");
		lboxType.addItem("enum");

		tbId = new TextBox();
		tbId.setWidth("100%");
		tbLabel = new TextBox();
		tbLabel.setWidth("100%");
		tbDefaultValue = new TextBox();
		tbDefaultValue.setWidth("100%");

		gridContent = new Grid(4, 3);
		gridContent.setWidth("100%");
		gridContent.setText(0, 0, "Id");
		gridContent.setText(1, 0, "Label");
		gridContent.setText(2, 0, "Default Value");
		gridContent.setText(3, 0, "Type");

		gridContent.setWidget(0, 1, tbId);
		gridContent.setWidget(1, 1, tbLabel);
		gridContent.setWidget(2, 1, tbDefaultValue);
		gridContent.setWidget(3, 1, lboxType);

		gridContent.getColumnFormatter().setWidth(0, "150px");

		btnOk = new Button("Save");
		btnOk.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				FormFieldJso formFieldJso;
				if (null != TableFormFieldsEditTableEntryDialog.this.currentFormFieldJso) {
					formFieldJso = currentFormFieldJso;
				} else {
					formFieldJso = widgetCallback
							.getDelegate()
							.getCurrentElementJso()
							.addCamundaExt_formField(
									widgetCallback.getDelegate()
											.getCurrentBpmnIoModelerJso()
											.nativeGetModdle());
					widgetCallback.getDataProvider().getList()
							.add(formFieldJso);
				}

				formFieldJso
						.setAttr_id(TableFormFieldsEditTableEntryDialog.this.tbId
								.getText());
				formFieldJso
						.setAttr_label(TableFormFieldsEditTableEntryDialog.this.tbLabel
								.getText());
				formFieldJso
						.setAttr_defaultValue(TableFormFieldsEditTableEntryDialog.this.tbDefaultValue
								.getText());
				formFieldJso
						.setAttr_type(TableFormFieldsEditTableEntryDialog.this.lboxType
								.getSelectedItemText());

				TableFormFieldsEditTableEntryDialog.this.hide();

				widgetCallback.getDataProvider().refresh();
				widgetCallback.getDelegate().onContentChange();
			}
		});

		btnBack = new Button("Back");
		btnBack.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				TableFormFieldsEditTableEntryDialog.this.hide();
			}
		});

		HorizontalPanel hpOptions = new HorizontalPanel();
		hpOptions.add(btnOk);
		hpOptions.add(btnBack);

		vpRoot.add(gridContent);
		vpRoot.add(hpOptions);

		setWidget(vpRoot);
	}

	public TableFormFieldsEditTableEntryDialog(
			final TableFormFieldsWidget widgetCallback,
			FormFieldJso formFieldJso) {
		this(widgetCallback);
		this.currentFormFieldJso = formFieldJso;

		for (int i = 0; i < lboxType.getItemCount(); i++) {
			if (lboxType.getItemText(i).equalsIgnoreCase(
					formFieldJso.getAttr_type())) {
				lboxType.setSelectedIndex(i);
				break;
			}
		}

		tbId.setText(formFieldJso.getAttr_id());
		tbLabel.setText(formFieldJso.getAttr_label());
		tbDefaultValue.setText(formFieldJso.getAttr_defaultValue());
	}

}
