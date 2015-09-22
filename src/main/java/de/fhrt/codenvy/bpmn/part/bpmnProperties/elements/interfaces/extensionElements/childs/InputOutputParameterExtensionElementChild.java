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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces._BaseElement;

public interface InputOutputParameterExtensionElementChild extends _BaseElement {
	public String getAttr_name();

	public void setAttr_name(String name);

	public String getAttr_value();

	public void setAttr_value(String value);

	public ScriptExtensionElementChild getScriptChild();

	public ScriptExtensionElementChild setScriptChild();

	public void removeScriptChild();

	public List<MapEntryExtensionElementChild> getMapEntryChilds();

	public MapEntryExtensionElementChild addMapEntryChild();

	public void removeMapEntryChild(
			MapEntryExtensionElementChild mapEntryElement);

	public List<ListValueExtensionElementChild> getListValueChilds();

	public ListValueExtensionElementChild addListValueChild();

	public void removeListValueChild(
			ListValueExtensionElementChild listValueElement);
}
