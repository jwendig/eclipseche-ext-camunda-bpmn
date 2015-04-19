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

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesTabController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementExtensionJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.extensions.ExecutionListenerJso;

public class TableExecutionListenerWidget extends Composite {

	private AbstractBpmnPropertiesTabController controller;
	private ListDataProvider<ExecutionListenerJso> executionListenersProvider;

	private VerticalPanel root;
	private CellTable<ExecutionListenerJso> ctExecutionListeners;
	private TextColumn<ExecutionListenerJso> tcExecutionListenersClass;
	private TextColumn<ExecutionListenerJso> tcExecutionListenersEvent;
	private TextColumn<ExecutionListenerJso> tcExecutionListenersExpression;
	private TextColumn<ExecutionListenerJso> tcExecutionListenersDelegateExpression;
	private Column<ExecutionListenerJso, String> tcExecutionListenerBtnRemove;
	private Column<ExecutionListenerJso, String> tcExecutionListenerBtnEdit;
	private Button btnAddExecutionListener;

	public TableExecutionListenerWidget() {
		super();
		btnAddExecutionListener = new Button("Add");

		tcExecutionListenersClass = new TextColumn<ExecutionListenerJso>() {

			@Override
			public String getValue(ExecutionListenerJso object) {
				return object.getAttr_class();
			}
		};

		tcExecutionListenersEvent = new TextColumn<ExecutionListenerJso>() {

			@Override
			public String getValue(ExecutionListenerJso object) {
				return object.getAttr_event();
			}
		};

		tcExecutionListenersExpression = new TextColumn<ExecutionListenerJso>() {

			@Override
			public String getValue(ExecutionListenerJso object) {
				return object.getAttr_expression();
			}
		};

		tcExecutionListenersDelegateExpression = new TextColumn<ExecutionListenerJso>() {

			@Override
			public String getValue(ExecutionListenerJso object) {
				return object.getAttr_delegateExpression();
			}
		};

		tcExecutionListenerBtnRemove = new Column<ExecutionListenerJso, String>(
				new ButtonCell()) {
			@Override
			public String getValue(ExecutionListenerJso object) {
				return "x";
			}
		};

		tcExecutionListenerBtnEdit = new Column<ExecutionListenerJso, String>(
				new ButtonCell()) {
			@Override
			public String getValue(ExecutionListenerJso object) {
				return "Edit";
			}
		};

		ctExecutionListeners = new CellTable<ExecutionListenerJso>();
		ctExecutionListeners.addStyleName("bpmnPropertiesWidget-cellTable");
		ctExecutionListeners.setWidth("100%");
		ctExecutionListeners.addColumn(tcExecutionListenersClass, "Class");
		ctExecutionListeners.addColumn(tcExecutionListenersExpression,
				"Expression");
		ctExecutionListeners.addColumn(tcExecutionListenersDelegateExpression,
				"DelegateExpression");
		ctExecutionListeners.addColumn(tcExecutionListenersEvent, "Event");
		ctExecutionListeners.addColumn(tcExecutionListenerBtnEdit, "");
		ctExecutionListeners.addColumn(tcExecutionListenerBtnRemove, "");

		root = new VerticalPanel();
		root.setSize("100%", "auto");
		root.add(ctExecutionListeners);

		HorizontalPanel hpExecutionListenerButtons = new HorizontalPanel();
		hpExecutionListenerButtons
				.setHorizontalAlignment(HorizontalAlignmentConstant
						.startOf(Direction.RTL));
		hpExecutionListenerButtons.add(btnAddExecutionListener);
		root.add(hpExecutionListenerButtons);

		initExecutionListenerDataProvider();
		initWidget(root);

		btnAddExecutionListener.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				new TableExecutionListenerEditTableEntryDialog(TableExecutionListenerWidget.this)
						.show();

			}
		});

		tcExecutionListenerBtnEdit
				.setFieldUpdater(new FieldUpdater<ExecutionListenerJso, String>() {

					@Override
					public void update(int index, ExecutionListenerJso object,
							String value) {
						new TableExecutionListenerEditTableEntryDialog(
								TableExecutionListenerWidget.this, object)
								.show();

					}
				});

		tcExecutionListenerBtnRemove
				.setFieldUpdater(new FieldUpdater<ExecutionListenerJso, String>() {

					@Override
					public void update(int index, ExecutionListenerJso object,
							String value) {
						if (controller
								.getBpmnDiagramElementJso()
								.removeExt_elemenemt(
										(BpmnDiagramElementExtensionJso) object)) {
							executionListenersProvider.getList().remove(object);
							executionListenersProvider.refresh();
							ctExecutionListeners.redraw();
							controller.getActionDelegate().onContentChange();
						} else {

						}
					}
				});
	}

	private void initExecutionListenerDataProvider() {
		Log.info(TabListenerController.class,
				"initExecutionListenerDataProvider");
		executionListenersProvider = new ListDataProvider<ExecutionListenerJso>();
		executionListenersProvider.addDataDisplay(ctExecutionListeners);
	}

	public AbstractBpmnPropertiesTabController getController() {
		return controller;
	}

	public void setController(AbstractBpmnPropertiesTabController controller) {
		this.controller = controller;
	}

	public ListDataProvider<ExecutionListenerJso> getExecutionListenersProvider() {
		return executionListenersProvider;
	}

	public void update() {
		executionListenersProvider.getList().clear();
		JsArray<BpmnDiagramElementExtensionJso> executionListeners = controller
				.getBpmnDiagramElementJso().getExt_executionListeners();
		for (int i = 0; i < executionListeners.length(); i++) {
			executionListenersProvider.getList().add(executionListeners.get(i));
		}
	}
}
