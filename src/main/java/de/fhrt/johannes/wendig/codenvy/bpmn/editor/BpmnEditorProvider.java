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

import com.google.inject.Inject;

import de.fhrt.johannes.wendig.codenvy.bpmn.BpmnExtension;
import de.fhrt.johannes.wendig.codenvy.bpmn.BpmnResource;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesPresenter;

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

	private BpmnElementPropertiesPresenter bpmnElementPropertiesEditorPresenter;
	private BpmnResource bpmnResource;
	private BpmnEditor bpmnEditor;

	@Inject
	public BpmnEditorProvider(
			final DefaultEditorProvider defaultEditorProvider,
			final NotificationManager notificationManager,
			BpmnResource bpmnResource,
			BpmnElementPropertiesPresenter bpmnElementPropertiesEditorPresenter,
			WorkspaceAgent workspaceAgent,
			ProjectServiceClient projectServiceClient,
			DialogFactory dialogFactory, BpmnEditor bpmnEditor) {
		super();
		this.defaultEditorProvider = defaultEditorProvider;
		this.notificationManager = notificationManager;
		this.projectServiceClient = projectServiceClient;
		this.dialogFactory = dialogFactory;
		this.workspaceAgent = workspaceAgent;

		this.bpmnElementPropertiesEditorPresenter = bpmnElementPropertiesEditorPresenter;
		this.bpmnResource = bpmnResource;
		this.bpmnEditor = bpmnEditor;
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
		// return new BpmnEditor(workspaceAgent, projectServiceClient,
		// dialogFactory, bpmnElementPropertiesEditorPresenter,
		// bpmnResource);
		return bpmnEditor;
	}
}
