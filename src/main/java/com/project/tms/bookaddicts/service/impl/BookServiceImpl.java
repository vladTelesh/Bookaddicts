package com.project.tms.bookaddicts.service.impl;

import com.project.tms.bookaddicts.pojo.Book;
import com.project.tms.bookaddicts.repository.BookRepository;
import com.project.tms.bookaddicts.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    @Value("${upload.path}")
    private String uploadPath;
    @Autowired
    BookRepository bookRepository;

    @Override
    public boolean save(Book book, MultipartFile image) {

        if (image != null && !image.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + image.getOriginalFilename();
            book.setImage(resultFileName);
            try {
                image.transferTo(new File(uploadPath + "/" + resultFileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        bookRepository.save(book);

        return true;
    }
}
