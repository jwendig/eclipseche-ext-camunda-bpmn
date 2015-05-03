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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.base.inputoutput;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnDataTableWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.OutputParameterJso;

public class TableOutputParametersWidget extends
		AbstractBpmnDataTableWidget<OutputParameterJso> {

	private TextColumn<OutputParameterJso> tcName;
	private Column<OutputParameterJso, String> tcBtnRemove;
	private Column<OutputParameterJso, String> tcBtnEdit;
	private Button btnAdd;

	public TableOutputParametersWidget(
			BpmnElementPropertiesView.ActionDelegate delegate) {
		super(delegate);
		tcName = new TextColumn<OutputParameterJso>() {

			@Override
			public String getValue(OutputParameterJso object) {
				return object.getAttr_name();
			}
		};

		tcBtnRemove = new Column<OutputParameterJso, String>(new ButtonCell()) {
			@Override
			public String getValue(OutputParameterJso object) {
				return "x";
			}
		};

		tcBtnRemove
				.setFieldUpdater(new FieldUpdater<OutputParameterJso, String>() {

					@Override
					public void update(int index, OutputParameterJso object,
							String value) {
						if (getDelegate().getCurrentElementJso()
								.removeCamundaExt_outputParameter(object)) {
							getDataProvider().getList().remove(object);
							getDataProvider().refresh();
							getTable().redraw();
							getDelegate().onContentChange();
						} else {

						}
					}
				});

		tcBtnEdit = new Column<OutputParameterJso, String>(new ButtonCell()) {
			@Override
			public String getValue(OutputParameterJso object) {
				return "Edit";
			}
		};

		tcBtnEdit
				.setFieldUpdater(new FieldUpdater<OutputParameterJso, String>() {

					@Override
					public void update(int index, OutputParameterJso object,
							String value) {
						new TableOutputParametersEditEntryDialog(
								TableOutputParametersWidget.this, object)
								.center();

					}
				});

		getTable().addColumn(tcName, "Name");
		getTable().addColumn(tcBtnEdit, "");
		getTable().addColumn(tcBtnRemove, "");

		btnAdd = new Button("Add");
		btnAdd.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				OutputParameterJso inputParameterJso = getDelegate()
						.getCurrentElementJso().addCamundaExt_outputParameter(
								getDelegate().getCurrentBpmnIoModelerJso()
										.nativeGetModdle());

				getDataProvider().getList().add(inputParameterJso);
				new TableOutputParametersEditEntryDialog(
						TableOutputParametersWidget.this, inputParameterJso)
						.center();

			}
		});

		getButtonPanel().add(btnAdd);

	}

	@Override
	public void update() {
		getDataProvider().getList().clear();
		List<OutputParameterJso> dataObjects = getDelegate()
				.getCurrentElementJso().getCamundaExt_outputParameters();
		getDataProvider().getList().addAll(dataObjects);
	}
}
