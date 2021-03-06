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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.process.definitions;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.uiElements.ProcessElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesTabController;

public class TabDefinitionsController extends
		AbstractBpmnPropertiesTabController<ProcessElement> {
	private final static String TAB_NAME = "Definitions";
	private TabDefinitionsView view;

	public TabDefinitionsController(
			BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(jsoAccess);
		this.view = new TabDefinitionsView(TAB_NAME, jsoAccess);
	}

	public TabDefinitionsView getView() {
		return view;
	}

	@Override
	public void updateView() {
		view.getCtErrors().update();
		view.getCtDataStores().update();
		view.getCtMessages().update();
		view.getCtSignals().update();
	}

}
