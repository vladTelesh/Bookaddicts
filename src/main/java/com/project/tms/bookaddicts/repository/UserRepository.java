package com.project.tms.bookaddicts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.tms.bookaddicts.pojo.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findById(long id);
    @Query(nativeQuery = true,value = "SELECT email FROM user WHERE id != :id AND email = :email")
    String findEmailWithoutCurrantId(@Param("email") String currentEmail, @Param("id") long id);
}