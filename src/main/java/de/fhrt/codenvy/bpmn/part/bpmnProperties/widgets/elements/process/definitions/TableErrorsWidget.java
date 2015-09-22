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

import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.root.ErrorJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.rootElements.ErrorRootElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnDataTableWidget;

public class TableErrorsWidget extends
		AbstractBpmnDataTableWidget<ErrorRootElement> {

	private Column<ErrorRootElement, String> tcName;
	private Column<ErrorRootElement, String> tcErrorCode;
	private Column<ErrorRootElement, String> tcBtnRemove;
	private Button btnAdd;

	public TableErrorsWidget(BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(jsoAccess);
		tcName = new Column<ErrorRootElement, String>(new EditTextCell()) {

			@Override
			public String getValue(ErrorRootElement object) {
				if (null == object.getAttr_name()) {
					return "";
				}
				return object.getAttr_name();
			}
		};

		tcName.setFieldUpdater(new FieldUpdater<ErrorRootElement, String>() {

			public void update(int index, final ErrorRootElement object,
					final String value) {
				Log.info(TableErrorsWidget.class,
						"tcDataObjectName-fieldUpdater: update");
				object.setAttr_name(value);
				getTable().redraw();
				getJsoAccess().onContentChange();
			}

		});

		tcErrorCode = new Column<ErrorRootElement, String>(new EditTextCell()) {

			@Override
			public String getValue(ErrorRootElement object) {
				if (null == object.getAttr_errorCode()) {
					return "";
				}
				return object.getAttr_errorCode();
			}
		};

		tcErrorCode
				.setFieldUpdater(new FieldUpdater<ErrorRootElement, String>() {

					public void update(int index,
							final ErrorRootElement object, final String value) {
						Log.info(TableErrorsWidget.class,
								"tcDataObjectName-fieldUpdater: update");
						object.setAttr_errorCode(value);
						getTable().redraw();
						getJsoAccess().onContentChange();
					}

				});

		tcBtnRemove = new Column<ErrorRootElement, String>(new ButtonCell()) {
			@Override
			public String getValue(ErrorRootElement object) {
				return "x";
			}
		};

		tcBtnRemove
				.setFieldUpdater(new FieldUpdater<ErrorRootElement, String>() {

					@Override
					public void update(int index, ErrorRootElement object,
							String value) {
						getJsoAccess().getCurrentElement()
								.removeRootElementError(object);
						getDataProvider().getList().remove(object);
						getDataProvider().refresh();
						getTable().redraw();
						getJsoAccess().onContentChange();
					}
				});

		getTable().addColumn(tcName, "Name");
		getTable().addColumn(tcErrorCode, "Error Code");
		getTable().addColumn(tcBtnRemove, "");

		btnAdd = new Button("Add");
		btnAdd.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				ErrorRootElement newDataObject = getJsoAccess()
						.getCurrentElement().addRootElementError();
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
				getJsoAccess().getCurrentElement().getRootElementsError());
	}
}
