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
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesTabView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.extensions.ExecutionListenerJso;

public class TabListenerView extends AbstractBpmnPropertiesTabView {
	private CellTable<ExecutionListenerJso> ctExecutionListeners;
	private TextColumn<ExecutionListenerJso> tcExecutionListenersClass;
	private TextColumn<ExecutionListenerJso> tcExecutionListenersEvent;
	private TextColumn<ExecutionListenerJso> tcExecutionListenersExpression;
	private TextColumn<ExecutionListenerJso> tcExecutionListenersDelegateExpression;
	private Column<ExecutionListenerJso, String> tcExecutionListenerBtnRemove;
	private Column<ExecutionListenerJso, String> tcExecutionListenerBtnEdit;

	private Button btnAddExecutionListener;

	public TabListenerView(String tabName) {
		super(tabName);
		Log.info(TabListenerView.class, "constructor");
	}

	@Override
	public void initContent() {
		Log.info(TabListenerView.class, "initContent");
		getGridTabContent().resize(2, 2);

		getGridTabContent().setText(0, 0, "Execution Listeners:");

		getGridTabContent().setWidget(0, 1, ctExecutionListeners);

		HorizontalPanel hpExecutionListenerButtons = new HorizontalPanel();
		hpExecutionListenerButtons.add(btnAddExecutionListener);
		getGridTabContent().setWidget(1, 1, hpExecutionListenerButtons);
	}

	@Override
	public void initContentElements() {
		Log.info(TabListenerView.class, "initContentElements");

		btnAddExecutionListener = new Button("Add");

		tcExecutionListenersClass = new TextColumn<ExecutionListenerJso>() {

			@Override
			public String getValue(ExecutionListenerJso object) {
				return object.getAttr_class();
			}
		};

		tcExecutionListenersEvent = new TextColumn<ExecutionListenerJso>() {

			@Override
			public String getValue(ExecutionListenerJso object) {
				return object.getAttr_event();
			}
		};

		tcExecutionListenersExpression = new TextColumn<ExecutionListenerJso>() {

			@Override
			public String getValue(ExecutionListenerJso object) {
				return object.getAttr_expression();
			}
		};

		tcExecutionListenersDelegateExpression = new TextColumn<ExecutionListenerJso>() {

			@Override
			public String getValue(ExecutionListenerJso object) {
				return object.getAttr_delegateExpression();
			}
		};

		tcExecutionListenerBtnRemove = new Column<ExecutionListenerJso, String>(
				new ButtonCell()) {
			@Override
			public String getValue(ExecutionListenerJso object) {
				return "x";
			}
		};

		tcExecutionListenerBtnEdit = new Column<ExecutionListenerJso, String>(
				new ButtonCell()) {
			@Override
			public String getValue(ExecutionListenerJso object) {
				return "Edit";
			}
		};

		ctExecutionListeners = new CellTable<ExecutionListenerJso>();
		ctExecutionListeners.addStyleName("bpmnPropertiesWidget-cellTable");
		ctExecutionListeners.setWidth("100%");
		ctExecutionListeners.addColumn(tcExecutionListenersClass, "Class");
		ctExecutionListeners.addColumn(tcExecutionListenersExpression,
				"Expression");
		ctExecutionListeners.addColumn(tcExecutionListenersDelegateExpression,
				"DelegateExpression");
		ctExecutionListeners.addColumn(tcExecutionListenersEvent, "Event");
		ctExecutionListeners.addColumn(tcExecutionListenerBtnEdit, "");
		ctExecutionListeners.addColumn(tcExecutionListenerBtnRemove, "");
	}

	public CellTable<ExecutionListenerJso> getCtExecutionListeners() {
		return ctExecutionListeners;
	}

	public Column<ExecutionListenerJso, String> getTcExecutionListenerBtnRemove() {
		return tcExecutionListenerBtnRemove;
	}

	public Button getBtnAddExecutionListener() {
		return btnAddExecutionListener;
	}

	public TextColumn<ExecutionListenerJso> getTcExecutionListenersClass() {
		return tcExecutionListenersClass;
	}

	public TextColumn<ExecutionListenerJso> getTcExecutionListenersEvent() {
		return tcExecutionListenersEvent;
	}

	public TextColumn<ExecutionListenerJso> getTcExecutionListenersExpression() {
		return tcExecutionListenersExpression;
	}

	public TextColumn<ExecutionListenerJso> getTcExecutionListenersDelegateExpression() {
		return tcExecutionListenersDelegateExpression;
	}

	public Column<ExecutionListenerJso, String> getTcExecutionListenerBtnEdit() {
		return tcExecutionListenerBtnEdit;
	}

}
