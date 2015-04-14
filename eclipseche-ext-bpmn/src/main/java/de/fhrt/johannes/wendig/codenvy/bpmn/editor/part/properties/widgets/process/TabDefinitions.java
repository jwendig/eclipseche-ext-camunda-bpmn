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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.process;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.user.cellview.client.CellTable;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.BaseBpmnProperties;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.BaseBpmnPropertiesTab;

public class TabDefinitions extends BaseBpmnPropertiesTab {

	private final static String TAB_NAME = "Definitions";
	
	private CellTable<String> ctErrors;
	private CellTable<String> ctMessages;
	private CellTable<String> ctSignals;
	private CellTable<String> ctDataStores;
	
	public TabDefinitions() {
		super();
		Log.info(TabDefinitions.class, "constructor");
		
		initContentElements();
		initContent();
	}
	
	@Override
	public String getTabName() {
		Log.info(TabDefinitions.class, "getTabName");
		return TAB_NAME;
	}
//	@Override
	public void initContent() {
		Log.info(TabDefinitions.class, "initContent");
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
//	@Override
	public void initContentElements() {
		Log.info(TabDefinitions.class, "initContentElements");
		ctErrors = new CellTable<String>();
		ctErrors.setWidth("100%");
		ctMessages = new CellTable<String>();
		ctMessages.setWidth("100%");
		ctSignals = new CellTable<String>();
		ctSignals.setWidth("100%");
		ctDataStores = new CellTable<String>();
		ctDataStores.setWidth("100%");
	}

}
