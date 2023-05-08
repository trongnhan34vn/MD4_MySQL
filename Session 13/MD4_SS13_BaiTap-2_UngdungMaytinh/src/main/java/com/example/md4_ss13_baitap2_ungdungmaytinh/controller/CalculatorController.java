package com.example.md4_ss13_baitap2_ungdungmaytinh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("calculator")
    public String calculator(@RequestParam ("num1") float num1, @RequestParam ("num2") float num2, @RequestParam ("operator") String operator, ModelMap modelMap) {
        float result = 0;
        switch (operator) {
            case "sum":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiple":
                result = num1 * num2;
                break;
            case "divide":
                result = num1 / num2;
                break;
        }
        modelMap.addAttribute("result", result);
        return "home";
    }

}
