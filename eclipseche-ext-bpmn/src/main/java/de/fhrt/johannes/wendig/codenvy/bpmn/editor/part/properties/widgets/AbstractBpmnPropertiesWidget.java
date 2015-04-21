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

import java.awt.FlowLayout;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementJso;

public abstract class AbstractBpmnPropertiesWidget extends Composite {

	private static final String LABEL_ELEMENT_NAME__DEFAULT_CONTENT = "No BPMN-Element selected";
	private String lbElementName_prefixText;

	/*
	 * root elements
	 */
	private FlowPanel flowLpRoot;
	private Label lbElementName;
	private TabLayoutPanel tabLpContent;
	private BpmnElementPropertiesView.ActionDelegate delegate;

	public AbstractBpmnPropertiesWidget(String lbElementName_prefixText,
			BpmnElementPropertiesView.ActionDelegate delegate) {
		super();
		Log.info(AbstractBpmnPropertiesWidget.class, "constructor");

		this.delegate = delegate;
		this.lbElementName_prefixText = lbElementName_prefixText;

		initPropertiesRoot();

		initWidget(flowLpRoot);

	}

	private void initPropertiesRoot() {
		flowLpRoot = new FlowPanel();
		flowLpRoot.setSize("100%", "100%");

		lbElementName = new Label(LABEL_ELEMENT_NAME__DEFAULT_CONTENT);
		lbElementName.setSize("100%", "auto");

		tabLpContent = new TabLayoutPanel(1, Unit.EM);
		tabLpContent.setSize("100%", "100%");
		tabLpContent.addStyleName("bpmnPropertiesWidget-tabLayoutPanel");

		flowLpRoot.add(lbElementName);
		flowLpRoot.add(tabLpContent);
	}

	public void updatePropertiesView() {
		Log.info(AbstractBpmnPropertiesWidget.class, "setSelectedItem");

		if (null != delegate.getCurrentElementJso()) {
			setLbElementNameText(this.delegate.getCurrentElementJso()
					.getAttr_id());
		} else {
			setLbElementNameText("");
		}
		updateTabs();
	}

	public abstract void updateTabs();

	/*
	 * Getter & Setter
	 */

	public void setLbElementNameText(String elementName) {
		lbElementName.setText(lbElementName_prefixText + ": " + elementName);
	}

	public TabLayoutPanel getTabLpContent() {
		return tabLpContent;
	}
}
