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

package de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.base;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;

public class ScriptWidget extends Composite {
	private Grid root;

	private TextBox tbFormat;
	private TextBox tbResource;
	private TextArea taScript;
	private RadioButton rbResource;
	private RadioButton rbScript;

	public ScriptWidget() {
		root = new Grid(3, 2);
		root.setSize("100%", "auto");

		tbFormat = new TextBox();
		tbFormat.setWidth("100%");

		tbResource = new TextBox();
		tbResource.setWidth("100%");

		taScript = new TextArea();
		taScript.setWidth("100%");

		ClickHandler rbHandler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (rbResource.getValue() == true) {
					tbResource.setEnabled(true);
					taScript.setEnabled(false);
					taScript.setText("");
				} else {
					taScript.setEnabled(true);
					tbResource.setEnabled(false);
					tbResource.setText("");
				}

			}
		};

		rbResource = new RadioButton("type");
		rbResource.addClickHandler(rbHandler);

		rbScript = new RadioButton("type");
		rbScript.addClickHandler(rbHandler);

		root.setText(0, 0, "Script Format");
		root.setWidget(1, 0, rbResource);
		root.setWidget(2, 0, rbScript);

		root.setWidget(0, 1, tbFormat);
		root.setWidget(1, 1, tbResource);
		root.setWidget(2, 1, taScript);

		initWidget(root);
	}

	public TextBox getTbFormat() {
		return tbFormat;
	}

	public TextBox getTbResource() {
		return tbResource;
	}

	public TextArea getTaScript() {
		return taScript;
	}

	public RadioButton getRbResource() {
		return rbResource;
	}

	public RadioButton getRbScript() {
		return rbScript;
	}

}
