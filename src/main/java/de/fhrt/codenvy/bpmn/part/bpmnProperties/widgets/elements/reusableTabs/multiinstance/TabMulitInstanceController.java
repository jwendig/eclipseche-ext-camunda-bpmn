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

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.childElements.MultiInstanceLoopCharacteristicsChildElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.childElements.StandardLoopCharacteristicsChildElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.uiElements.TaskElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesTabController;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.startevent.general.TabGeneralController;

public class TabMulitInstanceController<T extends TaskElement> extends
		AbstractBpmnPropertiesTabController<T> {
	private final static String TAB_NAME = "Multi Instance";
	private TabMultiInstanceView view;

	public TabMulitInstanceController(
			BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(jsoAccess);
		view = new TabMultiInstanceView(TAB_NAME, jsoAccess);

		view.getCbIsLoop().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						if (event.getValue()) {
							view.getCbMultiInstance().setValue(false);
							hideMultiInstanceLoopCharacteristicsFields();
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
						if (event.getValue()) {
							view.getCbIsLoop().setValue(false);
							showMultiInstanceLoopCharacteristicsFields();
						}else{
							hideMultiInstanceLoopCharacteristicsFields();
						}

						getCurrentBpmnElement()
								.setMultiInstanceLoopCharacteristics(
										event.getValue());

						contentChanged();
					}
				});

	}

	public TabMultiInstanceView getView() {
		return view;
	}

	@Override
	public void updateView() {
		StandardLoopCharacteristicsChildElement standardLoopCharacteristics = getCurrentBpmnElement()
				.getStandardLoopCharacteristicsChildElement();
		if (null == standardLoopCharacteristics) {
			view.getCbIsLoop().setValue(false);
		} else {
			view.getCbIsLoop().setValue(true);
		}

		MultiInstanceLoopCharacteristicsChildElement multiInstanceLoopCharacteristics = getCurrentBpmnElement()
				.getMultiInstanceLoopCharacteristicsChildElement();
		if (null == multiInstanceLoopCharacteristics) {
			view.getCbMultiInstance().setValue(false);

			hideMultiInstanceLoopCharacteristicsFields();

		} else {
			view.getCbMultiInstance().setValue(true);

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
