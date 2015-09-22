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

import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces._BaseElement;

public interface ScriptExtensionElementChild extends _BaseElement {
	public String getAttr_scriptFormat();

	public void setAttr_scriptFormat(String scriptFormat);

	public String getAttr_resource();

	public void setAttr_resource(String resource);

	public String getAttr_script();

	public void setAttr_script(String script);
}
