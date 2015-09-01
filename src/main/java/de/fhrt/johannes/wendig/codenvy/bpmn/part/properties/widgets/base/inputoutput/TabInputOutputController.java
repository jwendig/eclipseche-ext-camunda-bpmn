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

package de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.base.inputoutput;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.ExecutionListenerJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.BpmnElementPropertiesView.ActionDelegate;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.AbstractBpmnPropertiesTabController;

public class TabInputOutputController<T> extends
		AbstractBpmnPropertiesTabController<T> {

	private final static String TAB_NAME = "Input/Output";

	private TabInputOutputView view;

	public TabInputOutputController(ActionDelegate delegate) {
		super(delegate);
		this.view = new TabInputOutputView(TAB_NAME, delegate);
	}

	public TabInputOutputView getView() {
		return view;
	}

	@Override
	public void updateView() {
		view.getTableInputParameters().update();
		view.getTableOutputParameters().update();
	}
}
