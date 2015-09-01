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

package de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.base.multiinstance;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.UserTaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.AbstractBpmnPropertiesTabController;

public class TabMulitInstanceController<T> extends
		AbstractBpmnPropertiesTabController<T> {
	private final static String TAB_NAME = "Multi Instance";
	private TabMultiInstanceView view;

	public TabMulitInstanceController(
			BpmnElementPropertiesView delegate) {
		super(delegate);
		view = new TabMultiInstanceView(TAB_NAME, delegate);

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
