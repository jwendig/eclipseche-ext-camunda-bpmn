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

package de.fhrt.codenvy.bpmn.part.bpmnProperties;

import org.eclipse.che.ide.api.parts.base.BasePresenter;
import org.eclipse.che.ide.util.loging.Log;
import org.vectomatic.dom.svg.ui.SVGResource;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;

import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.BpmnElementJso;
import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.BpmnModelerJso;
import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.BpmnElementJso.BpmnElementType;
import de.fhrt.codenvy.bpmn.part.properties.widgets.AbstractBpmnPropertiesWidget;
import de.fhrt.codenvy.bpmn.part.properties.widgets.noselection.NoSelectionWidget;
import de.fhrt.codenvy.bpmn.part.properties.widgets.process.ProcessPropertiesWidget;
import de.fhrt.codenvy.bpmn.part.properties.widgets.servicetask.ServiceTaskPropertiesWidget;
import de.fhrt.codenvy.bpmn.part.properties.widgets.startevent.StartEventPropertiesWidget;
import de.fhrt.codenvy.bpmn.part.properties.widgets.unknown.UnknownItemWidget;
import de.fhrt.codenvy.bpmn.part.properties.widgets.usertask.UserTaskPropertiesWidget;

public class BpmnPropertiesPresenter extends BasePresenter implements
		BpmnPropertiesView.ActionDelegate {

	private BpmnPropertiesView view;
	private final static String TITLE = "BPMN Properties";
	
	@Inject
	public BpmnPropertiesPresenter(BpmnPropertiesView view) {
		Log.info(BpmnPropertiesPresenter.class, "constructor");
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
	public IsWidget getTitleWidget() {
		return super.getTitleWidget();
	}

	@Override
	public SVGResource getTitleSVGImage() {
		return super.getTitleSVGImage();
	}

	@Override
	public String getTitleToolTip() {
		return TITLE;
	}

	@Override
	public void go(AcceptsOneWidget container) {
		Log.info(BpmnPropertiesPresenter.class, "go");
		container.setWidget(view);
	}

	public BpmnPropertiesView getView() {
		return view;
	}
	
	
}
