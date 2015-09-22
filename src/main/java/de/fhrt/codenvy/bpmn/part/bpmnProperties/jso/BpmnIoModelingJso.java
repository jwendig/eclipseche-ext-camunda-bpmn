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

public class BpmnIoModelingJso extends JavaScriptObject {
	protected BpmnIoModelingJso() {

	}

	public final native void updateProperty(JavaScriptObject element,
			String key, Object value)/*-{
										console.log("test");
										var property = {};
										console.log("test1");
										property[key] = value;
										console.log("test2 " + property[key]);
										this.updateProperties(element, property);
										console.log("test3");
										}-*/;
}
