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
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.OutputParameterExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnDataTableWidget;

public class TableOutputParametersWidget extends
		AbstractBpmnDataTableWidget<OutputParameterExtensionElementChild> {

	private TextColumn<OutputParameterExtensionElementChild> tcName;
	private Column<OutputParameterExtensionElementChild, String> tcBtnRemove;
	private Column<OutputParameterExtensionElementChild, String> tcBtnEdit;
	private Button btnAdd;

	public TableOutputParametersWidget(
			BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(jsoAccess);
		tcName = new TextColumn<OutputParameterExtensionElementChild>() {

			@Override
			public String getValue(OutputParameterExtensionElementChild object) {
				return object.getAttr_name();
			}
		};

		tcBtnRemove = new Column<OutputParameterExtensionElementChild, String>(
				new ButtonCell()) {
			@Override
			public String getValue(OutputParameterExtensionElementChild object) {
				return "x";
			}
		};

		tcBtnRemove
				.setFieldUpdater(new FieldUpdater<OutputParameterExtensionElementChild, String>() {

					@Override
					public void update(int index,
							OutputParameterExtensionElementChild object,
							String value) {
						getJsoAccess().getCurrentElement()
								.removeExtensionChildElementOutputParameter(
										object);
						getDataProvider().getList().remove(object);
						getDataProvider().refresh();
						getTable().redraw();
						getJsoAccess().onContentChange();
					}
				});

		tcBtnEdit = new Column<OutputParameterExtensionElementChild, String>(
				new ButtonCell()) {
			@Override
			public String getValue(OutputParameterExtensionElementChild object) {
				return "Edit";
			}
		};

		tcBtnEdit
				.setFieldUpdater(new FieldUpdater<OutputParameterExtensionElementChild, String>() {

					@Override
					public void update(int index,
							OutputParameterExtensionElementChild object,
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
				OutputParameterExtensionElementChild outputParameter = getJsoAccess()
						.getCurrentElement()
						.addExtensionChildElementOutputParameter();

				getDataProvider().getList().add(outputParameter);
				new TableOutputParametersEditEntryDialog(
						TableOutputParametersWidget.this, outputParameter)
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
						.getExtensionChildElementsOutputParameters());
	}
}
