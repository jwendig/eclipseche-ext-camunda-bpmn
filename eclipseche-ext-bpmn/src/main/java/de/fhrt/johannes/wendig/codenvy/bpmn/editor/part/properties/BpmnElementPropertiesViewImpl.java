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

import org.eclipse.che.ide.api.parts.PartStackUIResources;
import org.eclipse.che.ide.api.parts.base.BaseView;
import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.inject.Inject;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.noselection.NoSelectionWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.process.ProcessPropertiesWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.servicetask.ServiceTaskPropertiesWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.startevent.StartEventPropertiesWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.unknown.UnknownItemWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.usertask.UserTaskPropertiesWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementJso;

public class BpmnElementPropertiesViewImpl extends
		BaseView<BpmnElementPropertiesView.ActionDelegate> implements
		BpmnElementPropertiesView {

	private DockLayoutPanel dockLpCurrentContent;

	// TODO: create View for NoElementSelected and load it on Startup
	private UnknownItemWidget unknowItemProperties;
	private NoSelectionWidget noselectionProperties;

	private ProcessPropertiesWidget processProperties;
	private ServiceTaskPropertiesWidget serviceTaskProperties;
	private StartEventPropertiesWidget startEventProperties;
	private UserTaskPropertiesWidget userTaskProperties;

	private AbstractBpmnPropertiesWidget currentProperties;

	@Inject
	public BpmnElementPropertiesViewImpl(PartStackUIResources resources) {
		super(resources);
		unknowItemProperties = new UnknownItemWidget();
		noselectionProperties = new NoSelectionWidget();

		processProperties = new ProcessPropertiesWidget(delegate);
		serviceTaskProperties = new ServiceTaskPropertiesWidget();
		startEventProperties = new StartEventPropertiesWidget();
		userTaskProperties = new UserTaskPropertiesWidget();

		currentProperties = noselectionProperties;

		dockLpCurrentContent = new DockLayoutPanel(Unit.PX);
		dockLpCurrentContent.setSize("100%", "100%");
		dockLpCurrentContent.add(currentProperties);

		setContentWidget(dockLpCurrentContent);
	}

	@Override
	public String getTitle() {
		Log.info(BpmnElementPropertiesViewImpl.class, "getTitle");
		return "test";
	}

	@Override
	public void setTitle(String title) {
		Log.info(BpmnElementPropertiesViewImpl.class,
				"setTitle: title before = " + title);
		super.setTitle(title);
	}

	@Override
	public void loadProcessProperties(BpmnDiagramElementJso selectedItem) {
		Log.info(BpmnElementPropertiesViewImpl.class, "loadProcessProperties");
		dockLpCurrentContent.remove(currentProperties);
		currentProperties = processProperties;
		currentProperties.setSelectedItem(selectedItem);
		dockLpCurrentContent.add(currentProperties);
	}

	@Override
	public void loadUserTaskProperties(BpmnDiagramElementJso selectedItem) {
		Log.info(BpmnElementPropertiesViewImpl.class, "loadUserTaskProperties");
		dockLpCurrentContent.remove(currentProperties);
		currentProperties = userTaskProperties;
		currentProperties.setSelectedItem(selectedItem);
		dockLpCurrentContent.add(currentProperties);
	}

	@Override
	public void loadServiceTaksProperties(BpmnDiagramElementJso selectedItem) {
		Log.info(BpmnElementPropertiesViewImpl.class,
				"loadServiceTaksProperties");
		dockLpCurrentContent.remove(currentProperties);
		currentProperties = serviceTaskProperties;
		currentProperties.setSelectedItem(selectedItem);
		dockLpCurrentContent.add(currentProperties);
	}

	@Override
	public void loadStartEventProperties(BpmnDiagramElementJso selectedItem) {
		Log.info(BpmnElementPropertiesViewImpl.class,
				"loadStartEventProperties");
		dockLpCurrentContent.remove(currentProperties);
		currentProperties = startEventProperties;
		currentProperties.setSelectedItem(selectedItem);
		dockLpCurrentContent.add(currentProperties);
	}

	@Override
	public void loadUnknownItemInfo(BpmnDiagramElementJso selectedItem) {
		dockLpCurrentContent.remove(currentProperties);
		currentProperties = unknowItemProperties;
		currentProperties.setSelectedItem(selectedItem);
		dockLpCurrentContent.add(currentProperties);
	}

	@Override
	public void loadNoSelectionInfo() {
		dockLpCurrentContent.remove(currentProperties);
		currentProperties = noselectionProperties;
		dockLpCurrentContent.add(currentProperties);
	}

}
