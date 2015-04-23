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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.process.definitions;

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
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.process.listener.TabListenerController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementPropertyJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.properties.DataObjectJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.properties.ErrorJso;

public class TableErrorsWidget extends AbstractBpmnDataTableWidget<ErrorJso> {

	private Column<ErrorJso, String> tcName;
	private Column<ErrorJso, String> tcErrorCode;
	private Column<ErrorJso, String> tcBtnRemove;
	private Button btnAdd;

	public TableErrorsWidget(BpmnElementPropertiesView.ActionDelegate delegate) {
		super(delegate);
		tcName = new Column<ErrorJso, String>(new EditTextCell()) {

			@Override
			public String getValue(ErrorJso object) {
				if (null == object.getAttr_name()) {
					return "";
				}
				return object.getAttr_name();
			}
		};

		tcName.setFieldUpdater(new FieldUpdater<ErrorJso, String>() {

			public void update(int index, final ErrorJso object,
					final String value) {
				Log.info(TableErrorsWidget.class,
						"tcDataObjectName-fieldUpdater: update");
				object.setAttr_name(value);
				getTable().redraw();
				getDelegate().onContentChange();
			}

		});

		tcErrorCode = new Column<ErrorJso, String>(new EditTextCell()) {

			@Override
			public String getValue(ErrorJso object) {
				if (null == object.getAttr_errorCode()) {
					return "";
				}
				return object.getAttr_errorCode();
			}
		};

		tcErrorCode.setFieldUpdater(new FieldUpdater<ErrorJso, String>() {

			public void update(int index, final ErrorJso object,
					final String value) {
				Log.info(TableErrorsWidget.class,
						"tcDataObjectName-fieldUpdater: update");
				object.setAttr_errorCode(value);
				getTable().redraw();
				getDelegate().onContentChange();
			}

		});

		tcBtnRemove = new Column<ErrorJso, String>(new ButtonCell()) {
			@Override
			public String getValue(ErrorJso object) {
				return "x";
			}
		};

		tcBtnRemove.setFieldUpdater(new FieldUpdater<ErrorJso, String>() {

			@Override
			public void update(int index, ErrorJso object, String value) {
				if (getDelegate().getCurrentElementJso()
						.removeProperty_element(
								(BpmnDiagramElementPropertyJso) object)) {
					getDataProvider().getList().remove(object);
					getDataProvider().refresh();
					getTable().redraw();
					getDelegate().onContentChange();
				} else {

				}
			}
		});

		getTable().addColumn(tcName, "Name");
		getTable().addColumn(tcErrorCode, "Error Code");
		getTable().addColumn(tcBtnRemove, "");

		btnAdd = new Button("Add");
		btnAdd.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				BpmnDiagramElementPropertyJso newDataObject = getDelegate()
						.getCurrentBpmnIoModelerJso().addRootElement_error(
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
		JsArray<BpmnDiagramElementPropertyJso> dataObjects = getDelegate()
				.getCurrentBpmnIoModelerJso().getRootElements_errors();
		for (int i = 0; i < dataObjects.length(); i++) {
			getDataProvider().getList().add(dataObjects.get(i));
		}
	}
}
