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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;

public interface FormFieldJso {
	public String getAttr_id();

	public void setAttr_id(String id);

	public String getAttr_label();

	public void setAttr_label(String label);

	public String getAttr_type();

	public void setAttr_type(String type);

	public String getAttr_defaultValue();

	public void setAttr_defaultValue(String defaultValue);

	public List<PropertyJso> getProperties();

	public PropertyJso addProperty(JavaScriptObject moddle);

	public boolean removeProperty(PropertyJso propertyJso);
}
