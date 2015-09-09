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

package de.fhrt.codenvy.bpmn.part.properties.widgets.process.definitions;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.user.cellview.client.CellTable;

import de.fhrt.codenvy.bpmn.part.properties.BpmnElementPropertiesView;
import de.fhrt.codenvy.bpmn.part.properties.widgets.AbstractBpmnPropertiesTabWidget;

public class TabDefinitionsView extends AbstractBpmnPropertiesTabWidget {

	private TableErrorsWidget ctErrors;
	private TableDataStoresWidget ctDataStores;
	private TableMessagesWidget ctMessages;
	private TableSignalsWidget ctSignals;

	public TabDefinitionsView(String tabName, BpmnElementPropertiesView.CurrentJsoAccess jsoAccess) {
		super(tabName, jsoAccess);
		Log.info(TabDefinitionsView.class, "constructor");
	}

	@Override
	public void initContent() {
		Log.info(TabDefinitionsView.class, "initContent");
		getGridTabContent().resize(4, 2);

		getGridTabContent().setText(0, 0, "Errors:");
		getGridTabContent().setText(1, 0, "Messages:");
		getGridTabContent().setText(2, 0, "Signals:");
		getGridTabContent().setText(3, 0, "Data Stores:");

		getGridTabContent().setWidget(0, 1, ctErrors);
		getGridTabContent().setWidget(1, 1, ctMessages);
		getGridTabContent().setWidget(2, 1, ctSignals);
		getGridTabContent().setWidget(3, 1, ctDataStores);
	}

	@Override
	public void initContentElements() {
		Log.info(TabDefinitionsView.class, "initContentElements");
		ctErrors = new TableErrorsWidget(getJsoAccess());
		ctMessages = new TableMessagesWidget(getJsoAccess());
		ctSignals = new TableSignalsWidget(getJsoAccess());
		ctDataStores = new TableDataStoresWidget(getJsoAccess());
	}

	public TableErrorsWidget getCtErrors() {
		return ctErrors;
	}

	public TableDataStoresWidget getCtDataStores() {
		return ctDataStores;
	}

	public TableMessagesWidget getCtMessages() {
		return ctMessages;
	}

	public TableSignalsWidget getCtSignals() {
		return ctSignals;
	}

}
