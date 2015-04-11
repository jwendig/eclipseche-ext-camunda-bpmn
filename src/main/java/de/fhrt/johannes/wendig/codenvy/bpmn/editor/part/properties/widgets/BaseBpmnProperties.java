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
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RenderableStamper;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class BaseBpmnProperties extends Composite {

	private static final String LABEL_ELEMENT_NAME__DEFAULT_CONTENT = "No BPMN-Element selected";
	private String lbElementName_prefixText;
	/*
	 * Make TabLayoutPanel vertical See: css-solution on
	 * http://stackoverflow.com/questions/3810876/gwt-vertical-tabs-like-igoogle
	 */

	private DockLayoutPanel docLpRoot;
	private Label lbElementName;
	private TabLayoutPanel tabLpContent;

	public BaseBpmnProperties(String lbElementName_prefixText) {
		super();

		this.lbElementName_prefixText = lbElementName_prefixText;

		docLpRoot = new DockLayoutPanel(Unit.PX);
		docLpRoot.setSize("100%", "100%");

		lbElementName = new Label(LABEL_ELEMENT_NAME__DEFAULT_CONTENT);
		lbElementName.setSize("100%", "100%");

		tabLpContent = new TabLayoutPanel(1.5, Unit.EM);
		tabLpContent.setSize("100%", "100%");

		docLpRoot.addNorth(lbElementName, lbElementName.getOffsetHeight());
		docLpRoot.add(tabLpContent);

		initWidget(docLpRoot);
	}

	@Override
	public void initializeClaimedElement() {
		super.initializeClaimedElement();
		Log.info(BaseBpmnProperties.class, "initializeClaimedElement");
	}

	@Override
	public SafeHtml render(RenderableStamper stamper) {
		Log.info(BaseBpmnProperties.class, "render");
		return super.render(stamper);
	}

	@Override
	public void render(RenderableStamper stamper, SafeHtmlBuilder builder) {
		super.render(stamper, builder);
		Log.info(BaseBpmnProperties.class, "render");
	}

	@Override
	protected void initWidget(Widget widget) {
		super.initWidget(widget);
		Log.info(BaseBpmnProperties.class, "initWidget");
	}

	@Override
	protected void onAttach() {
		super.onAttach();
		Log.info(BaseBpmnProperties.class, "onAttach");
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
