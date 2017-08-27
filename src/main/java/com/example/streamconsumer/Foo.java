package com.example.streamconsumer;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Foo {

	private final String value;

	// This is required for single property pojo https://github.com/FasterXML/jackson-module-parameter-names/issues/21
	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public Foo(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Foo{" +
				"value='" + value + '\'' +
				'}';
	}
}
