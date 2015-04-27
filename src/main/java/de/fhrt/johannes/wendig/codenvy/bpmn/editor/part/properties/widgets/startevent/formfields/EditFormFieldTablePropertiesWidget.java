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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.startevent.formfields;

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
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.FormFieldJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.PropertyJso;

public class EditFormFieldTablePropertiesWidget extends
		AbstractBpmnDataTableWidget<PropertyJso> {

	private Column<PropertyJso, String> tcName;
	private Column<PropertyJso, String> tcValue;
	private Column<PropertyJso, String> tcId;
	private Column<PropertyJso, String> tcBtnRemove;
	private Button btnAdd;

	private FormFieldJso currentFormFieldJso;

	public EditFormFieldTablePropertiesWidget(
			BpmnElementPropertiesView.ActionDelegate delegate,
			FormFieldJso currentFormFieldJso) {
		super(delegate);
		Log.info(EditFormFieldTablePropertiesWidget.class, "constructor");
		this.currentFormFieldJso = currentFormFieldJso;

		if (null == this.currentFormFieldJso) {
			Log.info(EditFormFieldTablePropertiesWidget.class,
					"constructor: currentFormFieldJso IS NULL");
		}

		if (null == delegate) {
			Log.info(EditFormFieldTablePropertiesWidget.class,
					"constructor: delegate IS NULL");
		}

		if (null == getDelegate().getCurrentBpmnIoModelerJso()
				.nativeGetModdle()) {
			Log.info(EditFormFieldTablePropertiesWidget.class,
					"constructor: moddle IS NULL");
		}

		tcName = new Column<PropertyJso, String>(new EditTextCell()) {

			@Override
			public String getValue(PropertyJso object) {
				if (null == object.getAttr_name()) {
					return "";
				}
				return object.getAttr_name();
			}
		};

		tcName.setFieldUpdater(new FieldUpdater<PropertyJso, String>() {

			public void update(int index, final PropertyJso object,
					final String value) {
				object.setAttr_name(value);
				getTable().redraw();
				getDelegate().onContentChange();
			}

		});

		tcValue = new Column<PropertyJso, String>(new EditTextCell()) {

			@Override
			public String getValue(PropertyJso object) {
				if (null == object.getAttr_value()) {
					return "";
				}
				return object.getAttr_value();
			}
		};

		tcValue.setFieldUpdater(new FieldUpdater<PropertyJso, String>() {

			public void update(int index, final PropertyJso object,
					final String value) {
				object.setAttr_value(value);
				getTable().redraw();
				getDelegate().onContentChange();
			}

		});

		tcId = new Column<PropertyJso, String>(new EditTextCell()) {

			@Override
			public String getValue(PropertyJso object) {
				if (null == object.getAttr_id()) {
					return "";
				}
				return object.getAttr_id();
			}
		};

		tcId.setFieldUpdater(new FieldUpdater<PropertyJso, String>() {

			public void update(int index, final PropertyJso object,
					final String value) {
				object.setAttr_id(value);
				getTable().redraw();
				getDelegate().onContentChange();
			}

		});

		tcBtnRemove = new Column<PropertyJso, String>(new ButtonCell()) {
			@Override
			public String getValue(PropertyJso object) {
				return "x";
			}
		};

		tcBtnRemove.setFieldUpdater(new FieldUpdater<PropertyJso, String>() {

			@Override
			public void update(int index, PropertyJso object, String value) {
				if (EditFormFieldTablePropertiesWidget.this.currentFormFieldJso
						.removeProperty(object)) {
					getDataProvider().getList().remove(object);
					getDataProvider().refresh();
					getTable().redraw();
					getDelegate().onContentChange();
				} else {

				}
			}
		});

		getTable().addColumn(tcName, "Name");
		getTable().addColumn(tcValue, "Value");
		getTable().addColumn(tcId, "Id");
		getTable().addColumn(tcBtnRemove, "");

		btnAdd = new Button("Add");
		btnAdd.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				PropertyJso newDataObject = EditFormFieldTablePropertiesWidget.this.currentFormFieldJso
						.addProperty(getDelegate().getCurrentBpmnIoModelerJso()
								.nativeGetModdle());
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
		getDataProvider().getList().addAll(currentFormFieldJso.getProperties());
	}

	public void setCurrentFormFieldJso(FormFieldJso currentFormFieldJso) {
		this.currentFormFieldJso = currentFormFieldJso;
	}

}
