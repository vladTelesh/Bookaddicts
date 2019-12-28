package com.project.tms.bookaddicts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        User updateUser = userRepository.findById(user.getId());
        
        updateUser.setEmail(user.getEmail());
        updateUser.setName(user.getName());
        updateUser.setSurname(user.getSurname());
        updateUser.setBirthday(user.getBirthday());

        userRepository.save(updateUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(updateUser, updateUser.getPassword(), updateUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public String findEmailWithoutCurrantId(String currentEmail, long id) {
        String email = userRepository.findEmailWithoutCurrantId(currentEmail,id);
        return email;
    }
}
