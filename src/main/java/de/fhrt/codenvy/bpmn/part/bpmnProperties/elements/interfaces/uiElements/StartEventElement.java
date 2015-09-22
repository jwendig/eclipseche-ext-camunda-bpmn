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

import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces._BaseElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.FormFieldExtensionElementChild;

public interface StartEventElement extends _BaseElement {
	public boolean getAttr_asyncAfter();

	public void setAttr_asyncAfter(boolean asyncAfter);

	public boolean getAttr_asyncBefore();

	public void setAttr_asyncBefore(boolean asyncBefore);

	public boolean getAttr_exclusive();

	public void setAttr_exclusive(boolean exclusive);

	public String getAttr_formHandlerClass();

	public void setAttr_formHandlerClass(String formHandlerClass);

	public String getAttr_formKey();

	public void setAttr_formKey(String formKey);

	public String getAttr_initiator();

	public void setAttr_initiator(String initiator);

	public List<FormFieldExtensionElementChild> getExtensionChildElementsFormField();

	public FormFieldExtensionElementChild addExtensionChildElementFormField();

	public void removeExtensionChildElementFormField(
			FormFieldExtensionElementChild element);
}
