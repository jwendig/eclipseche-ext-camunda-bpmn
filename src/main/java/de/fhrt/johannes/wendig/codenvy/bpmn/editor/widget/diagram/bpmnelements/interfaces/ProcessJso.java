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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementPropertyJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.properties.DataObjectJso;

public interface ProcessJso extends DefaultJso {
	public boolean getAttr_isExecutable();

	public void setAttr_isExecutable(boolean isExecutable);

	public String getAttr_candidateStarterGroups();

	public void setAttr_candidateStarterGroups(String candidateStarterGroups);

	public String getAttr_candidateStarterUsers();

	public void setAttr_candidateStarterUsers(String candidateStarterUsers);

	public JsArray<BpmnDiagramElementPropertyJso> getProperty_dataObjects();

	public BpmnDiagramElementPropertyJso addProperty_dataObject(JavaScriptObject moddle);

	public boolean removeProperty_element(
			BpmnDiagramElementPropertyJso propElement);
}
