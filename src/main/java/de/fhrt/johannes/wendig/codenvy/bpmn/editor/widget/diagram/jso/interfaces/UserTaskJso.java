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

public interface UserTaskJso extends TaskJso {
	public String getAttr_assignee();

	public void setAttr_assignee(String assignee);

	public String getAttr_candidateGroups();

	public void setAttr_candidateGroups(String candidateGroups);

	public String getAttr_candidateUsers();

	public void setAttr_candidateUsers(String candidateUsers);

	public String getAttr_dueDate();

	public void setAttr_dueDate(String dueDate);

	public String getAttr_formHandlerClass();

	public void setAttr_formHandlerClass(String formHandlerClass);

	public String getAttr_formKey();

	public void setAttr_formKey(String formKey);

	public String getAttr_priority();

	public void setAttr_priority(String priority);
}