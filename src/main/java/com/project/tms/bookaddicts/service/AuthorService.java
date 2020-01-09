package com.project.tms.bookaddicts.service;

import com.project.tms.bookaddicts.pojo.Author;

import java.util.List;

public interface AuthorService {
    Author findBySurname(String surname);
    List<Author> findAll();
    boolean save(Author author);
}
