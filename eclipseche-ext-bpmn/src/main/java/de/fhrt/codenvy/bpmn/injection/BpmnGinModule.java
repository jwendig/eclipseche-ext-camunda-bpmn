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

package de.fhrt.codenvy.bpmn.injection;

import org.eclipse.che.ide.api.extension.ExtensionGinModule;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

import de.fhrt.codenvy.bpmn.editor.BpmnEditorView;
import de.fhrt.codenvy.bpmn.editor.BpmnEditorViewImpl;

@ExtensionGinModule
public class BpmnGinModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(BpmnEditorView.class).to(BpmnEditorViewImpl.class);

	}

}
