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

import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.InputParameterExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.OutputParameterExtensionElementChild;

public interface UserTaskElement extends TaskElement {
	public String getAttr_assignee();

	public void setAttr_assignee(String assignee);

	public String getAttr_candidateGroups();

	public void setAttr_candidateGroups(String candidateGroups);

	public String getAttr_candidateUsers();

	public void setAttr_candidateUsers(String candidateUsers);

	public String getAttr_dueDate();

	public void setAttr_dueDate(String dueDate);

	public String getAttr_formHandlerClass();

	public void setAttr_formHandlerClass(String formHandlerClass);

	public String getAttr_formKey();

	public void setAttr_formKey(String formKey);

	public String getAttr_followUpDate();

	public void setAttr_followUpDate(String followUpDate);

	public boolean getAttr_isForCompensation();

	public void setAttr_isForCompensation(boolean isForCompensation);

	public String getAttr_priority();

	public void setAttr_priority(String priority);

	/*
	 * extensionElements
	 */

	public void removeExtensionChildElementInputParameter(
			InputParameterExtensionElementChild inputParameterElement);

	public List<InputParameterExtensionElementChild> getExtensionChildElementsInputParameters();

	public InputParameterExtensionElementChild addExtensionChildElementInputParameter();

	public void removeExtensionChildElementOutputParameter(
			OutputParameterExtensionElementChild outputParameterElement);

	public List<OutputParameterExtensionElementChild> getExtensionChildElementsOutputParameters();

	public OutputParameterExtensionElementChild addExtensionChildElementOutputParameter();
}
