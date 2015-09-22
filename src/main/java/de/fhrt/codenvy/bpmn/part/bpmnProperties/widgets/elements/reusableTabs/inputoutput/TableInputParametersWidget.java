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

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.InputParameterExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnDataTableWidget;

public class TableInputParametersWidget extends
		AbstractBpmnDataTableWidget<InputParameterExtensionElementChild> {

	private TextColumn<InputParameterExtensionElementChild> tcName;
	private Column<InputParameterExtensionElementChild, String> tcBtnRemove;
	private Column<InputParameterExtensionElementChild, String> tcBtnEdit;
	private Button btnAdd;

	public TableInputParametersWidget(
			BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(jsoAccess);
		tcName = new TextColumn<InputParameterExtensionElementChild>() {

			@Override
			public String getValue(InputParameterExtensionElementChild object) {
				return object.getAttr_name();
			}
		};

		tcBtnRemove = new Column<InputParameterExtensionElementChild, String>(
				new ButtonCell()) {
			@Override
			public String getValue(InputParameterExtensionElementChild object) {
				return "x";
			}
		};

		tcBtnRemove
				.setFieldUpdater(new FieldUpdater<InputParameterExtensionElementChild, String>() {

					@Override
					public void update(int index,
							InputParameterExtensionElementChild object,
							String value) {
						getJsoAccess().getCurrentElement()
								.removeExtensionChildElementInputParameter(
										object);
						getDataProvider().getList().remove(object);
						getDataProvider().refresh();
						getTable().redraw();
						getJsoAccess().onContentChange();
					}
				});

		tcBtnEdit = new Column<InputParameterExtensionElementChild, String>(
				new ButtonCell()) {
			@Override
			public String getValue(InputParameterExtensionElementChild object) {
				return "Edit";
			}
		};

		tcBtnEdit
				.setFieldUpdater(new FieldUpdater<InputParameterExtensionElementChild, String>() {

					@Override
					public void update(int index,
							InputParameterExtensionElementChild object,
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
				InputParameterExtensionElementChild inputParameterJso = getJsoAccess()
						.getCurrentElement()
						.addExtensionChildElementInputParameter();
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
		getDataProvider().getList().addAll(
				getJsoAccess().getCurrentElement()
						.getExtensionChildElementsInputParameters());
	}
}
