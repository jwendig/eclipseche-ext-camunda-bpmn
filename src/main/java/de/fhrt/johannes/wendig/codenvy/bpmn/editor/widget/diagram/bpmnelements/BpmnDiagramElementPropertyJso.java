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

import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.properties.DataObjectJso;
import de.fhrt.johannes.wendig.codenvy.bpmn.editor.widget.diagram.bpmnelements.interfaces.properties.ErrorJso;

public class BpmnDiagramElementPropertyJso extends BpmnBaseElementJso implements
		DataObjectJso, ErrorJso {

	public enum BpmnPropertyElementType {
		BPMN_DATA_OBJECT("bpmn:DataObject"), BPMN_ERROR("bpmn:Error");

		private final String bpmnIoTypeDefinition;

		private BpmnPropertyElementType(final String bpmnIoTypeDefinition) {
			this.bpmnIoTypeDefinition = bpmnIoTypeDefinition;
		}

		@Override
		public String toString() {
			return bpmnIoTypeDefinition;
		}

		public static BpmnPropertyElementType findByBpmnIoTypeDefinition(
				String bpmnIoTypeDefinition) {
			for (BpmnPropertyElementType t : values()) {
				if (t.bpmnIoTypeDefinition.equals(bpmnIoTypeDefinition)) {
					return t;
				}
			}
			return null;
		}
	}

	protected BpmnDiagramElementPropertyJso() {
	}
}
