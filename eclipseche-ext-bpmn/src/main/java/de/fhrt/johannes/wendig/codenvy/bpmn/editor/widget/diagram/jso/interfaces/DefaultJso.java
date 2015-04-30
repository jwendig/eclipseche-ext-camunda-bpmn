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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.BpmnElementCamundaExtensionJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.ExecutionListenerJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.childs.PropertyJso;

public interface DefaultJso {
	/*
	 * attributes
	 */
	public String getType();

	public String getAttr_id();

	public void setAttr_id(String id);

	public String getAttr_name();

	public void setAttr_name(String name);

	
	/*
	 * extensions
	 */
	public boolean removeCamundaExt_executionListener(ExecutionListenerJso element);

	public List<ExecutionListenerJso> getCamundaExt_executionListeners();

	public ExecutionListenerJso addCamundaExt_executionListener(JavaScriptObject moddle);

	public boolean removeCamundaExt_property(PropertyJso element);

	public List<PropertyJso> getCamundaExt_property();

	public PropertyJso addCamundaExt_property(JavaScriptObject moddle);

}
