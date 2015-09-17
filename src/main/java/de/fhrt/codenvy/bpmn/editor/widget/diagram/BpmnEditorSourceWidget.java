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
package de.fhrt.codenvy.bpmn.editor.widget.diagram;

import edu.stanford.bmir.gwtcodemirror.client.GWTCodeMirror;

public class BpmnEditorSourceWidget extends GWTCodeMirror {

	public BpmnEditorSourceWidget(String mode, String theme) {
		super(mode, theme);
	}

	public native void refresh()/*-{
										var cms = $doc.querySelectorAll('.CodeMirror');
										for(var i = 0; i < cms.length; i++){
										    var cm = cms[i]; // element
											cm.CodeMirror.refresh();
										}
										}-*/;
}
