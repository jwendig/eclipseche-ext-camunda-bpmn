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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.listener;

import org.eclipse.che.ide.util.loging.Log;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesTabWidget;

public class TabListenerView extends AbstractBpmnPropertiesTabWidget {
	private TableExecutionListenerWidget tableExecutionListener;
	private TableTaskListenerWidget tableTastListener;

	public TabListenerView(String tabName, BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(tabName, jsoAccess);
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

		tableExecutionListener = new TableExecutionListenerWidget(getJsoAccess());
		tableTastListener = new TableTaskListenerWidget(getJsoAccess());
	}

	public TableExecutionListenerWidget getTableExecutionListener() {
		return tableExecutionListener;
	}

	public TableTaskListenerWidget getTableTaskListener() {
		return tableTastListener;
	}
}
