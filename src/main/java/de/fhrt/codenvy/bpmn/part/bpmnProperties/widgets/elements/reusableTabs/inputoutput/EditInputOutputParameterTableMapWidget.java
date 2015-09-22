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
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.MapEntryExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnDataTableWidget;

public class EditInputOutputParameterTableMapWidget extends
		AbstractBpmnDataTableWidget<MapEntryExtensionElementChild> {

	private Column<MapEntryExtensionElementChild, String> tcKey;
	private Column<MapEntryExtensionElementChild, String> tcValue;
	private Column<MapEntryExtensionElementChild, String> tcBtnRemove;
	private Button btnAdd;

	private InputOutputParameterExtensionElementChild currentInputParameterJso;

	public EditInputOutputParameterTableMapWidget(
			BpmnPropertiesView.CurrentJsoAccess jsoAccess,
			InputOutputParameterExtensionElementChild currentInputParameterJso) {
		super(jsoAccess);
		Log.info(EditInputOutputParameterTableMapWidget.class, "constructor");
		this.currentInputParameterJso = currentInputParameterJso;

		tcKey = new Column<MapEntryExtensionElementChild, String>(
				new EditTextCell()) {

			@Override
			public String getValue(MapEntryExtensionElementChild object) {
				if (null == object.getAttr_key()) {
					return "";
				}
				return object.getAttr_value();
			}
		};

		tcKey.setFieldUpdater(new FieldUpdater<MapEntryExtensionElementChild, String>() {

			public void update(int index,
					final MapEntryExtensionElementChild object,
					final String value) {
				object.setAttr_key(value);
				getTable().redraw();
				getJsoAccess().onContentChange();
			}

		});

		tcValue = new Column<MapEntryExtensionElementChild, String>(
				new EditTextCell()) {

			@Override
			public String getValue(MapEntryExtensionElementChild object) {
				if (null == object.getAttr_value()) {
					return "";
				}
				return object.getAttr_value();
			}
		};

		tcValue.setFieldUpdater(new FieldUpdater<MapEntryExtensionElementChild, String>() {

			public void update(int index,
					final MapEntryExtensionElementChild object,
					final String value) {
				object.setAttr_value(value);
				getTable().redraw();
				getJsoAccess().onContentChange();
			}

		});

		tcBtnRemove = new Column<MapEntryExtensionElementChild, String>(
				new ButtonCell()) {
			@Override
			public String getValue(MapEntryExtensionElementChild object) {
				return "x";
			}
		};

		tcBtnRemove
				.setFieldUpdater(new FieldUpdater<MapEntryExtensionElementChild, String>() {

					@Override
					public void update(int index,
							MapEntryExtensionElementChild object, String value) {
						EditInputOutputParameterTableMapWidget.this.currentInputParameterJso
								.removeMapEntryChild(object);
						getDataProvider().getList().remove(object);
						getDataProvider().refresh();
						getTable().redraw();
						getJsoAccess().onContentChange();
					}
				});

		getTable().addColumn(tcKey, "Key");
		getTable().addColumn(tcValue, "Value");
		getTable().addColumn(tcBtnRemove, "");

		btnAdd = new Button("Add");
		btnAdd.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				MapEntryExtensionElementChild newDataObject = EditInputOutputParameterTableMapWidget.this.currentInputParameterJso
						.addMapEntryChild();
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
				currentInputParameterJso.getMapEntryChilds());
	}
}
