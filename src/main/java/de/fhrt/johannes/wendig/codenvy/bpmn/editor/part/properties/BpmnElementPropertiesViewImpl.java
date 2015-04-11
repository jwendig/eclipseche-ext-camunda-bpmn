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
package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.inject.Inject;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.BaseBpmnProperties;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.properties.process.ProcessProperties;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.properties.servicetask.ServiceTaskProperties;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.properties.startevent.StartEventProperties;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.properties.usertask.UserTaskProperties;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget;

public class BpmnElementPropertiesViewImpl extends Composite implements
		BpmnElementPropertiesView, BpmnElementPropertiesCallback {

	private DockLayoutPanel dockLpCurrentContent;

	private ProcessProperties processProperties;
	private ServiceTaskProperties serviceTaskProperties;
	private StartEventProperties startEventProperties;
	private UserTaskProperties userTaskProperties;

	private BaseBpmnProperties currentProperties;

	@Inject
	public BpmnElementPropertiesViewImpl() {
		processProperties = new ProcessProperties();
		serviceTaskProperties = new ServiceTaskProperties();
		startEventProperties = new StartEventProperties();
		userTaskProperties = new UserTaskProperties();

		currentProperties = processProperties;

		dockLpCurrentContent = new DockLayoutPanel(Unit.PX);
		dockLpCurrentContent.add(processProperties);

		initWidget(dockLpCurrentContent);
	}

	@Override
	public void setDelegate(ActionDelegate delegate) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.
	 * BpmnElementPropertiesCallback#elementSelected()
	 */
	@Override
	public void elementSelected(BpmnEditorDiagramWidget.ElementType type) {
		dockLpCurrentContent.remove(currentProperties);
		switch (type) {
		case SERVICE_TASK:
			currentProperties = serviceTaskProperties;
			break;
		case USER_TASK:
			currentProperties = userTaskProperties;
			break;
		case START_EVENT:
			currentProperties = startEventProperties;
			break;
		case UNKNOWN:
			currentProperties = processProperties;
		}
		dockLpCurrentContent.add(currentProperties);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.
	 * BpmnElementPropertiesCallback#elementUnselected()
	 */
	@Override
	public void elementUnselected() {
		dockLpCurrentContent.remove(currentProperties);
		currentProperties = processProperties;
		dockLpCurrentContent.add(currentProperties);
	}
}
