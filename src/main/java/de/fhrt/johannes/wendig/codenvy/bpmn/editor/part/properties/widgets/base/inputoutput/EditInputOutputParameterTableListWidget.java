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

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Button;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnDataTableWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.InputOutputParameterJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.childs.ListValueJso;

public class EditInputOutputParameterTableListWidget extends
		AbstractBpmnDataTableWidget<ListValueJso> {

	private Column<ListValueJso, String> tcValue;
	private Column<ListValueJso, String> tcBtnRemove;
	private Button btnAdd;

	private InputOutputParameterJso currentInputParameterJso;

	public EditInputOutputParameterTableListWidget(
			BpmnElementPropertiesView.ActionDelegate delegate,
			InputOutputParameterJso currentInputParameterJso) {
		super(delegate);
		Log.info(EditInputOutputParameterTableListWidget.class, "constructor");
		this.currentInputParameterJso = currentInputParameterJso;

		tcValue = new Column<ListValueJso, String>(new EditTextCell()) {

			@Override
			public String getValue(ListValueJso object) {
				if (null == object.getAttr_value()) {
					return "";
				}
				return object.getAttr_value();
			}
		};

		tcValue.setFieldUpdater(new FieldUpdater<ListValueJso, String>() {

			public void update(int index, final ListValueJso object,
					final String value) {
				object.setAttr_value(value);
				getTable().redraw();
				getDelegate().onContentChange();
			}

		});

		tcBtnRemove = new Column<ListValueJso, String>(new ButtonCell()) {
			@Override
			public String getValue(ListValueJso object) {
				return "x";
			}
		};

		tcBtnRemove.setFieldUpdater(new FieldUpdater<ListValueJso, String>() {

			@Override
			public void update(int index, ListValueJso object, String value) {
				if (EditInputOutputParameterTableListWidget.this.currentInputParameterJso
						.removeListValue(object)) {
					getDataProvider().getList().remove(object);
					getDataProvider().refresh();
					getTable().redraw();
					getDelegate().onContentChange();
				} else {

				}
			}
		});

		getTable().addColumn(tcValue, "Value");
		getTable().addColumn(tcBtnRemove, "");

		btnAdd = new Button("Add");
		btnAdd.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				ListValueJso newDataObject = EditInputOutputParameterTableListWidget.this.currentInputParameterJso
						.addListValue(getDelegate()
								.getCurrentBpmnIoModelerJso().nativeGetModdle());

				getDataProvider().getList().add(newDataObject);
				getDataProvider().refresh();
				getTable().redraw();
				getDelegate().onContentChange();
			}
		});

		getButtonPanel().add(btnAdd);

		update();
	}

	@Override
	public void update() {
		getDataProvider().getList().clear();
		getDataProvider().getList().addAll(
				currentInputParameterJso.getListValues());
	}

	public void setCurrentListJso(
			InputOutputParameterJso currentInputParameterJso) {
		this.currentInputParameterJso = currentInputParameterJso;
	}

}
