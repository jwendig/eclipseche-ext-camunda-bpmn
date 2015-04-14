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
package de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements;

import com.google.gwt.core.client.JavaScriptObject;

public abstract class AbstractBpmnJso extends JavaScriptObject {
	protected AbstractBpmnJso() {
	}

	public final native String getType() /*-{
											return this.businessObject.$type;
											}-*/;

	public final native String getBusinessObject() /*-{
													return this.businessObject;
													}-*/;

	public final native String getId() /*-{
											return this.businessObject.id;
											}-*/;

	public final native void setId(String id) /*-{
													this.businessObject.id = id;
													}-*/;

	public final native String getName() /*-{
												return this.businessObject.name;
												}-*/;

	public final native void setName(String name) /*-{
														this.businessObject.name = name;
														}-*/;

}
