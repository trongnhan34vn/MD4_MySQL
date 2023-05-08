package com.example.md4_ss13_baith5_ungdungdanhsachkhanhhang.controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import service.IStudentService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class StudentController {
    @Autowired
    private IStudentService studentServiceIMPL;

    @GetMapping(value = {"/","/students"})
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("students/list");
        List<User> userList = studentServiceIMPL.findAll();
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }

//    @GetMapping (value = "/detail/{id}")
//    public String detail(@PathVariable long id, Model model) {
//        User user = studentServiceIMPL.findById(id);
//        model.addAttribute("student", user);
//        return "/students/info";
//    }


    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, HttpServletRequest request) {
        System.out.println("detail");
        System.out.println("id" + id);
        Long _id = id-1;
        User student = studentServiceIMPL.findById(_id);
        request.setAttribute("student", student);
        return "/students/info";
    }

}
