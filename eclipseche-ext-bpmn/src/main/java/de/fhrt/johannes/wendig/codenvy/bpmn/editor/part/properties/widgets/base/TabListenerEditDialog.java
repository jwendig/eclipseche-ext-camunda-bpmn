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

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.base.TabListenerController.ExecutionListenerModel;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.extensions.ExecutionListenerJso;

public class TabListenerEditDialog extends DialogBox {

	private Button btnOk;
	private Button btnBack;
	private VerticalPanel vpRoot;
	private Grid gridContent;

	private TextBox tbEvent;
	private TextBox tbClass;

	private TabListenerController tabListenerControler;
	private ExecutionListenerModel executionListenerModel;

	public TabListenerEditDialog(
			final TabListenerController tabListenerControler) {
		super();
		this.tabListenerControler = tabListenerControler;

		setTitle("Execution Listener Details");
		setAnimationEnabled(true);
		setGlassEnabled(true);

		vpRoot = new VerticalPanel();

		tbEvent = new TextBox();
		tbClass = new TextBox();

		gridContent = new Grid(2, 3);
		gridContent.setText(0, 0, "Event");
		gridContent.setText(1, 0, "Class");

		gridContent.setWidget(0, 1, tbEvent);
		gridContent.setWidget(1, 1, tbClass);

		btnOk = new Button("Save");
		btnOk.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				ExecutionListenerJso executionListenerJso;
				if (null != TabListenerEditDialog.this
						.getExecutionListenerModel()) {
					executionListenerJso = TabListenerEditDialog.this
							.getExecutionListenerModel()
							.getExecutioinListenerJso();
				} else {
					executionListenerJso = tabListenerControler
							.getBpmnDiagramElementJso()
							.addExt_executionListener();
					tabListenerControler
							.getExecutionListenersProvider()
							.getList()
							.add(new ExecutionListenerModel(
									executionListenerJso));
				}

				executionListenerJso.setAttr_class(TabListenerEditDialog.this
						.getTbClass().getText());
				executionListenerJso.setAttr_event(TabListenerEditDialog.this
						.getTbEvent().getText());

				TabListenerEditDialog.this.hide();
			}
		});

		btnBack = new Button("Back");
		btnBack.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				TabListenerEditDialog.this.hide();
			}
		});

		HorizontalPanel hpOptions = new HorizontalPanel();
		hpOptions.add(btnOk);
		hpOptions.add(btnBack);

		vpRoot.add(hpOptions);

		setWidget(vpRoot);
	}

	public TabListenerEditDialog(
			final TabListenerController tabListenerControler,
			ExecutionListenerModel executionListenerModel) {
		this(tabListenerControler);
		this.executionListenerModel = executionListenerModel;

		tbEvent.setText(executionListenerModel.getEvent());
		tbClass.setText(executionListenerModel.getClazz());
	}

	public TextBox getTbEvent() {
		return tbEvent;
	}

	public TextBox getTbClass() {
		return tbClass;
	}

	public ExecutionListenerModel getExecutionListenerModel() {
		return executionListenerModel;
	}

}
