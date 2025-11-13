/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.codewithmosh.store;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author anas
 */
@Controller
public class HomeController {

    private final List<Product> produits = new ArrayList<>();  
    private final List<Category> categories = new ArrayList<>();

    public HomeController() {
        produits.add(new Product(1, "Chaussures", "Confortables pour le sport", 59.99, null));
        produits.add(new Product(2, "Montre", "Design élégant", 120.0,null));
        produits.add(new Product(3, "Sac à dos", "Résistant et stylé", 89.0,null));
        categories.add(new Category(1, "Vetements", "Chaussures,Vestes,Pulls"));
        categories.add(new Category(2, "Accesoires", "Sac,Montres,Bijoux"));
        //set Categories to products
        produits.get(0).setCategory(categories.get(0));
        produits.get(1).setCategory(categories.get(1));
        produits.get(2).setCategory(categories.get(1));

    }
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("storeName", "MyStore");
        model.addAttribute("message", "Bienvenue sur mon petit store 👋");
        model.addAttribute("produits", produits);
        model.addAttribute("categories", categories);
        
        System.out.println("🏁 index() appelé !");
        return "index";
    } 

    @GetMapping("/product/{id}")
    public String showProduct(@PathVariable int id, Model model){
        Product productFound = null;
        for ( Product p : produits){
            if (p.getId()== id){
                productFound = p;
                break;
            }
        }
        if (productFound != null){
            model.addAttribute("product", productFound);
        } else  {
            model.addAttribute("message", "Produit introuvable.");
            return "redirect:/";
        }

        return "product";
    }

    //Category

    @GetMapping("/category/{id}")
    public String showCategory(@PathVariable int id, Model model){
        Category categoryFound = null;
        for ( Category c : categories){
            if (c.getId() == id){
                categoryFound = c;
                break;
            }}
        if ( categoryFound == null ) {
            model.addAttribute("message", "Produit introuvable.");
            return "redirect:/";
        } else {
            model.addAttribute("category", categoryFound);
        }
        return "category";
    }

    


    


}
