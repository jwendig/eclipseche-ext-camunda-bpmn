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
