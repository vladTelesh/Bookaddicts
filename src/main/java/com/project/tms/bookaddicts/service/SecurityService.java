package com.project.tms.bookaddicts.service;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface SecurityService {
    void reloadPrincipal(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities);

    void autoLogin(String email, String password);
}
