package com.example.streamconsumer;

public class Foo {

    private final String value;
    private final String dummy;

    //FIXME: fails without @JsonProperty("value")
    public Foo(String value, String dummy) {
        this.value = value;
        this.dummy = dummy;
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
