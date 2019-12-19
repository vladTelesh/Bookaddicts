package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class PageController {

    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    @GetMapping("/registration")
    public String reg(){
        return "registration";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

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

}
