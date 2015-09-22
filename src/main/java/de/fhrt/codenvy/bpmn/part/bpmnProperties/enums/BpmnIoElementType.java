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

public enum BpmnIoElementType {
	DEFAULT("UNDEFINED"), PROCESS("bpmn:Process"), SCRIPT_TASK(
			"bpmn:ScriptTask"), SERVICE_TASK("bpmn:ServiceTask"), START_EVENT(
			"bpmn:StartEvent"), TASK("bpmn:Task"), USER_TASK("bpmn:UserTask");

	private final String bpmnIoTypeDefinition;

	private BpmnIoElementType(final String bpmnIoTypeDefinition) {
		this.bpmnIoTypeDefinition = bpmnIoTypeDefinition;
	}

	@Override
	public String toString() {
		return bpmnIoTypeDefinition;
	}

	public static BpmnIoElementType findByBpmnIoTypeDefinition(
			String bpmnIoTypeDefinition) {
		for (BpmnIoElementType t : values()) {
			if (t.bpmnIoTypeDefinition.equals(bpmnIoTypeDefinition)) {
				return t;
			}
		}
		return DEFAULT;
	}
}