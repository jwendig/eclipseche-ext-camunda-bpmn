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

import static org.eclipse.che.ide.api.action.IdeActions.GROUP_FILE_NEW;
import static org.eclipse.che.ide.api.parts.PartStackType.EDITING;

import org.eclipse.che.ide.api.action.ActionManager;
import org.eclipse.che.ide.api.action.DefaultActionGroup;
import org.eclipse.che.ide.api.editor.EditorRegistry;
import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.ide.api.filetypes.FileType;
import org.eclipse.che.ide.api.filetypes.FileTypeRegistry;
import org.eclipse.che.ide.api.parts.WorkspaceAgent;
import org.eclipse.che.ide.util.loging.Log;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.BpmnEditorProvider;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.howto.HowToPresenter;

/** Extension used to demonstrate the Editor API. */
@Singleton
@Extension(title = "BPMN Extension", version = "1.0.0")
public class BpmnExtension {
	/*
	 * extension-definitions
	 */
	public static final String BPMN_NEW_FILE_ACTION_ID = "newBpmnFileActionIdByJw";
	public static final String BPMN_EDITOR_ID = "codenvyBpmnEditorByJw";

	/*
	 * svg-file-definitions
	 */
	public static final String SVG_MIME_TYPE = "image/svg+xml";
	public static final String SVG_FILE_EXTENSION_NAME = "svg";
	public static final String SVG_NEW_FILE_CONTENT = "<html><head></head><body><h1>initial svg-file content</h1><p>real content after the next save action!</p></body></html>";

	/*
	 * bpmn-file-definition
	 */
	public static final String BPMN_MIME_TYPE = "text/bpmn";
	public static final String BPMN_FILE_EXTENSION_NAME = "bpmncustom";

	@Inject
	public BpmnExtension(WorkspaceAgent workspaceAgent,
			HowToPresenter howToPresenter,
			EditorRegistry editorRegistry, FileTypeRegistry fileTypeRegistry,
			BpmnEditorProvider bpmnEditorProvider, ActionManager actionManager,
			NewBpmnFileAction newBpmnFileAction, BpmnResource bpmnResource) {
		Log.info(BpmnExtension.class, "constructor");

		openBpmnHowtoPart(workspaceAgent, howToPresenter);

		FileType bpmnFileType = createAndRegisterBpmnFileType(fileTypeRegistry,
				bpmnResource);

		registerBpmnEditor(editorRegistry, bpmnEditorProvider, bpmnFileType);

		addNewBpmnFileAction(actionManager, newBpmnFileAction);
	}

	private void openBpmnHowtoPart(WorkspaceAgent workspaceAgent,
			HowToPresenter howToPresenter) {
		Log.info(BpmnExtension.class, "openBpmnHowtoPart");
		workspaceAgent.openPart(howToPresenter, EDITING);
	}

	private FileType createAndRegisterBpmnFileType(
			FileTypeRegistry fileTypeRegistry, BpmnResource bpmnResource) {
		Log.info(BpmnExtension.class, "createAndRegisterBpmnFileType");
		FileType bpmnFileType = new FileType("BPMN",
				bpmnResource.bpmnIconXsFile(), BPMN_MIME_TYPE,
				BPMN_FILE_EXTENSION_NAME);
		fileTypeRegistry.registerFileType(bpmnFileType);
		return bpmnFileType;
	}

	private void registerBpmnEditor(EditorRegistry editorRegistry,
			BpmnEditorProvider bpmnEditorProvider, FileType bpmnFileType) {
		Log.info(BpmnExtension.class, "registerBpmnEditor");
		editorRegistry.registerDefaultEditor(bpmnFileType, bpmnEditorProvider);
		editorRegistry.register(bpmnFileType, bpmnEditorProvider);
	}

	private void addNewBpmnFileAction(ActionManager actionManager,
			NewBpmnFileAction newBpmnFileAction) {
		Log.info(BpmnExtension.class, "addNewBpmnFileAction");
		actionManager
				.registerAction(BPMN_NEW_FILE_ACTION_ID, newBpmnFileAction);
		DefaultActionGroup newGroup = (DefaultActionGroup) actionManager
				.getAction(GROUP_FILE_NEW);
		newGroup.addSeparator();
		newGroup.add(newBpmnFileAction);
	}
}
