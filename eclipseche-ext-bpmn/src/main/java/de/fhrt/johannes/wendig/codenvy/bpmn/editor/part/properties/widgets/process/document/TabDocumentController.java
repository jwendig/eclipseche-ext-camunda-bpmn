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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.process.document;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView.ActionDelegate;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesTabController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.process.general.TabGeneralController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementJso;

public class TabDocumentController extends AbstractBpmnPropertiesTabController {
	private final static String TAB_NAME = "Document";
	private TabDocumentView view;

	public TabDocumentController(ActionDelegate delegate) {
		super(delegate);
		this.view = new TabDocumentView(TAB_NAME, delegate);

		view.getTbTargetNamespace().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				Log.info(TabGeneralController.class, "name-changed");
				getActionDelegate().getCurrentBpmnIoModelerJso()
						.setAttr_targetNamespace(
								view.getTbTargetNamespace().getText());
				getActionDelegate().onContentChange();
			}
		});

	}

	public TabDocumentView getView() {
		return view;
	}

	@Override
	public void updateView() {
		this.view.getTbTargetNamespace().setText(
				getActionDelegate().getCurrentBpmnIoModelerJso()
						.getAttr_targetNamespace());
	}

}
