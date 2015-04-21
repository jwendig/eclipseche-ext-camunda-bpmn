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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.process;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView.ActionDelegate;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesTabController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementJso;

public class TabExtensionsController extends
		AbstractBpmnPropertiesTabController {
	private final static String TAB_NAME = "Extensions";
	private TabExtensionsView view;

	public TabExtensionsController(ActionDelegate delegate) {
		super(delegate);
		this.view = new TabExtensionsView(TAB_NAME, delegate);
	}

	public TabExtensionsView getView() {
		return view;
	}

	@Override
	public void updateView() {

	}

}
