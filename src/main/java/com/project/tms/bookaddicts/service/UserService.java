package com.project.tms.bookaddicts.service;


import com.project.tms.bookaddicts.pojo.User;


public interface UserService {
    void save(User user);

    User findByEmail(String email);
}
