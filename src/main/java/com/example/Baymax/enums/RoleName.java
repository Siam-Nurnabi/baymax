package com.example.Baymax.enums;

public enum RoleName {
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_STUFF("ROLE_STUFF"),
    ROLE_USER("ROLE_USER"),
    ;

    private final String name;

    RoleName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
