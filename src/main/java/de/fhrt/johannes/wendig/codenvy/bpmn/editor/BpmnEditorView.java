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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.BpmnElementJso;

public interface BpmnEditorView {

	public interface ActionDelegate {
	}

	public void setContentIsDirty();

	public void bpmnElementSelected(BpmnElementJso elementJso);

	public void setCurrentXmlContent(String xml);

	public void setCurrentSvgContent(String svg);
}
