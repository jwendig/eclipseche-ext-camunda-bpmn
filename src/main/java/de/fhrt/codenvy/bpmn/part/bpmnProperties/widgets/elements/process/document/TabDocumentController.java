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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.process.document;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.uiElements.ProcessElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesTabController;

public class TabDocumentController extends
		AbstractBpmnPropertiesTabController<ProcessElement> {
	private final static String TAB_NAME = "Document";
	private TabDocumentView view;

	public TabDocumentController(BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(jsoAccess);
		this.view = new TabDocumentView(TAB_NAME, jsoAccess);

		view.getTbTargetNamespace().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getCurrentBpmnModeler().setAttr_targetNamespace(
						view.getTbTargetNamespace().getText());
				contentChanged();
			}
		});

	}

	public TabDocumentView getView() {
		return view;
	}

	@Override
	public void updateView() {
		this.view.getTbTargetNamespace().setText(
				getCurrentBpmnModeler().getAttr_targetNamespace());
	}

}
