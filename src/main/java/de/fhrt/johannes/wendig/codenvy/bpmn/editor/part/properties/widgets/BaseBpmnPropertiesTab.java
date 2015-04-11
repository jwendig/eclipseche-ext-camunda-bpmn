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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;

public class BaseBpmnPropertiesTab extends Composite {

	private Grid tabContent;

	public BaseBpmnPropertiesTab() {
		super();
		tabContent = new Grid();
		
//		initContentElements();
//		initContent();
		
		initWidget(tabContent);
	}

	/*
	 * abstract functions
	 */
//	public void initContentElements() {
//	}
//
//	public void initContent() {
//	}

	public String getTabName() {
		return "Name of tab is not defined";
	}

	/*
	 * getter & setter
	 */

	public Grid getTabContent() {
		return tabContent;
	}

	public void setTabContent(Grid content) {
		this.tabContent = content;
	}
}
