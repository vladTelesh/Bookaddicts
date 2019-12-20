package com.project.tms.bookaddicts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.project.tms.bookaddicts.pojo.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
