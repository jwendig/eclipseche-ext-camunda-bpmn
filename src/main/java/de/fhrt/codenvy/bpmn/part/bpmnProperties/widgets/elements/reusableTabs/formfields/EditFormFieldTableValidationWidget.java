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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.formfields;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Button;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.ConstraintExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.FormFieldExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnDataTableWidget;

public class EditFormFieldTableValidationWidget extends
		AbstractBpmnDataTableWidget<ConstraintExtensionElementChild> {

	private Column<ConstraintExtensionElementChild, String> tcName;
	private Column<ConstraintExtensionElementChild, String> tcConfig;
	private Column<ConstraintExtensionElementChild, String> tcBtnRemove;
	private Button btnAdd;

	private FormFieldExtensionElementChild currentFormFieldJso;

	public EditFormFieldTableValidationWidget(
			BpmnPropertiesView.CurrentJsoAccess jsoAccess,
			FormFieldExtensionElementChild currentFormFieldJso) {
		super(jsoAccess);
		Log.info(EditFormFieldTableValidationWidget.class, "constructor");
		this.currentFormFieldJso = currentFormFieldJso;

		tcName = new Column<ConstraintExtensionElementChild, String>(
				new EditTextCell()) {

			@Override
			public String getValue(ConstraintExtensionElementChild object) {
				if (null == object.getAttr_name()) {
					return "";
				}
				return object.getAttr_name();
			}
		};

		tcName.setFieldUpdater(new FieldUpdater<ConstraintExtensionElementChild, String>() {

			public void update(int index,
					final ConstraintExtensionElementChild object,
					final String value) {
				object.setAttr_name(value);
				getTable().redraw();
				getJsoAccess().onContentChange();
			}

		});

		tcConfig = new Column<ConstraintExtensionElementChild, String>(
				new EditTextCell()) {

			@Override
			public String getValue(ConstraintExtensionElementChild object) {
				if (null == object.getAttr_config()) {
					return "";
				}
				return object.getAttr_config();
			}
		};

		tcConfig.setFieldUpdater(new FieldUpdater<ConstraintExtensionElementChild, String>() {

			public void update(int index,
					final ConstraintExtensionElementChild object,
					final String value) {
				object.setAttr_config(value);
				getTable().redraw();
				getJsoAccess().onContentChange();
			}

		});

		tcBtnRemove = new Column<ConstraintExtensionElementChild, String>(
				new ButtonCell()) {
			@Override
			public String getValue(ConstraintExtensionElementChild object) {
				return "x";
			}
		};

		tcBtnRemove
				.setFieldUpdater(new FieldUpdater<ConstraintExtensionElementChild, String>() {

					@Override
					public void update(int index,
							ConstraintExtensionElementChild object, String value) {
						EditFormFieldTableValidationWidget.this.currentFormFieldJso
								.removeChildConstraint(object);
						getDataProvider().getList().remove(object);
						getDataProvider().refresh();
						getTable().redraw();
						getJsoAccess().onContentChange();
					}
				});

		getTable().addColumn(tcName, "Name");
		getTable().addColumn(tcConfig, "Config");
		getTable().addColumn(tcBtnRemove, "");

		btnAdd = new Button("Add");
		btnAdd.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				ConstraintExtensionElementChild newDataObject = EditFormFieldTableValidationWidget.this.currentFormFieldJso
						.addChildContraint();
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
				currentFormFieldJso.getChildsContraints());
	}

	// public void setCurrentFormFieldJso(FormFieldElementChild
	// currentFormFieldJso) {
	// this.currentFormFieldJso = currentFormFieldJso;
	// }

}
