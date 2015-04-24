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
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.Button;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnDataTableWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.root.ErrorJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.root.SignalJso;

public class TableSignalsWidget extends AbstractBpmnDataTableWidget<SignalJso> {

	private Column<SignalJso, String> tcName;
	private Column<SignalJso, String> tcId;
	private Column<SignalJso, String> tcBtnRemove;
	private Button btnAdd;

	public TableSignalsWidget(BpmnElementPropertiesView.ActionDelegate delegate) {
		super(delegate);
		tcName = new Column<SignalJso, String>(new EditTextCell()) {

			@Override
			public String getValue(SignalJso object) {
				if (null == object.getAttr_name()) {
					return "";
				}
				return object.getAttr_name();
			}
		};

		tcName.setFieldUpdater(new FieldUpdater<SignalJso, String>() {

			public void update(int index, final SignalJso object,
					final String value) {
				object.setAttr_name(value);
				getTable().redraw();
				getDelegate().onContentChange();
			}

		});

		tcId = new Column<SignalJso, String>(new EditTextCell()) {

			@Override
			public String getValue(SignalJso object) {
				if (null == object.getAttr_id()) {
					return "";
				}
				return object.getAttr_id();
			}
		};

		tcId.setFieldUpdater(new FieldUpdater<SignalJso, String>() {

			public void update(int index, final SignalJso object,
					final String value) {
				object.setAttr_id(value);
				getTable().redraw();
				getDelegate().onContentChange();
			}

		});

		tcBtnRemove = new Column<SignalJso, String>(new ButtonCell()) {
			@Override
			public String getValue(SignalJso object) {
				return "x";
			}
		};

		tcBtnRemove.setFieldUpdater(new FieldUpdater<SignalJso, String>() {

			@Override
			public void update(int index, SignalJso object, String value) {
				if (getDelegate().getCurrentBpmnIoModelerJso()
						.removeRootElementSignal(object)) {
					getDataProvider().getList().remove(object);
					getDataProvider().refresh();
					getTable().redraw();
					getDelegate().onContentChange();
				} else {

				}
			}
		});

		getTable().addColumn(tcName, "Name");
		getTable().addColumn(tcId, "Error Code");
		getTable().addColumn(tcBtnRemove, "");

		btnAdd = new Button("Add");
		btnAdd.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				SignalJso newDataObject = getDelegate()
						.getCurrentBpmnIoModelerJso().addRootElementSignalJso(
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
						.getRootElementsSignals());
	}
}
