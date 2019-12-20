package com.project.tms.bookaddicts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.tms.bookaddicts.pojo.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByName(String name);

}
