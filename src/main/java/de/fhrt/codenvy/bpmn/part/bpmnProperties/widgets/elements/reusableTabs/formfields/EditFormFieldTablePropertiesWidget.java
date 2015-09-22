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

import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.childs.PropertyJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.FormFieldExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.PropertyExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnDataTableWidget;

public class EditFormFieldTablePropertiesWidget extends
		AbstractBpmnDataTableWidget<PropertyExtensionElementChild> {

	private Column<PropertyExtensionElementChild, String> tcName;
	private Column<PropertyExtensionElementChild, String> tcValue;
	private Column<PropertyExtensionElementChild, String> tcId;
	private Column<PropertyExtensionElementChild, String> tcBtnRemove;
	private Button btnAdd;

	private FormFieldExtensionElementChild currentFormFieldJso;

	public EditFormFieldTablePropertiesWidget(
			BpmnPropertiesView.CurrentJsoAccess jsoAccess,
			FormFieldExtensionElementChild currentFormFieldJso) {
		super(jsoAccess);
		Log.info(EditFormFieldTablePropertiesWidget.class, "constructor");
		this.currentFormFieldJso = currentFormFieldJso;

		tcName = new Column<PropertyExtensionElementChild, String>(
				new EditTextCell()) {
			@Override
			public String getValue(PropertyExtensionElementChild object) {
				if (null == object.getAttr_name()) {
					return "";
				}
				return object.getAttr_name();
			}
		};

		tcName.setFieldUpdater(new FieldUpdater<PropertyExtensionElementChild, String>() {

			public void update(int index,
					final PropertyExtensionElementChild object,
					final String value) {
				object.setAttr_name(value);
				getTable().redraw();
				getJsoAccess().onContentChange();
			}

		});

		tcValue = new Column<PropertyExtensionElementChild, String>(
				new EditTextCell()) {

			@Override
			public String getValue(PropertyExtensionElementChild object) {
				if (null == object.getAttr_value()) {
					return "";
				}
				return object.getAttr_value();
			}
		};

		tcValue.setFieldUpdater(new FieldUpdater<PropertyExtensionElementChild, String>() {

			public void update(int index,
					final PropertyExtensionElementChild object,
					final String value) {
				object.setAttr_value(value);
				getTable().redraw();
				getJsoAccess().onContentChange();
			}

		});

		tcId = new Column<PropertyExtensionElementChild, String>(
				new EditTextCell()) {

			@Override
			public String getValue(PropertyExtensionElementChild object) {
				if (null == object.getAttr_id()) {
					return "";
				}
				return object.getAttr_id();
			}
		};

		tcId.setFieldUpdater(new FieldUpdater<PropertyExtensionElementChild, String>() {

			public void update(int index,
					final PropertyExtensionElementChild object,
					final String value) {
				object.setAttr_id(value);
				getTable().redraw();
				getJsoAccess().onContentChange();
			}

		});

		tcBtnRemove = new Column<PropertyExtensionElementChild, String>(
				new ButtonCell()) {
			@Override
			public String getValue(PropertyExtensionElementChild object) {
				return "x";
			}
		};

		tcBtnRemove
				.setFieldUpdater(new FieldUpdater<PropertyExtensionElementChild, String>() {

					@Override
					public void update(int index,
							PropertyExtensionElementChild object, String value) {
						EditFormFieldTablePropertiesWidget.this.currentFormFieldJso
								.removeChildProperty(object);
						getDataProvider().getList().remove(object);
						getDataProvider().refresh();
						getTable().redraw();
						getJsoAccess().onContentChange();
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
				PropertyExtensionElementChild newDataObject = EditFormFieldTablePropertiesWidget.this.currentFormFieldJso
						.addChildProperty();
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
				currentFormFieldJso.getChildsProperties());
	}

	// public void setCurrentFormFieldJso(FormFieldElementChild
	// currentFormFieldJso) {
	// this.currentFormFieldJso = currentFormFieldJso;
	// }

}
