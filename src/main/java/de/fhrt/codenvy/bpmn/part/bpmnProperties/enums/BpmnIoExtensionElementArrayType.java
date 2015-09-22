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

public enum BpmnIoExtensionElementArrayType {
	CAMUNDA_PROPERTIES("camunda:Properties", "values"), CAMUNDA_VALIDATION(
			"camunda:Validation", "values"), CAMUNDA_FORMDATA(
			"camunda:FormData", "values"), CAMUNDA_INPUT("camunda:InputOutput",
			"inputParameters"), CAMUNDA_OUTPUT("camunda:InputOutput",
			"outputParameters"), CAMUNDA_LIST("camunda:List", "list"), CAMUNDA_MAP(
			"camunda:Map", "map");

	private final String type;
	private final String field;

	private BpmnIoExtensionElementArrayType(
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