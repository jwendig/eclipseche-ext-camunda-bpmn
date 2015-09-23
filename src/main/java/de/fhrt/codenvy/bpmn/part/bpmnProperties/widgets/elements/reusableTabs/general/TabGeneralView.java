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

package de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.elements.reusableTabs.general;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextBox;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesTabWidget;

//from usertask
//TODO: include servicetask elements

public class TabGeneralView extends AbstractBpmnPropertiesTabWidget {
	private TextBox tbId;
	private TextBox tbName;
	private TextBox tbAssignee;
	private TextBox tbCandidateUsers;
	private TextBox tbCandidateGroups;
	private TextBox tbFormKey;
	private TextBox tbDueDate;
	private TextBox tbFollowUpDate;
	private TextBox tbPriority;
	private CheckBox cbAsycBefore;
	private CheckBox cbAsycAfter;
	private CheckBox cbExclusive;
	private TextBox tbRetryTimeCycle;
	private CheckBox cbForCompensation;
	private TextBox tbDocumentation;

	public TabGeneralView(String tabName,
			BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(tabName, jsoAccess);
		Log.info(TabGeneralView.class, "constructor");
	}

	@Override
	public void initContent() {
		Log.info(TabGeneralView.class, "initContent");
		getGridTabContent().resize(15, 2);

		getGridTabContent().setText(0, 0, "Id:");
		getGridTabContent().setText(1, 0, "Name:");
		getGridTabContent().setText(2, 0, "Assignee:");
		getGridTabContent().setText(3, 0, "Candidate Users:");
		getGridTabContent().setText(4, 0, "Candidate Groups:");
		getGridTabContent().setText(5, 0, "Form Key:");
		getGridTabContent().setText(6, 0, "Due Date:");
		getGridTabContent().setText(7, 0, "Follow Up Date:");
		getGridTabContent().setText(8, 0, "Priority:");
		getGridTabContent().setText(9, 0, "Asynchronous Before:");
		getGridTabContent().setText(10, 0, "Asynchronous After:");
		getGridTabContent().setText(11, 0, "Exclusive:");
		getGridTabContent().setText(12, 0, "Retry Time Cycle:");
		getGridTabContent().setText(13, 0, "For Compensation:");
		getGridTabContent().setText(14, 0, "Documentation:");

		getGridTabContent().setWidget(0, 1, tbId);
		getGridTabContent().setWidget(1, 1, tbName);
		getGridTabContent().setWidget(2, 1, tbAssignee);
		getGridTabContent().setWidget(3, 1, tbCandidateUsers);
		getGridTabContent().setWidget(4, 1, tbCandidateGroups);
		getGridTabContent().setWidget(5, 1, tbFormKey);
		getGridTabContent().setWidget(6, 1, tbDueDate);
		getGridTabContent().setWidget(7, 1, tbFollowUpDate);
		getGridTabContent().setWidget(8, 1, tbPriority);
		getGridTabContent().setWidget(9, 1, cbAsycBefore);
		getGridTabContent().setWidget(10, 1, cbAsycAfter);
		getGridTabContent().setWidget(11, 1, cbExclusive);
		getGridTabContent().setWidget(12, 1, tbRetryTimeCycle);
		getGridTabContent().setWidget(13, 1, cbForCompensation);
		getGridTabContent().setWidget(14, 1, tbDocumentation);
	}

	@Override
	public void initContentElements() {
		Log.info(TabGeneralView.class, "initContentElements");
		tbId = new TextBox();
		tbId.setWidth("100%");

		tbName = new TextBox();
		tbName.setWidth("100%");

		tbAssignee = new TextBox();
		tbAssignee.setWidth("100%");

		tbCandidateUsers = new TextBox();
		tbCandidateUsers.setWidth("100%");

		tbCandidateGroups = new TextBox();
		tbCandidateGroups.setWidth("100%");

		tbFormKey = new TextBox();
		tbFormKey.setWidth("100%");

		tbDueDate = new TextBox();
		tbDueDate.setWidth("100%");

		tbFollowUpDate = new TextBox();
		tbFollowUpDate.setWidth("100%");

		tbPriority = new TextBox();
		tbPriority.setWidth("100%");

		cbAsycBefore = new CheckBox();
		cbAsycBefore.setWidth("100%");

		cbAsycAfter = new CheckBox();
		cbAsycAfter.setWidth("100%");

		cbExclusive = new CheckBox();
		cbExclusive.setWidth("100%");

		tbRetryTimeCycle = new TextBox();
		tbRetryTimeCycle.setWidth("100%");

		cbForCompensation = new CheckBox();
		cbForCompensation.setWidth("100%");

		tbDocumentation = new TextBox();
		tbDocumentation.setWidth("100%");
	}

	public TextBox getTbId() {
		return tbId;
	}

	public TextBox getTbName() {
		return tbName;
	}

	public TextBox getTbAssignee() {
		return tbAssignee;
	}

	public TextBox getTbCandidateUsers() {
		return tbCandidateUsers;
	}

	public TextBox getTbCandidateGroups() {
		return tbCandidateGroups;
	}

	public TextBox getTbFormKey() {
		return tbFormKey;
	}

	public TextBox getTbDueDate() {
		return tbDueDate;
	}

	public TextBox getTbFollowUpDate() {
		return tbFollowUpDate;
	}

	public TextBox getTbPriority() {
		return tbPriority;
	}

	public CheckBox getCbAsycBefore() {
		return cbAsycBefore;
	}

	public CheckBox getCbAsycAfter() {
		return cbAsycAfter;
	}

	public CheckBox getCbExclusive() {
		return cbExclusive;
	}

	public TextBox getTbRetryTimeCycle() {
		return tbRetryTimeCycle;
	}

	public CheckBox getCbForCompensation() {
		return cbForCompensation;
	}

	public TextBox getTbDocumentation() {
		return tbDocumentation;
	}

}
