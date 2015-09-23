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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.usertask.general;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.elements.interfaces.uiElements.UserTaskElement;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesTabController;

public class TabGeneralController extends
		AbstractBpmnPropertiesTabController<UserTaskElement> {
	private final static String TAB_NAME = "General";
	private TabGeneralView view;

	public TabGeneralController(BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(jsoAccess);
		view = new TabGeneralView(TAB_NAME, jsoAccess);
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

		view.getTbAssignee().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getCurrentBpmnElement().setAttr_assignee(
						view.getTbAssignee().getText());
				contentChanged();
			}
		});

		view.getTbCandidateUsers().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getCurrentBpmnElement().setAttr_candidateUsers(
						view.getTbCandidateUsers().getText());
				contentChanged();
			}
		});

		view.getTbCandidateGroups().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getCurrentBpmnElement().setAttr_candidateGroups(
						view.getTbCandidateGroups().getText());
				contentChanged();
			}
		});

		view.getTbFormKey().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getCurrentBpmnElement().setAttr_formKey(
						view.getTbFormKey().getText());
				contentChanged();
			}
		});

		view.getTbDueDate().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getCurrentBpmnElement().setAttr_dueDate(
						view.getTbDueDate().getText());
				contentChanged();
			}
		});

		view.getTbFollowUpDate().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getCurrentBpmnElement().setAttr_followUpDate(
						view.getTbFollowUpDate().getText());
				contentChanged();
			}
		});

		view.getTbPriority().addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				getCurrentBpmnElement().setAttr_priority(
						view.getTbPriority().getText());
				contentChanged();
			}
		});

		view.getCbAsycAfter().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						getCurrentBpmnElement().setAttr_asyncAfter(
								event.getValue());

						refreshDependentFields();

						contentChanged();

					}
				});

		view.getCbAsycBefore().addValueChangeHandler(
				new ValueChangeHandler<Boolean>() {

					@Override
					public void onValueChange(ValueChangeEvent<Boolean> event) {
						getCurrentBpmnElement().setAttr_asyncBefore(
								event.getValue());

						refreshDependentFields();

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
		view.getTbAssignee()
				.setText(getCurrentBpmnElement().getAttr_assignee());
		view.getTbCandidateUsers().setText(
				getCurrentBpmnElement().getAttr_candidateUsers());
		view.getTbCandidateGroups().setText(
				getCurrentBpmnElement().getAttr_candidateGroups());
		view.getTbFormKey().setText(getCurrentBpmnElement().getAttr_formKey());
		view.getTbDueDate().setText(getCurrentBpmnElement().getAttr_dueDate());
		view.getTbFollowUpDate().setText(
				getCurrentBpmnElement().getAttr_followUpDate());
		view.getTbPriority()
				.setText(getCurrentBpmnElement().getAttr_priority());
		view.getCbAsycAfter().setValue(
				getCurrentBpmnElement().getAttr_asyncAfter());
		view.getCbAsycBefore().setValue(
				getCurrentBpmnElement().getAttr_asyncBefore());
		view.getCbExclusive().setValue(
				getCurrentBpmnElement().getAttr_exclusive());
		view.getCbForCompensation().setValue(
				getCurrentBpmnElement().getAttr_isForCompensation());
		view.getTbDocumentation().setText("not implemented");

		refreshDependentFields();
		
		// TODO: implement
		view.getTbDocumentation().setEnabled(false);
	}

	private void refreshDependentFields() {
		if (view.getCbAsycAfter().getValue()
				|| view.getCbAsycBefore().getValue()) {
			view.getCbExclusive().setEnabled(true);
			view.getTbRetryTimeCycle().setEnabled(true);
		} else {
			view.getCbExclusive().setEnabled(false);
			view.getCbExclusive().setValue(true);
			view.getTbRetryTimeCycle().setEnabled(false);
			view.getTbRetryTimeCycle().setText("");
		}
	}
}
