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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.extensions;

import org.eclipse.che.ide.util.loging.Log;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesTabWidget;

public class TabExtensionsView extends AbstractBpmnPropertiesTabWidget {
	private TableExtensionsWidget ctExtensions;

	public TabExtensionsView(String tabName,
			BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(tabName, jsoAccess);
		Log.info(TabExtensionsView.class, "constructor");
	}

	@Override
	public void initContent() {
		Log.info(TabExtensionsView.class, "initContent");
		getGridTabContent().resize(1, 2);

		getGridTabContent().setText(0, 0, "Extensions:");

		getGridTabContent().setWidget(0, 1, ctExtensions);
	}

	@Override
	public void initContentElements() {
		Log.info(TabExtensionsView.class, "initContentElements");
		ctExtensions = new TableExtensionsWidget(getJsoAccess());
		ctExtensions.setWidth("100%");
	}

	public TableExtensionsWidget getCtExtensions() {
		return ctExtensions;
	}

}
