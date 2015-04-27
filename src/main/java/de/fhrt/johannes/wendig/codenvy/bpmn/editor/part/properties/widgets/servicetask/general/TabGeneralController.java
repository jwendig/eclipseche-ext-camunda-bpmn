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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.servicetask.general;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnPropertiesTabController;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.ServiceTaskJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.UserTaskJso;

public class TabGeneralController extends
		AbstractBpmnPropertiesTabController<ServiceTaskJso> {
	private final static String TAB_NAME = "General";
	private TabGeneralView view;

	public TabGeneralController(
			BpmnElementPropertiesView.ActionDelegate delegate) {
		super(delegate);
		view = new TabGeneralView(TAB_NAME, delegate);
		view.getTbId().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getCurrentBpmnElement().setAttr_id(view.getTbId().getText());
				contentChanged();
			}
		});

		view.getTbName().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getCurrentBpmnElement()
						.setAttr_name(view.getTbName().getText());
				contentChanged();
			}
		});

		view.getTbClass().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getCurrentBpmnElement().setAttr_class(
						view.getTbClass().getText());
				contentChanged();
			}
		});

		view.getTbExpression().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getCurrentBpmnElement().setAttr_expression(
						view.getTbExpression().getText());
				contentChanged();
			}
		});

		view.getTbExpressionDelegate().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getCurrentBpmnElement().setAttr_delegateExpression(
						view.getTbExpressionDelegate().getText());
				contentChanged();
			}
		});

		ClickHandler rbHandler = new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				if (view.getRbClass().getValue() == true) {
					view.getTbClass().setEnabled(true);
					view.getTbExpression().setEnabled(false);
					view.getTbExpression().setText("");
					view.getTbExpressionDelegate().setEnabled(false);
					view.getTbExpressionDelegate().setText("");
				} else if (view.getRbExpression().getValue() == true) {
					view.getTbClass().setEnabled(false);
					view.getTbClass().setText("");
					view.getTbExpression().setEnabled(true);
					view.getTbExpressionDelegate().setEnabled(false);
					view.getTbExpressionDelegate().setText("");
				} else if (view.getRbExpressionDelegate().getValue() == true) {
					view.getTbClass().setEnabled(false);
					view.getTbClass().setText("");
					view.getTbExpression().setEnabled(false);
					view.getTbExpression().setText("");
					view.getTbExpressionDelegate().setEnabled(true);
				}
				getCurrentBpmnElement().setAttr_class(
						view.getTbClass().getText());
				getCurrentBpmnElement().setAttr_expression(
						view.getTbExpression().getText());
				getCurrentBpmnElement().setAttr_delegateExpression(
						view.getTbExpressionDelegate().getText());
				contentChanged();

			}
		};

		view.getRbClass().addClickHandler(rbHandler);
		view.getRbExpression().addClickHandler(rbHandler);
		view.getRbExpressionDelegate().addClickHandler(rbHandler);

		view.getTbResultVariable().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getCurrentBpmnElement().setAttr_resultVariable(
						view.getTbResultVariable().getText());
				contentChanged();
			}
		});

		view.getCbAsycAfter().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						getCurrentBpmnElement().setAttr_asyncAfter(
								event.getValue());
						contentChanged();

					}
				});

		view.getCbAsycBefore().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						getCurrentBpmnElement().setAttr_asyncBefore(
								event.getValue());
						contentChanged();
					}
				});

		view.getCbExclusive().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						getCurrentBpmnElement().setAttr_exclusive(
								event.getValue());
						contentChanged();
					}
				});

		view.getTbRetryTimeCycle().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO: implement
				// getActionDelegate().onContentChange();
			}
		});

		view.getCbForCompensation().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						getCurrentBpmnElement().setAttr_isForCompensation(
								event.getValue());
						contentChanged();
					}
				});

		view.getTbDocumentation().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				// TODO: implement
				// getActionDelegate().onContentChange();
			}
		});
	}

	public TabGeneralView getView() {
		return view;
	}

	@Override
	public void updateView() {
		view.getTbId().setText(getCurrentBpmnElement().getAttr_id());
		view.getTbName().setText(getCurrentBpmnElement().getAttr_name());

		view.getTbClass().setText(getCurrentBpmnElement().getAttr_class());
		view.getTbExpression().setText(
				getCurrentBpmnElement().getAttr_expression());
		view.getTbExpressionDelegate().setText(
				getCurrentBpmnElement().getAttr_delegateExpression());

		if (getCurrentBpmnElement().getAttr_class().length() > 0) {
			view.getRbClass().setValue(true);
			view.getTbClass().setEnabled(true);
			view.getTbExpression().setEnabled(false);
			view.getTbExpressionDelegate().setEnabled(false);
		} else if (getCurrentBpmnElement().getAttr_expression().length() > 0) {
			view.getRbExpression().setValue(true);
			view.getTbClass().setEnabled(false);
			view.getTbExpression().setEnabled(true);
			view.getTbExpressionDelegate().setEnabled(false);
		} else if (getCurrentBpmnElement().getAttr_delegateExpression()
				.length() > 0) {
			view.getRbExpressionDelegate().setValue(true);
			view.getTbClass().setEnabled(false);
			view.getTbExpression().setEnabled(false);
			view.getTbExpressionDelegate().setEnabled(true);
		} else {
			view.getRbClass().setValue(true);
			view.getTbClass().setEnabled(true);
			view.getTbExpression().setEnabled(false);
			view.getTbExpressionDelegate().setEnabled(false);
		}

		view.getTbResultVariable().setText(
				getCurrentBpmnElement().getAttr_resultVariable());
		view.getCbAsycAfter().setValue(
				getCurrentBpmnElement().getAttr_asyncAfter());
		view.getCbAsycBefore().setValue(
				getCurrentBpmnElement().getAttr_asyncBefore());
		view.getCbExclusive().setValue(
				getCurrentBpmnElement().getAttr_exclusive());
		view.getTbRetryTimeCycle().setText("not implemented");
		view.getCbForCompensation().setValue(
				getCurrentBpmnElement().getAttr_isForCompensation());
		view.getTbDocumentation().setText("not implemented");

		view.getTbName().setEnabled(false);
		view.getTbRetryTimeCycle().setEnabled(false);

		// TODO: implement
		view.getTbDocumentation().setEnabled(false);
	}
}
