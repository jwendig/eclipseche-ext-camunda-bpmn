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
										var property = {};
										
										if(value == null){
											property[key] = undefined;
										}else{
											property[key] = value;
										}
										
										this.updateProperties(element, property);
										}-*/;
}
