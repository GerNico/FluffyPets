package com.fluffypets.MVC.model.enumes;

public enum UserRole {
    ADMIN("admin"), USER("user"), BLOCKED("blocked");

    private final String value;

    UserRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}