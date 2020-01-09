package com.project.tms.bookaddicts.service.impl;

import com.project.tms.bookaddicts.pojo.Author;
import com.project.tms.bookaddicts.repository.AuthorRepository;
import com.project.tms.bookaddicts.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author findBySurname(String surname) {
        return authorRepository.findBySurname(surname);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public boolean save(Author author) {
        authorRepository.save(author);
        return true;
    }
}
