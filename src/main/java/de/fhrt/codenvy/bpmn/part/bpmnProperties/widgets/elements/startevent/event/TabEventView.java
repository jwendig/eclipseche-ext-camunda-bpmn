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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.startevent.event;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.user.client.ui.TextBox;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesTabWidget;

public class TabEventView extends AbstractBpmnPropertiesTabWidget {
	private TextBox tbInitiator;

	public TabEventView(String tabName,
			BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(tabName, jsoAccess);
		Log.info(TabEventView.class, "constructor");
	}

	@Override
	public void initContent() {
		Log.info(TabEventView.class, "initContent");
		getGridTabContent().resize(1, 2);

		getGridTabContent().setText(0, 0, "Initiator:");

		getGridTabContent().setWidget(0, 1, tbInitiator);
	}

	@Override
	public void initContentElements() {
		Log.info(TabEventView.class, "initContentElements");
		tbInitiator = new TextBox();
		tbInitiator.setWidth("100%");
	}

	public TextBox getTbInitiator() {
		return tbInitiator;
	}

}
