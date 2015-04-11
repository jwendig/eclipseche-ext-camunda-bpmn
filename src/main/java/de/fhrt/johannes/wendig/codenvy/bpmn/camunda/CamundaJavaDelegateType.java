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

package de.fhrt.johannes.wendig.codenvy.bpmn.camunda;

public class CamundaJavaDelegateType extends AbstractCamundaType{

	private static final String BPMN_ATTR_NAME = "camunda:class";
	
	public CamundaJavaDelegateType(String path, String filename) {
		super(path, filename);
	}
	
	@Override
	public String getBpmnAttrName() {
		return BPMN_ATTR_NAME;
	}

	@Override
	public String getBpmnAttrContent() {
		return getPath() + (getPath().endsWith(".")? "":".") + getFilename();
	}

}
