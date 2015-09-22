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

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Button;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.InputOutputParameterExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.ListValueExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnDataTableWidget;

public class EditInputOutputParameterTableListWidget extends
		AbstractBpmnDataTableWidget<ListValueExtensionElementChild> {

	private Column<ListValueExtensionElementChild, String> tcValue;
	private Column<ListValueExtensionElementChild, String> tcBtnRemove;
	private Button btnAdd;

	private InputOutputParameterExtensionElementChild currentInputParameterJso;

	public EditInputOutputParameterTableListWidget(
			BpmnPropertiesView.CurrentJsoAccess jsoAccess,
			InputOutputParameterExtensionElementChild currentInputParameterJso) {
		super(jsoAccess);
		Log.info(EditInputOutputParameterTableListWidget.class, "constructor");
		this.currentInputParameterJso = currentInputParameterJso;

		tcValue = new Column<ListValueExtensionElementChild, String>(
				new EditTextCell()) {

			@Override
			public String getValue(ListValueExtensionElementChild object) {
				if (null == object.getAttr_value()) {
					return "";
				}
				return object.getAttr_value();
			}
		};

		tcValue.setFieldUpdater(new FieldUpdater<ListValueExtensionElementChild, String>() {

			public void update(int index,
					final ListValueExtensionElementChild object,
					final String value) {
				object.setAttr_value(value);
				getTable().redraw();
				getJsoAccess().onContentChange();
			}

		});

		tcBtnRemove = new Column<ListValueExtensionElementChild, String>(
				new ButtonCell()) {
			@Override
			public String getValue(ListValueExtensionElementChild object) {
				return "x";
			}
		};

		tcBtnRemove
				.setFieldUpdater(new FieldUpdater<ListValueExtensionElementChild, String>() {

					@Override
					public void update(int index,
							ListValueExtensionElementChild object, String value) {
						EditInputOutputParameterTableListWidget.this.currentInputParameterJso
								.removeListValueChild(object);
						getDataProvider().getList().remove(object);
						getDataProvider().refresh();
						getTable().redraw();
						getJsoAccess().onContentChange();
					}
				});

		getTable().addColumn(tcValue, "Value");
		getTable().addColumn(tcBtnRemove, "");

		btnAdd = new Button("Add");
		btnAdd.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				ListValueExtensionElementChild newDataObject = EditInputOutputParameterTableListWidget.this.currentInputParameterJso
						.addListValueChild();
				getDataProvider().getList().add(newDataObject);
				getDataProvider().refresh();
				getTable().redraw();
				getJsoAccess().onContentChange();
			}
		});

		getButtonPanel().add(btnAdd);

		update();
	}

	@Override
	public void update() {
		getDataProvider().getList().clear();
		getDataProvider().getList().addAll(
				currentInputParameterJso.getListValueChilds());
	}

	public void setCurrentListJso(
			InputOutputParameterExtensionElementChild currentInputParameterJso) {
		this.currentInputParameterJso = currentInputParameterJso;
	}

}
