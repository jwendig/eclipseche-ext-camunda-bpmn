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

import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces._BaseElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.childElements.MultiInstanceLoopCharacteristicsChildElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.childElements.StandardLoopCharacteristicsChildElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.FailedJobRetryTimeCycleExtensionElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.extensionElements.childs.InputParameterExtensionElementChild;

/*
 * attribute access for all bpmn-io task elements
 */
public interface TaskElement extends _BaseElement {
	public boolean getAttr_asyncAfter();

	public void setAttr_asyncAfter(boolean asyncAfter);

	public boolean getAttr_asyncBefore();

	public void setAttr_asyncBefore(boolean asyncBefore);

	public boolean getAttr_exclusive();

	public void setAttr_exclusive(boolean exclusive);

	/*
	 * child elements
	 */

	public void setStandardLoopCharacteristics(boolean enabled);

	public StandardLoopCharacteristicsChildElement getStandardLoopCharacteristicsChildElement();

	public void setMultiInstanceLoopCharacteristics(boolean enabled);

	public MultiInstanceLoopCharacteristicsChildElement getMultiInstanceLoopCharacteristicsChildElement();

	/*
	 * extension elements
	 */

	public void clearExtensionElementFailedJobRetryTimeCycle(
			FailedJobRetryTimeCycleExtensionElement retryTimeCycleElement);

	public FailedJobRetryTimeCycleExtensionElement getExtensionElementFailedJobRetryTimeCycle();

	public FailedJobRetryTimeCycleExtensionElement createExtensionElementFailedJobRetryTimeCycle();

}
