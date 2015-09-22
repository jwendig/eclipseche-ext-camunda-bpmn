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
package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.process;

import org.eclipse.che.ide.util.loging.Log;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.uiElements.ProcessElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesWidget;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.process.definitions.TabDefinitionsController;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.process.document.TabDocumentController;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.process.general.TabGeneralController;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.extensions.TabExtensionsController;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.listener.TabListenerController;

public class ProcessPropertiesWidget extends AbstractBpmnPropertiesWidget {

	private final static String LB_ELEMENT_NAME_PREFIX = "Process";

	private TabGeneralController tabGeneralController;
	private TabListenerController<ProcessElement> tabListenerController;
	private TabDocumentController tabDocumentController;
	private TabDefinitionsController tabDefinitionsController;

	private TabExtensionsController<ProcessElement> tabExtensionsController;

	public ProcessPropertiesWidget(BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(LB_ELEMENT_NAME_PREFIX, jsoAccess);
		Log.info(ProcessPropertiesWidget.class, "constructor");

		tabGeneralController = new TabGeneralController(jsoAccess);
		tabListenerController = new TabListenerController<ProcessElement>(
				jsoAccess, false);
		tabDocumentController = new TabDocumentController(jsoAccess);
		tabDefinitionsController = new TabDefinitionsController(jsoAccess);
		tabExtensionsController = new TabExtensionsController<ProcessElement>(
				jsoAccess);

		getTabLpContent().add(tabGeneralController.getView(),
				tabGeneralController.getView().getTabName());
		getTabLpContent().add(tabDefinitionsController.getView(),
				tabDefinitionsController.getView().getTabName());
		getTabLpContent().add(tabDocumentController.getView(),
				tabDocumentController.getView().getTabName());
		getTabLpContent().add(tabListenerController.getView(),
				tabListenerController.getView().getTabName());
		getTabLpContent().add(tabExtensionsController.getView(),
				tabExtensionsController.getView().getTabName());

		getTabLpContent().selectTab(tabGeneralController.getView());
	}

	@Override
	public void updateTabs() {
		Log.info(ProcessPropertiesWidget.class, "updateTabs()");
		tabGeneralController.updateView();
		tabListenerController.updateView();
		tabDocumentController.updateView();
		tabDefinitionsController.updateView();
		tabExtensionsController.updateView();
	}
}
