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
package de.fhrt.codenvy.bpmn.part.bpmnProperties;

import org.eclipse.che.ide.api.mvp.View;
import org.eclipse.che.ide.api.parts.base.BaseActionDelegate;

import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.inject.ImplementedBy;

import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.BpmnElementJso;
import de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.BpmnModelerJso;

@ImplementedBy(BpmnPropertiesViewImpl.class)
public interface BpmnPropertiesView extends
		View<BpmnPropertiesView.ActionDelegate> {
	public interface ActionDelegate extends BaseActionDelegate {
	}

	public interface CurrentJsoAccess {
		public BpmnElementJso getCurrentElementJso();

		public BpmnModelerJso getCurrentBpmnIoModelerJso();

		void onContentChange();
	}

	public void loadWidgetForSelectedBpmnElement(BpmnModelerJso modelerJso,
			BpmnElementJso elementJso);

	public void clearView();
}
