package com.ua.volunteer.company.constant;

public enum Sex {
    MALE("Male"),
    FEMALE("Female");

    private String value;

    Sex(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
