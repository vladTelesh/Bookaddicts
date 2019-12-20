package com.project.tms.bookaddicts.service;

public interface SecurityService {
    String findLoggedInEmail();

    void autoLogin(String email, String password);
}
