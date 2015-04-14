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

import javax.annotation.Nonnull;

import org.eclipse.che.api.project.gwt.client.ProjectServiceClient;
import org.eclipse.che.api.project.shared.dto.ItemReference;
import org.eclipse.che.ide.api.editor.AbstractEditorPresenter;
import org.eclipse.che.ide.api.editor.EditorInput;
import org.eclipse.che.ide.api.parts.PartStackType;
import org.eclipse.che.ide.api.parts.WorkspaceAgent;
import org.eclipse.che.ide.rest.AsyncRequestCallback;
import org.eclipse.che.ide.rest.StringUnmarshaller;
import org.eclipse.che.ide.ui.dialogs.CancelCallback;
import org.eclipse.che.ide.ui.dialogs.ConfirmCallback;
import org.eclipse.che.ide.ui.dialogs.DialogFactory;
import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import de.fhrt.johannes.wendig.codenvy.bpmn.BpmnExtension;
import de.fhrt.johannes.wendig.codenvy.bpmn.BpmnResource;
import de.fhrt.johannes.wendig.codenvy.bpmn.camunda.CamundaFormKeyType;
import de.fhrt.johannes.wendig.codenvy.bpmn.camunda.CamundaJavaDelegateType;
import de.fhrt.johannes.wendig.codenvy.bpmn.camunda.CamundaTypeHolder;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesPresenter;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget;
import de.fhrt.johannes.wendig.codenvy.bpmn.util.ProjectParser;

public class BpmnEditor extends AbstractEditorPresenter implements
		BpmnEditorCallback {
	private ProjectServiceClient projectServiceClient;
	private WorkspaceAgent workspaceAgent;
	private final DialogFactory dialogFactory;

	private BpmnElementPropertiesPresenter bpmnElementPropertiesEditorPresenter;
	private BpmnResource bpmnResource;

	private String currentSvgContent;
	private String currentXmlContent;

	private BpmnEditorDiagramWidget bpmnDiagramWidget;
	private String svgFileParentPath;
	private String svgFileName;

	private CamundaTypeHolder camundaTypeHolder;

	public BpmnEditor(WorkspaceAgent workspaceAgent,
			ProjectServiceClient projectServiceClient,
			DialogFactory dialogFactory,
			BpmnElementPropertiesPresenter bpmnElementPropertiesPresenter,
			BpmnResource bpmnResource) {
		this.workspaceAgent = workspaceAgent;
		this.projectServiceClient = projectServiceClient;
		this.dialogFactory = dialogFactory;

		this.bpmnResource = bpmnResource;
		this.bpmnElementPropertiesEditorPresenter = bpmnElementPropertiesPresenter;
		bpmnDiagramWidget = new BpmnEditorDiagramWidget(this,
				bpmnElementPropertiesPresenter, bpmnResource);
		bpmnDiagramWidget.setSize("100%", "100%");

	}

	@Override
	public void doSave() {
		Log.info(BpmnEditor.class, "doSave");

		updateSvgFile();
		updateXmlFile();
	}

	@Override
	public void doSave(AsyncCallback<EditorInput> callback) {
		Log.info(BpmnEditor.class, "doSave(callback)");

		// refresh the buffered editor content
		bpmnDiagramWidget.exportArtifacts();

		doSave();

	}

	@Override
	public void doSaveAs() {
		Log.info(BpmnEditor.class, "doSaveAs");
	}

	@Override
	public void activate() {
		Log.info(BpmnEditor.class, "activate");

		// TODO: find a solution ....
		// parseProjectForCamundaElements();
	}

	@Override
	public void close(boolean save) {
		Log.info(BpmnEditor.class, "close");

	}

	@Override
	public void onClose(@Nonnull final AsyncCallback<Void> callback) {
		Log.info(BpmnEditor.class, "onClose");

		if (isDirty()) {
			Log.info(BpmnEditor.class, "onClose: file IS DIRTY");
			dialogFactory.createConfirmDialog(
					"Close",
					"'" + getEditorInput().getName()
							+ "' has been modified. Save changes?",
					new ConfirmCallback() {
						@Override
						public void accepted() {
							doSave();
							handleClose();
							callback.onSuccess(null);
						}
					}, new CancelCallback() {
						@Override
						public void cancelled() {
							handleClose();
							callback.onSuccess(null);
						}
					}).show();
		} else {
			Log.info(BpmnEditor.class, "onClose: file IS NOT DIRTY");
			handleClose();
			callback.onSuccess(null);
		}

		workspaceAgent.removePart(bpmnElementPropertiesEditorPresenter);
	}

	@Override
	public String getTitle() {
		Log.info(BpmnEditor.class, "getTitle");
		return "BPMN Editor: " + input.getFile().getName();
	}

	@Override
	public ImageResource getTitleImage() {
		Log.info(BpmnEditor.class, "getTitleImage");
		return null;
	}

	@Override
	public String getTitleToolTip() {
		Log.info(BpmnEditor.class, "getTitleToolTip");
		return null;
	}

	@Override
	protected void initializeEditor() {
		Log.info(BpmnEditor.class, "initializeEditor");

		projectServiceClient.getFileContent(input.getFile().getPath(),
				new AsyncRequestCallback<String>(new StringUnmarshaller()) {
					@Override
					protected void onSuccess(String result) {
						Log.info(BpmnEditor.class,
								"initializeEditor:getFileContent:onSuccess: file-loaded");
						while (null == bpmnDiagramWidget) {
							Log.info(BpmnEditor.class,
									"initializeEditor:getFileContent:onSuccess: diagramWidget not ready");
						}

						Log.info(BpmnEditor.class,
								"initializeEditor:getFileContent:onSuccess: diagramWidget ready");
						bpmnDiagramWidget.openDiagram(result);
					}

					@Override
					protected void onFailure(Throwable exception) {
						Log.error(BpmnEditor.class,
								"initializeEditor:getFileContent:onFailure",
								exception);
						// TODO: alert or something else
					}
				});

		initSvgFileVariables();

		workspaceAgent.openPart(bpmnElementPropertiesEditorPresenter,
				PartStackType.INFORMATION);
	}

	@Override
	public void go(AcceptsOneWidget container) {
		Log.info(BpmnEditor.class, "go");

		container.setWidget(bpmnDiagramWidget);
	}

	/*
	 * Custom functions
	 */

	private void initSvgFileVariables() {
		Log.info(BpmnEditor.class, "initSvgFileVariables");
		svgFileName = input
				.getFile()
				.getName()
				.replace("." + BpmnExtension.BPMN_FILE_EXTENSION_NAME,
						"." + BpmnExtension.SVG_FILE_EXTENSION_NAME);
		svgFileParentPath = input.getFile().getPath()
				.replace(input.getFile().getName(), "");
	}

	public void parseProjectForCamundaElements() {
		Log.info(BpmnEditor.class, "parseProjectForCamundaElements");
		camundaTypeHolder = ProjectParser.parseProjectForCamundaElements(input
				.getFile().getProject());

		Log.info(BpmnEditor.class, "parseProjectForCamundaElements: Found ("
				+ CamundaJavaDelegateType.class.getSimpleName() + ")");
		for (CamundaJavaDelegateType cjdt : camundaTypeHolder
				.getJavaDelegateClasses()) {
			Log.info(BpmnEditor.class,
					"parseProjectForCamundaElements: Found ("
							+ CamundaJavaDelegateType.class.getSimpleName()
							+ "): FileName=" + cjdt.getFilename());
			Log.info(BpmnEditor.class,
					"parseProjectForCamundaElements: Found ("
							+ CamundaJavaDelegateType.class.getSimpleName()
							+ "): Path=" + cjdt.getPath());
		}

		Log.info(BpmnEditor.class, "parseProjectForCamundaElements: Found ("
				+ CamundaFormKeyType.class.getSimpleName() + ")");
		for (CamundaFormKeyType cjdt : camundaTypeHolder.getFormKeyFiles()) {
			Log.info(BpmnEditor.class,
					"parseProjectForCamundaElements: Found ("
							+ CamundaFormKeyType.class.getSimpleName()
							+ "): FileName=" + cjdt.getFilename());
			Log.info(BpmnEditor.class,
					"parseProjectForCamundaElements: Found ("
							+ CamundaFormKeyType.class.getSimpleName()
							+ "): Path=" + cjdt.getPath());
		}
	}

	private void updateXmlFile() {
		Log.info(BpmnEditor.class, "updateXmlFile");
		if (null != currentXmlContent) {
			Log.info(
					BpmnEditor.class,
					"updateXmlFile: bpmnDiagramWidget.currentXmlContent IS NOT NULL, do updateXmlFile");
			projectServiceClient.updateFile(input.getFile().getPath(),
					currentXmlContent, BpmnExtension.BPMN_MIME_TYPE,
					new AsyncRequestCallback<Void>() {

						@Override
						protected void onSuccess(Void result) {
							Log.info(BpmnEditor.class,
									"doSave:updateXmlFile:onSuccess");
						}

						@Override
						protected void onFailure(Throwable exception) {
							Log.error(BpmnEditor.class,
									"doSave:updateXmlFile:onFailure", exception);

						}
					});
		} else {
			Log.info(BpmnEditor.class,
					"updateXmlFile: bpmnDiagramWidget.currentXmlContent IS NULL, do nothing");
		}
	}

	private void createSvgFile() {
		Log.info(BpmnEditor.class, "createSvgFile");
		if (null != currentSvgContent) {
			projectServiceClient.createFile(svgFileParentPath, svgFileName,
					currentSvgContent, BpmnExtension.SVG_MIME_TYPE,
					new AsyncRequestCallback<ItemReference>() {

						@Override
						protected void onSuccess(ItemReference result) {
							Log.info(BpmnEditor.class,
									"initializeEditor: createSvgFile: onSuccess");
						}

						@Override
						protected void onFailure(Throwable exception) {
							if (!exception.getMessage().contains(
									"already exists")) {
								Log.error(
										BpmnEditor.class,
										"initializeEditor:createSvgFile:onFailure",
										exception);
							}
						}
					});
		} else {
			Log.info(BpmnEditor.class,
					"createSvgFile: bpmnDiagramWidget.currentSvgContent IS NULL, do nothing");
		}
	}

	private void updateSvgFile() {
		Log.info(BpmnEditor.class, "updateSvgFile");
		if (null != currentSvgContent) {
			projectServiceClient.updateFile(svgFileParentPath + svgFileName,
					currentSvgContent, BpmnExtension.SVG_MIME_TYPE,
					new AsyncRequestCallback<Void>() {

						@Override
						protected void onSuccess(Void result) {
							Log.info(BpmnEditor.class,
									"doSave:updateSvgFile:onSuccess");
						}

						@Override
						protected void onFailure(Throwable exception) {
							Log.error(BpmnEditor.class,
									"doSave:updateSvgFile:onFailure", exception);

							createSvgFile();

						}
					});
		} else {
			Log.info(BpmnEditor.class,
					"updateSvgFile: bpmnDiagramWidget.currentSvgContent IS NULL, do nothing");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.fhrt.johannes.wendig.codenvy.bpmn.editor.BpmnEditorCallback#
	 * setContentIsDirty()
	 */
	@Override
	public void setContentIsDirty() {
		Log.info(BpmnEditor.class, "setContentIsDirty");
		updateDirtyState(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.fhrt.johannes.wendig.codenvy.bpmn.editor.BpmnEditorCallback#
	 * setCurrentXmlContent(java.lang.String)
	 */
	@Override
	public void setCurrentXmlContent(String xml) {
		Log.info(BpmnEditor.class, "setCurrentXmlContent");
		currentXmlContent = xml;

		// TODO: find a solution ....
		// parseProjectForCamundaElements();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.fhrt.johannes.wendig.codenvy.bpmn.editor.BpmnEditorCallback#
	 * setCurrentSvgContent(java.lang.String)
	 */
	@Override
	public void setCurrentSvgContent(String svg) {
		Log.info(BpmnEditor.class, "setCurrentSvgContent");
		currentSvgContent = svg;
	}

}
