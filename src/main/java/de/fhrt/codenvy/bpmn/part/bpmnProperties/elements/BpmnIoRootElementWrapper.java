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

import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.rootElements.DataStoreRootElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.rootElements.ErrorRootElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.rootElements.MessageRootElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.rootElements.SignalRootElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoModdleJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoModelerJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoModelingJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoRootElementJso;

public class BpmnIoRootElementWrapper implements DataStoreRootElement,
		ErrorRootElement, SignalRootElement, MessageRootElement {
	private BpmnIoRootElementJso element;
	private BpmnIoModelerJso modeler;
	private BpmnIoModelingJso modeling;
	private BpmnIoModdleJso moddle;

	public BpmnIoRootElementWrapper(BpmnIoRootElementJso element,
			BpmnIoModelerJso modeler) {
		super();
		this.element = element;
		this.modeler = modeler;
		this.modeling = modeler.nativeGetBpmnIoModelingJso();
		this.moddle = modeler.nativeGetBpmnIoModdleJso();
	}

	public BpmnIoRootElementJso getElement() {
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
	public String getAttr_id() {
		return element.getStringAttribute("id");
	}

	@Override
	public void setAttr_id(String id) {
		element.setAttribute("id", id);
	}

	@Override
	public String getAttr_name() {
		return element.getStringAttribute("name");
	}

	@Override
	public void setAttr_name(String name) {
		element.setAttribute("name", name);
	}

	@Override
	public String getAttr_errorCode() {
		return element.getStringAttribute("errorCode");
	}

	@Override
	public void setAttr_errorCode(String errorCode) {
		element.setAttribute("errorCode", errorCode);

	}

}
