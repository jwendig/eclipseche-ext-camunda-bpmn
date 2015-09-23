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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.startevent.general;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.uiElements.StartEventElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesTabController;

public class TabGeneralController extends
		AbstractBpmnPropertiesTabController<StartEventElement> {
	private final static String TAB_NAME = "General";
	private TabGeneralView view;

	public TabGeneralController(BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(jsoAccess);
		view = new TabGeneralView(TAB_NAME, jsoAccess);
		view.getTbId().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getCurrentBpmnElement().setAttr_id(view.getTbId().getText());
				contentChanged();
			}
		});

		view.getTbName().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getCurrentBpmnElement()
						.setAttr_name(view.getTbName().getText());
				contentChanged();
			}
		});

		view.getTbFormKey().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getCurrentBpmnElement().setAttr_formKey(
						view.getTbFormKey().getText());
				contentChanged();
			}
		});

		view.getCbAsycAfter().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						Log.info(TabGeneralController.class,
								"isExecuteable-changed");
						getCurrentBpmnElement().setAttr_asyncAfter(
								event.getValue());
						contentChanged();

					}
				});

		view.getCbAsycBefore().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						Log.info(TabGeneralController.class,
								"isExecuteable-changed");
						getCurrentBpmnElement().setAttr_asyncBefore(
								event.getValue());
						contentChanged();
					}
				});

		view.getTbRetryTimeCycle().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO: implement
				// getActionDelegate().onContentChange();
			}
		});

		view.getTbDocumentation().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO: implement
				// getActionDelegate().onContentChange();
			}
		});
	}

	public TabGeneralView getView() {
		return view;
	}

	@Override
	public void updateView() {
		view.getTbId().setText(getCurrentBpmnElement().getAttr_id());

		view.getTbName().setText(getCurrentBpmnElement().getAttr_name());
		view.getTbFormKey().setText(getCurrentBpmnElement().getAttr_formKey());

		view.getCbAsycAfter().setValue(
				getCurrentBpmnElement().getAttr_asyncAfter());
		view.getCbAsycBefore().setValue(
				getCurrentBpmnElement().getAttr_asyncBefore());

		view.getTbRetryTimeCycle().setText("not implemented");
		view.getTbDocumentation().setText("not implemented");

		view.getTbRetryTimeCycle().setEnabled(false);
		view.getTbDocumentation().setEnabled(false);
	}
}
