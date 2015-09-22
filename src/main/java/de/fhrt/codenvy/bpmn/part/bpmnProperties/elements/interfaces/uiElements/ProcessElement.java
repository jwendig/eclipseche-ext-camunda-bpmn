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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.uiElements;

import java.util.List;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces._BaseElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.ExecutionListenerExtensionElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.TaskListenerExtensionElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.PropertyExtensionElementChild;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.flowElements.DataObjectFlowElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.rootElements.DataStoreRootElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.rootElements.ErrorRootElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.rootElements.MessageRootElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.rootElements.SignalRootElement;

public interface ProcessElement extends _BaseElement {
	public boolean getAttr_isExecutable();

	public void setAttr_isExecutable(boolean isExecutable);

	public String getAttr_candidateStarterGroups();

	public void setAttr_candidateStarterGroups(String candidateStarterGroups);

	public String getAttr_candidateStarterUsers();

	public void setAttr_candidateStarterUsers(String candidateStarterUsers);

	/*
	 * flowElements
	 */

	public DataObjectFlowElement addDataObjectFlowElement();

	public void removeDataObjectFlowElement(DataObjectFlowElement propElement);

	public List<DataObjectFlowElement> getDataObjectsFlowElements();

	/*
	 * extensionElements
	 */

	public ExecutionListenerExtensionElement addExtensionElementExecutionListener();

	public void removeExtensionElementExecutionListener(
			ExecutionListenerExtensionElement extensionElement);

	public List<ExecutionListenerExtensionElement> getExecutionListenerExtensionElements();

	public TaskListenerExtensionElement addExtensionElementTaskListener();

	public void removeTaskListenerExtensionElement(
			TaskListenerExtensionElement extensionElement);

	public List<TaskListenerExtensionElement> getTaskListenerExtensionElements();

	public PropertyExtensionElementChild addExtensionChildElementProperty();

	public void removeExtensionChildElementPropety(
			PropertyExtensionElementChild propertyElement);

	public List<PropertyExtensionElementChild> getExtensionChildElementsPropety();

	/*
	 * rootElements
	 */

	public DataStoreRootElement addRootElementDataStore();

	public void removeRootElementDataStore(DataStoreRootElement dataStoreElement);

	public List<DataStoreRootElement> getRootElementsDataStore();

	public ErrorRootElement addRootElementError();

	public void removeRootElementError(ErrorRootElement errorElement);

	public List<ErrorRootElement> getRootElementsError();

	public MessageRootElement addRootElementMessage();

	public void removeRootElementMessage(MessageRootElement messageElement);

	public List<MessageRootElement> getRootElementsMessage();

	public SignalRootElement addRootElementSignal();

	public void removeRootElementSignal(SignalRootElement signalElement);

	public List<SignalRootElement> getRootElementsSignal();
}
