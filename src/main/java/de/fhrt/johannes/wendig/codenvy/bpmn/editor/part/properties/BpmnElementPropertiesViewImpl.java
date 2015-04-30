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
package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties;

import org.eclipse.che.ide.api.parts.PartStackUIResources;
import org.eclipse.che.ide.api.parts.base.BaseView;
import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.inject.Inject;

public class BpmnElementPropertiesViewImpl extends
		BaseView<BpmnElementPropertiesView.ActionDelegate> implements
		BpmnElementPropertiesView {

	private DockLayoutPanel root;

	@Inject
	public BpmnElementPropertiesViewImpl(PartStackUIResources resources) {
		super(resources);

		root = new DockLayoutPanel(Unit.PX);
		root.setSize("100%", "100%");

		setContentWidget(root);
	}

	@Override
	public String getTitle() {
		Log.info(BpmnElementPropertiesViewImpl.class, "getTitle");
		return "test";
	}

	@Override
	public void setTitle(String title) {
		Log.info(BpmnElementPropertiesViewImpl.class,
				"setTitle: title before = " + title);
		super.setTitle(title);
	}

	@Override
	public DockLayoutPanel getDockLpCurrentContent() {
		return root;
	}
}
