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
package de.fhrt.johannes.wendig.codenvy.bpmn.part.properties;

import org.eclipse.che.ide.api.parts.PartStackUIResources;
import org.eclipse.che.ide.api.parts.base.BaseView;
import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.inject.Inject;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.BpmnElementJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.BpmnElementJso.BpmnElementType;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.BpmnModelerJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.AbstractBpmnPropertiesWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.noselection.NoSelectionWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.process.ProcessPropertiesWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.servicetask.ServiceTaskPropertiesWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.startevent.StartEventPropertiesWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.unknown.UnknownItemWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.usertask.UserTaskPropertiesWidget;

public class BpmnElementPropertiesViewImpl extends
		BaseView<BpmnElementPropertiesView.ActionDelegate> implements
		BpmnElementPropertiesView, BpmnElementPropertiesView.CurrentJsoAccess {

	private final static String TITLE = "BPMN Properties";

	private DockLayoutPanel root;

	private BpmnElementJso currentElementJso;
	private BpmnModelerJso currentBpmnIoModelerJso;
	private AbstractBpmnPropertiesWidget currentProperties;

	private UnknownItemWidget unknowItemProperties;
	private NoSelectionWidget noselectionProperties;
	private ProcessPropertiesWidget processProperties;
	private ServiceTaskPropertiesWidget serviceTaskProperties;
	private StartEventPropertiesWidget startEventProperties;
	private UserTaskPropertiesWidget userTaskProperties;

	@Inject
	public BpmnElementPropertiesViewImpl(PartStackUIResources resources) {
		super(resources);
		noselectionProperties = new NoSelectionWidget();
		unknowItemProperties = new UnknownItemWidget(this);
		processProperties = new ProcessPropertiesWidget(this);
		serviceTaskProperties = new ServiceTaskPropertiesWidget(this);
		startEventProperties = new StartEventPropertiesWidget(this);
		userTaskProperties = new UserTaskPropertiesWidget(this);

		root = new DockLayoutPanel(Unit.PX);
		root.setSize("100%", "100%");
		root.add(noselectionProperties);

		setTitle(TITLE);
		setContentWidget(root);
	}

	@Override
	public void setTitle(String title) {
		Log.info(BpmnElementPropertiesViewImpl.class,
				"setTitle: title before = " + title);
		super.setTitle(title);
	}

	@Override
	public void loadWidgetForSelectedBpmnElement(BpmnModelerJso modelerJso,
			BpmnElementJso elementJso) {
		Log.info(BpmnElementPropertiesViewImpl.class,
				"loadWidgetForSelectedBpmnElement");
		currentElementJso = elementJso;
		currentBpmnIoModelerJso = modelerJso;

		root.clear();

		switch (BpmnElementType
				.findByBpmnIoTypeDefinition(elementJso.getType())) {
		case DEFAULT:
			currentProperties = unknowItemProperties;
			break;
		case PROCESS:
			currentProperties = processProperties;
			break;
		case SCRIPT_TASK:
			currentProperties = unknowItemProperties;
			break;
		case SERVICE_TASK:
			currentProperties = serviceTaskProperties;
			break;
		case START_EVENT:
			currentProperties = startEventProperties;
			break;
		case TASK:
			currentProperties = unknowItemProperties;
			break;
		case USER_TASK:
			currentProperties = userTaskProperties;
			break;
		default:
			currentProperties = unknowItemProperties;
		}

		root.add(currentProperties);
		currentProperties.updatePropertiesView();

	}

	@Override
	public void clearView() {
		Log.info(BpmnElementPropertiesViewImpl.class, "clearView");
		root.clear();
		root.add(noselectionProperties);
	}

	@Override
	public void onContentChange() {
		currentBpmnIoModelerJso.nativeUpdateData();
	}

	@Override
	public BpmnElementJso getCurrentElementJso() {
		return currentElementJso;
	}

	@Override
	public BpmnModelerJso getCurrentBpmnIoModelerJso() {
		return currentBpmnIoModelerJso;
	}
}
