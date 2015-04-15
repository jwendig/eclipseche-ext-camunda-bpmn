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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.process;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.ProcessJso;

public class TabGeneralController {
	private TabGeneralView view;

	public TabGeneralController() {
		this.view = new TabGeneralView();
	}

	public TabGeneralView getView() {
		return view;
	}

	public void initView(final ProcessJso element) {
		view.getTbProcessId().setText(element.getAttr_id());
		view.getTbName().setText(element.getAttr_name());

		view.getCbIsExecutable().setValue(element.getAttr_isExecutable());

		view.getTbDocumentation().setEnabled(false);
		view.getTbDocumentation().setText("not implemented");

		view.getTbProcessId().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				element.setAttr_id(view.getTbProcessId().getText());
			}
		});

		view.getTbName().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				element.setAttr_name(view.getTbName().getText());
			}
		});

		view.getCbIsExecutable().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						element.setAttr_isExecutable(event.getValue());
					}
				});
	}
}
