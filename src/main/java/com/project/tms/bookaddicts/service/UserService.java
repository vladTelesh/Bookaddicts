package com.project.tms.bookaddicts.service;


import com.project.tms.bookaddicts.pojo.User;



public interface UserService {

    void save(User user);

    void update(User user);

    User findByEmail(String email);

    String findEmailWithoutCurrantId(String currentEmail,  long id);
}
