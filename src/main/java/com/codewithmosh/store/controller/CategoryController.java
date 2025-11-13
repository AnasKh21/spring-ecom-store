package com.codewithmosh.store.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codewithmosh.store.dto.ProductDto;
import com.codewithmosh.store.service.CategoryService;
import com.codewithmosh.store.service.ProductService;



@Controller
public class CategoryController {
    private final CategoryService categoryService;
    private final ProductService productService;
   
    public CategoryController(CategoryService categoryService, ProductService productService){
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/categories")
    public String showCategories(Model model) {
    List<String> categories = categoryService.getAllCategories();
    System.out.println("Cats = " + categories); // log rapide
    model.addAttribute("categories", categories);
    return "categories";
}

    //produits d'une catégorie

    @GetMapping("/categories/{cat}")
    public String showProductsByCategory (@PathVariable("cat") String category, Model model){
        List<ProductDto> products = productService.getProductsByCategory(category);
        System.out.println("produits de la catégorie :"+ category + ":" + products);
        model.addAttribute("category", category);
        model.addAttribute("produits",products);
        return "category-products";
    }


}
