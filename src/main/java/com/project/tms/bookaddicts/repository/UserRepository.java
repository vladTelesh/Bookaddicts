package com.project.tms.bookaddicts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.tms.bookaddicts.pojo.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}