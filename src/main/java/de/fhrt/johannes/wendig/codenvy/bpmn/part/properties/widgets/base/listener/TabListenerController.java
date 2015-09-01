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

package de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.base.listener;

import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.AbstractBpmnPropertiesTabController;

public class TabListenerController<T> extends
		AbstractBpmnPropertiesTabController<T> {

	private final static String TAB_NAME = "Listener";

	private TabListenerView view;
	private boolean hasTaskListener;

	public TabListenerController(BpmnElementPropertiesView delegate,
			boolean hasTaskListener) {
		super(delegate);
		this.hasTaskListener = hasTaskListener;
		this.view = new TabListenerView(TAB_NAME, delegate);

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
