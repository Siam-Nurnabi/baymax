package com.example.IMS.enums;

public enum Permission {
    USER_READ_PRIVILEGE("USER_READ_PRIVILEGE"),
    USER_WRITE_PRIVILEGE("USER_WRITE_PRIVILEGE"),
    USER_DELETE_PRIVILEGE("USER_DELETE_PRIVILEGE"),
    ;

    private final String privilege;

    Permission(String privilege) {
        this.privilege = privilege;
    }

    public String getPrivilege() {
        return privilege;
    }
}
