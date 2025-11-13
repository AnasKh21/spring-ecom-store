/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.codewithmosh.store.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.codewithmosh.store.service.CategoryService;
import com.codewithmosh.store.service.ProductService;

/**
 *
 * @author anas
 */
@Controller
public class HomeController {


    private final ProductService ProductService;
    private final CategoryService CategoryService;
    

    public HomeController(ProductService Productservice, CategoryService categoryService) {
        this.ProductService = Productservice;
        this.CategoryService = categoryService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("storeName", "MyStore");
        model.addAttribute("produits", ProductService.getAllProducts());
        model.addAttribute("categories", CategoryService.getAllCategories());
        return "index";
    } 

    


}
