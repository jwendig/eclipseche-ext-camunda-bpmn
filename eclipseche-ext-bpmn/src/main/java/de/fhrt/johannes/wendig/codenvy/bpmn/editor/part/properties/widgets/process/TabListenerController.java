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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.process;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView.ActionDelegate;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesTabController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementExtensionJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.extensions.ExecutionListenerJso;

public class TabListenerController extends AbstractBpmnPropertiesTabController {

	private final static String TAB_NAME = "Listener";

	private TabListenerView view;

	public TabListenerController(ActionDelegate delegate) {
		super(delegate);
		this.view = new TabListenerView(TAB_NAME);
		view.getTableExecutionListener().setController(this);

		// initExecutionListenerSelectionModel();
	}

	// TODO: no need there, but stay for example...
	// private void initExecutionListenerSelectionModel() {
	// Log.info(TabListenerController.class,
	// "initExecutionListenerSelectionModel");
	//
	// final SingleSelectionModel<ExecutionListenerJso> selectionModel = new
	// SingleSelectionModel<ExecutionListenerJso>();
	// selectionModel
	// .addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
	// public void onSelectionChange(SelectionChangeEvent event) {
	// Log.info(TabListenerController.class,
	// "initExecutionListenerSelectionModel: selectionChangeHandler");
	// selectedExecutionListenerJso = selectionModel
	// .getSelectedObject();
	//
	// if (null != selectedExecutionListenerJso) {
	// Log.info(
	// TabListenerController.class,
	// "initExecutionListenerSelectionModel: selectionChangeHandler: a element is selected ("
	// + selectedExecutionListenerJso
	// .getAttr_class() + ")");
	// } else {
	// Log.info(
	// TabListenerController.class,
	// "initExecutionListenerSelectionModel: selectionChangeHandler: no element is selected");
	// }
	// }
	// });
	// view.getCtExecutionListeners().setSelectionModel(selectionModel);
	// }

	// private void initExecutionListenerDataProvider() {
	// Log.info(TabListenerController.class,
	// "initExecutionListenerDataProvider");
	// executionListenersProvider = new
	// ListDataProvider<ExecutionListenerJso>();
	// executionListenersProvider.addDataDisplay(view
	// .getCtExecutionListeners());
	// }

	public TabListenerView getView() {
		return view;
	}

	@Override
	public void updateView(final BpmnDiagramElementJso element) {
		Log.info(TabListenerController.class, "loadSelectedElement");

		setBpmnDiagramElementJso(element);
		view.getTableExecutionListener().update();
	}
}
