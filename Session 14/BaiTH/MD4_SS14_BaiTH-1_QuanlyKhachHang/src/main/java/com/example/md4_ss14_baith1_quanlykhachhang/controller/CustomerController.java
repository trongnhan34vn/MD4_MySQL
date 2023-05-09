package com.example.md4_ss14_baith1_quanlykhachhang.controller;

import com.example.md4_ss14_baith1_quanlykhachhang.model.Customer;
import com.example.md4_ss14_baith1_quanlykhachhang.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping(value = {"/", "/customer"})
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public String index(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute (value = "customer") Customer customer, Model model) {
        customerService.save(customer);
        model.addAttribute("message", "Đúng r! Ơn dơời");
        return "/create";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        System.out.println(customerService.findById(id));
        model.addAttribute("customer", customerService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute (value = "customer") Customer  customer, Model model) {
        customerService.save(customer);
        model.addAttribute("message", "Đúng r! Ơn dơời");
        return "/edit";
    }


    @GetMapping("/{id}/delete")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute (value = "customer") Customer customer, Model model) {
        customerService.remove(customer.getId());
        model.addAttribute("message", "Đúng r! Ơn dơời");
        return "/delete";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "/view";
    }
}