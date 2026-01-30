package com.javaworld.user_service.models;

public enum RoleBasedAuthority {

    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN");

    public String getRole() {
        return role;
    }

    private final String role;

    RoleBasedAuthority(String role) {
        this.role = role;
    }
}
