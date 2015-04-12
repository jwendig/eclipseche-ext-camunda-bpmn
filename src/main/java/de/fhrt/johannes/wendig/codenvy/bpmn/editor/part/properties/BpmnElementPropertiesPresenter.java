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

import org.eclipse.che.ide.api.parts.AbstractPartPresenter;
import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.query.client.GQuery;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget;

@Singleton
public class BpmnElementPropertiesPresenter extends AbstractPartPresenter
		implements BpmnElementPropertiesView.ActionDelegate,
		BpmnElementPropertiesCallback {

	private BpmnElementPropertiesView view;
	private final static String TITLE = "BPMN Properties";

	@Inject
	public BpmnElementPropertiesPresenter(BpmnElementPropertiesView view) {
		Log.info(BpmnElementPropertiesPresenter.class, "constructor");
		this.view = view;
		this.view.setDelegate(this);
	}

	@Override
	public String getTitle() {
		return TITLE;
	}

	@Override
	public ImageResource getTitleImage() {
		return null;
	}

	@Override
	public String getTitleToolTip() {
		return null;
	}

	@Override
	public void go(AcceptsOneWidget container) {
		Log.info(BpmnElementPropertiesPresenter.class, "go");
		container.setWidget(view);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.
	 * BpmnElementPropertiesCallback#elementSelected()
	 */
	@Override
	public void elementSelected(BpmnEditorDiagramWidget.ElementType type,
			GQuery selectedItem) {
		Log.info(BpmnElementPropertiesPresenter.class, "elementSelected");
		switch (type) {
		case SERVICE_TASK:
			view.loadServiceTaksProperties(selectedItem);
			break;
		case USER_TASK:
			view.loadUserTaskProperties(selectedItem);
			break;
		case START_EVENT:
			view.loadStartEventProperties(selectedItem);
			break;
		case UNKNOWN:
			view.loadUnknownItemInfo(selectedItem);
		}
	}

	@Override
	public void containerSelected(GQuery base) {
		view.loadProcessProperties(base);

	}
}
