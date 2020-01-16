package com.project.tms.bookaddicts.controller;


import com.project.tms.bookaddicts.pojo.*;
import com.project.tms.bookaddicts.service.AuthorService;
import com.project.tms.bookaddicts.service.BookService;
import com.project.tms.bookaddicts.service.DetailsInfoService;
import com.project.tms.bookaddicts.validator.entity.AuthorValidator;
import com.project.tms.bookaddicts.validator.entity.BookValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Controller
public class AuthorAndBookController {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorValidator authorValidator;
    @Autowired
    private BookValidator bookValidator;
    @Autowired
    private DetailsInfoService detailsInfoService;


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
        return "redirect:/add-book";
    }

    @GetMapping("/add-book")
    public String getBook(Model model) {
        List<Author> authors = authorService.findAll();
        model.addAttribute("authors", authors);
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/add-book")
    public String addBook(@ModelAttribute("book") Book book, @RequestParam("file") MultipartFile image,BindingResult bindingResult) {
       bookValidator.validate(book,bindingResult);

       if(bindingResult.hasErrors()){
           return "add-book";
       }
       bookService.save(book,image);

        return "redirect:/info-book/"+book.getId();
    }

    @GetMapping("/info-book/{id}")
    public String getInfoBook(@AuthenticationPrincipal User user, @PathVariable("id") long id, Model model){
        Book book = bookService.findById(id);
        if(detailsInfoService.findByBookIdAndUserId(user.getId(),id)){
            model.addAttribute("check","has");
        }
        model.addAttribute("book",book);
        model.addAttribute("comment",new Comment());
        return "info-book";
    }

    @PostMapping("/add-lib-book")
    public String addBookInLibrary(@ModelAttribute DetailsInfo detailsInfo){
        detailsInfoService.save(detailsInfo);
        return "redirect:/home";
    }
}
