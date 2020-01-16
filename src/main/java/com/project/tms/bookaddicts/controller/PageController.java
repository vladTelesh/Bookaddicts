package com.project.tms.bookaddicts.controller;

import com.project.tms.bookaddicts.pojo.Author;
import com.project.tms.bookaddicts.pojo.User;
import com.project.tms.bookaddicts.service.AuthorService;
import com.project.tms.bookaddicts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {

    @Autowired
    private AuthorService authorService;
    @Autowired
    UserService userService;
    @GetMapping("/search")
    public String search(){
        return "search";
    }

    @PostMapping(value = "/search")
    public String postSearch(@RequestParam("surname") String surname, Model model) {
        Author author = authorService.findBySurname(surname);
        if(author == null){
            model.addAttribute("error","not found");
            return "search";
        }
        model.addAttribute("author",author);
        return "info-author";
    }

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal User user, Model model){
        User user1 = userService.findByEmail(user.getEmail());
        model.addAttribute("book",user1.getBooks());
        return "home";
    }
}
