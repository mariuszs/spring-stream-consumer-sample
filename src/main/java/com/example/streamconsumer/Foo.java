package com.example.streamconsumer;

public class Foo {

    private final String value;

    //FIXME: fails without @JsonProperty("value")
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
