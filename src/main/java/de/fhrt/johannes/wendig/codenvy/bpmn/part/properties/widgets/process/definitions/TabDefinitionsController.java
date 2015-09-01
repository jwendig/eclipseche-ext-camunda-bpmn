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

package de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.process.definitions;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.ProcessJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.AbstractBpmnPropertiesTabController;

public class TabDefinitionsController extends
		AbstractBpmnPropertiesTabController<ProcessJso> {
	private final static String TAB_NAME = "Definitions";
	private TabDefinitionsView view;

	public TabDefinitionsController(BpmnElementPropertiesView delegate) {
		super(delegate);
		this.view = new TabDefinitionsView(TAB_NAME, delegate);
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
