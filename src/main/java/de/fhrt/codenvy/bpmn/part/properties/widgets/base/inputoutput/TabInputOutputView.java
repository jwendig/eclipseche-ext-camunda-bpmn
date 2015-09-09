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

package de.fhrt.codenvy.bpmn.part.properties.widgets.base.inputoutput;

import org.eclipse.che.ide.util.loging.Log;

import de.fhrt.codenvy.bpmn.part.properties.BpmnElementPropertiesView;
import de.fhrt.codenvy.bpmn.part.properties.widgets.AbstractBpmnPropertiesTabWidget;

public class TabInputOutputView extends AbstractBpmnPropertiesTabWidget {
	private TableInputParametersWidget tableInputParameters;

	private TableOutputParametersWidget tableOutputParameters;

	public TabInputOutputView(String tabName, BpmnElementPropertiesView.CurrentJsoAccess jsoAccess) {
		super(tabName, jsoAccess);
		Log.info(TabInputOutputView.class, "constructor");
	}

	@Override
	public void initContent() {
		Log.info(TabInputOutputView.class, "initContent");
		getGridTabContent().resize(2, 2);

		getGridTabContent().setText(0, 0, "Input Parameters:");
		getGridTabContent().setWidget(0, 1, tableInputParameters);

		getGridTabContent().setText(1, 0, "Output Parameters:");
		getGridTabContent().setWidget(1, 1, tableOutputParameters);

	}

	@Override
	public void initContentElements() {
		Log.info(TabInputOutputView.class, "initContentElements");

		tableInputParameters = new TableInputParametersWidget(getJsoAccess());
		tableOutputParameters = new TableOutputParametersWidget(getJsoAccess());
	}

	public TableInputParametersWidget getTableInputParameters() {
		return tableInputParameters;
	}

	public TableOutputParametersWidget getTableOutputParameters() {
		return tableOutputParameters;
	}

}
