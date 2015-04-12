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

@ImplementedBy(BpmnElementPropertiesViewImpl.class)
public interface BpmnElementPropertiesView extends
		View<BpmnElementPropertiesView.ActionDelegate> {
	public interface ActionDelegate {
	}

	public void loadUnknownItemInfo(GQuery selectedItem);
	
	public void loadProcessProperties(GQuery selectedItem);

	public void loadUserTaskProperties(GQuery selectedItem);

	public void loadServiceTaksProperties(GQuery selectedItem);

	public void loadStartEventProperties(GQuery selectedItem);
}
