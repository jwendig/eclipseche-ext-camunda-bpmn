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

package de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.base.formfields;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Button;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.FormFieldJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.childs.ConstraintJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.childs.PropertyJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.AbstractBpmnDataTableWidget;

public class EditFormFieldTableValidationWidget extends
		AbstractBpmnDataTableWidget<ConstraintJso> {

	private Column<ConstraintJso, String> tcName;
	private Column<ConstraintJso, String> tcConfig;
	private Column<ConstraintJso, String> tcBtnRemove;
	private Button btnAdd;

	private FormFieldJso currentFormFieldJso;

	public EditFormFieldTableValidationWidget(
			BpmnElementPropertiesView delegate, FormFieldJso currentFormFieldJso) {
		super(delegate);
		Log.info(EditFormFieldTableValidationWidget.class, "constructor");
		this.currentFormFieldJso = currentFormFieldJso;

		tcName = new Column<ConstraintJso, String>(new EditTextCell()) {

			@Override
			public String getValue(ConstraintJso object) {
				if (null == object.getAttr_name()) {
					return "";
				}
				return object.getAttr_name();
			}
		};

		tcName.setFieldUpdater(new FieldUpdater<ConstraintJso, String>() {

			public void update(int index, final ConstraintJso object,
					final String value) {
				object.setAttr_name(value);
				getTable().redraw();
				getDelegate().onContentChange();
			}

		});

		tcConfig = new Column<ConstraintJso, String>(new EditTextCell()) {

			@Override
			public String getValue(ConstraintJso object) {
				if (null == object.getAttr_config()) {
					return "";
				}
				return object.getAttr_config();
			}
		};

		tcConfig.setFieldUpdater(new FieldUpdater<ConstraintJso, String>() {

			public void update(int index, final ConstraintJso object,
					final String value) {
				object.setAttr_config(value);
				getTable().redraw();
				getDelegate().onContentChange();
			}

		});

		tcBtnRemove = new Column<ConstraintJso, String>(new ButtonCell()) {
			@Override
			public String getValue(ConstraintJso object) {
				return "x";
			}
		};

		tcBtnRemove.setFieldUpdater(new FieldUpdater<ConstraintJso, String>() {

			@Override
			public void update(int index, ConstraintJso object, String value) {
				if (EditFormFieldTableValidationWidget.this.currentFormFieldJso
						.removeConstraint(object)) {
					getDataProvider().getList().remove(object);
					getDataProvider().refresh();
					getTable().redraw();
					getDelegate().onContentChange();
				} else {

				}
			}
		});

		getTable().addColumn(tcName, "Name");
		getTable().addColumn(tcConfig, "Config");
		getTable().addColumn(tcBtnRemove, "");

		btnAdd = new Button("Add");
		btnAdd.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				ConstraintJso newDataObject = EditFormFieldTableValidationWidget.this.currentFormFieldJso
						.addConstraint(getDelegate()
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
		getDataProvider().getList().addAll(currentFormFieldJso.getContraints());
	}

	public void setCurrentFormFieldJso(FormFieldJso currentFormFieldJso) {
		this.currentFormFieldJso = currentFormFieldJso;
	}

}
