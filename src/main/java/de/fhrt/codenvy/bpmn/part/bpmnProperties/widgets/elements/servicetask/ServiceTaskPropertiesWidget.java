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
package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.servicetask;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.uiElements.ServiceTaskElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesWidget;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.extensions.TabExtensionsController;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.general.TabGeneralController;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.general.TabGeneralView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.inputoutput.TabInputOutputController;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.listener.TabListenerController;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.multiinstance.TabMulitInstanceController;

//import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.servicetask.general.TabGeneralController;

public class ServiceTaskPropertiesWidget extends AbstractBpmnPropertiesWidget {

	private final static String LB_ELEMENT_NAME_PREFIX = "Service Task";
	private final static Integer[] TAB_GENERAL_FIELDS = { TabGeneralView.ROW_CLASS,
			TabGeneralView.ROW_EXPRESSION,
			TabGeneralView.ROW_EXPRESSION_DELEGATE,
			TabGeneralView.ROW_RESULT_VARIABLE, };

	private TabGeneralController<ServiceTaskElement> tabGeneralController;
	private TabMulitInstanceController<ServiceTaskElement> tabMultiInstanceController;
	private TabListenerController<ServiceTaskElement> tabListenerController;
	private TabExtensionsController<ServiceTaskElement> tabExtensionsController;
	private TabInputOutputController<ServiceTaskElement> tabInputOutputController;

	// TODO: tabFieldInjections, input/output, connector

	public ServiceTaskPropertiesWidget(
			BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(LB_ELEMENT_NAME_PREFIX, jsoAccess);

		tabGeneralController = new TabGeneralController<ServiceTaskElement>(
				jsoAccess, TAB_GENERAL_FIELDS);
		tabMultiInstanceController = new TabMulitInstanceController<ServiceTaskElement>(
				jsoAccess);
		tabListenerController = new TabListenerController<ServiceTaskElement>(
				jsoAccess, false);
		tabExtensionsController = new TabExtensionsController<ServiceTaskElement>(
				jsoAccess);

		tabInputOutputController = new TabInputOutputController<ServiceTaskElement>(
				jsoAccess);

		getTabLpContent().add(tabGeneralController.getView(),
				tabGeneralController.getView().getTabName());
		getTabLpContent().add(tabMultiInstanceController.getView(),
				tabMultiInstanceController.getView().getTabName());
		getTabLpContent().add(tabListenerController.getView(),
				tabListenerController.getView().getTabName());
		getTabLpContent().add(tabInputOutputController.getView(),
				tabInputOutputController.getView().getTabName());
		getTabLpContent().add(tabExtensionsController.getView(),
				tabExtensionsController.getView().getTabName());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.
	 * AbstractBpmnProperties
	 * #initSelectedItem(de.fhrt.johannes.wendig.codenvy.bpmn
	 * .editor.widget.diagram.bpmnelements.BpmnDiagramElementJso)
	 */
	@Override
	public void updateTabs() {
		tabGeneralController.updateView();
		tabMultiInstanceController.updateView();
		tabListenerController.updateView();
		tabExtensionsController.updateView();
		tabInputOutputController.updateView();
	}
}
