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

package de.fhrt.codenvy.bpmn.editor.widget.diagram.jso.interfaces;

public interface ScriptTaskJso extends TaskJso {
	public String getAttr_resource();

	public void setAttr_resource(String resource);

	public String getAttr_resultVariable();

	public void setAttr_resultVariable(String resultVariable);
}