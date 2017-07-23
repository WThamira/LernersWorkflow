package com.learners.models.enums;

public enum WorkType {
	CON("conversion"),REN("RENEW"),EXT("EXTENSION");
	
	private String value;

	private WorkType(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
