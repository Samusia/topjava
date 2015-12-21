package ru.javawebinar.topjava.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Samusia
 * on 30.11.2015.
 */
public enum Role implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
