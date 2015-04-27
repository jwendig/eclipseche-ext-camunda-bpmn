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

import com.google.gwt.user.client.ui.Label;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.usertask.general.TabGeneralController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.usertask.multiinstance.TabMulitInstanceController;

public class UserTaskPropertiesWidget extends AbstractBpmnPropertiesWidget {

	private final static String LB_ELEMENT_NAME_PREFIX = "User Task";

	private TabGeneralController tabGeneralController;
	private TabMulitInstanceController tabMultiInstanceController;

	public UserTaskPropertiesWidget(
			BpmnElementPropertiesView.ActionDelegate delegate) {
		super(LB_ELEMENT_NAME_PREFIX, delegate);

		tabGeneralController = new TabGeneralController(delegate);
		tabMultiInstanceController = new TabMulitInstanceController(delegate);
		
		getTabLpContent().add(tabGeneralController.getView(),
				tabGeneralController.getView().getTabName());
		getTabLpContent().add(tabMultiInstanceController.getView(),
				tabMultiInstanceController.getView().getTabName());
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
	}
}
