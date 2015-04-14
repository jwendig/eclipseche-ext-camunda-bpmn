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
package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties;

import org.eclipse.che.ide.api.mvp.View;

import com.google.gwt.query.client.GQuery;
import com.google.inject.ImplementedBy;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnProcessJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.CamundaElementJso;

@ImplementedBy(BpmnElementPropertiesViewImpl.class)
public interface BpmnElementPropertiesView extends
		View<BpmnElementPropertiesView.ActionDelegate> {
	public interface ActionDelegate {
	}

	public void loadUnknownItemInfo(CamundaElementJso selectedItem);

	public void loadProcessProperties(BpmnProcessJso selectedItem);

	public void loadUserTaskProperties(CamundaElementJso selectedItem);

	public void loadServiceTaksProperties(CamundaElementJso selectedItem);

	public void loadStartEventProperties(CamundaElementJso selectedItem);
}
