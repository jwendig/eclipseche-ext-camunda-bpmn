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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.base.formfields;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesTabWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.ExecutionListenerJso;

public class TabFormFieldsView extends AbstractBpmnPropertiesTabWidget {
	private TableFormFieldsWidget tableFormFields;

	public TabFormFieldsView(String tabName,
			BpmnElementPropertiesView.ActionDelegate delegate) {
		super(tabName, delegate);
		Log.info(TabFormFieldsView.class, "constructor");
	}

	@Override
	public void initContent() {
		Log.info(TabFormFieldsView.class, "initContent");
		getGridTabContent().resize(2, 2);

		getGridTabContent().setText(0, 0, "Form Fields:");
		getGridTabContent().setWidget(0, 1, tableFormFields);
	}

	@Override
	public void initContentElements() {
		Log.info(TabFormFieldsView.class, "initContentElements");

		tableFormFields = new TableFormFieldsWidget(getDelegate());
	}

	public TableFormFieldsWidget getTableFormFields() {
		return tableFormFields;
	}

}
