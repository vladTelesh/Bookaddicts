package com.project.tms.bookaddicts.controller;


import com.project.tms.bookaddicts.pojo.Author;
import com.project.tms.bookaddicts.service.AuthorService;
import com.project.tms.bookaddicts.validator.entity.AuthorValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private AuthorValidator authorValidator;

    @GetMapping("/add-author")
    public String pageAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "add-author";
    }

    @PostMapping("/add-author")
    public String formAuthor(@ModelAttribute("author") Author author, BindingResult bindingResult) {
        authorValidator.validate(author, bindingResult);
        if (bindingResult.hasErrors()) {
            return "add-author";
        }
        authorService.save(author);
        return "add-book";
    }
}
