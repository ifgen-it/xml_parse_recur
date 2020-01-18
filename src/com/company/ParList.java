package com.company;

public class ParList {

    private String value;

    public ParList() {
    }

    public ParList(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ParList{" +
                "value='" + value + '\'' +
                '}';
    }
}
