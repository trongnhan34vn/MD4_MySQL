package com.example.md4_ss15_baitap1_homthudientu.controller;

import com.example.md4_ss15_baitap1_homthudientu.model.App;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/", "/app"})
public class AppController {
    @GetMapping
    public String home(Model model) {
        model.addAttribute("app", new App());
        return "/home";
    }

    @PostMapping("/setting")
    public String setting (@ModelAttribute ("app") App app, Model model) {
        System.out.println(app);
        model.addAttribute("app", app);
        model.addAttribute("message", "Setting Success!");
        return "/setting";
    }
}
