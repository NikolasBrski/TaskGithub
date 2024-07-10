package com.example.task.model;

import com.fasterxml.jackson.annotation.JsonValue;


public enum AccountType {

    PERSONAL("Personal"),
    ENTERPRISE("Enterprise"),
    ORGANIZATION("Organization"),
    USER("User");

    private final String value;

    AccountType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}