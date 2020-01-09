package com.project.tms.bookaddicts.controller;

import com.project.tms.bookaddicts.pojo.Comment;
import com.project.tms.bookaddicts.pojo.User;
import com.project.tms.bookaddicts.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class WebController {

    @Autowired
    CommentService commentService;
    @GetMapping(value = "/delete/{id}")
    public String deleteBookOfLibrary(@PathVariable long id) {
        return "redirect:/home";
    }

    @PostMapping(value = "/comment")
    public String addComment(@AuthenticationPrincipal User user, @ModelAttribute Comment comment){
        comment.setUser(user);
        commentService.save(comment);
        return "redirect:/info-book/"+comment.getBook().getId();
    }


}
