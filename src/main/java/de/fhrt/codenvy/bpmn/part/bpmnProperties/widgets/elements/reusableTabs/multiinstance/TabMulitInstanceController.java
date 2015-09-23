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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.multiinstance;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.childElements.FormalExpressionChildElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.childElements.MultiInstanceLoopCharacteristicsChildElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.uiElements.TaskElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesTabController;

public class TabMulitInstanceController<T extends TaskElement> extends
		AbstractBpmnPropertiesTabController<T> {
	private final static String TAB_NAME = "Multi Instance";
	private TabMultiInstanceView view;

	private MultiInstanceLoopCharacteristicsChildElement multiInstanceLoopCharacteristics;
	private FormalExpressionChildElement mutliInstanceCompletionCondition;
	private FormalExpressionChildElement mutliInstanceLoopCardinality;

	public TabMulitInstanceController(
			BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(jsoAccess);
		view = new TabMultiInstanceView(TAB_NAME, jsoAccess);

		view.getCbIsLoop().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						if (event.getValue()) {
							view.getCbMultiInstance().setValue(false, true);
						}

						getCurrentBpmnElement().setStandardLoopCharacteristics(
								event.getValue());

						contentChanged();
					}
				});

		view.getCbMultiInstance().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						getCurrentBpmnElement()
								.setMultiInstanceLoopCharacteristics(
										event.getValue());

						if (event.getValue()) {
							view.getCbIsLoop().setValue(false);
							multiInstanceLoopCharacteristics = getCurrentBpmnElement()
									.getMultiInstanceLoopCharacteristicsChildElement();
							showMultiInstanceLoopCharacteristicsFields();
						} else {
							hideMultiInstanceLoopCharacteristicsFields();
							view.getCbMultiInstanceIsSequential().setValue(
									false);
							view.getTbMultiInstanceCollection().setValue("");
							view.getTbMultiInstanceElementVariable().setValue(
									"");
							view.getTbMultiInstanceCompletionCondition()
									.setValue("");
							view.getTbMultiInstanceLoopCardinality().setValue(
									"");
						}

						contentChanged();
					}
				});

		view.getTbMultiInstanceLoopCardinality().addKeyUpHandler(
				new KeyUpHandler() {

					@Override
					public void onKeyUp(KeyUpEvent event) {
						if (view.getTbMultiInstanceLoopCardinality().getText()
								.length() == 0) {
							multiInstanceLoopCharacteristics
									.removeChildElementLoopCardinality();
							mutliInstanceLoopCardinality = null;
						} else {
							if (mutliInstanceLoopCardinality == null) {
								mutliInstanceLoopCardinality = multiInstanceLoopCharacteristics
										.createChildElementLoopCardinality();
							}
							mutliInstanceLoopCardinality.setAttr_body(view
									.getTbMultiInstanceLoopCardinality()
									.getText());
						}

						contentChanged();
					}
				});

		view.getCbMultiInstanceIsSequential().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						multiInstanceLoopCharacteristics
								.setAttr_isSequential(event.getValue());
						contentChanged();
					}
				});

		view.getTbMultiInstanceCollection().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				multiInstanceLoopCharacteristics.setAttr_collection(view
						.getTbMultiInstanceCollection().getText());
				contentChanged();
			}
		});

		view.getTbMultiInstanceCompletionCondition().addKeyUpHandler(
				new KeyUpHandler() {

					@Override
					public void onKeyUp(KeyUpEvent event) {
						if (view.getTbMultiInstanceCompletionCondition()
								.getText().length() == 0) {
							multiInstanceLoopCharacteristics
									.removeChildElementCompletionCondition();
							mutliInstanceCompletionCondition = null;
						} else {
							if (mutliInstanceCompletionCondition == null) {
								mutliInstanceCompletionCondition = multiInstanceLoopCharacteristics
										.createChildElementCompletionCondition();
							}
							mutliInstanceCompletionCondition.setAttr_body(view
									.getTbMultiInstanceCompletionCondition()
									.getText());
						}

						contentChanged();
					}
				});

		view.getTbMultiInstanceElementVariable().addKeyUpHandler(
				new KeyUpHandler() {

					@Override
					public void onKeyUp(KeyUpEvent event) {
						multiInstanceLoopCharacteristics
								.setAttr_elementVariable(view
										.getTbMultiInstanceElementVariable()
										.getText());
						contentChanged();
					}
				});

	}

	public TabMultiInstanceView getView() {
		return view;
	}

	@Override
	public void updateView() {
		if (null == getCurrentBpmnElement()
				.getStandardLoopCharacteristicsChildElement()) {
			view.getCbIsLoop().setValue(false);
		} else {
			view.getCbIsLoop().setValue(true);
		}

		multiInstanceLoopCharacteristics = getCurrentBpmnElement()
				.getMultiInstanceLoopCharacteristicsChildElement();
		if (null == multiInstanceLoopCharacteristics) {
			view.getCbMultiInstance().setValue(false);

			hideMultiInstanceLoopCharacteristicsFields();

		} else {
			view.getCbMultiInstance().setValue(true);

			view.getCbMultiInstanceIsSequential().setValue(
					multiInstanceLoopCharacteristics.getAttr_isSequential());
			view.getTbMultiInstanceCollection().setValue(
					multiInstanceLoopCharacteristics.getAttr_collection());
			view.getTbMultiInstanceElementVariable().setValue(
					multiInstanceLoopCharacteristics.getAttr_elementVariable());

			mutliInstanceCompletionCondition = multiInstanceLoopCharacteristics
					.getChildElementCompletionCondition();
			if (null == mutliInstanceCompletionCondition) {
				view.getTbMultiInstanceCompletionCondition().setValue("");
			} else {
				view.getTbMultiInstanceCompletionCondition().setValue(
						mutliInstanceCompletionCondition.getAttr_body());
			}

			mutliInstanceLoopCardinality = multiInstanceLoopCharacteristics
					.getChildElementLoopCardinality();
			if (null == mutliInstanceLoopCardinality) {
				view.getTbMultiInstanceLoopCardinality().setValue("");
			} else {
				view.getTbMultiInstanceLoopCardinality().setValue(
						mutliInstanceLoopCardinality.getAttr_body());
			}

			showMultiInstanceLoopCharacteristicsFields();
		}
	}

	private void showMultiInstanceLoopCharacteristicsFields() {
		view.getGridTabContent().getRowFormatter().setVisible(2, true);
		view.getGridTabContent().getRowFormatter().setVisible(3, true);
		view.getGridTabContent().getRowFormatter().setVisible(4, true);
		view.getGridTabContent().getRowFormatter().setVisible(5, true);
		view.getGridTabContent().getRowFormatter().setVisible(6, true);
	}

	private void hideMultiInstanceLoopCharacteristicsFields() {
		view.getGridTabContent().getRowFormatter().setVisible(2, false);
		view.getGridTabContent().getRowFormatter().setVisible(3, false);
		view.getGridTabContent().getRowFormatter().setVisible(4, false);
		view.getGridTabContent().getRowFormatter().setVisible(5, false);
		view.getGridTabContent().getRowFormatter().setVisible(6, false);
	}
}
