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

package de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.childs.ListValueJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.childs.MapEntryJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.jso.interfaces.extensions.childs.ScriptJso;

public interface InputOutputParameterJso {
	public String getAttr_name();

	public void setAttr_name(String name);

	public String getAttr_value();

	public void setAttr_value(String value);

	public ScriptJso getChild_script();

	public ScriptJso addChild_script(JavaScriptObject moddle);

	public boolean removeChild_script();

	public List<MapEntryJso> getMapEntries();

	public MapEntryJso addMapEntry(JavaScriptObject moddle);

	public boolean removeMapEntry(MapEntryJso mapEntryJso);

	public List<ListValueJso> getListValues();

	public ListValueJso addListValue(JavaScriptObject moddle);

	public boolean removeListValue(ListValueJso listValueJso);
}
