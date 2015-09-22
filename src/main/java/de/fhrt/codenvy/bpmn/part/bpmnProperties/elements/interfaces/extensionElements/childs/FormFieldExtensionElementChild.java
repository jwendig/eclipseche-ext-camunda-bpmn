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

import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.childs.PropertyJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces._BaseElement;

public interface FormFieldExtensionElementChild extends _BaseElement {
	public String getAttr_id();

	public void setAttr_id(String id);

	public String getAttr_label();

	public void setAttr_label(String label);

	public String getAttr_type();

	public void setAttr_type(String type);

	public String getAttr_defaultValue();

	public void setAttr_defaultValue(String defaultValue);

	public List<PropertyExtensionElementChild> getChildsProperties();

	public PropertyExtensionElementChild addChildProperty();

	public void removeChildProperty(PropertyExtensionElementChild propertyJso);

	public List<ConstraintExtensionElementChild> getChildsContraints();

	public ConstraintExtensionElementChild addChildContraint();

	public void removeChildConstraint(
			ConstraintExtensionElementChild constraintExtensionElement);
}
