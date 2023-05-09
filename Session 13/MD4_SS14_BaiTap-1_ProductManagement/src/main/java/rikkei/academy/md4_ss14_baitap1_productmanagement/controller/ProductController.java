package rikkei.academy.md4_ss14_baitap1_productmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import rikkei.academy.md4_ss14_baitap1_productmanagement.model.Product;
import rikkei.academy.md4_ss14_baitap1_productmanagement.service.IProductService;

@Controller
@RequestMapping(value = {"/", "/product"})
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("listProduct", productService.findAll());
        System.out.println(productService.findAll());
        return "home";
    }

    @GetMapping(value = "/create")
    public String showFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping(value = "/save")
    public String createProduct(@ModelAttribute ("product") Product product, Model model) {
        productService.save(product);
        model.addAttribute("message", "create product success!");
        return "create";
    }

    @GetMapping(value = "/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        productService.remove(id);
        home(model);
        return "home";
    }

    @GetMapping(value = "/{id}/update")
    public String update(@PathVariable int id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping(value = "/update")
    public String updateProd(@ModelAttribute ("update") Product product, Model model) {
        productService.save(product);
        model.addAttribute("message", "update success!");
        return "edit";
    }
}
