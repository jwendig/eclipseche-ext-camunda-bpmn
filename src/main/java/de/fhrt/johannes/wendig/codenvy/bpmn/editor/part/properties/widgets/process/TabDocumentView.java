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

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.user.client.ui.TextBox;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesTabWidget;

public class TabDocumentView extends AbstractBpmnPropertiesTabWidget {

	private TextBox tbTargetNamespace;

	public TabDocumentView(String tabName,
			BpmnElementPropertiesView.ActionDelegate delegate) {
		super(tabName, delegate);
		Log.info(TabDocumentView.class, "constructor");
	}

	@Override
	public void initContent() {
		Log.info(TabDocumentView.class, "initContent");
		getGridTabContent().resize(4, 2);

		getGridTabContent().setText(0, 0, "Target Namespace:");

		getGridTabContent().setWidget(0, 1, tbTargetNamespace);
	}

	@Override
	public void initContentElements() {
		Log.info(TabDocumentView.class, "initContentElements");
		tbTargetNamespace = new TextBox();
		tbTargetNamespace.setText("http://activiti.org/bpmn");
		tbTargetNamespace.setEnabled(false);
		tbTargetNamespace.setWidth("100%");
	}

}
