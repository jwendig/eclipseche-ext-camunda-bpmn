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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.process.general;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnDataTableWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesTabController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.base.listener.TabListenerController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.BpmnElementPropertyJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.properties.DataObjectJso;

public class TableDataObjectsWidget extends
		AbstractBpmnDataTableWidget<DataObjectJso> {

	private Column<DataObjectJso, String> tcDataObjectName;
	private Column<DataObjectJso, String> tcBtnRemove;
	private Button btnAdd;

	public TableDataObjectsWidget(
			BpmnElementPropertiesView.ActionDelegate delegate) {
		super(delegate);
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
						getDelegate().onContentChange();
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
				if (getDelegate().getCurrentElementJso()
						.removeBpmnProperty_element(
								(BpmnElementPropertyJso) object)) {
					getDataProvider().getList().remove(object);
					getDataProvider().refresh();
					getTable().redraw();
					getDelegate().onContentChange();
				} else {

				}
			}
		});

		getTable().addColumn(tcDataObjectName, "Name");
		getTable().addColumn(tcBtnRemove, "");

		btnAdd = new Button("Add");
		btnAdd.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				BpmnElementPropertyJso newDataObject = getDelegate()
						.getCurrentElementJso().addProperty_dataObject(getDelegate().getCurrentBpmnIoModelerJso().nativeGetModdle());
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
		JsArray<BpmnElementPropertyJso> dataObjects = getDelegate()
				.getCurrentElementJso().getBpmnProperty_dataObjects();
		for (int i = 0; i < dataObjects.length(); i++) {
			getDataProvider().getList().add(dataObjects.get(i));
		}
	}
}
