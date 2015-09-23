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

import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.TextBox;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.BpmnPropertiesView;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.widgets.AbstractBpmnPropertiesTabWidget;

public class TabMultiInstanceView extends AbstractBpmnPropertiesTabWidget {
	private CheckBox cbIsLoop;
	private CheckBox cbMultiInstance;

	private TextBox tbMultiInstanceLoopCardinality;
	private CheckBox cbMultiInstanceIsSequential;
	private TextBox tbMultiInstanceCollection;
	private TextBox tbMultiInstanceElementVariable;
	private TextBox tbMultiInstanceCompletionCondition;

	public TabMultiInstanceView(String tabName,
			BpmnPropertiesView.CurrentJsoAccess jsoAccess) {
		super(tabName, jsoAccess);
		Log.info(TabMultiInstanceView.class, "constructor");
	}

	@Override
	public void initContent() {
		Log.info(TabMultiInstanceView.class, "initContent");
		getGridTabContent().resize(7, 2);

		getGridTabContent().setText(0, 0, "Is Loop:");
		getGridTabContent().setText(1, 0, "Is Multi Instance:");
		getGridTabContent().setText(2, 0, "Loop Cardinality:");
		getGridTabContent().setText(3, 0, "Is Sequential:");
		getGridTabContent().setText(4, 0, "Collection:");
		getGridTabContent().setText(5, 0, "Element Variable:");
		getGridTabContent().setText(6, 0, "Completion Condition:");

		getGridTabContent().setWidget(0, 1, cbIsLoop);
		getGridTabContent().setWidget(1, 1, cbMultiInstance);
		getGridTabContent().setWidget(2, 1, tbMultiInstanceLoopCardinality);
		getGridTabContent().setWidget(3, 1, cbMultiInstanceIsSequential);
		getGridTabContent().setWidget(4, 1, tbMultiInstanceCollection);
		getGridTabContent().setWidget(5, 1, tbMultiInstanceElementVariable);
		getGridTabContent().setWidget(6, 1, tbMultiInstanceCompletionCondition);

	}

	@Override
	public void initContentElements() {
		Log.info(TabMultiInstanceView.class, "initContentElements");
		cbIsLoop = new CheckBox();
		cbIsLoop.setWidth("100%");
		cbIsLoop.setHTML("Please note, the loop activity is not supported by the Camunda BPM engine. See for more information the <a href='http://docs.camunda.org/manual/7.3/api-references/bpmn20/#tasks-task-markers-loops' target='_blank' >Camunda user guide</a>.");

		cbMultiInstance = new CheckBox();
		cbMultiInstance.setWidth("100%");
		cbMultiInstance
				.setHTML("Please refer to the <a href='http://docs.camunda.org/manual/7.3/api-references/bpmn20/#tasks-task-markers-multiple-instance' target='_blank'>Camunda documentation</a> for multi instance.");

		tbMultiInstanceLoopCardinality = new TextBox();
		tbMultiInstanceLoopCardinality.setWidth("100%");

		cbMultiInstanceIsSequential = new CheckBox();
		cbMultiInstanceIsSequential.setWidth("100%");

		tbMultiInstanceCollection = new TextBox();
		tbMultiInstanceCollection.setWidth("100%");

		tbMultiInstanceElementVariable = new TextBox();
		tbMultiInstanceElementVariable.setWidth("100%");

		tbMultiInstanceCompletionCondition = new TextBox();
		tbMultiInstanceCompletionCondition.setWidth("100%");

	}

	public CheckBox getCbIsLoop() {
		return cbIsLoop;
	}

	public CheckBox getCbMultiInstance() {
		return cbMultiInstance;
	}

	public TextBox getTbMultiInstanceLoopCardinality() {
		return tbMultiInstanceLoopCardinality;
	}

	public CheckBox getCbMultiInstanceIsSequential() {
		return cbMultiInstanceIsSequential;
	}

	public TextBox getTbMultiInstanceCollection() {
		return tbMultiInstanceCollection;
	}

	public TextBox getTbMultiInstanceElementVariable() {
		return tbMultiInstanceElementVariable;
	}

	public TextBox getTbMultiInstanceCompletionCondition() {
		return tbMultiInstanceCompletionCondition;
	}

}
