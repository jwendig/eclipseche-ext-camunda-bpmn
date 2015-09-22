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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.process.general;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.uiElements.ProcessElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesTabController;

public class TabGeneralController extends
		AbstractBpmnPropertiesTabController<ProcessElement> {
	private final static String TAB_NAME = "General";
	private TabGeneralView view;

	public TabGeneralController(BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(jsoAccess);
		view = new TabGeneralView(TAB_NAME, jsoAccess);
		view.getTbProcessId().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				Log.info(TabGeneralController.class, "processId-changed");
				getCurrentBpmnElement().setAttr_id(
						view.getTbProcessId().getText());
				contentChanged();
			}
		});

		view.getTbName().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				Log.info(TabGeneralController.class, "name-changed");
				getCurrentBpmnElement()
						.setAttr_name(view.getTbName().getText());
				contentChanged();
			}
		});

		view.getCbIsExecutable().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						Log.info(TabGeneralController.class,
								"isExecuteable-changed");
						getCurrentBpmnElement().setAttr_isExecutable(
								event.getValue());
						contentChanged();
					}
				});
	}

	public TabGeneralView getView() {
		return view;
	}

	@Override
	public void updateView() {
		Log.info(TabGeneralController.class, "updateView()");
		view.getTbProcessId().setText(getCurrentBpmnElement().getAttr_id());
		view.getTbName().setText(getCurrentBpmnElement().getAttr_name());

		view.getCbIsExecutable().setValue(
				getCurrentBpmnElement().getAttr_isExecutable());

		view.getTbDocumentation().setEnabled(false);
		view.getTbDocumentation().setText("not implemented");

		view.getTableDataObjectsWidget().update();
	}
}
