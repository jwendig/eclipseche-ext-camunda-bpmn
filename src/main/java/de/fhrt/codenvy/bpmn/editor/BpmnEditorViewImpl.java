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
import org.vectomatic.dom.svg.ui.SVGResource;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import de.fhrt.codenvy.bpmn.BpmnExtension;
import de.fhrt.codenvy.bpmn.BpmnResource;
import de.fhrt.codenvy.bpmn.editor.widget.diagram.BpmnEditorDiagramWidget;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesPresenter;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoElementJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoModelerJso;

public class BpmnEditorViewImpl extends AbstractEditorPresenter implements
		BpmnEditorView {
	private ProjectServiceClient projectServiceClient;
	private WorkspaceAgent workspaceAgent;
	private final DialogFactory dialogFactory;

	private BpmnPropertiesPresenter bpmnPropertiesPresenter;

	private String currentSvgContent;
	private String currentXmlContent;

	private BpmnEditorDiagramWidget bpmnDiagramWidget;
	private String svgFileParentPath;
	private String svgFileName;

	private static int viewCounter = 0;

	@Inject
	public BpmnEditorViewImpl(WorkspaceAgent workspaceAgent,
			ProjectServiceClient projectServiceClient,
			DialogFactory dialogFactory,
			BpmnPropertiesPresenter bpmnPropertiesPresenter,
			BpmnResource bpmnResource) {

		viewCounter++;

		this.workspaceAgent = workspaceAgent;
		this.projectServiceClient = projectServiceClient;
		this.dialogFactory = dialogFactory;

		this.bpmnPropertiesPresenter = bpmnPropertiesPresenter;

		bpmnDiagramWidget = new BpmnEditorDiagramWidget(this, bpmnResource,
				viewCounter);
		bpmnDiagramWidget.setSize("100%", "100%");

	}

	@Override
	public void doSave() {
		Log.info(BpmnEditorViewImpl.class, "doSave");

		updateSvgFile();
		updateXmlFile();

		updateDirtyState(false);
	}

	@Override
	public void doSave(AsyncCallback<EditorInput> callback) {
		Log.info(BpmnEditorViewImpl.class, "doSave(callback)");

		// refresh the buffered editor content
		// TODO: implement in BpmnIoModelerJso
		// bpmnDiagramWidget.exportArtifacts();

		doSave();

	}

	@Override
	public void doSaveAs() {
		Log.info(BpmnEditorViewImpl.class, "doSaveAs");
	}

	@Override
	public void activate() {
		Log.info(BpmnEditorViewImpl.class, "activate");

//		bpmnPropertiesPresenter.getView().clearView();

	}

	@Override
	public void close(boolean save) {
		Log.info(BpmnEditorViewImpl.class, "close");

	}

	@Override
	public void onClose(@Nonnull final AsyncCallback<Void> callback) {
		Log.info(BpmnEditorViewImpl.class, "onClose");
		viewCounter--;

		if (isDirty()) {
			Log.info(BpmnEditorViewImpl.class, "onClose: file IS DIRTY");
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
			Log.info(BpmnEditorViewImpl.class, "onClose: file IS NOT DIRTY");
			handleClose();
			callback.onSuccess(null);
		}
		if (viewCounter == 0) {
			workspaceAgent.removePart(bpmnPropertiesPresenter);
		}
	}

	@Override
	public String getTitle() {
		Log.info(BpmnEditorViewImpl.class, "getTitle");
		return "BPMN Editor: " + input.getFile().getName();
	}

	@Override
	public ImageResource getTitleImage() {
		Log.info(BpmnEditorViewImpl.class, "getTitleImage");
		return input.getImageResource();
	}

	@Override
	public SVGResource getTitleSVGImage() {
		return input.getSVGResource();
	}

	@Override
	public String getTitleToolTip() {
		Log.info(BpmnEditorViewImpl.class, "getTitleToolTip");
		return null;
	}

	@Override
	protected void initializeEditor() {
		Log.info(BpmnEditorViewImpl.class, "initializeEditor");

		projectServiceClient.getFileContent(input.getFile().getPath(),
				new AsyncRequestCallback<String>(new StringUnmarshaller()) {
					@Override
					protected void onSuccess(String result) {
						Log.info(BpmnEditorViewImpl.class,
								"initializeEditor:getFileContent:onSuccess: file-loaded");
						while (null == bpmnDiagramWidget) {
							Log.info(BpmnEditorViewImpl.class,
									"initializeEditor:getFileContent:onSuccess: diagramWidget not ready");
						}

						Log.info(BpmnEditorViewImpl.class,
								"initializeEditor:getFileContent:onSuccess: diagramWidget ready");

						bpmnDiagramWidget.openDiagram(result);
					}

					@Override
					protected void onFailure(Throwable exception) {
						Log.error(BpmnEditorViewImpl.class,
								"initializeEditor:getFileContent:onFailure",
								exception);
						// TODO: alert or something else
					}
				});

		initSvgFileVariables();

		workspaceAgent.openPart(bpmnPropertiesPresenter,
				PartStackType.INFORMATION);
	}

	@Override
	public void go(AcceptsOneWidget container) {
		Log.info(BpmnEditorViewImpl.class, "go");

		container.setWidget(bpmnDiagramWidget);
	}

	/*
	 * Custom functions
	 */

	private void initSvgFileVariables() {
		Log.info(BpmnEditorViewImpl.class, "initSvgFileVariables");
		svgFileName = input
				.getFile()
				.getName()
				.replace("." + BpmnExtension.BPMN_FILE_EXTENSION_NAME,
						"." + BpmnExtension.SVG_FILE_EXTENSION_NAME);
		svgFileParentPath = input.getFile().getPath()
				.replace(input.getFile().getName(), "");
	}

	private void updateXmlFile() {
		Log.info(BpmnEditorViewImpl.class, "updateXmlFile");
		if (null != currentXmlContent) {
			Log.info(
					BpmnEditorViewImpl.class,
					"updateXmlFile: bpmnDiagramWidget.currentXmlContent IS NOT NULL, do updateXmlFile");
			projectServiceClient.updateFile(input.getFile().getPath(),
					currentXmlContent, BpmnExtension.BPMN_MIME_TYPE,
					new AsyncRequestCallback<Void>() {

						@Override
						protected void onSuccess(Void result) {
							Log.info(BpmnEditorViewImpl.class,
									"doSave:updateXmlFile:onSuccess");
						}

						@Override
						protected void onFailure(Throwable exception) {
							Log.error(BpmnEditorViewImpl.class,
									"doSave:updateXmlFile:onFailure", exception);

						}
					});
		} else {
			Log.info(BpmnEditorViewImpl.class,
					"updateXmlFile: bpmnDiagramWidget.currentXmlContent IS NULL, do nothing");
		}
	}

	private void createSvgFile() {
		Log.info(BpmnEditorViewImpl.class, "createSvgFile");
		if (null != currentSvgContent) {
			projectServiceClient.createFile(svgFileParentPath, svgFileName,
					currentSvgContent, BpmnExtension.SVG_MIME_TYPE,
					new AsyncRequestCallback<ItemReference>() {

						@Override
						protected void onSuccess(ItemReference result) {
							Log.info(BpmnEditorViewImpl.class,
									"initializeEditor: createSvgFile: onSuccess");
						}

						@Override
						protected void onFailure(Throwable exception) {
							if (!exception.getMessage().contains(
									"already exists")) {
								Log.error(
										BpmnEditorViewImpl.class,
										"initializeEditor:createSvgFile:onFailure",
										exception);
							}
						}
					});
		} else {
			Log.info(BpmnEditorViewImpl.class,
					"createSvgFile: bpmnDiagramWidget.currentSvgContent IS NULL, do nothing");
		}
	}

	private void updateSvgFile() {
		Log.info(BpmnEditorViewImpl.class, "updateSvgFile");
		if (null != currentSvgContent) {
			projectServiceClient.updateFile(svgFileParentPath + svgFileName,
					currentSvgContent, BpmnExtension.SVG_MIME_TYPE,
					new AsyncRequestCallback<Void>() {

						@Override
						protected void onSuccess(Void result) {
							Log.info(BpmnEditorViewImpl.class,
									"doSave: updateSvgFile: onSuccess");
						}

						@Override
						protected void onFailure(Throwable exception) {
							if (exception.getMessage()
									.contains("doesn't exist")) {
								Log.info(BpmnEditorViewImpl.class,
										"doSave: updateSvgFile: onFailure: file doesn't exist, create it");
								createSvgFile();
							} else {
								Log.error(BpmnEditorViewImpl.class,
										"doSave: updateSvgFile: onFailure",
										exception);
							}

						}
					});
		} else {
			Log.info(BpmnEditorViewImpl.class,
					"updateSvgFile: bpmnDiagramWidget.currentSvgContent IS NULL, do nothing");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.fhrt.johannes.wendig.codenvy.bpmn.editor.BpmnEditorView#setContentIsDirty
	 * ()
	 */
	@Override
	public void setContentIsDirty() {
		Log.info(BpmnEditorViewImpl.class, "setContentIsDirty");
		updateDirtyState(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.fhrt.johannes.wendig.codenvy.bpmn.editor.BpmnEditorView#
	 * setCurrentXmlContent(java.lang.String)
	 */
	@Override
	public void setCurrentXmlContent(String xml) {
		Log.info(BpmnEditorViewImpl.class, "setCurrentXmlContent");
		currentXmlContent = xml;

		// TODO: find a solution ....
		// parseProjectForCamundaElements();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.fhrt.johannes.wendig.codenvy.bpmn.editor.BpmnEditorView#
	 * setCurrentSvgContent(java.lang.String)
	 */
	@Override
	public void setCurrentSvgContent(String svg) {
		Log.info(BpmnEditorViewImpl.class, "setCurrentSvgContent");
		currentSvgContent = svg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.fhrt.johannes.wendig.codenvy.bpmn.editor.BpmnEditorView#
	 * bpmnElementSelected
	 * (de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram
	 * .bpmnelements.BpmnDiagramElementJso)
	 */
	@Override
	public void bpmnElementSelected(BpmnIoModelerJso modelerJso,
			BpmnIoElementJso elementJso) {
		// bpmnElementPropertiesEditorPresenter.bpmnElementSelected(
		// modelerJso, elementJso);

		bpmnPropertiesPresenter.getView().loadWidgetForSelectedBpmnElement(
				modelerJso, elementJso);
	}

}
