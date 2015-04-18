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

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesTab;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.base.TabListenerController.ExecutionListenerModel;

public class TabListenerView extends AbstractBpmnPropertiesTab {
	private final static String TAB_NAME = "Listener";

	private CellTable<ExecutionListenerModel> ctExecutionListeners;
	private TextColumn<ExecutionListenerModel> tcExecutionListenersClass;
	private TextColumn<ExecutionListenerModel> tcExecutionListenersEvent;
	private TextColumn<ExecutionListenerModel> tcExecutionListenersExpression;
	private TextColumn<ExecutionListenerModel> tcExecutionListenersDelegateExpression;

	private Button btnAddExecutionListener;
	private Button btnRemoveExecutionListener;
	private Button btnEditExecutionListener;

	public TabListenerView() {
		super();
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
		hpExecutionListenerButtons.add(btnEditExecutionListener);
		hpExecutionListenerButtons.add(btnRemoveExecutionListener);
		getGridTabContent().setWidget(1, 1, hpExecutionListenerButtons);
	}

	@Override
	public void initContentElements() {
		Log.info(TabListenerView.class, "initContentElements");

		btnAddExecutionListener = new Button("Add");
		btnRemoveExecutionListener = new Button("Remove");
		btnEditExecutionListener = new Button("Edit");

		tcExecutionListenersClass = new TextColumn<TabListenerController.ExecutionListenerModel>() {

			@Override
			public String getValue(ExecutionListenerModel object) {
				return object.getClazz();
			}
		};

		tcExecutionListenersEvent = new TextColumn<TabListenerController.ExecutionListenerModel>() {

			@Override
			public String getValue(ExecutionListenerModel object) {
				return object.getEvent();
			}
		};

		tcExecutionListenersExpression = new TextColumn<TabListenerController.ExecutionListenerModel>() {

			@Override
			public String getValue(ExecutionListenerModel object) {
				return object.getExpression();
			}
		};

		tcExecutionListenersDelegateExpression = new TextColumn<TabListenerController.ExecutionListenerModel>() {

			@Override
			public String getValue(ExecutionListenerModel object) {
				return object.getDelegateExpression();
			}
		};

		ctExecutionListeners = new CellTable<ExecutionListenerModel>();
		ctExecutionListeners.setStyleName("bpmnPropertiesWidget-cellTable");
		ctExecutionListeners.setWidth("100%");
		ctExecutionListeners.addColumn(tcExecutionListenersClass, "Class");
		ctExecutionListeners.addColumn(tcExecutionListenersExpression,
				"Expression");
		ctExecutionListeners.addColumn(tcExecutionListenersDelegateExpression,
				"DelegateExpression");
		ctExecutionListeners.addColumn(tcExecutionListenersEvent, "Event");

	}

	@Override
	public String getTabName() {
		Log.info(TabListenerView.class, "getTabName");
		return TAB_NAME;
	}

	public CellTable<ExecutionListenerModel> getCtExecutionListeners() {
		return ctExecutionListeners;
	}

	public Button getBtnAddExecutionListener() {
		return btnAddExecutionListener;
	}

	public Button getBtnRemoveExecutionListener() {
		return btnRemoveExecutionListener;
	}

	public Button getBtnEditExecutionListener() {
		return btnEditExecutionListener;
	}
	
	
}
