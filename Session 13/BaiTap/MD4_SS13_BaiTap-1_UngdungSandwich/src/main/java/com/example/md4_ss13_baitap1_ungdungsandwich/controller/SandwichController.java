package com.example.md4_ss13_baitap1_ungdungsandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping(value = "/")
    public String home() {
        return "home";
    }

    @PostMapping(value = "condiment")
    public String condiment(@RequestParam (value = "condiment") String[] condiment, Model model) {
        model.addAttribute("condiment", condiment);
        return "result";
    }
}
