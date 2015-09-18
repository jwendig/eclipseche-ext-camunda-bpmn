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

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TabLayoutPanel;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.properties.BpmnElementPropertiesView;

public abstract class AbstractBpmnPropertiesWidget extends Composite {

	private String lbElementName_prefixText;
	private String lbElementText;
	private TabLayoutPanel tabLpContent;
	private BpmnPropertiesView.CurrentJsoAccess jsoAccess;

	public AbstractBpmnPropertiesWidget(String lbElementName_prefixText,
			BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super();
		this.jsoAccess = jsoAccess;
		this.lbElementName_prefixText = lbElementName_prefixText;

		initPropertiesRoot();
		initWidget(tabLpContent);
	}

	private void initPropertiesRoot() {
		tabLpContent = new TabLayoutPanel(1, Unit.EM);
		tabLpContent.setSize("100%", "100%");
		tabLpContent.addStyleName("bpmnPropertiesWidget-tabLayoutPanel");
	}

	public void updatePropertiesView() {
		lbElementText = lbElementName_prefixText;
		if (null != jsoAccess.getCurrentElementJso()) {
			lbElementText += " : "
					+ this.jsoAccess.getCurrentElementJso().getAttr_id();
		}
		updateTabs();
	}

	public abstract void updateTabs();

	public TabLayoutPanel getTabLpContent() {
		return tabLpContent;
	}

	public String getLbElementName_prefixText() {
		return lbElementName_prefixText;
	}

	public String getLbElementText() {
		return lbElementText;
	}
}
