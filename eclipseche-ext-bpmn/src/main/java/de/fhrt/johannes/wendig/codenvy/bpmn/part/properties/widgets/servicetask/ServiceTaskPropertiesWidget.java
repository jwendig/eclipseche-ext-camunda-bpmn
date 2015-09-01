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
package de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.servicetask;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.ServiceTaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.AbstractBpmnPropertiesWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.base.extensions.TabExtensionsController;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.base.inputoutput.TabInputOutputController;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.base.listener.TabListenerController;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.base.multiinstance.TabMulitInstanceController;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.servicetask.general.TabGeneralController;

public class ServiceTaskPropertiesWidget extends AbstractBpmnPropertiesWidget {

	private final static String LB_ELEMENT_NAME_PREFIX = "Service Task";

	private TabGeneralController tabGeneralController;
	private TabMulitInstanceController<ServiceTaskJso> tabMultiInstanceController;
	private TabListenerController<ServiceTaskJso> tabListenerController;
	private TabExtensionsController<ServiceTaskJso> tabExtensionsController;
	private TabInputOutputController<ServiceTaskJso> tabInputOutputController;

	// TODO: tabFieldInjections, input/output, connector

	public ServiceTaskPropertiesWidget(BpmnElementPropertiesView delegate) {
		super(LB_ELEMENT_NAME_PREFIX, delegate);

		tabGeneralController = new TabGeneralController(delegate);
		tabMultiInstanceController = new TabMulitInstanceController<ServiceTaskJso>(
				delegate);
		tabListenerController = new TabListenerController<ServiceTaskJso>(
				delegate, false);
		tabExtensionsController = new TabExtensionsController<ServiceTaskJso>(
				delegate);

		tabInputOutputController = new TabInputOutputController<ServiceTaskJso>(
				delegate);

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
