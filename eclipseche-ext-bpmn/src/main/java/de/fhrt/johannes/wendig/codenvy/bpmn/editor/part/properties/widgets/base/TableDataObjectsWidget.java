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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.base;

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

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesTabController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.process.TabListenerController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementPropertyJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.properties.DataObjectJso;

public class TableDataObjectsWidget extends Composite {

	private AbstractBpmnPropertiesTabController controller;
	private ListDataProvider<DataObjectJso> dataObjectsProvider;

	private VerticalPanel root;
	private CellTable<DataObjectJso> ctDataObjects;
	private Column<DataObjectJso, String> tcDataObjectName;
	private Column<DataObjectJso, String> tcBtnRemove;
	private Button btnAdd;

	public TableDataObjectsWidget() {
		super();
		btnAdd = new Button("Add");

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
						ctDataObjects.redraw();
						controller.getActionDelegate().onContentChange();
					}

				});

		tcBtnRemove = new Column<DataObjectJso, String>(new ButtonCell()) {
			@Override
			public String getValue(DataObjectJso object) {
				return "x";
			}
		};

		ctDataObjects = new CellTable<DataObjectJso>();
		ctDataObjects.addStyleName("bpmnPropertiesWidget-cellTable");
		ctDataObjects.setWidth("100%");
		ctDataObjects.addColumn(tcDataObjectName, "Name");
		ctDataObjects.addColumn(tcBtnRemove, "");

		root = new VerticalPanel();
		root.setSize("100%", "auto");
		root.add(ctDataObjects);

		HorizontalPanel hpExecutionListenerButtons = new HorizontalPanel();
		hpExecutionListenerButtons
				.setHorizontalAlignment(HorizontalAlignmentConstant
						.startOf(Direction.RTL));
		hpExecutionListenerButtons.add(btnAdd);
		root.add(hpExecutionListenerButtons);

		initDataProvider();
		initWidget(root);

		btnAdd.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				BpmnDiagramElementPropertyJso newDataObject = controller
						.getBpmnDiagramElementJso().addProperty_dataObject();
				dataObjectsProvider.getList().add(newDataObject);
				dataObjectsProvider.refresh();
				ctDataObjects.redraw();
				controller.getActionDelegate().onContentChange();
			}
		});

		tcBtnRemove.setFieldUpdater(new FieldUpdater<DataObjectJso, String>() {

			@Override
			public void update(int index, DataObjectJso object, String value) {
				if (controller.getBpmnDiagramElementJso()
						.removeProperty_element(
								(BpmnDiagramElementPropertyJso) object)) {
					dataObjectsProvider.getList().remove(object);
					dataObjectsProvider.refresh();
					ctDataObjects.redraw();
					controller.getActionDelegate().onContentChange();
				} else {

				}
			}
		});
	}

	private void initDataProvider() {
		Log.info(TabListenerController.class,
				"initExecutionListenerDataProvider");
		dataObjectsProvider = new ListDataProvider<DataObjectJso>();
		dataObjectsProvider.addDataDisplay(ctDataObjects);
	}

	public AbstractBpmnPropertiesTabController getController() {
		return controller;
	}

	public void setController(AbstractBpmnPropertiesTabController controller) {
		this.controller = controller;
	}

	public ListDataProvider<DataObjectJso> getExecutionListenersProvider() {
		return dataObjectsProvider;
	}

	public void update() {
		dataObjectsProvider.getList().clear();
		JsArray<BpmnDiagramElementPropertyJso> dataObjects = controller
				.getBpmnDiagramElementJso().getProperty_dataObjects();
		for (int i = 0; i < dataObjects.length(); i++) {
			dataObjectsProvider.getList().add(dataObjects.get(i));
		}
	}
}
