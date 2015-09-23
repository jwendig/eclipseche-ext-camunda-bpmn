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

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.rootElements.MessageRootElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnDataTableWidget;

public class TableMessagesWidget extends
		AbstractBpmnDataTableWidget<MessageRootElement> {

	private Column<MessageRootElement, String> tcId;
	private Column<MessageRootElement, String> tcName;
	private Column<MessageRootElement, String> tcBtnRemove;
	private Button btnAdd;

	public TableMessagesWidget(BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(jsoAccess);
		tcName = new Column<MessageRootElement, String>(new EditTextCell()) {

			@Override
			public String getValue(MessageRootElement object) {
				if (null == object.getAttr_name()) {
					return "";
				}
				return object.getAttr_name();
			}
		};

		tcName.setFieldUpdater(new FieldUpdater<MessageRootElement, String>() {

			public void update(int index, final MessageRootElement object,
					final String value) {
				Log.info(TableMessagesWidget.class,
						"tcDataObjectName-fieldUpdater: update");
				object.setAttr_name(value);
				getTable().redraw();
				getJsoAccess().onContentChange();
			}

		});

		tcId = new Column<MessageRootElement, String>(new EditTextCell()) {

			@Override
			public String getValue(MessageRootElement object) {
				if (null == object.getAttr_id()) {
					return "";
				}
				return object.getAttr_id();
			}
		};

		tcId.setFieldUpdater(new FieldUpdater<MessageRootElement, String>() {

			public void update(int index, final MessageRootElement object,
					final String value) {
				Log.info(TableMessagesWidget.class,
						"tcDataObjectName-fieldUpdater: update");
				object.setAttr_id(value);
				getTable().redraw();
				getJsoAccess().onContentChange();
			}

		});

		tcBtnRemove = new Column<MessageRootElement, String>(new ButtonCell()) {
			@Override
			public String getValue(MessageRootElement object) {
				return "x";
			}
		};

		tcBtnRemove
				.setFieldUpdater(new FieldUpdater<MessageRootElement, String>() {

					@Override
					public void update(int index, MessageRootElement object,
							String value) {
						getJsoAccess().getCurrentElement()
								.removeRootElementMessage(object);
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
				MessageRootElement newDataObject = getJsoAccess()
						.getCurrentElement().addRootElementMessage();
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
				getJsoAccess().getCurrentElement().getRootElementsMessage());
	}
}
