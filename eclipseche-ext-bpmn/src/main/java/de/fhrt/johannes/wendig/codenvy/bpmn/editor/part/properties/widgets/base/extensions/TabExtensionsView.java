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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.base.extensions;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextBox;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView.ActionDelegate;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesTabWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.process.definitions.TableErrorsWidget;

public class TabExtensionsView extends AbstractBpmnPropertiesTabWidget {
	private TableExtensionsWidget ctExtensions;

	public TabExtensionsView(String tabName,
			BpmnElementPropertiesView.ActionDelegate delegate) {
		super(tabName, delegate);
		Log.info(TabExtensionsView.class, "constructor");
	}

	@Override
	public void initContent() {
		Log.info(TabExtensionsView.class, "initContent");
		getGridTabContent().resize(1, 2);

		getGridTabContent().setText(0, 0, "Extensions:");

		getGridTabContent().setWidget(0, 1, ctExtensions);
	}

	@Override
	public void initContentElements() {
		Log.info(TabExtensionsView.class, "initContentElements");
		ctExtensions = new TableExtensionsWidget(getDelegate());
		ctExtensions.setWidth("100%");
	}

	public TableExtensionsWidget getCtExtensions() {
		return ctExtensions;
	}

}
