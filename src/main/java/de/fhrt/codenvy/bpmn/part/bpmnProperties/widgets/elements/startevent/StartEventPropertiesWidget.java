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
package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.startevent;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.uiElements.StartEventElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesWidget;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.extensions.TabExtensionsController;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.formfields.TabFormFieldsController;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.listener.TabListenerController;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.startevent.event.TabEventController;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.startevent.general.TabGeneralController;

public class StartEventPropertiesWidget extends AbstractBpmnPropertiesWidget {

	private final static String LB_ELEMENT_NAME_PREFIX = "Start Event";

	private TabGeneralController tabGeneralController;
	private TabEventController tabEventController;
	private TabListenerController<StartEventElement> tabListenerController;
	private TabExtensionsController<StartEventElement> tabExtensionsController;
	private TabFormFieldsController tabFormFieldsController;

	public StartEventPropertiesWidget(
			BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(LB_ELEMENT_NAME_PREFIX, jsoAccess);

		tabGeneralController = new TabGeneralController(jsoAccess);
		tabEventController = new TabEventController(jsoAccess);
		tabListenerController = new TabListenerController<StartEventElement>(
				jsoAccess, false);
		tabFormFieldsController = new TabFormFieldsController(jsoAccess);
		tabExtensionsController = new TabExtensionsController<StartEventElement>(
				jsoAccess);

		getTabLpContent().add(tabGeneralController.getView(),
				tabGeneralController.getView().getTabName());
		getTabLpContent().add(tabEventController.getView(),
				tabEventController.getView().getTabName());
		getTabLpContent().add(tabListenerController.getView(),
				tabListenerController.getView().getTabName());
		getTabLpContent().add(tabFormFieldsController.getView(),
				tabFormFieldsController.getView().getTabName());
		getTabLpContent().add(tabExtensionsController.getView(),
				tabExtensionsController.getView().getTabName());
	}

	@Override
	public void updateTabs() {
		tabGeneralController.updateView();
		tabEventController.updateView();
		tabListenerController.updateView();
		tabExtensionsController.updateView();
		tabFormFieldsController.updateView();
	}
}
