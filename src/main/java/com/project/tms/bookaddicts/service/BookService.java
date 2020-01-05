package com.project.tms.bookaddicts.service;

import com.project.tms.bookaddicts.pojo.Book;
import org.springframework.web.multipart.MultipartFile;

public interface BookService {

    boolean save(Book book, MultipartFile image);
    Book findById(long id);
}
