package com.learners.models.enums;

public enum BloodGroup {
	
	AP("A+"),AN("A-"),BP("B+"),BN("B-"),OP("O+"),ON("O-"),ABP("AB+"),ABN("AB-");
	private String value;

	private BloodGroup(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
