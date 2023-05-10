package com.example.md4_ss15_baitap3_tokhaiyte.controller;

import com.example.md4_ss15_baitap3_tokhaiyte.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/", "/user"})
public class UserController {
    @GetMapping
    public String home(Model model) {
        Customer customer = new Customer();
        model.addAttribute("form", new DeclareForm(customer, new Vehicle(), new Symtoms(), new HistoryInfection()));
        return "/home";
    }

    @PostMapping("/send")
    public String send(@ModelAttribute ("form") DeclareForm declareForm) {
        System.out.println(declareForm);
        return "/result";
    }
}
