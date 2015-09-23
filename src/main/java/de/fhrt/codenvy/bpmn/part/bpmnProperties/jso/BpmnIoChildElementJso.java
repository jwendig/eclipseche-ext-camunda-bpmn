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
package de.fhrt.codenvy.bpmn.part.bpmnProperties.jso;

import com.google.gwt.core.client.JavaScriptObject;

public class BpmnIoChildElementJso extends JavaScriptObject {

	protected BpmnIoChildElementJso() {
	}

	public final native String getType() /*-{
											return this.$type;
											}-*/;

	public final native Object getObjectAttribute(String key)/*-{
																return this[key];
																}-*/;

	public final native String getStringAttribute(String key)/*-{
																return this[key];
																}-*/;

	public final native boolean getBooleanAttribute(String key)/*-{
																return this[key];
																}-*/;

	public final native void setAttribute(String key, Object value)/*-{
																	this[key] = value;
																	}-*/;
}
