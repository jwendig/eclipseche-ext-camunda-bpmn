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

import org.eclipse.che.ide.api.parts.base.BasePresenter;
import org.eclipse.che.ide.util.loging.Log;
import org.vectomatic.dom.svg.ui.SVGResource;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.BpmnEditorView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementJso.BpmnElementType;

public class BpmnElementPropertiesPresenter extends BasePresenter implements
		BpmnElementPropertiesView.ActionDelegate, BpmnElementPropertiesCallback {

	private BpmnEditorView bpmnEditorCallback;

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
		Log.info(BpmnElementPropertiesPresenter.class, "go");
		container.setWidget(view);
	}

	@Override
	public void bpmnElementSelected(BpmnDiagramElementJso elementJso) {
		Log.info(BpmnElementPropertiesPresenter.class, "bpmnElementSelected");

		switch (BpmnElementType
				.findByBpmnIoTypeDefinition(elementJso.getType())) {
		case DEFAULT:
			view.loadUnknownItemInfo(elementJso);
			break;
		case PROCESS:
			view.loadProcessProperties(elementJso);
			break;
		case SCRIPT_TASK:
			view.loadUnknownItemInfo(elementJso);
			break;
		case SERVICE_TASK:
			view.loadServiceTaksProperties(elementJso);
			break;
		case START_EVENT:
			view.loadStartEventProperties(elementJso);
			break;
		case TASK:
			view.loadUnknownItemInfo(elementJso);
			break;
		case USER_TASK:
			view.loadUserTaskProperties(elementJso);
			break;
		default:
			view.loadUnknownItemInfo(elementJso);
		}
	}

	/*
	 * Callbacks from view
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.
	 * BpmnElementPropertiesView.ActionDelegate#onContentChange()
	 */
	@Override
	public void onContentChange() {
		Log.info(BpmnElementPropertiesPresenter.class, "onContentChange");
		bpmnEditorCallback.setContentIsDirty();
	}

	/*
	 * Getter & Setter
	 */

	public BpmnEditorView getBpmnEditorCallback() {
		return bpmnEditorCallback;
	}

	public void setBpmnEditorCallback(BpmnEditorView bpmnEditorCallback) {
		this.bpmnEditorCallback = bpmnEditorCallback;
	}

}
