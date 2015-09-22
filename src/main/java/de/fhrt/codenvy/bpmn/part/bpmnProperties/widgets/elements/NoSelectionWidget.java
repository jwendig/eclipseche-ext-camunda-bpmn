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
package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements;

import java.util.Iterator;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

import de.fhrt.codenvy.bpmn.part.properties.BpmnElementPropertiesView;

public class NoSelectionWidget extends Composite {

	private final static String LB_ELEMENT_NAME_PREFIX = "Nothing selected";
	private DockLayoutPanel root;

	public NoSelectionWidget() {
		super();
		Log.info(NoSelectionWidget.class, "constructor");

		root = new DockLayoutPanel(Unit.PCT);
		root.setSize("100%", "100%");
		root.add(new Label("Select a BPMN-Element to edit his properties!"));
		initWidget(root);
	}
}
