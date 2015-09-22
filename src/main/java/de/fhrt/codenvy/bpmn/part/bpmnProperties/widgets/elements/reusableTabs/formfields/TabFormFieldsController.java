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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.formfields;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.FormFieldExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesTabController;

public class TabFormFieldsController extends
		AbstractBpmnPropertiesTabController<FormFieldExtensionElementChild> {

	private final static String TAB_NAME = "Form Fields";

	private TabFormFieldsView view;

	public TabFormFieldsController(BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
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
