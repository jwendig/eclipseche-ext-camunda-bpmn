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
package de.fhrt.johannes.wendig.codenvy.bpmn;

import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.project.tree.TreeNode;
import org.eclipse.che.ide.api.project.tree.generic.StorableNode;
import org.eclipse.che.ide.newresource.AbstractNewResourceAction;
import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget;

/**
 * Action to create new Groovy file.
 *
 * @author Artem Zatsarynnyy
 */
@Singleton
public class NewBpmnFileAction extends AbstractNewResourceAction {

	private BpmnResource resource;

	@Inject
	public NewBpmnFileAction(BpmnResource resource) {
		super("BPMN file", "Creates new BPMN file", null);
		Log.info(NewBpmnFileAction.class, "constructor");
		this.resource = resource;
	}

	@Override
	protected String getExtension() {
		Log.info(NewBpmnFileAction.class, "getExtension");
		return BpmnExtension.BPMN_FILE_EXTENSION_NAME;
	}

	@Override
	protected String getDefaultContent() {
		Log.info(NewBpmnFileAction.class, "getDefaultContent");
		return resource.newBpmnFile().getText();
	}

	@Override
	protected String getMimeType() {
		Log.info(NewBpmnFileAction.class, "getMimeType");
		return BpmnExtension.BPMN_MIME_TYPE;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * Log for call-informations TODO: maybe create svg-file here
		 */
		Log.info(NewBpmnFileAction.class, "actionPerformed");
		super.actionPerformed(e);
		Log.info(NewBpmnFileAction.class, "actionPerformed - after");
	}

	@Override
	public void updateProjectAction(ActionEvent e) {
		Log.info(NewBpmnFileAction.class, "updateProjectAction");
		super.updateProjectAction(e);
	}
}