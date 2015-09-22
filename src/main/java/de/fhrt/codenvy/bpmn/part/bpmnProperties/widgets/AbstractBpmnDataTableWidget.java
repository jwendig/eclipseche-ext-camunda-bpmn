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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;

public abstract class AbstractBpmnDataTableWidget<T> extends Composite {
	private BpmnPropertiesView.CurrentJsoAccess jsoAccess;
	private ListDataProvider<T> dataProvider;
	private CellTable<T> table;
	private VerticalPanel rootPanel;
	private HorizontalPanel buttonPanel;

	public AbstractBpmnDataTableWidget(
			BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		Log.info(AbstractBpmnDataTableWidget.class, "constructor()");
		this.jsoAccess = jsoAccess;

		table = new CellTable<T>();
		table.addStyleName("bpmnPropertiesWidget-cellTable");
		table.setWidth("100%");

		buttonPanel = new HorizontalPanel();

		buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

		rootPanel = new VerticalPanel();
		rootPanel.setSize("100%", "auto");
		rootPanel.add(table);
		rootPanel.add(buttonPanel);

		initWidget(rootPanel);

		dataProvider = new ListDataProvider<T>();
		dataProvider.addDataDisplay(table);
	}

	public BpmnPropertiesView.CurrentJsoAccess getJsoAccess() {
		return jsoAccess;
	}

	public ListDataProvider<T> getDataProvider() {
		return dataProvider;
	}

	public CellTable<T> getTable() {
		return table;
	}

	public VerticalPanel getRootPanel() {
		return rootPanel;
	}

	public HorizontalPanel getButtonPanel() {
		return buttonPanel;
	}

	public abstract void update();

}
