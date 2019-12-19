package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {


    @PostMapping("/add-new-user")
    public String addUser() {
        return "redirect:home";
    }

    @PostMapping("/authorization")
    public String authorization() {
        return "redirect:home";
    }

    @PostMapping("/add-new-book")
    public String addBook(@RequestParam String name) {
        return "info-book";
    }

    @PostMapping("/add-new-author")
    public String addAuthor(@RequestParam String name) {
        return "info-author";
    }

    @GetMapping("/search/{id}")
    public String search(@PathVariable long id) {
        return "/info-author";
    }

    @GetMapping("/delete/{id}")
    public String deleteBookOfLibrary(@PathVariable long id) {
        return "redirect:/home";
    }

    @GetMapping("/book/{id}")
    public String showBook(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "info-book";
    }
}
