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

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.InputParameterJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.OutputParameterJso;

public interface ServiceTaskJso extends TaskJso {
	public String getAttr_class();

	public void setAttr_class(String clazz);

	public String getAttr_delegateExpression();

	public void setAttr_delegateExpression(String delegateExpression);

	public String getAttr_expression();

	public void setAttr_expression(String expression);

	public String getAttr_resultVariable();

	public void setAttr_resultVariable(String resultVariable);

	public String getAttr_type();

	public void setAttr_type(String type);

	public boolean getAttr_isForCompensation();

	public void setAttr_isForCompensation(boolean isForCompensation);

	public boolean removeCamundaExt_inputParameter(InputParameterJso element);

	public List<InputParameterJso> getCamundaExt_inputParameters();

	public InputParameterJso addCamundaExt_inputParameter(
			JavaScriptObject moddle);

	public boolean removeCamundaExt_outputParameter(OutputParameterJso element);

	public List<OutputParameterJso> getCamundaExt_outputParameters();

	public OutputParameterJso addCamundaExt_outputParameter(
			JavaScriptObject moddle);
}
