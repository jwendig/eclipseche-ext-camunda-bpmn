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

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.inject.Inject;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnProperties;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.process.ProcessProperties;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.servicetask.ServiceTaskProperties;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.startevent.StartEventProperties;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.unknown.UnknownItem;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.usertask.UserTaskProperties;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnProcessJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.CamundaElementJso;

public class BpmnElementPropertiesViewImpl extends Composite implements
		BpmnElementPropertiesView {

	private DockLayoutPanel dockLpCurrentContent;

	private ProcessProperties processProperties;
	private ServiceTaskProperties serviceTaskProperties;
	private StartEventProperties startEventProperties;
	private UserTaskProperties userTaskProperties;
	private UnknownItem unknowItemProperties;

	private AbstractBpmnProperties currentProperties;

	@Inject
	public BpmnElementPropertiesViewImpl() {
		Log.info(BpmnElementPropertiesViewImpl.class, "constructor");
		processProperties = new ProcessProperties();
		serviceTaskProperties = new ServiceTaskProperties();
		startEventProperties = new StartEventProperties();
		userTaskProperties = new UserTaskProperties();
		unknowItemProperties = new UnknownItem();

		currentProperties = processProperties;

		dockLpCurrentContent = new DockLayoutPanel(Unit.PX);
		dockLpCurrentContent.setSize("100%", "100%");
		dockLpCurrentContent.add(processProperties);

		initWidget(dockLpCurrentContent);
	}

	@Override
	public void setDelegate(ActionDelegate delegate) {
		Log.info(BpmnElementPropertiesViewImpl.class, "setDelegate");
	}

	@Override
	public void loadProcessProperties(BpmnProcessJso selectedItem) {
		Log.info(BpmnElementPropertiesViewImpl.class, "loadProcessProperties");
		dockLpCurrentContent.remove(currentProperties);
		currentProperties = processProperties;
		currentProperties.setSelectedProcess(selectedItem);
		dockLpCurrentContent.add(currentProperties);
	}

	@Override
	public void loadUserTaskProperties(CamundaElementJso selectedItem) {
		Log.info(BpmnElementPropertiesViewImpl.class, "loadUserTaskProperties");
		dockLpCurrentContent.remove(currentProperties);
		currentProperties = userTaskProperties;
		currentProperties.setSelectedItem(selectedItem);
		dockLpCurrentContent.add(currentProperties);
	}

	@Override
	public void loadServiceTaksProperties(CamundaElementJso selectedItem) {
		Log.info(BpmnElementPropertiesViewImpl.class,
				"loadServiceTaksProperties");
		dockLpCurrentContent.remove(currentProperties);
		currentProperties = serviceTaskProperties;
		currentProperties.setSelectedItem(selectedItem);
		dockLpCurrentContent.add(currentProperties);
	}

	@Override
	public void loadStartEventProperties(CamundaElementJso selectedItem) {
		Log.info(BpmnElementPropertiesViewImpl.class,
				"loadStartEventProperties");
		dockLpCurrentContent.remove(currentProperties);
		currentProperties = startEventProperties;
		currentProperties.setSelectedItem(selectedItem);
		dockLpCurrentContent.add(currentProperties);
	}

	@Override
	public void loadUnknownItemInfo(CamundaElementJso selectedItem) {
		dockLpCurrentContent.remove(currentProperties);
		currentProperties = unknowItemProperties;
		currentProperties.setSelectedItem(selectedItem);
		dockLpCurrentContent.add(currentProperties);
	}

}
