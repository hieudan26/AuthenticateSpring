package com.socialmedia.loginandregistration.common;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.socialmedia.loginandregistration.common.UserPermission.*;


public enum AppUserRole {
    CUSTOMER(Sets.newHashSet(CUSTOMER_READ, CUSTOMER_WRITE)),
    ADMIN(Sets.newHashSet(ADMIN_READ, ADMIN_WRITE, CUSTOMER_READ, CUSTOMER_WRITE));

    private final Set<UserPermission> permissions;

    AppUserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        //permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}