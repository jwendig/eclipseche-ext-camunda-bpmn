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
package de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.startevent;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.StartEventJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.AbstractBpmnPropertiesWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.base.extensions.TabExtensionsController;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.base.formfields.TabFormFieldsController;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.base.listener.TabListenerController;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.startevent.event.TabEventController;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.startevent.general.TabGeneralController;

public class StartEventPropertiesWidget extends AbstractBpmnPropertiesWidget {

	private final static String LB_ELEMENT_NAME_PREFIX = "Start Event";

	private TabGeneralController tabGeneralController;
	private TabEventController tabEventController;
	private TabListenerController<StartEventJso> tabListenerController;
	private TabExtensionsController<StartEventJso> tabExtensionsController;
	private TabFormFieldsController tabFormFieldsController;

	public StartEventPropertiesWidget(BpmnElementPropertiesView delegate) {
		super(LB_ELEMENT_NAME_PREFIX, delegate);

		tabGeneralController = new TabGeneralController(delegate);
		tabEventController = new TabEventController(delegate);
		tabListenerController = new TabListenerController<StartEventJso>(
				delegate, false);
		tabFormFieldsController = new TabFormFieldsController(delegate);
		tabExtensionsController = new TabExtensionsController<StartEventJso>(
				delegate);

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
		tabEventController.updateView();
		tabListenerController.updateView();
		tabExtensionsController.updateView();
		tabFormFieldsController.updateView();
	}
}
