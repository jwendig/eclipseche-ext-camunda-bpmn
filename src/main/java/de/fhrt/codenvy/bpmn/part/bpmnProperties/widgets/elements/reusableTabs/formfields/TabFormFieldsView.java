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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.formfields;

import org.eclipse.che.ide.util.loging.Log;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesTabWidget;

public class TabFormFieldsView extends AbstractBpmnPropertiesTabWidget {
	private TableFormFieldsWidget tableFormFields;

	public TabFormFieldsView(String tabName, BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(tabName, jsoAccess);
		Log.info(TabFormFieldsView.class, "constructor");
	}

	@Override
	public void initContent() {
		Log.info(TabFormFieldsView.class, "initContent");
		getGridTabContent().resize(2, 2);

		getGridTabContent().setText(0, 0, "Form Fields:");
		getGridTabContent().setWidget(0, 1, tableFormFields);
	}

	@Override
	public void initContentElements() {
		Log.info(TabFormFieldsView.class, "initContentElements");

		tableFormFields = new TableFormFieldsWidget(getJsoAccess());
	}

	public TableFormFieldsWidget getTableFormFields() {
		return tableFormFields;
	}

}
