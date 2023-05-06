package rikkei.academy.md4_ss12_baith1_taoduanspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Greeting {
    // @RequestParam là annotation để đánh dấu rằng name là tham số được truyền vào
    @GetMapping ("/greeting")
    public String greeting(@RequestParam String name, Model model) {
        //model là đối tượng để truyền dữ liệu từ controller sang view
        model.addAttribute("name", name);
        //model.addAtt là phương thức để truyền dữ liệu từ controller sang view
        return "hello";
    }
}
