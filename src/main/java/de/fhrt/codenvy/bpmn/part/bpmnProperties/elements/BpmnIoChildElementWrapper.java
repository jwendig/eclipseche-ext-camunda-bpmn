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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.elements;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.childElements.MultiInstanceLoopCharacteristicsChildElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.childElements.StandardLoopCharacteristicsChildElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoChildElementJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoModdleJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoModelerJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoModelingJso;

public class BpmnIoChildElementWrapper implements
		StandardLoopCharacteristicsChildElement,
		MultiInstanceLoopCharacteristicsChildElement {
	private BpmnIoChildElementJso element;
	private BpmnIoModelerJso modeler;
	private BpmnIoModelingJso modeling;
	private BpmnIoModdleJso moddle;

	public BpmnIoChildElementWrapper(BpmnIoChildElementJso element,
			BpmnIoModelerJso modeler) {
		super();
		this.element = element;
		this.modeler = modeler;
		this.modeling = modeler.nativeGetBpmnIoModelingJso();
		this.moddle = modeler.nativeGetBpmnIoModdleJso();
	}

	public BpmnIoChildElementJso getElement() {
		return element;
	}

	public BpmnIoModelerJso getModeler() {
		return modeler;
	}

	@Override
	public String getType() {
		return element.getType();
	}
}
