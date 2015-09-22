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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.multiinstance;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.user.client.ui.CheckBox;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesTabWidget;

public class TabMultiInstanceView extends AbstractBpmnPropertiesTabWidget {
	private CheckBox cbIsLoop;
	private CheckBox cbMultiInstance;

	public TabMultiInstanceView(String tabName,
			BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(tabName, jsoAccess);
		Log.info(TabMultiInstanceView.class, "constructor");
	}

	@Override
	public void initContent() {
		Log.info(TabMultiInstanceView.class, "initContent");
		getGridTabContent().resize(2, 2);

		getGridTabContent().setText(0, 0, "Is Loop:");
		getGridTabContent().setText(1, 0, "Is Multi Instance:");

		getGridTabContent().setWidget(0, 1, cbIsLoop);
		getGridTabContent().setWidget(1, 1, cbMultiInstance);
	}

	@Override
	public void initContentElements() {
		Log.info(TabMultiInstanceView.class, "initContentElements");
		cbIsLoop = new CheckBox();
		cbIsLoop.setWidth("100%");

		cbMultiInstance = new CheckBox();
		cbMultiInstance.setWidth("100%");

	}

	public CheckBox getCbIsLoop() {
		return cbIsLoop;
	}

	public CheckBox getCbMultiInstance() {
		return cbMultiInstance;
	}

}
