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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets;

import org.eclipse.che.ide.util.loging.Log;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces._BaseElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoModelerJso;

public abstract class AbstractBpmnPropertiesTabController<T> {
	private BpmnPropertiesView.CurrentJsoAccess jsoAccess;

	public AbstractBpmnPropertiesTabController(
			BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		this.jsoAccess = jsoAccess;
	}

	public abstract void updateView();

	public T getCurrentBpmnElement() {
		Log.info(AbstractBpmnPropertiesTabController.class,
				"getCurrentBpmnElement()");
		return (T) jsoAccess.getCurrentElement();
	}

	public BpmnIoModelerJso getCurrentBpmnModeler() {
		return jsoAccess.getCurrentElement().getModeler();
	}

	public void contentChanged() {
		jsoAccess.onContentChange();
	}
}
