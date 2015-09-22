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

public enum BpmnIoExtensionChildElementType {
	CAMUNDA_SCRIPT("camunda:Script", "script"), CAMUNDA_PROPERTY(
			"camunda:Property", "properties"), CAMUNDA_CONSTRAINT(
			"camunda:Constraint", "validations"), CAMUNDA_FORMFIELD(
			"camunda:FormField", "values"), CAMUNDA_INPUT_PARAMETER(
			"camunda:InputParameter", "inputParameters"), CAMUNDA_OUTPUT_PARAMETER(
			"camunda:OutputParameter", "outputParameters"), CAMUNDA_MAP_ENTRY(
			"camunda:Entry", "map"), CAMUNDA_LIST_VALUE("camunda:Value", "list");

	private final String type;
	private final String key;

	private BpmnIoExtensionChildElementType(final String type, final String key) {
		this.type = type;
		this.key = key;
	}

	@Override
	public String toString() {
		return type;
	}

	public String getType() {
		return type;
	}

	public String getKey() {
		return key;
	}

}