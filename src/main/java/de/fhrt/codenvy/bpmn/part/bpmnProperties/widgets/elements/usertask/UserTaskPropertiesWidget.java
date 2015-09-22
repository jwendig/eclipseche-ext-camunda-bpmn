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
package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.usertask;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.uiElements.UserTaskElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesWidget;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.extensions.TabExtensionsController;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.formfields.TabFormFieldsController;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.inputoutput.TabInputOutputController;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.listener.TabListenerController;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.multiinstance.TabMulitInstanceController;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.usertask.general.TabGeneralController;

public class UserTaskPropertiesWidget extends AbstractBpmnPropertiesWidget {

	private final static String LB_ELEMENT_NAME_PREFIX = "User Task";

	private TabGeneralController tabGeneralController;
	private TabMulitInstanceController<UserTaskElement> tabMultiInstanceController;
	private TabListenerController<UserTaskElement> tabListenerController;
	private TabFormFieldsController tabFormFieldsController;
	private TabExtensionsController<UserTaskElement> tabExtensionsController;
	private TabInputOutputController<UserTaskElement> tabInputOutputController;

	// TODO: TabInputOutput

	public UserTaskPropertiesWidget(
			BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(LB_ELEMENT_NAME_PREFIX, jsoAccess);

		tabGeneralController = new TabGeneralController(jsoAccess);
		tabMultiInstanceController = new TabMulitInstanceController<UserTaskElement>(
				jsoAccess);
		tabListenerController = new TabListenerController<UserTaskElement>(
				jsoAccess, true);
		tabFormFieldsController = new TabFormFieldsController(jsoAccess);
		tabExtensionsController = new TabExtensionsController<UserTaskElement>(
				jsoAccess);
		tabInputOutputController = new TabInputOutputController<UserTaskElement>(
				jsoAccess);

		getTabLpContent().add(tabGeneralController.getView(),
				tabGeneralController.getView().getTabName());
		getTabLpContent().add(tabMultiInstanceController.getView(),
				tabMultiInstanceController.getView().getTabName());
		getTabLpContent().add(tabListenerController.getView(),
				tabListenerController.getView().getTabName());
		getTabLpContent().add(tabFormFieldsController.getView(),
				tabFormFieldsController.getView().getTabName());
		getTabLpContent().add(tabExtensionsController.getView(),
				tabExtensionsController.getView().getTabName());
		getTabLpContent().add(tabInputOutputController.getView(),
				tabInputOutputController.getView().getTabName());
	}

	@Override
	public void updateTabs() {
		tabGeneralController.updateView();
		tabMultiInstanceController.updateView();
		tabListenerController.updateView();
		tabFormFieldsController.updateView();
		tabExtensionsController.updateView();
		tabInputOutputController.updateView();
	}
}
