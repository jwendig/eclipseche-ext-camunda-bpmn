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
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.ExecutionListenerJso;

public class TableExecutionListenerWidget extends
		AbstractBpmnDataTableWidget<ExecutionListenerJso> {

	private TextColumn<ExecutionListenerJso> tcExecutionListenersClass;
	private TextColumn<ExecutionListenerJso> tcExecutionListenersEvent;
	private TextColumn<ExecutionListenerJso> tcExecutionListenersExpression;
	private TextColumn<ExecutionListenerJso> tcExecutionListenersDelegateExpression;
	private Column<ExecutionListenerJso, String> tcExecutionListenerBtnRemove;
	private Column<ExecutionListenerJso, String> tcExecutionListenerBtnEdit;
	private Button btnAddExecutionListener;

	public TableExecutionListenerWidget(
			BpmnElementPropertiesView.ActionDelegate delegate) {
		super(delegate);
		tcExecutionListenersClass = new TextColumn<ExecutionListenerJso>() {

			@Override
			public String getValue(ExecutionListenerJso object) {
				return object.getAttr_class();
			}
		};

		tcExecutionListenersEvent = new TextColumn<ExecutionListenerJso>() {

			@Override
			public String getValue(ExecutionListenerJso object) {
				return object.getAttr_event();
			}
		};

		tcExecutionListenersExpression = new TextColumn<ExecutionListenerJso>() {

			@Override
			public String getValue(ExecutionListenerJso object) {
				return object.getAttr_expression();
			}
		};

		tcExecutionListenersDelegateExpression = new TextColumn<ExecutionListenerJso>() {

			@Override
			public String getValue(ExecutionListenerJso object) {
				return object.getAttr_delegateExpression();
			}
		};

		tcExecutionListenerBtnRemove = new Column<ExecutionListenerJso, String>(
				new ButtonCell()) {
			@Override
			public String getValue(ExecutionListenerJso object) {
				return "x";
			}
		};

		tcExecutionListenerBtnRemove
				.setFieldUpdater(new FieldUpdater<ExecutionListenerJso, String>() {

					@Override
					public void update(int index, ExecutionListenerJso object,
							String value) {
						if (getDelegate().getCurrentElementJso()
								.removeCamundaExt_executionListener(object)) {
							getDataProvider().getList().remove(object);
							getDataProvider().refresh();
							getTable().redraw();
							getDelegate().onContentChange();
						} else {

						}
					}
				});

		tcExecutionListenerBtnEdit = new Column<ExecutionListenerJso, String>(
				new ButtonCell()) {
			@Override
			public String getValue(ExecutionListenerJso object) {
				return "Edit";
			}
		};

		tcExecutionListenerBtnEdit
				.setFieldUpdater(new FieldUpdater<ExecutionListenerJso, String>() {

					@Override
					public void update(int index, ExecutionListenerJso object,
							String value) {
						new TableExecutionListenerEditTableEntryDialog(
								TableExecutionListenerWidget.this, object)
								.center();

					}
				});

		getTable().addColumn(tcExecutionListenersClass, "Class");
		getTable().addColumn(tcExecutionListenersExpression, "Expression");
		getTable().addColumn(tcExecutionListenersDelegateExpression,
				"DelegateExpression");
		getTable().addColumn(tcExecutionListenersEvent, "Event");
		getTable().addColumn(tcExecutionListenerBtnEdit, "");
		getTable().addColumn(tcExecutionListenerBtnRemove, "");

		btnAddExecutionListener = new Button("Add");
		btnAddExecutionListener.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				new TableExecutionListenerEditTableEntryDialog(
						TableExecutionListenerWidget.this).center();

			}
		});

		getButtonPanel().add(btnAddExecutionListener);

	}

	@Override
	public void update() {
		getDataProvider().getList().clear();
		List<ExecutionListenerJso> dataObjects = getDelegate()
				.getCurrentElementJso().getCamundaExt_executionListeners();
		getDataProvider().getList().addAll(dataObjects);
	}
}
