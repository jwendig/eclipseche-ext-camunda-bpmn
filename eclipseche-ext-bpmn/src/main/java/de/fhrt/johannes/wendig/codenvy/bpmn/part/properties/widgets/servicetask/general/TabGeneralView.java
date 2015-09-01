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

package de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.servicetask.general;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextBox;

import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.BpmnElementPropertiesView.ActionDelegate;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.AbstractBpmnPropertiesTabWidget;

public class TabGeneralView extends AbstractBpmnPropertiesTabWidget {
	private TextBox tbId;
	private TextBox tbName;
	private RadioButton rbClass;
	private TextBox tbClass;
	private RadioButton rbExpression;
	private TextBox tbExpression;
	private RadioButton rbExpressionDelegate;
	private TextBox tbExpressionDelegate;
	private TextBox tbResultVariable;
	private CheckBox cbAsycBefore;
	private CheckBox cbAsycAfter;
	private CheckBox cbExclusive;
	private TextBox tbRetryTimeCycle;
	private CheckBox cbForCompensation;
	private TextBox tbDocumentation;

	public TabGeneralView(String tabName,
			BpmnElementPropertiesView.CurrentJsoAccess jsoAccess) {
		super(tabName, jsoAccess);
		Log.info(TabGeneralView.class, "constructor");
	}

	@Override
	public void initContent() {
		Log.info(TabGeneralView.class, "initContent");
		getGridTabContent().resize(12, 2);

		getGridTabContent().setText(0, 0, "Id:");
		getGridTabContent().setText(1, 0, "Name:");
		getGridTabContent().setText(2, 0, "Class:");
		getGridTabContent().setText(3, 0, "Expression:");
		getGridTabContent().setText(4, 0, "Expression Delegate:");
		getGridTabContent().setText(5, 0, "Result Variable:");
		getGridTabContent().setText(6, 0, "Asynchronous Before:");
		getGridTabContent().setText(7, 0, "Asynchronous After:");
		getGridTabContent().setText(8, 0, "Exclusive:");
		getGridTabContent().setText(9, 0, "Retry Time Cycle:");
		getGridTabContent().setText(10, 0, "For Compensation:");
		getGridTabContent().setText(11, 0, "Documentation:");

		getGridTabContent().setWidget(0, 1, tbId);
		getGridTabContent().setWidget(1, 1, tbName);

		HorizontalPanel hPanelClass = new HorizontalPanel();
		hPanelClass.setWidth("100%");
		hPanelClass.add(rbClass);
		hPanelClass.add(tbClass);
		getGridTabContent().setWidget(2, 1, hPanelClass);

		HorizontalPanel hPanelExpression = new HorizontalPanel();
		hPanelExpression.setWidth("100%");
		hPanelExpression.add(rbExpression);
		hPanelExpression.add(tbExpression);
		getGridTabContent().setWidget(3, 1, hPanelExpression);

		HorizontalPanel hPanelExpressionDelegate = new HorizontalPanel();
		hPanelExpressionDelegate.setWidth("100%");
		hPanelExpressionDelegate.add(rbExpressionDelegate);
		hPanelExpressionDelegate.add(tbExpressionDelegate);
		getGridTabContent().setWidget(4, 1, hPanelExpressionDelegate);
		getGridTabContent().setWidget(5, 1, tbResultVariable);
		getGridTabContent().setWidget(6, 1, cbAsycBefore);
		getGridTabContent().setWidget(7, 1, cbAsycAfter);
		getGridTabContent().setWidget(8, 1, cbExclusive);
		getGridTabContent().setWidget(9, 1, tbRetryTimeCycle);
		getGridTabContent().setWidget(10, 1, cbForCompensation);
		getGridTabContent().setWidget(11, 1, tbDocumentation);
	}

	@Override
	public void initContentElements() {
		Log.info(TabGeneralView.class, "initContentElements");
		tbId = new TextBox();
		tbId.setWidth("100%");

		tbName = new TextBox();
		tbName.setWidth("100%");

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
