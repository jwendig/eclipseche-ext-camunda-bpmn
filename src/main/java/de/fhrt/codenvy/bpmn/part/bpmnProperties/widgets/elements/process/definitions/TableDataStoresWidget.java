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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.process.definitions;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Button;

import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.root.DataStoreJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.rootElements.DataStoreRootElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnDataTableWidget;

public class TableDataStoresWidget extends
		AbstractBpmnDataTableWidget<DataStoreRootElement> {

	private Column<DataStoreRootElement, String> tcId;
	private Column<DataStoreRootElement, String> tcName;
	private Column<DataStoreRootElement, String> tcBtnRemove;
	private Button btnAdd;

	public TableDataStoresWidget(BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(jsoAccess);
		tcId = new Column<DataStoreRootElement, String>(new EditTextCell()) {

			@Override
			public String getValue(DataStoreRootElement object) {
				if (null == object.getAttr_id()) {
					return "";
				}
				return object.getAttr_id();
			}
		};

		tcId.setFieldUpdater(new FieldUpdater<DataStoreRootElement, String>() {

			public void update(int index, final DataStoreRootElement object,
					final String value) {
				Log.info(TableDataStoresWidget.class,
						"tcDataObjectName-fieldUpdater: update");
				object.setAttr_id(value);
				getTable().redraw();
				getJsoAccess().onContentChange();
			}

		});

		tcName = new Column<DataStoreRootElement, String>(new EditTextCell()) {

			@Override
			public String getValue(DataStoreRootElement object) {
				if (null == object.getAttr_name()) {
					return "";
				}
				return object.getAttr_name();
			}
		};

		tcName.setFieldUpdater(new FieldUpdater<DataStoreRootElement, String>() {

			public void update(int index, final DataStoreRootElement object,
					final String value) {
				Log.info(TableDataStoresWidget.class,
						"tcDataObjectName-fieldUpdater: update");
				object.setAttr_name(value);
				getTable().redraw();
				getJsoAccess().onContentChange();
			}

		});

		tcBtnRemove = new Column<DataStoreRootElement, String>(new ButtonCell()) {
			@Override
			public String getValue(DataStoreRootElement object) {
				return "x";
			}
		};

		tcBtnRemove
				.setFieldUpdater(new FieldUpdater<DataStoreRootElement, String>() {

					@Override
					public void update(int index, DataStoreRootElement object,
							String value) {
						getJsoAccess().getCurrentElement()
								.removeRootElementDataStore(object);
						getDataProvider().getList().remove(object);
						getDataProvider().refresh();
						getTable().redraw();
						getJsoAccess().onContentChange();
					}
				});

		getTable().addColumn(tcId, "Id");
		getTable().addColumn(tcName, "Name");
		getTable().addColumn(tcBtnRemove, "");

		btnAdd = new Button("Add");
		btnAdd.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				DataStoreRootElement newDataObject = getJsoAccess()
						.getCurrentElement().addRootElementDataStore();
				getDataProvider().getList().add(newDataObject);
				getDataProvider().refresh();
				getTable().redraw();
				getJsoAccess().onContentChange();
			}
		});

		getButtonPanel().add(btnAdd);

	}

	@Override
	public void update() {
		getDataProvider().getList().clear();
		getDataProvider().getList().addAll(
				getJsoAccess().getCurrentElement().getRootElementsDataStore());
	}
}
