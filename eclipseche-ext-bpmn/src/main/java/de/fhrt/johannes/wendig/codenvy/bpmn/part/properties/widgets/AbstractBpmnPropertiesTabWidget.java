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

package de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.ScrollPanel;

import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.BpmnElementPropertiesView;

public abstract class AbstractBpmnPropertiesTabWidget extends Composite {

	private BpmnElementPropertiesView.CurrentJsoAccess jsoAccess;
	private String tabName = "Document";
	private Grid gridTabContent;

	public AbstractBpmnPropertiesTabWidget(String tabName,
			BpmnElementPropertiesView.CurrentJsoAccess jsoAccess) {
		super();
		this.tabName = tabName;
		this.jsoAccess = jsoAccess;

		gridTabContent = new Grid();
		gridTabContent.setSize("100%", "100%");

		initContentElements();
		initContent();

		ScrollPanel scrollLpContentWrapper = new ScrollPanel(gridTabContent);
		scrollLpContentWrapper.setSize("100%", "100%");

		initWidget(scrollLpContentWrapper);

		if (gridTabContent.getColumnCount() > 1) {
			gridTabContent.getColumnFormatter().setWidth(0, "100px");
			gridTabContent.getColumnFormatter().setWidth(1, "auto");
		}
	}

	/*
	 * abstract functions
	 */
	public void initContentElements() {
	}

	public void initContent() {
	}

	/*
	 * getter & setter
	 */

	public Grid getGridTabContent() {
		return gridTabContent;
	}

	public void setGridTabContent(Grid content) {
		this.gridTabContent = content;
	}

	public BpmnElementPropertiesView.CurrentJsoAccess getJsoAccess() {
		return jsoAccess;
	}

	public String getTabName() {
		return tabName;
	}

}
