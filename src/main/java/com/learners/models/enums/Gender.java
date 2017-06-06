package com.learners.models.enums;

public enum Gender {
	
	MALE("MALE"),FEMALE("FEMALE");
	
	private String value;

	private Gender(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}	
}
