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

public enum BpmnIoChildElementType {
	BPMN_STANDARD_LOOP_CHARACTERISTICS("bpmn:StandardLoopCharacteristics",
			"loopCharacteristics");

	private final String type;
	private final String field;

	private BpmnIoChildElementType(
			final String bpmnIoFlowElementTypeDefinition, final String field) {
		this.type = bpmnIoFlowElementTypeDefinition;
		this.field = field;
	}

	@Override
	public String toString() {
		return type;
	}

	public String getType() {
		return type;
	}

	public String getField() {
		return field;
	}

}