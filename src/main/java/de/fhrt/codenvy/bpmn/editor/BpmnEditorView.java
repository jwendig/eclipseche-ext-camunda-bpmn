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

package de.fhrt.codenvy.bpmn.editor;

import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoElementJso;
import de.fhrt.codenvy.bpmn.part.bpmnProperties.jso.BpmnIoModelerJso;

public interface BpmnEditorView {

	public interface ActionDelegate {
	}

	public void setContentIsDirty();

	public void bpmnElementSelected(BpmnIoModelerJso modelerJso,
			BpmnIoElementJso elementJso);

	public void setCurrentXmlContent(String xml);

	public void setCurrentSvgContent(String svg);
}
