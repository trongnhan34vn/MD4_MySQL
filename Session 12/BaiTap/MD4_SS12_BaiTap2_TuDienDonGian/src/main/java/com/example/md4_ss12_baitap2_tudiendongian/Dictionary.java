package com.example.md4_ss12_baitap2_tudiendongian;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Dictionary {
    @GetMapping("/")
    public String show() {
        return "dictionary" ;
    }
    @PostMapping("/dictionary")
    public String find(Model model, @RequestParam("word") String word) {
        String result = null;
        switch (word) {
            case "Nam": 
                result = "Nam béo";
                break;
            case "Hello":
                result = "Xin chào!";
                break;
            case "Khoa":
                result = "Khoa Pug";
                break;
        }
        model.addAttribute("result", result);
        return "dictionary";
    }
}
