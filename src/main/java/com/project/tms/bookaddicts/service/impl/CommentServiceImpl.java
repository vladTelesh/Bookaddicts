package com.project.tms.bookaddicts.service.impl;

import com.project.tms.bookaddicts.pojo.Comment;
import com.project.tms.bookaddicts.repository.CommentRepository;
import com.project.tms.bookaddicts.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public boolean save(Comment comment) {
        commentRepository.save(comment);
        return true;
    }
}
