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
package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.properties.startevent;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RenderableStamper;
import com.google.gwt.user.client.ui.Widget;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.BaseBpmnProperties;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget;

public class StartEventProperties extends BaseBpmnProperties {

	private final static String LB_ELEMENT_NAME_PREFIX = "Start Event";
	
	public StartEventProperties() {
		super(LB_ELEMENT_NAME_PREFIX);
		
		getTabLpContent().add(new Label("TODO: tabs - StartEventProperties"));
	}

	@Override
	public void initializeClaimedElement() {
		super.initializeClaimedElement();
		Log.info(StartEventProperties.class, "initializeClaimedElement");
		
	}

	@Override
	public SafeHtml render(RenderableStamper stamper) {
		Log.info(StartEventProperties.class, "render");
		return super.render(stamper);
	}

	@Override
	public void render(RenderableStamper stamper, SafeHtmlBuilder builder) {
		super.render(stamper, builder);
		Log.info(StartEventProperties.class, "render");
	}

	@Override
	protected void initWidget(Widget widget) {
		super.initWidget(widget);
		Log.info(StartEventProperties.class, "initWidget");
	}

	@Override
	protected void onAttach() {
		super.onAttach();
		Log.info(StartEventProperties.class, "onAttach");
	}
}
