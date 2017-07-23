package com.learners.models.enums;

import java.util.Arrays;
import java.util.List;

public enum LessonType {
	
	L1("Technical knowledge which includes lectures and practical lessons","foaYk yd m%dfhda.sl mdvï we;=<;a jk ld3⁄4ñl ±kSu"),
	L2("Road Rulesand Signals","ud3⁄4. Í;s iy ud3⁄4. ix×"),
	L3("Practical training","m%dfhda.sl mqyqKqj");
	
	private List<String> value;

	private LessonType(String... value) {
		this.value = Arrays.asList(value);
	}

	@Override
	public String toString() {
		return this.value.toString();
	}
}
