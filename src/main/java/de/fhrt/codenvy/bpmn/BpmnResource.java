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
package de.fhrt.codenvy.bpmn;

import org.vectomatic.dom.svg.ui.SVGResource;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.TextResource;

/**
 * The resources for editor tutorial.
 * 
 * @author <a href="mailto:aplotnikov@codenvy.com">Andrey Plotnikov</a>
 */
public interface BpmnResource extends ClientBundle {

	@Source("newDiagram.bpmn")
	TextResource newBpmnFile();

	@Source("img/bpmn-file-ico.svg")
	SVGResource bpmnIconSvgFile();

	@Source("img/bpmn-ico-circle-x-small.png")
	ImageResource bpmnIconXsFile();

	@Source("img/bpmn-ico-circle.png")
	ImageResource bpmnIconXlFile();

	@Source("bpmn-io-editor/index.js")
	TextResource bpmnIoIndexJsFile();

	@Source("bpmn-io-editor/css/diagram-js.css")
	CssResource getBpmnDiagramJsCss();

	@Source("bpmn-io-editor/css/custom.css")
	CssResource getBpmnDiagramJsCustomCss();

	@Source("bpmn-io-editor/css/app.css")
	CssResource getBpmnAppCss();

	@Source("bpmn-io-editor/vendor/bpmn-font/css/bpmn-embedded.css")
	CssResource getBpmnFontCss();

	@Source("bpmn-io-properties/css/gwt-custom.css")
	CssResource getBpmnPropertiesTabCss();
}
