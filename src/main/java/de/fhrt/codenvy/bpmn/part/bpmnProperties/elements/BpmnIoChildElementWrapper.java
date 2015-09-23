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

	@Override
	public void setAttr_collection(String collection) {
		element.setAttribute("collection", collection);

	}

	@Override
	public String getAttr_collection() {
		return element.getStringAttribute("collection");
	}

	@Override
	public void setAttr_elementVariable(String elementVariable) {
		element.setAttribute("elementVariable", elementVariable);

	}

	@Override
	public String getAttr_elementVariable() {
		return element.getStringAttribute("elementVariable");
	}

	@Override
	public void setAttr_isSequential(boolean isSequential) {
		element.setAttribute("isSequential", isSequential);
		/*
		 * TODO: find a way to use a updateProperty-Function to set this
		 * attribute, this is needed to refresh the ui. The existing function
		 * updatePropeties at the modeling element accepts only elements that
		 * have an businessObject.
		 */
//		modeling.updateProperty(element, "isSequential", isSequential);

	}

	@Override
	public boolean getAttr_isSequential() {
		return element.getBooleanAttribute("isSequential");
	}
}
