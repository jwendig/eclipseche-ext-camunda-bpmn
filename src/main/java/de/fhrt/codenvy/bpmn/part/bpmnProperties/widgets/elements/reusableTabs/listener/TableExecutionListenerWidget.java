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
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.ExecutionListenerExtensionElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.ScriptExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnDataTableWidget;

public class TableExecutionListenerWidget extends
		AbstractBpmnDataTableWidget<ExecutionListenerExtensionElement> {

	private TextColumn<ExecutionListenerExtensionElement> tcExecutionListenersClass;
	private TextColumn<ExecutionListenerExtensionElement> tcExecutionListenersEvent;
	private TextColumn<ExecutionListenerExtensionElement> tcExecutionListenersExpression;
	private TextColumn<ExecutionListenerExtensionElement> tcExecutionListenersDelegateExpression;
	private TextColumn<ExecutionListenerExtensionElement> tcExecutionListenersScript;
	private Column<ExecutionListenerExtensionElement, String> tcExecutionListenerBtnRemove;
	private Column<ExecutionListenerExtensionElement, String> tcExecutionListenerBtnEdit;
	private Button btnAddExecutionListener;

	public TableExecutionListenerWidget(
			BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(jsoAccess);
		tcExecutionListenersClass = new TextColumn<ExecutionListenerExtensionElement>() {

			@Override
			public String getValue(ExecutionListenerExtensionElement object) {
				return object.getAttr_class();
			}
		};

		tcExecutionListenersEvent = new TextColumn<ExecutionListenerExtensionElement>() {

			@Override
			public String getValue(ExecutionListenerExtensionElement object) {
				return object.getAttr_event();
			}
		};

		tcExecutionListenersExpression = new TextColumn<ExecutionListenerExtensionElement>() {

			@Override
			public String getValue(ExecutionListenerExtensionElement object) {
				return object.getAttr_expression();
			}
		};

		tcExecutionListenersDelegateExpression = new TextColumn<ExecutionListenerExtensionElement>() {

			@Override
			public String getValue(ExecutionListenerExtensionElement object) {
				return object.getAttr_delegateExpression();
			}
		};

		tcExecutionListenersScript = new TextColumn<ExecutionListenerExtensionElement>() {

			@Override
			public String getValue(ExecutionListenerExtensionElement object) {
				if (null != object.getScriptChild()) {
					ScriptExtensionElementChild scriptJso = object.getScriptChild();
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

		tcExecutionListenerBtnRemove = new Column<ExecutionListenerExtensionElement, String>(
				new ButtonCell()) {
			@Override
			public String getValue(ExecutionListenerExtensionElement object) {
				return "x";
			}
		};

		tcExecutionListenerBtnRemove
				.setFieldUpdater(new FieldUpdater<ExecutionListenerExtensionElement, String>() {

					@Override
					public void update(int index,
							ExecutionListenerExtensionElement object,
							String value) {

						getJsoAccess()
								.getCurrentElement()
								.removeExtensionElementExecutionListener(object);
						getDataProvider().getList().remove(object);
						getDataProvider().refresh();
						getTable().redraw();
						getJsoAccess().onContentChange();
					}
				});

		tcExecutionListenerBtnEdit = new Column<ExecutionListenerExtensionElement, String>(
				new ButtonCell()) {
			@Override
			public String getValue(ExecutionListenerExtensionElement object) {
				return "Edit";
			}
		};

		tcExecutionListenerBtnEdit
				.setFieldUpdater(new FieldUpdater<ExecutionListenerExtensionElement, String>() {

					@Override
					public void update(int index,
							ExecutionListenerExtensionElement object,
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
		getTable().addColumn(tcExecutionListenersScript, "Script");
		getTable().addColumn(tcExecutionListenersEvent, "Event");
		getTable().addColumn(tcExecutionListenerBtnEdit, "");
		getTable().addColumn(tcExecutionListenerBtnRemove, "");

		btnAddExecutionListener = new Button("Add");
		btnAddExecutionListener.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				ExecutionListenerExtensionElement executionListener = getJsoAccess()
						.getCurrentElement()
						.addExtensionElementExecutionListener();

				getDataProvider().getList().add(executionListener);

				new TableExecutionListenerEditTableEntryDialog(
						TableExecutionListenerWidget.this, executionListener)
						.center();
			}
		});

		getButtonPanel().add(btnAddExecutionListener);

	}

	@Override
	public void update() {
		getDataProvider().getList().clear();
		getDataProvider().getList().addAll(
				getJsoAccess().getCurrentElement()
						.getExecutionListenerExtensionElements());
	}
}
