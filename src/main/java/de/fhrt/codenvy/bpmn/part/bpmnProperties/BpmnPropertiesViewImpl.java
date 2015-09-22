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
package de.fhrt.codenvy.bpmn.part.bpmnProperties;

import org.eclipse.che.ide.api.parts.PartStackUIResources;
import org.eclipse.che.ide.api.parts.base.BaseView;
import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.inject.Inject;

import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.BpmnElementJso.BpmnElementType;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.BpmnIoElementWrapper;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoElementJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoModelerJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesWidget;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.NoSelectionWidget;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.UnknownItemWidget;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.process.ProcessPropertiesWidget;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.startevent.StartEventPropertiesWidget;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.usertask.UserTaskPropertiesWidget;

public class BpmnPropertiesViewImpl extends
		BaseView<BpmnPropertiesView.ActionDelegate> implements
		BpmnPropertiesView, BpmnPropertiesView.CurrentJsoAccess {

	private final static String TITLE = "BPMN Properties";

	private LayoutPanel widgetContainer;

	private BpmnIoElementWrapper currentElement;
	private AbstractBpmnPropertiesWidget currentProperties;

	private UnknownItemWidget unknowItemProperties;
	private NoSelectionWidget noselectionProperties;
	private ProcessPropertiesWidget processProperties;
	private StartEventPropertiesWidget startEventProperties;
	private UserTaskPropertiesWidget userTaskProperties;

	@Inject
	public BpmnPropertiesViewImpl(PartStackUIResources resources) {
		super(resources);
		noselectionProperties = new NoSelectionWidget();
		unknowItemProperties = new UnknownItemWidget(this);
		processProperties = new ProcessPropertiesWidget(this);
		startEventProperties = new StartEventPropertiesWidget(this);
		userTaskProperties = new UserTaskPropertiesWidget(this);

		widgetContainer = new LayoutPanel();
		widgetContainer.setSize("100%", "100%");
		widgetContainer.add(noselectionProperties);

		setTitle(TITLE);
		setContentWidget(widgetContainer);
	}

	@Override
	public void loadWidgetForSelectedBpmnElement(BpmnIoModelerJso modelerJso,
			BpmnIoElementJso elementJso) {
		Log.info(BpmnPropertiesViewImpl.class,
				"loadWidgetForSelectedBpmnElement");

		currentElement = new BpmnIoElementWrapper(elementJso, modelerJso);
		widgetContainer.clear();

		switch (BpmnElementType
				.findByBpmnIoTypeDefinition(elementJso.getType())) {
		case DEFAULT:
			currentProperties = unknowItemProperties;
			break;
		case PROCESS:
			currentProperties = processProperties;
			break;
		// case SCRIPT_TASK:
		// currentProperties = unknowItemProperties;
		// break;
		// case SERVICE_TASK:
		// currentProperties = serviceTaskProperties;
		// break;
		case START_EVENT:
			currentProperties = startEventProperties;
			break;
		// case TASK:
		// currentProperties = unknowItemProperties;
		// break;
		case USER_TASK:
			currentProperties = userTaskProperties;
			break;
		default:
			currentProperties = unknowItemProperties;
		}

		widgetContainer.add(currentProperties);
		currentProperties.updatePropertiesView();
		setTitle(TITLE + " (" + currentProperties.getLbElementText() + ")");
	}

	@Override
	public void clearView() {
		Log.info(BpmnPropertiesViewImpl.class, "clearView");
		widgetContainer.clear();
		widgetContainer.add(noselectionProperties);
	}

	@Override
	public void onContentChange() {
		currentElement.getModeler().nativeUpdateData();
	}

	@Override
	public BpmnIoElementWrapper getCurrentElement() {
		return currentElement;
	}

}
