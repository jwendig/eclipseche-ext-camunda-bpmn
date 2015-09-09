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

package de.fhrt.codenvy.bpmn.part.properties.widgets.base.formfields;

import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.FormFieldJso;
import de.fhrt.codenvy.bpmn.part.properties.BpmnElementPropertiesView;
import de.fhrt.codenvy.bpmn.part.properties.widgets.AbstractBpmnPropertiesTabController;

public class TabFormFieldsController extends
		AbstractBpmnPropertiesTabController<FormFieldJso> {

	private final static String TAB_NAME = "Form Fields";

	private TabFormFieldsView view;

	public TabFormFieldsController(BpmnElementPropertiesView.CurrentJsoAccess jsoAccess) {
		super(jsoAccess);
		this.view = new TabFormFieldsView(TAB_NAME, jsoAccess);
	}

	public TabFormFieldsView getView() {
		return view;
	}

	@Override
	public void updateView() {
		view.getTableFormFields().update();
	}
}
