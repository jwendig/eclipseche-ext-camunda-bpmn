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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.base;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.Scheduler;
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
	private ListDataProvider<ExecutionListenerJso> executionListenersProvider;
	private ExecutionListenerJso selectedExecutionListenerJso;
	private BpmnDiagramElementJso bpmnDiagramElementJso;

	public TabListenerController(ActionDelegate delegate) {
		super(delegate);
		this.view = new TabListenerView(TAB_NAME);

		initExecutionListenerDataProvider();

		// initExecutionListenerSelectionModel();

		initExecutionListenerButtons();
	}

	private void initExecutionListenerButtons() {
		Log.info(TabListenerController.class, "initExecutionListenerButtons");
		view.getBtnAddExecutionListener().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				new TabListenerEditDialog(TabListenerController.this).show();

			}
		});

		view.getTcExecutionListenerBtnEdit().setFieldUpdater(
				new FieldUpdater<ExecutionListenerJso, String>() {

					@Override
					public void update(int index, ExecutionListenerJso object,
							String value) {
						new TabListenerEditDialog(TabListenerController.this,
								object).show();

					}
				});

		view.getTcExecutionListenerBtnRemove().setFieldUpdater(
				new FieldUpdater<ExecutionListenerJso, String>() {

					@Override
					public void update(int index, ExecutionListenerJso object,
							String value) {
						if (TabListenerController.this.bpmnDiagramElementJso
								.removeExt_elemenemt((BpmnDiagramElementExtensionJso) object)) {
							getExecutionListenersProvider().getList().remove(
									object);
							getExecutionListenersProvider().refresh();
							view.getCtExecutionListeners().redraw();
							getActionDelegate().onContentChange();
						} else {

						}
					}
				});
	}

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

	private void initExecutionListenerDataProvider() {
		Log.info(TabListenerController.class,
				"initExecutionListenerDataProvider");
		executionListenersProvider = new ListDataProvider<ExecutionListenerJso>();
		executionListenersProvider.addDataDisplay(view
				.getCtExecutionListeners());
	}

	public TabListenerView getView() {
		return view;
	}

	public void loadSelectedElement(final BpmnDiagramElementJso element) {
		Log.info(TabListenerController.class, "loadSelectedElement");

		this.bpmnDiagramElementJso = element;
		executionListenersProvider.getList().clear();
		JsArray<BpmnDiagramElementExtensionJso> executionListeners = bpmnDiagramElementJso
				.getExt_executionListeners();
		for (int i = 0; i < executionListeners.length(); i++) {
			executionListenersProvider.getList().add(executionListeners.get(i));
		}
	}

	public BpmnDiagramElementJso getBpmnDiagramElementJso() {
		return bpmnDiagramElementJso;
	}

	public ListDataProvider<ExecutionListenerJso> getExecutionListenersProvider() {
		return executionListenersProvider;
	}
}
