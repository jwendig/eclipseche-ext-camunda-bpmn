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

package de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.BpmnElementJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.BpmnModelerJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.BpmnElementPropertiesView;

public abstract class AbstractBpmnPropertiesTabController<T> {
	private BpmnElementPropertiesView.CurrentJsoAccess jsoAccess;

	public AbstractBpmnPropertiesTabController(
			BpmnElementPropertiesView.CurrentJsoAccess jsoAccess) {
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
