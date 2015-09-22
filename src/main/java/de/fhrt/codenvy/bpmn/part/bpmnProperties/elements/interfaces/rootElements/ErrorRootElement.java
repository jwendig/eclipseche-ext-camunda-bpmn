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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.rootElements;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces._BaseElement;

public interface ErrorRootElement extends _BaseElement {
	public String getAttr_id();

	public void setAttr_id(String id);

	public String getAttr_name();

	public void setAttr_name(String name);

	public String getAttr_errorCode();

	public void setAttr_errorCode(String errorCode);
}
