package com.socialmedia.loginandregistration.common;

public enum UserPermission {
    CUSTOMER_READ("customer:read"),
    CUSTOMER_WRITE("customer:write"),
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write");
    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
