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
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesTabWidget;

//from usertask
//TODO: include servicetask elements

public class TabGeneralView extends AbstractBpmnPropertiesTabWidget {
	public final static int ROW_ASSIGNEE = 2;
	public final static int ROW_CANDIDATE_USERS = 3;
	public final static int ROW_CANDIDATE_GROUPS = 4;
	public final static int ROW_FORM_KEY = 5;
	public final static int ROW_DUE_DATE = 6;
	public final static int ROW_FOLLOW_UP_DATE = 7;
	public final static int ROW_PRIORITY = 8;
	public final static int ROW_CLASS = 9;
	public final static int ROW_EXPRESSION = 10;
	public final static int ROW_EXPRESSION_DELEGATE = 11;
	public final static int ROW_RESULT_VARIABLE = 12;
	public final static int ROW_EXCLUSIVE = 15;
	public final static int ROW_FOR_COMPENSATION = 17;

	private TextBox tbId;
	private TextBox tbName;
	private CheckBox cbAsycBefore;
	private CheckBox cbAsycAfter;
	private CheckBox cbExclusive;
	private TextBox tbRetryTimeCycle;
	private CheckBox cbForCompensation;
	private TextBox tbDocumentation;

	/*
	 * elements for UserTask
	 */
	private TextBox tbAssignee;
	private TextBox tbCandidateUsers;
	private TextBox tbCandidateGroups;
	private TextBox tbFormKey;
	private TextBox tbDueDate;
	private TextBox tbFollowUpDate;
	private TextBox tbPriority;

	/*
	 * elements for ServiceTask
	 */
	private RadioButton rbClass;
	private TextBox tbClass;
	private RadioButton rbExpression;
	private TextBox tbExpression;
	private RadioButton rbExpressionDelegate;
	private TextBox tbExpressionDelegate;
	private TextBox tbResultVariable;

	public TabGeneralView(String tabName,
			BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(tabName, jsoAccess);
		Log.info(TabGeneralView.class, "constructor");
	}

	@Override
	public void initContent() {
		Log.info(TabGeneralView.class, "initContent");
		getGridTabContent().resize(19, 2);

		getGridTabContent().setText(0, 0, "Id:");
		getGridTabContent().setWidget(0, 1, tbId);

		getGridTabContent().setText(1, 0, "Name:");
		getGridTabContent().setWidget(1, 1, tbName);
		/*
		 * elements for userTask
		 */
		getGridTabContent().setText(2, 0, "Assignee:");
		getGridTabContent().setWidget(2, 1, tbAssignee);

		getGridTabContent().setText(3, 0, "Candidate Users:");
		getGridTabContent().setWidget(3, 1, tbCandidateUsers);

		getGridTabContent().setText(4, 0, "Candidate Groups:");
		getGridTabContent().setWidget(4, 1, tbCandidateGroups);

		getGridTabContent().setText(5, 0, "Form Key:");
		getGridTabContent().setWidget(5, 1, tbFormKey);

		getGridTabContent().setText(6, 0, "Due Date:");
		getGridTabContent().setWidget(6, 1, tbDueDate);

		getGridTabContent().setText(7, 0, "Follow Up Date:");
		getGridTabContent().setWidget(7, 1, tbFollowUpDate);

		getGridTabContent().setText(8, 0, "Priority:");
		getGridTabContent().setWidget(8, 1, tbPriority);

		/*
		 * elements for ServiceTask
		 */
		getGridTabContent().setText(9, 0, "Class:");
		HorizontalPanel hPanelClass = new HorizontalPanel();
		hPanelClass.setWidth("100%");
		hPanelClass.add(rbClass);
		hPanelClass.add(tbClass);
		getGridTabContent().setWidget(9, 1, hPanelClass);

		getGridTabContent().setText(10, 0, "Expression:");
		HorizontalPanel hPanelExpression = new HorizontalPanel();
		hPanelExpression.setWidth("100%");
		hPanelExpression.add(rbExpression);
		hPanelExpression.add(tbExpression);
		getGridTabContent().setWidget(10, 1, hPanelExpression);

		getGridTabContent().setText(11, 0, "Expression Delegate:");
		HorizontalPanel hPanelExpressionDelegate = new HorizontalPanel();
		hPanelExpressionDelegate.setWidth("100%");
		hPanelExpressionDelegate.add(rbExpressionDelegate);
		hPanelExpressionDelegate.add(tbExpressionDelegate);
		getGridTabContent().setWidget(11, 1, hPanelExpressionDelegate);

		getGridTabContent().setText(12, 0, "Result Variable:");
		getGridTabContent().setWidget(12, 1, tbResultVariable);

		/*
		 * default elements
		 */
		getGridTabContent().setText(13, 0, "Asynchronous Before:");
		getGridTabContent().setWidget(13, 1, cbAsycBefore);

		getGridTabContent().setText(14, 0, "Asynchronous After:");
		getGridTabContent().setWidget(14, 1, cbAsycAfter);

		getGridTabContent().setText(15, 0, "Exclusive:");
		getGridTabContent().setWidget(15, 1, cbExclusive);

		getGridTabContent().setText(16, 0, "Retry Time Cycle:");
		getGridTabContent().setWidget(16, 1, tbRetryTimeCycle);

		getGridTabContent().setText(17, 0, "For Compensation:");
		getGridTabContent().setWidget(17, 1, cbForCompensation);

		getGridTabContent().setText(18, 0, "Documentation:");
		getGridTabContent().setWidget(18, 1, tbDocumentation);

		for (int i = 2; i <= 12; i++) {
			getGridTabContent().getRowFormatter().setVisible(i, false);
		}

		getGridTabContent().getRowFormatter().setVisible(ROW_EXCLUSIVE, false);
		getGridTabContent().getRowFormatter().setVisible(ROW_FOR_COMPENSATION, false);

	}

	@Override
	public void initContentElements() {
		Log.info(TabGeneralView.class, "initContentElements");

		/*
		 * default elements
		 */
		tbId = new TextBox();
		tbId.setWidth("100%");

		tbName = new TextBox();
		tbName.setWidth("100%");

		/*
		 * elements for UserTask
		 */
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

		/*
		 * elements for ServiceTask
		 */
		rbClass = new RadioButton("type");
		rbClass.setWidth("30px");
		tbClass = new TextBox();
		tbClass.setWidth("100%");

		rbExpression = new RadioButton("type");
		rbExpression.setWidth("30px");
		tbExpression = new TextBox();
		tbExpression.setWidth("100%");

		rbExpressionDelegate = new RadioButton("type");
		rbExpressionDelegate.setWidth("30px");
		tbExpressionDelegate = new TextBox();
		tbExpressionDelegate.setWidth("100%");

		tbResultVariable = new TextBox();
		tbResultVariable.setWidth("100%");

		/*
		 * default elements
		 */
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

	public RadioButton getRbClass() {
		return rbClass;
	}

	public TextBox getTbClass() {
		return tbClass;
	}

	public RadioButton getRbExpression() {
		return rbExpression;
	}

	public TextBox getTbExpression() {
		return tbExpression;
	}

	public RadioButton getRbExpressionDelegate() {
		return rbExpressionDelegate;
	}

	public TextBox getTbExpressionDelegate() {
		return tbExpressionDelegate;
	}

	public TextBox getTbResultVariable() {
		return tbResultVariable;
	}

}
