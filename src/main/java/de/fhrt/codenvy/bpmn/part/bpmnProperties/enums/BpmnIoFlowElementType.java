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
package de.fhrt.codenvy.bpmn.part.bpmnProperties.enums;


public enum BpmnIoFlowElementType {
	BPMN_DATA_OBJECT("bpmn:DataObject");

	private final String type;

	private BpmnIoFlowElementType(final String bpmnIoFlowElementTypeDefinition) {
		this.type = bpmnIoFlowElementTypeDefinition;
	}

	@Override
	public String toString() {
		return type;
	}
}