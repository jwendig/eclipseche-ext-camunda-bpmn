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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.listener;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.TaskListenerExtensionElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.ScriptExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnDataTableWidget;

public class TableTaskListenerWidget extends
		AbstractBpmnDataTableWidget<TaskListenerExtensionElement> {

	private TextColumn<TaskListenerExtensionElement> tcExecutionListenersClass;
	private TextColumn<TaskListenerExtensionElement> tcExecutionListenersEvent;
	private TextColumn<TaskListenerExtensionElement> tcExecutionListenersExpression;
	private TextColumn<TaskListenerExtensionElement> tcExecutionListenersDelegateExpression;
	private TextColumn<TaskListenerExtensionElement> tcExecutionListenersScript;
	private Column<TaskListenerExtensionElement, String> tcExecutionListenerBtnRemove;
	private Column<TaskListenerExtensionElement, String> tcExecutionListenerBtnEdit;
	private Button btnAddTaskListener;

	public TableTaskListenerWidget(BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(jsoAccess);
		tcExecutionListenersClass = new TextColumn<TaskListenerExtensionElement>() {

			@Override
			public String getValue(TaskListenerExtensionElement object) {
				return object.getAttr_class();
			}
		};

		tcExecutionListenersEvent = new TextColumn<TaskListenerExtensionElement>() {

			@Override
			public String getValue(TaskListenerExtensionElement object) {
				return object.getAttr_event();
			}
		};

		tcExecutionListenersExpression = new TextColumn<TaskListenerExtensionElement>() {

			@Override
			public String getValue(TaskListenerExtensionElement object) {
				return object.getAttr_expression();
			}
		};

		tcExecutionListenersDelegateExpression = new TextColumn<TaskListenerExtensionElement>() {

			@Override
			public String getValue(TaskListenerExtensionElement object) {
				return object.getAttr_delegateExpression();
			}
		};

		tcExecutionListenersScript = new TextColumn<TaskListenerExtensionElement>() {

			@Override
			public String getValue(TaskListenerExtensionElement object) {
				if (null != object.getScriptChild()) {
					ScriptExtensionElementChild scriptJso = object
							.getScriptChild();
					StringBuilder sbValue = new StringBuilder();
					sbValue.append("format: ");
					sbValue.append(scriptJso.getAttr_scriptFormat());

					if (scriptJso.getAttr_resource().length() > 0) {
						sbValue.append("; resource: ");
						sbValue.append(scriptJso.getAttr_resource());
					} else {
						sbValue.append("; script: ");
						sbValue.append(scriptJso.getAttr_script());
					}

					return sbValue.toString();
				} else {
					return "";
				}
			}
		};

		tcExecutionListenerBtnRemove = new Column<TaskListenerExtensionElement, String>(
				new ButtonCell()) {
			@Override
			public String getValue(TaskListenerExtensionElement object) {
				return "x";
			}
		};

		tcExecutionListenerBtnRemove
				.setFieldUpdater(new FieldUpdater<TaskListenerExtensionElement, String>() {

					@Override
					public void update(int index,
							TaskListenerExtensionElement object, String value) {
						getJsoAccess().getCurrentElement()
								.removeTaskListenerExtensionElement(object);
						getDataProvider().getList().remove(object);
						getDataProvider().refresh();
						getTable().redraw();
						getJsoAccess().onContentChange();

					}
				});

		tcExecutionListenerBtnEdit = new Column<TaskListenerExtensionElement, String>(
				new ButtonCell()) {
			@Override
			public String getValue(TaskListenerExtensionElement object) {
				return "Edit";
			}
		};

		tcExecutionListenerBtnEdit
				.setFieldUpdater(new FieldUpdater<TaskListenerExtensionElement, String>() {

					@Override
					public void update(int index,
							TaskListenerExtensionElement object, String value) {
						new TableTaskListenerEditTableEntryDialog(
								TableTaskListenerWidget.this, object).center();

					}
				});

		getTable().addColumn(tcExecutionListenersClass, "Class");
		getTable().addColumn(tcExecutionListenersExpression, "Expression");
		getTable().addColumn(tcExecutionListenersDelegateExpression,
				"DelegateExpression");
		getTable().addColumn(tcExecutionListenersScript, "Script");
		getTable().addColumn(tcExecutionListenersEvent, "Event");
		getTable().addColumn(tcExecutionListenerBtnEdit, "");
		getTable().addColumn(tcExecutionListenerBtnRemove, "");

		btnAddTaskListener = new Button("Add");
		btnAddTaskListener.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				TaskListenerExtensionElement taskListener = getJsoAccess()
						.getCurrentElement().addExtensionElementTaskListener();

				getDataProvider().getList().add(taskListener);

				new TableTaskListenerEditTableEntryDialog(
						TableTaskListenerWidget.this, taskListener).center();

			}
		});

		getButtonPanel().add(btnAddTaskListener);

	}

	@Override
	public void update() {
		getDataProvider().getList().clear();
		getDataProvider().getList().addAll(
				getJsoAccess().getCurrentElement()
						.getTaskListenerExtensionElements());
	}
}
