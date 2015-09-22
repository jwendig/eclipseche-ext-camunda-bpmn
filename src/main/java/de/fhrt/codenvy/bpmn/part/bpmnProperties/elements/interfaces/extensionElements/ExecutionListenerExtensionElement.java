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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces._BaseElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.ScriptExtensionElementChild;

public interface ExecutionListenerExtensionElement extends _BaseElement {
	public String getAttr_class();

	public void setAttr_class(String clazz);

	public String getAttr_delegateExpression();

	public void setAttr_delegateExpression(String delegateExpression);

	public String getAttr_expression();

	public void setAttr_expression(String expression);

	public String getAttr_event();

	public void setAttr_event(String event);

	public ScriptExtensionElementChild getScriptChild();

	public ScriptExtensionElementChild setScriptChild();

	public void removeScriptChild();

}
