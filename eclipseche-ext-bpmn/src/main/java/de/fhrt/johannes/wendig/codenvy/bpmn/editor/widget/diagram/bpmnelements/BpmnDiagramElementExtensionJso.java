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

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.extensions.ExecutionListenerJso;

public class BpmnDiagramElementExtensionJso extends BpmnBaseElementJso
		implements ExecutionListenerJso {

	public enum BpmnExtensionElementType {
		BPMN_EXTENSION_ELEMENT("bpmn:ExtensionElements"), CAMUNDA_EXECUTION_LISTENER(
				"camunda:ExecutionListener");

		private final String bpmnIoTypeDefinition;

		private BpmnExtensionElementType(final String bpmnIoTypeDefinition) {
			this.bpmnIoTypeDefinition = bpmnIoTypeDefinition;
		}

		@Override
		public String toString() {
			return bpmnIoTypeDefinition;
		}

		public static BpmnExtensionElementType findByBpmnIoTypeDefinition(
				String bpmnIoTypeDefinition) {
			for (BpmnExtensionElementType t : values()) {
				if (t.bpmnIoTypeDefinition.equals(bpmnIoTypeDefinition)) {
					return t;
				}
			}
			return null;
		}
	}

	protected BpmnDiagramElementExtensionJso() {
	}

	@Override
	public final native String getAttr_event()/*-{
												return this.event;
												}-*/;

	@Override
	public final native void setAttr_event(String event)/*-{
														this.event = event;
														}-*/;

}
