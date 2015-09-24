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

public enum BpmnIoExtensionElementType {
	// TODO: check which is the correct namespace for remove fox_failed_job.., fox or camunda
	
	CAMUNDA_EXECUTION_LISTENER("camunda:ExecutionListener"), CAMUNDA_TASK_LISTENER(
			"camunda:TaskListener"), FOX_FAILED_JOB_RETRY_TIME_CYCLE(
			"fox:FailedJobRetryTimeCycle"), CAMUNDA_FAILED_JOB_RETRY_TIME_CYCLE(
					"camunda:FailedJobRetryTimeCycle");

	private final String type;

	private BpmnIoExtensionElementType(
			final String bpmnIoFlowElementTypeDefinition) {
		this.type = bpmnIoFlowElementTypeDefinition;

	}

	@Override
	public String toString() {
		return type;
	}

	public String getType() {
		return type;
	}
}