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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.process.general;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextBox;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesTabWidget;

public class TabGeneralView extends AbstractBpmnPropertiesTabWidget {
	private TextBox tbProcessId;
	private TextBox tbName;
	private CheckBox cbIsExecutable;
	private TableDataObjectsWidget ctDataObjects;
	private TextBox tbDocumentation;

	public TabGeneralView(String tabName, BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(tabName, jsoAccess);
		Log.info(TabGeneralView.class, "constructor");
	}

	@Override
	public void initContent() {
		Log.info(TabGeneralView.class, "initContent");
		getGridTabContent().resize(5, 2);

		getGridTabContent().setText(0, 0, "Process Id:");
		getGridTabContent().setText(1, 0, "Name:");
		getGridTabContent().setText(2, 0, "Is Executable:");
		getGridTabContent().setText(3, 0, "Data Objects:");
		getGridTabContent().setText(4, 0, "Documentation:");

		getGridTabContent().setWidget(0, 1, tbProcessId);
		getGridTabContent().setWidget(1, 1, tbName);
		getGridTabContent().setWidget(2, 1, cbIsExecutable);
		getGridTabContent().setWidget(3, 1, ctDataObjects);
		getGridTabContent().setWidget(4, 1, tbDocumentation);
	}

	@Override
	public void initContentElements() {
		Log.info(TabGeneralView.class, "initContentElements");
		tbProcessId = new TextBox();
		tbProcessId.setWidth("100%");
		tbName = new TextBox();
		tbName.setWidth("100%");
		cbIsExecutable = new CheckBox();
		cbIsExecutable.setWidth("100%");
		ctDataObjects = new TableDataObjectsWidget(getJsoAccess());
		ctDataObjects.setWidth("100%");
		tbDocumentation = new TextBox();
		tbDocumentation.setWidth("100%");
	}

	public TextBox getTbProcessId() {
		return tbProcessId;
	}

	public TextBox getTbName() {
		return tbName;
	}

	public CheckBox getCbIsExecutable() {
		return cbIsExecutable;
	}

	public TableDataObjectsWidget getTableDataObjectsWidget() {
		return ctDataObjects;
	}

	public TextBox getTbDocumentation() {
		return tbDocumentation;
	}

}
