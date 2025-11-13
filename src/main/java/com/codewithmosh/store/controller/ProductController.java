package com.codewithmosh.store.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codewithmosh.store.service.ProductService;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public String showProduct(@PathVariable int id, Model model){
        var p = productService.getProductById(id);
        if (p == null) {
            model.addAttribute("message", "Produit introuvable.");
            return "redirect:/";
        }
        model.addAttribute("p",p);
        return "product";
    }
}
