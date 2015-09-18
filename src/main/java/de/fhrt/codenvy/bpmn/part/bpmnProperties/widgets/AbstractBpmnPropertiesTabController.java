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

import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.BpmnModelerJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;

public abstract class AbstractBpmnPropertiesTabController<T> {
	private BpmnPropertiesView.CurrentJsoAccess jsoAccess;

	public AbstractBpmnPropertiesTabController(
			BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		this.jsoAccess = jsoAccess;
	}

	public abstract void updateView();

	public T getCurrentBpmnElement() {
		return (T) jsoAccess.getCurrentElementJso();
	}

	public BpmnModelerJso getCurrentBpmnModeler() {
		return jsoAccess.getCurrentBpmnIoModelerJso();
	}

	public void contentChanged() {
		jsoAccess.onContentChange();
	}
}
