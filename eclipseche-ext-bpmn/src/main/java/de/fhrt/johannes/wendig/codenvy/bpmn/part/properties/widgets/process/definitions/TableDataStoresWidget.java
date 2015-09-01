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

package de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.process.definitions;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Button;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.root.DataStoreJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.root.ErrorJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.AbstractBpmnDataTableWidget;

public class TableDataStoresWidget extends
		AbstractBpmnDataTableWidget<DataStoreJso> {

	private Column<DataStoreJso, String> tcId;
	private Column<DataStoreJso, String> tcName;
	private Column<DataStoreJso, String> tcBtnRemove;
	private Button btnAdd;

	public TableDataStoresWidget(BpmnElementPropertiesView delegate) {
		super(delegate);
		tcId = new Column<DataStoreJso, String>(new EditTextCell()) {

			@Override
			public String getValue(DataStoreJso object) {
				if (null == object.getAttr_id()) {
					return "";
				}
				return object.getAttr_id();
			}
		};

		tcId.setFieldUpdater(new FieldUpdater<DataStoreJso, String>() {

			public void update(int index, final DataStoreJso object,
					final String value) {
				Log.info(TableDataStoresWidget.class,
						"tcDataObjectName-fieldUpdater: update");
				object.setAttr_id(value);
				getTable().redraw();
				getDelegate().onContentChange();
			}

		});

		tcName = new Column<DataStoreJso, String>(new EditTextCell()) {

			@Override
			public String getValue(DataStoreJso object) {
				if (null == object.getAttr_name()) {
					return "";
				}
				return object.getAttr_name();
			}
		};

		tcName.setFieldUpdater(new FieldUpdater<DataStoreJso, String>() {

			public void update(int index, final DataStoreJso object,
					final String value) {
				Log.info(TableDataStoresWidget.class,
						"tcDataObjectName-fieldUpdater: update");
				object.setAttr_name(value);
				getTable().redraw();
				getDelegate().onContentChange();
			}

		});

		tcBtnRemove = new Column<DataStoreJso, String>(new ButtonCell()) {
			@Override
			public String getValue(DataStoreJso object) {
				return "x";
			}
		};

		tcBtnRemove.setFieldUpdater(new FieldUpdater<DataStoreJso, String>() {

			@Override
			public void update(int index, DataStoreJso object, String value) {
				if (getDelegate().getCurrentBpmnIoModelerJso()
						.removeRootElementDataStore(object)) {
					getDataProvider().getList().remove(object);
					getDataProvider().refresh();
					getTable().redraw();
					getDelegate().onContentChange();
				} else {

				}
			}
		});

		getTable().addColumn(tcId, "Id");
		getTable().addColumn(tcName, "Name");
		getTable().addColumn(tcBtnRemove, "");

		btnAdd = new Button("Add");
		btnAdd.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				DataStoreJso newDataObject = getDelegate()
						.getCurrentBpmnIoModelerJso().addRootElementDataStore(
								getDelegate().getCurrentBpmnIoModelerJso()
										.nativeGetModdle());
				getDataProvider().getList().add(newDataObject);
				getDataProvider().refresh();
				getTable().redraw();
				getDelegate().onContentChange();
			}
		});

		getButtonPanel().add(btnAdd);

	}

	@Override
	public void update() {
		getDataProvider().getList().clear();
		getDataProvider().getList().addAll(
				getDelegate().getCurrentBpmnIoModelerJso()
						.getRootElementsDataStores());
	}
}
