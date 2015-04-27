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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.ExecutionListenerJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.TaskListenerJso;

public interface TaskJso extends DefaultJso {
	public boolean getAttr_asyncAfter();

	public void setAttr_asyncAfter(boolean asyncAfter);

	public boolean getAttr_asyncBefore();

	public void setAttr_asyncBefore(boolean asyncBefore);

	public boolean getAttr_exclusive();

	public void setAttr_exclusive(boolean exclusive);

	/*
	 * Only for Multi Instance Loop Characteristrics of Task
	 */
	public String getAttr_collection();

	public void setAttr_collection(String collection);

	public String getAttr_elementVariable();

	public void setAttr_elementVariable(String elementVariable);

	public boolean removeCamundaExt_taskListener(TaskListenerJso element);

	public List<TaskListenerJso> getCamundaExt_taskListeners();

	public TaskListenerJso addCamundaExt_taskListener(JavaScriptObject moddle);
}
