package com.project.tms.bookaddicts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {

    @GetMapping("/search")
    public String search(){
        return "search";
    }

    @GetMapping("/add-book")
    public String addBook(){
        return "add-book";
    }

    @GetMapping("/add-author")
    public String addAuthor(){
        return "add-author";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

}
