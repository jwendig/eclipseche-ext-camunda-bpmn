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
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementJso;

/**
 * EditorProvider for Groovy file type.
 * 
 * @author <a href="mailto:aplotnikov@codenvy.com">Andrey Plotnikov</a>
 */
public class BpmnEditorProvider implements EditorProvider,
		BpmnEditorView.ActionDelegate {

	private BpmnEditorViewImpl bpmnEditorView;

	@Inject
	public BpmnEditorProvider(BpmnEditorViewImpl bpmnEditorView) {
		super();

		this.bpmnEditorView = bpmnEditorView;

		bind();
	}

	private void bind() {
		bpmnEditorView.setActionDelegate(this);
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
		/*
		 * with the injected instance of editor view i can open only one editor window at one time.
		 * Fix: instead of inject the instance, create a new instance here.
		 * 		but this needs to fix the id-generation of bpmn.io
		 */
		
		return bpmnEditorView;
	}
}
