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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.properties.process;

import com.google.gwt.user.cellview.client.CellTable;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.BaseBpmnPropertiesTab;

public class TabDefinitions extends BaseBpmnPropertiesTab {

	private final static String TAB_NAME = "Definitions";
	
	private CellTable<String> ctErrors;
	private CellTable<String> ctMessages;
	private CellTable<String> ctSignals;
	private CellTable<String> ctDataStores;
	
	public TabDefinitions() {
		super();
		
		initContentElements();
		initContent();
	}
	
	@Override
	public String getTabName() {
		return TAB_NAME;
	}
//	@Override
	public void initContent() {
		getTabContent().resize(4, 2);

		getTabContent().setText(0, 0, "Errors:");
		getTabContent().setText(1, 0, "Messages:");
		getTabContent().setText(2, 0, "Signals:");
		getTabContent().setText(3, 0, "Data Stores:");

		getTabContent().setWidget(0, 1, ctErrors);
		getTabContent().setWidget(1, 1, ctMessages);
		getTabContent().setWidget(2, 1, ctSignals);
		getTabContent().setWidget(3, 1, ctDataStores);
	}
//	@Override
	public void initContentElements() {
		ctErrors = new CellTable<String>();
		ctMessages = new CellTable<String>();
		ctSignals = new CellTable<String>();
		ctDataStores = new CellTable<String>();
	}

}
