/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.codewithmosh.store.client;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author anas
 */
@Component
public class CategoryApiClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "https://fakestoreapi.com";

    public List<String> fetchAllCategories() {
        String url = BASE_URL + "/products/categories";
        try {
            String[] cats = restTemplate.getForObject(url, String[].class);
            return cats == null ? Collections.emptyList() : Arrays.asList(cats);
        } catch (Exception e) {
            // évite de casser le rendu Thymeleaf si l’API échoue
            System.err.println("Erreur fetchAllCategories: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    
}



    
    
    
