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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.startevent.general;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.web.bindery.requestfactory.server.RequestFactoryJarExtractor.ClassLoaderLoader;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesTabController;

public class TabGeneralController extends AbstractBpmnPropertiesTabController {
	private final static String TAB_NAME = "General";
	private TabGeneralView view;

	public TabGeneralController(
			BpmnElementPropertiesView.ActionDelegate delegate) {
		super(delegate);
		view = new TabGeneralView(TAB_NAME, delegate);
		view.getTbId().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getActionDelegate().getCurrentElementJso().setAttr_id(
						view.getTbId().getText());
				getActionDelegate().onContentChange();
			}
		});

		view.getTbName().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getActionDelegate().getCurrentElementJso().setAttr_name(
						view.getTbName().getText());
				getActionDelegate().onContentChange();
			}
		});

		view.getTbFormKey().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getActionDelegate().getCurrentElementJso().setAttr_formKey(
						view.getTbFormKey().getText());
				getActionDelegate().onContentChange();
			}
		});

		view.getCbAsycAfter().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						Log.info(TabGeneralController.class,
								"isExecuteable-changed");
						getActionDelegate().getCurrentElementJso()
								.setAttr_asyncAfter(event.getValue());
						getActionDelegate().onContentChange();
					}
				});

		view.getCbAsycBefore().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						Log.info(TabGeneralController.class,
								"isExecuteable-changed");
						getActionDelegate().getCurrentElementJso()
								.setAttr_asyncBefore(event.getValue());
						getActionDelegate().onContentChange();
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
		view.getTbId().setText(
				getActionDelegate().getCurrentElementJso().getAttr_id());
		view.getTbName().setText(
				getActionDelegate().getCurrentElementJso().getAttr_name());
		view.getTbFormKey().setText(
				getActionDelegate().getCurrentElementJso().getAttr_formKey());

		view.getCbAsycAfter().setValue(
				getActionDelegate().getCurrentElementJso()
						.getAttr_asyncAfter());
		view.getCbAsycBefore().setValue(
				getActionDelegate().getCurrentElementJso()
						.getAttr_asyncBefore());

		view.getTbRetryTimeCycle().setEnabled(false);
		view.getTbRetryTimeCycle().setText("not implemented");
		
		view.getTbDocumentation().setEnabled(false);
		view.getTbDocumentation().setText("not implemented");

	}
}