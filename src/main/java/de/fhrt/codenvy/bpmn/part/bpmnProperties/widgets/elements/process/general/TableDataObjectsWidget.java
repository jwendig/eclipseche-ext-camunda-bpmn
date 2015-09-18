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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.process.general;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Button;

import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.BpmnElementPropertyJso;
import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.bpmn.DataObjectJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnDataTableWidget;

public class TableDataObjectsWidget extends
		AbstractBpmnDataTableWidget<DataObjectJso> {

	private Column<DataObjectJso, String> tcDataObjectName;
	private Column<DataObjectJso, String> tcBtnRemove;
	private Button btnAdd;

	public TableDataObjectsWidget(BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(jsoAccess);
		tcDataObjectName = new Column<DataObjectJso, String>(new EditTextCell()) {

			@Override
			public String getValue(DataObjectJso object) {
				if (null == object.getAttr_name()) {
					return "";
				}
				return object.getAttr_name();
			}
		};

		tcDataObjectName
				.setFieldUpdater(new FieldUpdater<DataObjectJso, String>() {

					public void update(int index, final DataObjectJso object,
							final String value) {
						Log.info(TableDataObjectsWidget.class,
								"tcDataObjectName-fieldUpdater: update");
						object.setAttr_name(value);
						getTable().redraw();
						getJsoAccess().onContentChange();
					}

				});

		tcBtnRemove = new Column<DataObjectJso, String>(new ButtonCell()) {
			@Override
			public String getValue(DataObjectJso object) {
				return "x";
			}
		};

		tcBtnRemove.setFieldUpdater(new FieldUpdater<DataObjectJso, String>() {

			@Override
			public void update(int index, DataObjectJso object, String value) {
//				if (getJsoAccess().getCurrentElementJso().removeBpmnElement(
//						(BpmnElementPropertyJso) object)) {
//					getDataProvider().getList().remove(object);
//					getDataProvider().refresh();
//					getTable().redraw();
//					getJsoAccess().onContentChange();
//				} else {
//
//				}
			}
		});

		getTable().addColumn(tcDataObjectName, "Name");
		getTable().addColumn(tcBtnRemove, "");

		btnAdd = new Button("Add");
		btnAdd.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
//				BpmnElementPropertyJso newDataObject = getJsoAccess()
//						.getCurrentElementJso().addBpmnDataObject(
//								getJsoAccess().getCurrentBpmnIoModelerJso()
//										.nativeGetModdle());
//				getDataProvider().getList().add(newDataObject);
//				getDataProvider().refresh();
//				getTable().redraw();
//				getJsoAccess().onContentChange();
			}
		});

		getButtonPanel().add(btnAdd);

	}

	@Override
	public void update() {
//		getDataProvider().getList().clear();
//		JsArray<BpmnElementPropertyJso> dataObjects = getJsoAccess()
//				.getCurrentElementJso().getBpmnDataObjects();
//		for (int i = 0; i < dataObjects.length(); i++) {
//			getDataProvider().getList().add(dataObjects.get(i));
//		}
	}
}
