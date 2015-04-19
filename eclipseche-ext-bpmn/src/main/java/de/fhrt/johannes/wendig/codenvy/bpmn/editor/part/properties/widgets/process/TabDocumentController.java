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

public class TabDocumentController extends AbstractBpmnPropertiesTabController {
	private final static String TAB_NAME = "Document";
	private TabDocumentView view;

	public TabDocumentController(ActionDelegate delegate) {
		super(delegate);
		this.view = new TabDocumentView(TAB_NAME);
	}

	public TabDocumentView getView() {
		return view;
	}

}
