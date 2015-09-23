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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.uiElements;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;

import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.InputParameterJso;
import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.OutputParameterJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces._BaseElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.InputParameterExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.OutputParameterExtensionElementChild;

public interface ServiceTaskElement extends TaskElement {
	public String getAttr_class();

	public void setAttr_class(String clazz);

	public String getAttr_delegateExpression();

	public void setAttr_delegateExpression(String delegateExpression);

	public String getAttr_expression();

	public void setAttr_expression(String expression);

	public String getAttr_resultVariable();

	public void setAttr_resultVariable(String resultVariable);

	public String getAttr_type();

	public void setAttr_type(String type);

	public boolean getAttr_isForCompensation();

	public void setAttr_isForCompensation(boolean isForCompensation);

	public void removeExtensionChildElementInputParameter(
			InputParameterExtensionElementChild inputParameterElement);

	public List<InputParameterExtensionElementChild> getExtensionChildElementsInputParameters();

	public InputParameterExtensionElementChild addExtensionChildElementInputParameter();

	public void removeExtensionChildElementOutputParameter(
			OutputParameterExtensionElementChild outputParameterElement);

	public List<OutputParameterExtensionElementChild> getExtensionChildElementsOutputParameters();

	public OutputParameterExtensionElementChild addExtensionChildElementOutputParameter();
}
