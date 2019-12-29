package com.project.tms.bookaddicts.service.impl;

import com.project.tms.bookaddicts.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import com.project.tms.bookaddicts.service.SecurityService;

import java.util.Collection;

@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    @Qualifier("UserDetailsService")
    private UserDetailsService userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

    @Override
    public void reloadPrincipal(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(principal, credentials, authorities);

        if (authentication.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(authentication);
            logger.debug(String.format("Auto login successfully!"));
        }
    }

    @Override
    public void autoLogin(String email, String password) {
        User user = (User) userDetailsService.loadUserByUsername(email);

        reloadPrincipal(user, user.getPassword(),user.getAuthorities());
    }
}

