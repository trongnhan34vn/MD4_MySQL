package com.example.md4_ss12_baitap1_chuyendoitiente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyServlet {
    @GetMapping ("/")
    public String show() {
        return "show";
    }
    @PostMapping("/exchange")
    public String exchange(Model model, @RequestParam ("number") int num, @RequestParam ("currency") String currency) {
        double rate;
        if (currency.equals("vnd")) {
            rate = 23000;
        } else {
            rate = (double) 1 / 23000;
        }
        double result = num * rate;
        model.addAttribute("result", result);
        return "show";
    }
}
