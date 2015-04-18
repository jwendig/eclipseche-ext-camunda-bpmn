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

import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementExtensionJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.extensions.ExecutionListenerJso;

public class TabListenerController {

	public static class ExecutionListenerModel {

		private final ExecutionListenerJso executioinListenerJso;

		public ExecutionListenerModel(ExecutionListenerJso executioinListenerJso) {
			this.executioinListenerJso = executioinListenerJso;
		}

		public String getClazz() {
			return executioinListenerJso.getAttr_class();
		}

		public String getEvent() {
			return executioinListenerJso.getAttr_event();
		}

		public String getExpression() {
			return executioinListenerJso.getAttr_expression();
		}

		public String getDelegateExpression() {
			return executioinListenerJso.getAttr_delegateExpression();
		}

		public ExecutionListenerJso getExecutioinListenerJso() {
			return executioinListenerJso;
		}

	}

	private TabListenerView view;
	private ListDataProvider<ExecutionListenerModel> executionListenersProvider;
	private ExecutionListenerModel selectedExecutionListener;
	private BpmnDiagramElementJso bpmnDiagramElementJso;

	public TabListenerController() {
		Log.info(TabListenerController.class, "constructor");
		this.view = new TabListenerView();

		initExecutionListenerDataProvider();

		initExecutionListenerSelectionModel();

		initExecutionListenerButtons();
	}

	private void initExecutionListenerButtons() {
		Log.info(TabListenerController.class, "initExecutionListenerButtons");
		view.getBtnEditExecutionListener().setEnabled(false);
		view.getBtnRemoveExecutionListener().setEnabled(false);
		view.getBtnAddExecutionListener().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				new TabListenerEditDialog(TabListenerController.this).show();

			}
		});

		view.getBtnEditExecutionListener().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				new TabListenerEditDialog(TabListenerController.this,
						selectedExecutionListener).show();

			}
		});

		view.getBtnRemoveExecutionListener().addClickHandler(
				new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						if (TabListenerController.this.bpmnDiagramElementJso
								.removeExt_elemenemt((BpmnDiagramElementExtensionJso) TabListenerController.this.selectedExecutionListener
										.getExecutioinListenerJso())) {
							TabListenerController.this.executionListenersProvider
									.getList()
									.remove(TabListenerController.this.selectedExecutionListener);
						} else {

						}

					}
				});
	}

	private void initExecutionListenerSelectionModel() {
		Log.info(TabListenerController.class,
				"initExecutionListenerSelectionModel");
		final SingleSelectionModel<ExecutionListenerModel> selectionModel = new SingleSelectionModel<ExecutionListenerModel>();
		selectionModel
				.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
					public void onSelectionChange(SelectionChangeEvent event) {
						Log.info(TabListenerController.class,
								"initExecutionListenerSelectionModel: selectionChangeHandler");
						selectedExecutionListener = selectionModel
								.getSelectedObject();

						if (null != selectedExecutionListener) {
							Log.info(
									TabListenerController.class,
									"initExecutionListenerSelectionModel: selectionChangeHandler: a element is selected ("
											+ selectedExecutionListener
													.getClazz() + ")");
							view.getBtnEditExecutionListener().setEnabled(true);
							view.getBtnRemoveExecutionListener().setEnabled(
									true);
						} else {
							Log.info(
									TabListenerController.class,
									"initExecutionListenerSelectionModel: selectionChangeHandler: no element is selected");
							view.getBtnEditExecutionListener()
									.setEnabled(false);
							view.getBtnRemoveExecutionListener().setEnabled(
									false);
						}
					}
				});
		view.getCtExecutionListeners().setSelectionModel(selectionModel);
	}

	private void initExecutionListenerDataProvider() {
		Log.info(TabListenerController.class,
				"initExecutionListenerDataProvider");
		executionListenersProvider = new ListDataProvider<ExecutionListenerModel>();
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
			executionListenersProvider.getList().add(
					new ExecutionListenerModel(executionListeners.get(i)));
		}
	}

	public BpmnDiagramElementJso getBpmnDiagramElementJso() {
		return bpmnDiagramElementJso;
	}

	public ListDataProvider<ExecutionListenerModel> getExecutionListenersProvider() {
		return executionListenersProvider;
	}

}
