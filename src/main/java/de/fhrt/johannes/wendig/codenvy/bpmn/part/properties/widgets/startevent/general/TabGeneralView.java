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

package de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.startevent.general;

import org.eclipse.che.ide.util.loging.Log;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextBox;

import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.BpmnElementPropertiesView;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.BpmnElementPropertiesView.ActionDelegate;
import de.fhrt.johannes.wendig.codenvy.bpmn.part.properties.widgets.AbstractBpmnPropertiesTabWidget;

public class TabGeneralView extends AbstractBpmnPropertiesTabWidget {
	private TextBox tbId;
	private TextBox tbName;
	private TextBox tbFormKey;
	private CheckBox cbAsycBefore;
	private CheckBox cbAsycAfter;
	private TextBox tbRetryTimeCycle;
	private TextBox tbDocumentation;

	public TabGeneralView(String tabName,
			BpmnElementPropertiesView.ActionDelegate delegate) {
		super(tabName, delegate);
		Log.info(TabGeneralView.class, "constructor");
	}

	@Override
	public void initContent() {
		Log.info(TabGeneralView.class, "initContent");
		getGridTabContent().resize(7, 2);

		getGridTabContent().setText(0, 0, "Id:");
		getGridTabContent().setText(1, 0, "Name:");
		getGridTabContent().setText(2, 0, "Form Key:");
		getGridTabContent().setText(3, 0, "Asynchronous Before:");
		getGridTabContent().setText(4, 0, "Asynchronous After:");
		getGridTabContent().setText(5, 0, "Retry Time Cycle:");
		getGridTabContent().setText(6, 0, "Documentation:");

		getGridTabContent().setWidget(0, 1, tbId);
		getGridTabContent().setWidget(1, 1, tbName);
		getGridTabContent().setWidget(2, 1, tbFormKey);
		getGridTabContent().setWidget(3, 1, cbAsycBefore);
		getGridTabContent().setWidget(4, 1, cbAsycAfter);
		getGridTabContent().setWidget(5, 1, tbRetryTimeCycle);
		getGridTabContent().setWidget(6, 1, tbDocumentation);
	}

	@Override
	public void initContentElements() {
		Log.info(TabGeneralView.class, "initContentElements");
		tbId = new TextBox();
		tbId.setWidth("100%");
		tbName = new TextBox();
		tbName.setWidth("100%");
		tbFormKey = new TextBox();
		tbFormKey.setWidth("100%");
		cbAsycBefore = new CheckBox();
		cbAsycBefore.setWidth("100%");
		cbAsycAfter = new CheckBox();
		cbAsycAfter.setWidth("100%");
		tbRetryTimeCycle = new TextBox();
		tbRetryTimeCycle.setWidth("100%");
		tbDocumentation = new TextBox();
		tbDocumentation.setWidth("100%");
	}

	public TextBox getTbId() {
		return tbId;
	}

	public TextBox getTbName() {
		return tbName;
	}

	public TextBox getTbFormKey() {
		return tbFormKey;
	}

	public CheckBox getCbAsycBefore() {
		return cbAsycBefore;
	}

	public CheckBox getCbAsycAfter() {
		return cbAsycAfter;
	}

	public TextBox getTbRetryTimeCycle() {
		return tbRetryTimeCycle;
	}

	public TextBox getTbDocumentation() {
		return tbDocumentation;
	}


}
