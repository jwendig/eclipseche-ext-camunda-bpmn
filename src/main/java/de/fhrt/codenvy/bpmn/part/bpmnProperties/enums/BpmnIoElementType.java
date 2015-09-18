package de.fhrt.codenvy.bpmn.part.bpmnProperties.enums;


public enum BpmnIoElementType {
	DEFAULT("UNDEFINED"), PROCESS("bpmn:Process"), SCRIPT_TASK(
			"bpmn:ScriptTask"), SERVICE_TASK("bpmn:ServiceTask"), START_EVENT(
			"bpmn:StartEvent"), TASK("bpmn:Task"), USER_TASK("bpmn:UserTask");

	private final String bpmnIoTypeDefinition;

	private BpmnIoElementType(final String bpmnIoTypeDefinition) {
		this.bpmnIoTypeDefinition = bpmnIoTypeDefinition;
	}

	@Override
	public String toString() {
		return bpmnIoTypeDefinition;
	}

	public static BpmnIoElementType findByBpmnIoTypeDefinition(
			String bpmnIoTypeDefinition) {
		for (BpmnIoElementType t : values()) {
			if (t.bpmnIoTypeDefinition.equals(bpmnIoTypeDefinition)) {
				return t;
			}
		}
		return DEFAULT;
	}
}