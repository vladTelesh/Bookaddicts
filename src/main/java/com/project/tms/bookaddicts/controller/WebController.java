package com.project.tms.bookaddicts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {


    @GetMapping(value = "/search/{id}")
    public String search(@PathVariable long id) {
        return "/info-author";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteBookOfLibrary(@PathVariable long id) {
        return "redirect:/home";
    }


}
