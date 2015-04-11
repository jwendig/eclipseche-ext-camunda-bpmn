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

package de.fhrt.johannes.wendig.codenvy.bpmn.util;

import java.util.Map;

import org.eclipse.che.ide.api.project.tree.TreeNode;
import org.eclipse.che.ide.api.project.tree.generic.FileNode;
import org.eclipse.che.ide.api.project.tree.generic.ItemNode;
import org.eclipse.che.ide.api.project.tree.generic.ProjectNode;
import org.eclipse.che.ide.util.loging.Log;
import org.reflections.serializers.JavaCodeSerializer;
import org.reflections.serializers.JavassistSerializer;

import com.google.gwt.typedarrays.server.JavaImpl;

import de.fhrt.johannes.wendig.codenvy.bpmn.camunda.CamundaFormKeyType;
import de.fhrt.johannes.wendig.codenvy.bpmn.camunda.CamundaJavaDelegateType;
import de.fhrt.johannes.wendig.codenvy.bpmn.camunda.CamundaTypeHolder;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.BpmnEditor;

public class ProjectParser {

	/*
	 * Use name of camunda Classes is dirty, but import an external jar to gwt
	 * project failed
	 * 
	 * Better solution: try ->
	 * http://www.vogella.com/tutorials/GWT/article.html#modules_use
	 */

	private static final String CAMUNDA_CLASS_NAME__JAVA_DELEGATE = "org.camunda.bpm.engine.delegate.JavaDelegate";
	private static final String CAMUNDA_CLASS_NAME__TEST_EXCEPTION = "java.lang.Exception";

	public static CamundaTypeHolder parseProjectForCamundaElements(
			ProjectNode projectNode) {
		Log.info(BpmnEditor.class, "parseProjectForCamundaElements");

		CamundaTypeHolder camundaTypeHolder = new CamundaTypeHolder();
		parseTreeNode(camundaTypeHolder, projectNode);

		return camundaTypeHolder;
	}

	private static void parseTreeNode(CamundaTypeHolder camundaTypeHolder,
			TreeNode<?> treeNode) {
		parseTreeNode(camundaTypeHolder, treeNode, false, false);
	}

	private static void parseTreeNode(CamundaTypeHolder camundaTypeHolder,
			TreeNode<?> treeNode, boolean isChildOfJavaFolder,
			boolean isChildOfWebappFolder) {
		Log.info(BpmnEditor.class, "parseTreeNode");

		if (treeNode.isLeaf()) {
			Log.info(BpmnEditor.class,
					"parseTreeNode: leaf:" + treeNode.getDisplayName());
			ItemNode itemNode = (ItemNode) treeNode;
			try {
				Log.info(BpmnEditor.class, "parseTreeNode: leaf: url="
						+ ((FileNode) itemNode).getContentUrl());
			} catch (ClassCastException e) {

			}

			// treeNode is a file, check if is a camunda type
			if (isChildOfJavaFolder
					&& itemNode.getData().getName().endsWith(".java")) {
				/*
				 * This dont work, need a solution for check the java-classes inside the project
				 * 
				 * see CodenvyGoogleGroup-thread
				 * mabye use ClassLoader and read text
				 */
				
				switch (itemNode.getData().getClass().getSuperclass().getName()) {
				case CAMUNDA_CLASS_NAME__TEST_EXCEPTION:
					Log.info(BpmnEditor.class, "parseTreeNode: leaf:"
							+ treeNode.getDisplayName() + " TYPE: "
							+ CAMUNDA_CLASS_NAME__TEST_EXCEPTION);
					CamundaJavaDelegateType type2 = new CamundaJavaDelegateType(
							itemNode.getPath(), treeNode.getDisplayName());
					camundaTypeHolder.getJavaDelegateClasses().add(type2);
					break;
				default:
					Log.info(BpmnEditor.class, "parseTreeNode: leaf:"
							+ treeNode.getDisplayName()
							+ " IS NOT A SEARCHED FILE");
					break;
				}
			} else if (isChildOfWebappFolder
					&& itemNode.getData().getName().endsWith(".html")) {
				Log.info(BpmnEditor.class,
						"parseTreeNode: leaf:" + treeNode.getDisplayName()
								+ " TYPE: " + "HTML");
				CamundaFormKeyType type = new CamundaFormKeyType(
						itemNode.getPath(), treeNode.getDisplayName());
				camundaTypeHolder.getFormKeyFiles().add(type);
			}

		} else {
			// treeNode is a folder
			Log.info(BpmnEditor.class,
					"parseTreeNode: folder:" + treeNode.getDisplayName());
			if (treeNode.getDisplayName().equals("webapp")) {
				isChildOfWebappFolder = true;
			}

			if (treeNode.getDisplayName().equals("java")) {
				isChildOfJavaFolder = true;
			}

			for (TreeNode<?> tn : treeNode.getChildren().asIterable()) {
				parseTreeNode(camundaTypeHolder, tn, isChildOfJavaFolder,
						isChildOfWebappFolder);
			}
		}
	}
}
