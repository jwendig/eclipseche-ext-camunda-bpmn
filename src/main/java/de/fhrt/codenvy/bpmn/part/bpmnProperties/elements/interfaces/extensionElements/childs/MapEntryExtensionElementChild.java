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

import com.google.gwt.core.client.JavaScriptObject;

public interface MapEntryExtensionElementChild {
	public JavaScriptObject getElement();

	public String getAttr_key();

	public void setAttr_key(String key);

	public String getAttr_value();

	public void setAttr_value(String value);
}
