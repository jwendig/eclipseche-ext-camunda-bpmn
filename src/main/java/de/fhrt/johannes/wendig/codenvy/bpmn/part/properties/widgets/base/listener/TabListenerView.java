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

package de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.base.listener;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.ExecutionListenerJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.AbstractBpmnPropertiesTabWidget;

public class TabListenerView extends AbstractBpmnPropertiesTabWidget {
	private TableExecutionListenerWidget tableExecutionListener;
	private TableTaskListenerWidget tableTastListener;

	public TabListenerView(String tabName,
			BpmnElementPropertiesView.ActionDelegate delegate) {
		super(tabName, delegate);
		Log.info(TabListenerView.class, "constructor");
	}

	@Override
	public void initContent() {
		Log.info(TabListenerView.class, "initContent");
		getGridTabContent().resize(2, 2);

		getGridTabContent().setText(0, 0, "Execution Listeners:");
		getGridTabContent().setWidget(0, 1, tableExecutionListener);

		getGridTabContent().setText(1, 0, "Task Listeners:");
		getGridTabContent().setWidget(1, 1, tableTastListener);

	}

	@Override
	public void initContentElements() {
		Log.info(TabListenerView.class, "initContentElements");

		tableExecutionListener = new TableExecutionListenerWidget(getDelegate());
		tableTastListener = new TableTaskListenerWidget(getDelegate());
	}

	public TableExecutionListenerWidget getTableExecutionListener() {
		return tableExecutionListener;
	}

	public TableTaskListenerWidget getTableTaskListener() {
		return tableTastListener;
	}
}
