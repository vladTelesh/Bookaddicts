package com.project.tms.bookaddicts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.tms.bookaddicts.pojo.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
