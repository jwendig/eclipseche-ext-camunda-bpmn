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
package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.usertask;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.base.extensions.TabExtensionsController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.base.formfields.TabFormFieldsController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.base.listener.TabListenerController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.base.multiinstance.TabMulitInstanceController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.usertask.general.TabGeneralController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.UserTaskJso;

public class UserTaskPropertiesWidget extends AbstractBpmnPropertiesWidget {

	private final static String LB_ELEMENT_NAME_PREFIX = "User Task";

	private TabGeneralController tabGeneralController;
	private TabMulitInstanceController<UserTaskJso> tabMultiInstanceController;
	private TabListenerController<UserTaskJso> tabListenerController;
	private TabFormFieldsController tabFormFieldsController;
	private TabExtensionsController<UserTaskJso> tabExtensionsController;
	
	// TODO: TabInputOutput

	public UserTaskPropertiesWidget(
			BpmnElementPropertiesView.ActionDelegate delegate) {
		super(LB_ELEMENT_NAME_PREFIX, delegate);

		tabGeneralController = new TabGeneralController(delegate);
		tabMultiInstanceController = new TabMulitInstanceController<UserTaskJso>(
				delegate);
		tabListenerController = new TabListenerController<UserTaskJso>(
				delegate, true);
		tabFormFieldsController = new TabFormFieldsController(delegate);
		tabExtensionsController = new TabExtensionsController<UserTaskJso>(
				delegate);

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
		tabFormFieldsController.updateView();
		tabExtensionsController.updateView();
	}
}
