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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.ExecutionListenerJso;

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
		} else if (executionListenerModel.getAttr_expression().length() > 0) {
			currentType = "Expression";
		} else if (executionListenerModel.getAttr_delegateExpression().length() > 0) {
			currentType = "Delegate Expression";
		}
		// TODO: check if it is script

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

				switch (lboxType.getSelectedItemText()) {
				case "Class":
					gridContent.setWidget(2, 1, tbClass);
					break;
				case "Script":
					gridContent.setWidget(2, 1, new Label("not implemented"));
					break;
				case "Expression":
					gridContent.setWidget(2, 1, tbExpression);
					break;
				case "Delegate Expression":
					gridContent.setWidget(2, 1, tbDelegateExpression);
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

		gridContent = new Grid(3, 3);
		gridContent.setWidth("100%");
		gridContent.setText(0, 0, "Event");
		gridContent.setText(1, 0, "Type");
		gridContent.setWidget(2, 0, lbSelectedType);

		gridContent.setWidget(0, 1, lboxEvent);
		gridContent.setWidget(1, 1, lboxType);
		gridContent.setWidget(2, 1, tbClass);

		gridContent.getColumnFormatter().setWidth(0, "150px");

		btnOk = new Button("Save");
		btnOk.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				currentExecutionListenerJso
						.setAttr_event(TableExecutionListenerEditTableEntryDialog.this.lboxEvent
								.getSelectedItemText());
				currentExecutionListenerJso
						.setAttr_class(TableExecutionListenerEditTableEntryDialog.this.tbClass
								.getText());
				currentExecutionListenerJso
						.setAttr_expression(TableExecutionListenerEditTableEntryDialog.this.tbExpression
								.getText());
				currentExecutionListenerJso
						.setAttr_delegateExpression(TableExecutionListenerEditTableEntryDialog.this.tbDelegateExpression
								.getText());

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
