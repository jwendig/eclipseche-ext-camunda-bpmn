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

package de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.BpmnElementPropertyJso;
import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.bpmn.DataObjectJso;

public interface ProcessJso extends DefaultJso {
	public boolean getAttr_isExecutable();

	public void setAttr_isExecutable(boolean isExecutable);

	public String getAttr_candidateStarterGroups();

	public void setAttr_candidateStarterGroups(String candidateStarterGroups);

	public String getAttr_candidateStarterUsers();

	public void setAttr_candidateStarterUsers(String candidateStarterUsers);

	public JsArray<BpmnElementPropertyJso> getBpmnDataObjects();

	public BpmnElementPropertyJso addBpmnDataObject(JavaScriptObject moddle);

	public boolean removeBpmnElement(BpmnElementPropertyJso propElement);
}
