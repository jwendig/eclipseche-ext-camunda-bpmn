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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.childElements;

import com.google.gwt.core.client.JavaScriptObject;

public interface MultiInstanceLoopCharacteristicsChildElement {
	public JavaScriptObject getElement();

	public String getType();

	public void setAttr_collection(String collection);

	public String getAttr_collection();

	public void setAttr_elementVariable(String elementVariable);

	public String getAttr_elementVariable();

	public void setAttr_isSequential(boolean isSequential);

	public boolean getAttr_isSequential();
}
