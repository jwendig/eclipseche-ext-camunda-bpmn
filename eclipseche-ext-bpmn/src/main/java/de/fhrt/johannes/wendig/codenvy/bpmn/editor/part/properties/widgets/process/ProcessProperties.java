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
package de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.process;

import org.eclipse.che.ide.util.loging.Log;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.AbstractBpmnProperties;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.BpmnDiagramElementJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.ProcessJso;

public class ProcessProperties extends AbstractBpmnProperties {

	private final static String LB_ELEMENT_NAME_PREFIX = "Process";

	private ProcessJso element;

	private TabGeneral tabGeneralProperties;
	private TabDefinitions tabDefinitionsProperties;

	public ProcessProperties() {
		super(LB_ELEMENT_NAME_PREFIX);
		Log.info(ProcessProperties.class, "constructor");

		tabGeneralProperties = new TabGeneral();
		tabDefinitionsProperties = new TabDefinitions();

		getTabLpContent().add(tabGeneralProperties,
				tabGeneralProperties.getTabName());
		getTabLpContent().add(tabDefinitionsProperties,
				tabDefinitionsProperties.getTabName());

		getTabLpContent().selectTab(tabGeneralProperties);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.fhrt.johannes.wendig.codenvy.bpmn.editor.part.properties.widgets.
	 * AbstractBpmnProperties
	 * #initSelectedItem(de.fhrt.johannes.wendig.codenvy.bpmn
	 * .editor.widget.diagram.bpmnelements.BpmnDiagramElementJso)
	 */
	@Override
	public void initSelectedItem(BpmnDiagramElementJso selectedItem) {
		element = selectedItem;
	}
	
	
}
