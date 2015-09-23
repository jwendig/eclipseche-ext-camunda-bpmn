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
package de.fhrt.codenvy.bpmn.editor;

import org.eclipse.che.api.project.gwt.client.ProjectServiceClient;
import org.eclipse.che.ide.api.editor.EditorPartPresenter;
import org.eclipse.che.ide.api.editor.EditorProvider;
import org.eclipse.che.ide.api.notification.NotificationManager;
import org.eclipse.che.ide.api.parts.WorkspaceAgent;
import org.eclipse.che.ide.jseditor.client.defaulteditor.DefaultEditorProvider;
import org.eclipse.che.ide.ui.dialogs.DialogFactory;

import com.google.inject.Inject;

import de.fhrt.codenvy.bpmn.BpmnExtension;
import de.fhrt.codenvy.bpmn.BpmnResource;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesPresenter;

/**
 * EditorProvider for Groovy file type.
 * 
 * @author <a href="mailto:aplotnikov@codenvy.com">Andrey Plotnikov</a>
 */
public class BpmnEditorProvider implements EditorProvider {

	private final DefaultEditorProvider defaultEditorProvider;
	private final NotificationManager notificationManager;
	private final ProjectServiceClient projectServiceClient;
	private final DialogFactory dialogFactory;
	private WorkspaceAgent workspaceAgent;

	private BpmnResource bpmnResource;
	private BpmnEditorViewImpl bpmnEditorView;
	private BpmnPropertiesPresenter bpmnPropertiesEditorPresenter;

	@Inject
	public BpmnEditorProvider(
			final DefaultEditorProvider defaultEditorProvider,
			final NotificationManager notificationManager,
			BpmnResource bpmnResource,
			BpmnPropertiesPresenter bpmnPropertiesEditorPresenter,
			WorkspaceAgent workspaceAgent,
			ProjectServiceClient projectServiceClient,
			DialogFactory dialogFactory) {
		super();

		this.defaultEditorProvider = defaultEditorProvider;
		this.notificationManager = notificationManager;
		this.projectServiceClient = projectServiceClient;
		this.dialogFactory = dialogFactory;
		this.workspaceAgent = workspaceAgent;

		this.bpmnPropertiesEditorPresenter = bpmnPropertiesEditorPresenter;
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
		bpmnEditorView = new BpmnEditorViewImpl(workspaceAgent,
				projectServiceClient, dialogFactory,
				bpmnPropertiesEditorPresenter, bpmnResource);
		return bpmnEditorView;

	}
}
