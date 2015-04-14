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

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TabLayoutPanel;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnProcessJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.CamundaElementJso;

public class AbstractBpmnProperties extends Composite {

	private static final String LABEL_ELEMENT_NAME__DEFAULT_CONTENT = "No BPMN-Element selected";
	private String lbElementName_prefixText;
	/*
	 * Make TabLayoutPanel vertical See: css-solution on
	 * http://stackoverflow.com/questions/3810876/gwt-vertical-tabs-like-igoogle
	 */

	private DockLayoutPanel docLpRoot;
	private Label lbElementName;
	private TabLayoutPanel tabLpContent;
	private CamundaElementJso selectedItem;
	private BpmnProcessJso selectedProcess;

	public AbstractBpmnProperties(String lbElementName_prefixText) {
		super();
		Log.info(AbstractBpmnProperties.class, "constructor");

		this.lbElementName_prefixText = lbElementName_prefixText;

		docLpRoot = new DockLayoutPanel(Unit.EM);
		docLpRoot.setSize("100%", "100%");

		lbElementName = new Label(LABEL_ELEMENT_NAME__DEFAULT_CONTENT);
		lbElementName.setSize("100%", "100%");

		tabLpContent = new TabLayoutPanel(1, Unit.EM);
		tabLpContent.setSize("100%", "100%");
		tabLpContent.addStyleName("bpmnPropertiesWidget-tabLayoutPanel");

		docLpRoot.addNorth(lbElementName, 1.5);
		docLpRoot.add(tabLpContent);

		initWidget(docLpRoot);

	}

	public void setSelectedItem(CamundaElementJso selectedItem) {
		Log.info(AbstractBpmnProperties.class, "setSelectedItem");
		this.selectedItem = selectedItem;
	}

	public void setSelectedProcess(BpmnProcessJso selectedProcess) {
		Log.info(AbstractBpmnProperties.class, "setSelectedProcess");
		this.selectedProcess = selectedProcess;
	}

	/*
	 * Getter & Setter
	 */

	public void setLbElementNameText(String elementName) {
		lbElementName.setText(lbElementName_prefixText + ": " + elementName);
	}

	public TabLayoutPanel getTabLpContent() {
		return tabLpContent;
	}

	public DockLayoutPanel getDocLpRoot() {
		return docLpRoot;
	}

}
