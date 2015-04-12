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
package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.properties.process;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.RenderableStamper;
import com.google.gwt.user.client.ui.Widget;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.BaseBpmnProperties;

public class ProcessProperties extends BaseBpmnProperties {

	private final static String LB_ELEMENT_NAME_PREFIX = "Process";

	private TabGeneral tabGeneralProperties;
	private TabDefinitions tabDefinitionsProperties;

	public ProcessProperties() {
		super(LB_ELEMENT_NAME_PREFIX);
		Log.info(ProcessProperties.class, "constructor");

		tabGeneralProperties = new TabGeneral();
		tabDefinitionsProperties = new TabDefinitions();

		getTabLpContent().add(tabGeneralProperties,
				tabGeneralProperties.getTabName());
		getTabLpContent().add(tabDefinitionsProperties,
				tabDefinitionsProperties.getTabName());

		getTabLpContent().selectTab(tabGeneralProperties);
	}

	@Override
	public void initializeClaimedElement() {
		super.initializeClaimedElement();
		Log.info(ProcessProperties.class, "initializeClaimedElement");
	}

	@Override
	public SafeHtml render(RenderableStamper stamper) {
		Log.info(ProcessProperties.class, "render");
		return super.render(stamper);
	}

	@Override
	public void render(RenderableStamper stamper, SafeHtmlBuilder builder) {
		super.render(stamper, builder);
		Log.info(ProcessProperties.class, "render");
	}

	@Override
	protected void initWidget(Widget widget) {
		super.initWidget(widget);
		Log.info(ProcessProperties.class, "initWidget");
	}

	@Override
	protected void onAttach() {
		super.onAttach();
		Log.info(ProcessProperties.class, "onAttach");
	}
}
