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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.base.multiinstance;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextBox;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView.ActionDelegate;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesTabWidget;

public class TabMultiInstanceView extends AbstractBpmnPropertiesTabWidget {
	private CheckBox cbIsLoop;
	private CheckBox cbMultiInstance;

	public TabMultiInstanceView(String tabName,
			BpmnElementPropertiesView.ActionDelegate delegate) {
		super(tabName, delegate);
		Log.info(TabMultiInstanceView.class, "constructor");
	}

	@Override
	public void initContent() {
		Log.info(TabMultiInstanceView.class, "initContent");
		getGridTabContent().resize(2, 2);

		getGridTabContent().setText(0, 0, "Is Loop:");
		getGridTabContent().setText(1, 0, "Is Multi Instance:");

		getGridTabContent().setWidget(0, 1, cbIsLoop);
		getGridTabContent().setWidget(1, 1, cbMultiInstance);
	}

	@Override
	public void initContentElements() {
		Log.info(TabMultiInstanceView.class, "initContentElements");
		cbIsLoop = new CheckBox();
		cbIsLoop.setWidth("100%");

		cbMultiInstance = new CheckBox();
		cbMultiInstance.setWidth("100%");

	}

	public CheckBox getCbIsLoop() {
		return cbIsLoop;
	}

	public CheckBox getCbMultiInstance() {
		return cbMultiInstance;
	}


}
