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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.base.formfields;

import java.util.List;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnDataTableWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.ExecutionListenerJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.FormFieldJso;

public class TableFormFieldsWidget extends
		AbstractBpmnDataTableWidget<FormFieldJso> {

	private TextColumn<FormFieldJso> tcId;
	private TextColumn<FormFieldJso> tcLabel;
	private Column<FormFieldJso, String> tcBtnRemove;
	private Column<FormFieldJso, String> tcBtnEdit;
	private Button btnAdd;

	public TableFormFieldsWidget(
			BpmnElementPropertiesView.ActionDelegate delegate) {
		super(delegate);
		tcId = new TextColumn<FormFieldJso>() {

			@Override
			public String getValue(FormFieldJso object) {
				return object.getAttr_id();
			}
		};

		tcLabel = new TextColumn<FormFieldJso>() {

			@Override
			public String getValue(FormFieldJso object) {
				return object.getAttr_label();
			}
		};

		tcBtnRemove = new Column<FormFieldJso, String>(new ButtonCell()) {
			@Override
			public String getValue(FormFieldJso object) {
				return "x";
			}
		};

		tcBtnRemove.setFieldUpdater(new FieldUpdater<FormFieldJso, String>() {

			@Override
			public void update(int index, FormFieldJso object, String value) {
				if (getDelegate().getCurrentElementJso()
						.removeCamundaExt_formField(object)) {
					getDataProvider().getList().remove(object);
					getDataProvider().refresh();
					getTable().redraw();
					getDelegate().onContentChange();
				} else {

				}
			}
		});

		tcBtnEdit = new Column<FormFieldJso, String>(new ButtonCell()) {
			@Override
			public String getValue(FormFieldJso object) {
				return "Edit";
			}
		};

		tcBtnEdit.setFieldUpdater(new FieldUpdater<FormFieldJso, String>() {

			@Override
			public void update(int index, FormFieldJso object, String value) {
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
				FormFieldJso formFieldJso = getDelegate()
						.getCurrentElementJso().addCamundaExt_formField(
								getDelegate().getCurrentBpmnIoModelerJso()
										.nativeGetModdle());

				getDataProvider().getList().add(formFieldJso);

				new TableFormFieldsEditTableEntryDialog(
						TableFormFieldsWidget.this, formFieldJso).center();

			}
		});

		getButtonPanel().add(btnAdd);

	}

	@Override
	public void update() {
		getDataProvider().getList().clear();
		List<FormFieldJso> dataObjects = getDelegate().getCurrentElementJso()
				.getCamundaExt_formField();
		getDataProvider().getList().addAll(dataObjects);
	}
}
