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
import org.eclipse.che.ide.api.parts.base.BaseActionDelegate;

import com.google.inject.ImplementedBy;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementJso;

@ImplementedBy(BpmnElementPropertiesViewImpl.class)
public interface BpmnElementPropertiesView extends
		View<BpmnElementPropertiesView.ActionDelegate> {
	public interface ActionDelegate extends BaseActionDelegate {
		void onContentChange();
	}

	public void setTitle(String title);

	public void loadNoSelectionInfo();

	public void loadUnknownItemInfo(BpmnDiagramElementJso selectedItem);

	public void loadProcessProperties(BpmnDiagramElementJso selectedItem);

	public void loadUserTaskProperties(BpmnDiagramElementJso selectedItem);

	public void loadServiceTaksProperties(BpmnDiagramElementJso selectedItem);

	public void loadStartEventProperties(BpmnDiagramElementJso selectedItem);
}