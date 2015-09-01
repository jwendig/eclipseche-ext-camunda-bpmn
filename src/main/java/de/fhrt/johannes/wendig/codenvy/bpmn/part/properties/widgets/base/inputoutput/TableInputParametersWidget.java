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

package de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.base.inputoutput;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.ExecutionListenerJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.InputParameterJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.TaskListenerJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.AbstractBpmnDataTableWidget;

public class TableInputParametersWidget extends
		AbstractBpmnDataTableWidget<InputParameterJso> {

	private TextColumn<InputParameterJso> tcName;
	private Column<InputParameterJso, String> tcBtnRemove;
	private Column<InputParameterJso, String> tcBtnEdit;
	private Button btnAdd;

	public TableInputParametersWidget(
			BpmnElementPropertiesView.ActionDelegate delegate) {
		super(delegate);
		tcName = new TextColumn<InputParameterJso>() {

			@Override
			public String getValue(InputParameterJso object) {
				return object.getAttr_name();
			}
		};

		tcBtnRemove = new Column<InputParameterJso, String>(new ButtonCell()) {
			@Override
			public String getValue(InputParameterJso object) {
				return "x";
			}
		};

		tcBtnRemove
				.setFieldUpdater(new FieldUpdater<InputParameterJso, String>() {

					@Override
					public void update(int index, InputParameterJso object,
							String value) {
						if (getDelegate().getCurrentElementJso()
								.removeCamundaExt_inputParameter(object)) {
							getDataProvider().getList().remove(object);
							getDataProvider().refresh();
							getTable().redraw();
							getDelegate().onContentChange();
						} else {

						}
					}
				});

		tcBtnEdit = new Column<InputParameterJso, String>(new ButtonCell()) {
			@Override
			public String getValue(InputParameterJso object) {
				return "Edit";
			}
		};

		tcBtnEdit
				.setFieldUpdater(new FieldUpdater<InputParameterJso, String>() {

					@Override
					public void update(int index, InputParameterJso object,
							String value) {
						new TableInputParametersEditEntryDialog(
								TableInputParametersWidget.this, object)
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
				InputParameterJso inputParameterJso = getDelegate()
						.getCurrentElementJso().addCamundaExt_inputParameter(
								getDelegate().getCurrentBpmnIoModelerJso()
										.nativeGetModdle());

				getDataProvider().getList().add(inputParameterJso);
				new TableInputParametersEditEntryDialog(
						TableInputParametersWidget.this, inputParameterJso)
						.center();

			}
		});

		getButtonPanel().add(btnAdd);

	}

	@Override
	public void update() {
		getDataProvider().getList().clear();
		List<InputParameterJso> dataObjects = getDelegate()
				.getCurrentElementJso().getCamundaExt_inputParameters();
		getDataProvider().getList().addAll(dataObjects);
	}
}
