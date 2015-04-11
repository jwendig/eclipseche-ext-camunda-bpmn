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
package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.properties.usertask;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RenderableStamper;
import com.google.gwt.user.client.ui.Widget;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.BaseBpmnProperties;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget;

public class UserTaskProperties extends BaseBpmnProperties {

	private final static String LB_ELEMENT_NAME_PREFIX = "User Task";

	public UserTaskProperties() {
		super(LB_ELEMENT_NAME_PREFIX);

	}

	@Override
	public void initializeClaimedElement() {
		super.initializeClaimedElement();
		Log.info(UserTaskProperties.class, "initializeClaimedElement");
	}

	@Override
	public SafeHtml render(RenderableStamper stamper) {
		Log.info(UserTaskProperties.class, "render");
		return super.render(stamper);
	}

	@Override
	public void render(RenderableStamper stamper, SafeHtmlBuilder builder) {
		super.render(stamper, builder);
		Log.info(UserTaskProperties.class, "render");
	}

	@Override
	protected void initWidget(Widget widget) {
		super.initWidget(widget);
		Log.info(UserTaskProperties.class, "initWidget");
	}

	@Override
	protected void onAttach() {
		super.onAttach();
		Log.info(UserTaskProperties.class, "onAttach");
	}
}
