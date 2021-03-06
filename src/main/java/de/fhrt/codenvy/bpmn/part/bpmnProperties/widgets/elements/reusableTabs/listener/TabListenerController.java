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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.listener;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesTabController;

public class TabListenerController<T> extends
		AbstractBpmnPropertiesTabController<T> {

	private final static String TAB_NAME = "Listener";

	private TabListenerView view;
	private boolean hasTaskListener;

	public TabListenerController(BpmnPropertiesView.CurrentJsoAccess jsoAccess,
			boolean hasTaskListener) {
		super(jsoAccess);
		this.hasTaskListener = hasTaskListener;
		this.view = new TabListenerView(TAB_NAME, jsoAccess);

		if (!hasTaskListener) {
			view.getGridTabContent().removeRow(1);
		}
	}

	public TabListenerView getView() {
		return view;
	}

	@Override
	public void updateView() {
		view.getTableExecutionListener().update();
		if (hasTaskListener) {
			view.getTableTaskListener().update();
		}
	}
}
