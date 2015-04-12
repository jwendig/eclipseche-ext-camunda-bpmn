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

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextBox;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.BaseBpmnPropertiesTab;

public class TabGeneral extends BaseBpmnPropertiesTab {

	private final static String TAB_NAME = "General";

	private TextBox tbProcessId;
	private TextBox tbName;
	private CheckBox cbIsExecutable;
	private CellTable<String> ctDataObjects;
	private TextBox tbDocumentation;

	public TabGeneral() {
		super();
		Log.info(TabGeneral.class, "constructor");
		initContentElements();
		initContent();
	}

	// @Override
	public void initContent() {
		Log.info(TabGeneral.class, "initContent");
		getTabContent().resize(5, 2);

		getTabContent().setText(0, 0, "Process Id:");
		getTabContent().setText(1, 0, "Name:");
		getTabContent().setText(2, 0, "Is Executable:");
		getTabContent().setText(3, 0, "Data Objects:");
		getTabContent().setText(4, 0, "Documentation:");

		getTabContent().setWidget(0, 1, tbProcessId);
		getTabContent().setWidget(1, 1, tbName);
		getTabContent().setWidget(2, 1, cbIsExecutable);
		getTabContent().setWidget(3, 1, ctDataObjects);
		getTabContent().setWidget(4, 1, tbDocumentation);
	}

	// @Override
	public void initContentElements() {
		Log.info(TabGeneral.class, "initContentElements");
		tbProcessId = new TextBox();
		tbProcessId.setWidth("100%");
		tbName = new TextBox();
		tbName.setWidth("100%");
		cbIsExecutable = new CheckBox();
		cbIsExecutable.setWidth("100%");
		ctDataObjects = new CellTable<String>();
		ctDataObjects.setWidth("100%");
		tbDocumentation = new TextBox();
		tbDocumentation.setWidth("100%");
	}

	@Override
	public String getTabName() {
		Log.info(TabGeneral.class, "getTabName");
		return TAB_NAME;
	}
}
