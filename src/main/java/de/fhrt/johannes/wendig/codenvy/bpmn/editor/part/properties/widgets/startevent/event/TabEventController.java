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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.startevent.event;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesTabController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.StartEventJso;

public class TabEventController extends
		AbstractBpmnPropertiesTabController<StartEventJso> {
	private final static String TAB_NAME = "Event";
	private TabEventView view;

	public TabEventController(BpmnElementPropertiesView.ActionDelegate delegate) {
		super(delegate);
		view = new TabEventView(TAB_NAME, delegate);
		view.getTbInitiator().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// getActionDelegate().getCurrentElementJso().setAttr_initiator(
				// view.getTbInitiator().getText());
				// getActionDelegate().onContentChange();
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
		// view.getTbInitiator().setText(
		// getActionDelegate().getCurrentElementJso().getAttr_initiator());
		getCurrentBpmnElement().setAttr_initiator(
				view.getTbInitiator().getText());

	}
}
