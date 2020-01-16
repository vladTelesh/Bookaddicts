package com.project.tms.bookaddicts.service.impl;

import com.project.tms.bookaddicts.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.project.tms.bookaddicts.pojo.User;
import com.project.tms.bookaddicts.repository.UserRepository;
import com.project.tms.bookaddicts.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private SecurityService securityService;
    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        User user = userRepository.findByEmail(email);

        return user;

    }

    @Override
    public void update(User user) {

        userRepository.save(user);

        securityService.reloadPrincipal(user, user.getPassword(), user.getAuthorities());

    }

    @Override
    public String findEmailWithoutCurrantId(String currentEmail, long id) {
        String email = userRepository.findEmailWithoutCurrantId(currentEmail,id);

        return email;
    }
}
