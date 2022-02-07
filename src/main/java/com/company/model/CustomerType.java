package com.company.model;

public enum CustomerType {

    REGULAR("Regular"),
    GUEST("Guest"),
    ;

    private String message;

    CustomerType(String message) {
        this.message = message;
    }
}
