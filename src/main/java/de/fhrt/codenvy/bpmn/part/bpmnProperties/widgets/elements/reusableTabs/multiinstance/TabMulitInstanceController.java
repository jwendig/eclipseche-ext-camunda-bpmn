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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.multiinstance;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesTabController;

public class TabMulitInstanceController<T> extends
		AbstractBpmnPropertiesTabController<T> {
	private final static String TAB_NAME = "Multi Instance";
	private TabMultiInstanceView view;

	public TabMulitInstanceController(
			BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(jsoAccess);
		view = new TabMultiInstanceView(TAB_NAME, jsoAccess);

	}

	public TabMultiInstanceView getView() {
		return view;
	}

	@Override
	public void updateView() {
		view.getCbIsLoop().setValue(false);
		view.getCbIsLoop()
				.setText(
						"Please note, the loop activity is not supported by the Camunda BPM engine.");
		view.getCbIsLoop().setEnabled(false);
		view.getCbMultiInstance().setValue(false);
		view.getCbMultiInstance().setText("not implemented: TODO");
		view.getCbMultiInstance().setEnabled(false);
	}
}
