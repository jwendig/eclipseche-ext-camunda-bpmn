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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.formfields;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.FormFieldExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnDataTableWidget;

public class TableFormFieldsWidget extends
		AbstractBpmnDataTableWidget<FormFieldExtensionElementChild> {

	private TextColumn<FormFieldExtensionElementChild> tcId;
	private TextColumn<FormFieldExtensionElementChild> tcLabel;
	private Column<FormFieldExtensionElementChild, String> tcBtnRemove;
	private Column<FormFieldExtensionElementChild, String> tcBtnEdit;
	private Button btnAdd;

	public TableFormFieldsWidget(BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(jsoAccess);
		tcId = new TextColumn<FormFieldExtensionElementChild>() {

			@Override
			public String getValue(FormFieldExtensionElementChild object) {
				return object.getAttr_id();
			}
		};

		tcLabel = new TextColumn<FormFieldExtensionElementChild>() {

			@Override
			public String getValue(FormFieldExtensionElementChild object) {
				return object.getAttr_label();
			}
		};

		tcBtnRemove = new Column<FormFieldExtensionElementChild, String>(
				new ButtonCell()) {
			@Override
			public String getValue(FormFieldExtensionElementChild object) {
				return "x";
			}
		};

		tcBtnRemove
				.setFieldUpdater(new FieldUpdater<FormFieldExtensionElementChild, String>() {

					@Override
					public void update(int index, FormFieldExtensionElementChild object,
							String value) {
						getJsoAccess().getCurrentElement()
								.removeExtensionChildElementFormField(object);
						getDataProvider().getList().remove(object);
						getDataProvider().refresh();
						getTable().redraw();
						getJsoAccess().onContentChange();
					}
				});

		tcBtnEdit = new Column<FormFieldExtensionElementChild, String>(new ButtonCell()) {
			@Override
			public String getValue(FormFieldExtensionElementChild object) {
				return "Edit";
			}
		};

		tcBtnEdit
				.setFieldUpdater(new FieldUpdater<FormFieldExtensionElementChild, String>() {

					@Override
					public void update(int index, FormFieldExtensionElementChild object,
							String value) {
						new TableFormFieldsEditTableEntryDialog(
								TableFormFieldsWidget.this, object).center();

					}
				});

		getTable().addColumn(tcId, "Id");
		getTable().addColumn(tcLabel, "Label");
		getTable().addColumn(tcBtnEdit, "");
		getTable().setColumnWidth(2, "50px");
		getTable().addColumn(tcBtnRemove, "");
		getTable().setColumnWidth(3, "20px");

		btnAdd = new Button("Add");
		btnAdd.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				FormFieldExtensionElementChild formField = getJsoAccess()
						.getCurrentElement()
						.addExtensionChildElementFormField();
				getDataProvider().getList().add(formField);

				new TableFormFieldsEditTableEntryDialog(
						TableFormFieldsWidget.this, formField).center();

			}
		});

		getButtonPanel().add(btnAdd);

	}

	@Override
	public void update() {
		getDataProvider().getList().clear();
		getDataProvider().getList().addAll(
				getJsoAccess().getCurrentElement()
						.getExtensionChildElementsFormField());
	}
}
