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
	private BpmnElementPropertiesView actionDelegate;

	public AbstractBpmnPropertiesTabController(
			BpmnElementPropertiesView actionDelegate) {
		this.actionDelegate = actionDelegate;
	}

	public abstract void updateView();

	// public BpmnElementPropertiesView.ActionDelegate getActionDelegate() {
	// return actionDelegate;
	// }

	public T getCurrentBpmnElement() {
		return (T) actionDelegate.getCurrentElementJso();
	}

	public BpmnModelerJso getCurrentBpmnModeler() {
		return actionDelegate.getCurrentBpmnIoModelerJso();
	}

	public void contentChanged() {
		actionDelegate.onContentChange();
	}
}
