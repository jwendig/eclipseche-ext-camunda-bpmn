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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.startevent.event;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.uiElements.StartEventElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesTabController;

public class TabEventController extends
		AbstractBpmnPropertiesTabController<StartEventElement> {
	private final static String TAB_NAME = "Event";
	private TabEventView view;

	public TabEventController(BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(jsoAccess);
		view = new TabEventView(TAB_NAME, jsoAccess);
		view.getTbInitiator().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getCurrentBpmnElement().setAttr_initiator(
						view.getTbInitiator().getText());
				contentChanged();
			}
		});

	}

	public TabEventView getView() {
		return view;
	}

	@Override
	public void updateView() {
		getCurrentBpmnElement().setAttr_initiator(
				view.getTbInitiator().getText());

	}
}
