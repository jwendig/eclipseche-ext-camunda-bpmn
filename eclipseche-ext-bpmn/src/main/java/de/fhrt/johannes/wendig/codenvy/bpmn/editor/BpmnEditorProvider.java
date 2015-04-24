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
package de.fhrt.johannes.wendig.codenvy.bpmn.editor;

import org.eclipse.che.api.project.gwt.client.ProjectServiceClient;
import org.eclipse.che.ide.api.editor.EditorPartPresenter;
import org.eclipse.che.ide.api.editor.EditorProvider;
import org.eclipse.che.ide.api.notification.NotificationManager;
import org.eclipse.che.ide.api.parts.WorkspaceAgent;
import org.eclipse.che.ide.jseditor.client.defaulteditor.DefaultEditorProvider;
import org.eclipse.che.ide.ui.dialogs.DialogFactory;
import org.vectomatic.dom.svg.ui.SVGResource;

import com.google.gwt.resources.client.ImageResource;
import com.google.inject.Inject;

import de.fhrt.johannes.wendig.codenvy.bpmn.BpmnExtension;
import de.fhrt.johannes.wendig.codenvy.bpmn.BpmnResource;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesPresenter;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.BpmnElementJso;

/**
 * EditorProvider for Groovy file type.
 * 
 * @author <a href="mailto:aplotnikov@codenvy.com">Andrey Plotnikov</a>
 */
public class BpmnEditorProvider implements EditorProvider,
		BpmnEditorView.ActionDelegate {

	private final DefaultEditorProvider defaultEditorProvider;
	private final NotificationManager notificationManager;
	private final ProjectServiceClient projectServiceClient;
	private final DialogFactory dialogFactory;
	private WorkspaceAgent workspaceAgent;
	
	private BpmnResource bpmnResource;
	private BpmnEditorViewImpl bpmnEditorView;
	private BpmnElementPropertiesPresenter bpmnElementPropertiesEditorPresenter;

	@Inject
	public BpmnEditorProvider(final DefaultEditorProvider defaultEditorProvider,
			final NotificationManager notificationManager,
			BpmnResource bpmnResource,
			BpmnElementPropertiesPresenter bpmnElementPropertiesEditorPresenter,
			WorkspaceAgent workspaceAgent,
			ProjectServiceClient projectServiceClient,
			DialogFactory dialogFactory) {
		super();

		this.defaultEditorProvider = defaultEditorProvider;
		this.notificationManager = notificationManager;
		this.projectServiceClient = projectServiceClient;
		this.dialogFactory = dialogFactory;
		this.workspaceAgent = workspaceAgent;
		
		this.bpmnElementPropertiesEditorPresenter = bpmnElementPropertiesEditorPresenter;
		this.bpmnResource = bpmnResource;
	}

	@Override
	public String getId() {
		return BpmnExtension.BPMN_EDITOR_ID;
	}

	@Override
	public String getDescription() {
		return "Codenvy BPMN Editor";
	}
	
	/** {@inheritDoc} */
	@Override
	public EditorPartPresenter getEditor() {
		bpmnEditorView = new BpmnEditorViewImpl(workspaceAgent, projectServiceClient,
				dialogFactory, bpmnElementPropertiesEditorPresenter,
				bpmnResource);
		bpmnEditorView.setActionDelegate(this);
		return bpmnEditorView;
		
	}
}
