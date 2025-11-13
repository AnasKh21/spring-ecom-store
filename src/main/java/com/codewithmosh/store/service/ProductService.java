/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.codewithmosh.store.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codewithmosh.store.client.ProductApiClient;
import com.codewithmosh.store.dto.ProductDto;

@Service
public class ProductService {

    private final ProductApiClient client;

    // 🧩 Le constructeur : c’est ici que Spring "injecte" le client
    public ProductService(ProductApiClient client) {
        this.client = client;  // on le garde pour l'utiliser plus tard
    }

    public List<ProductDto> getAllProducts() {
        // ici tu appelles ton client :
        return client.fetchAllProducts();
    }

    public List<ProductDto> getProductsByCategory(String category){
        List<ProductDto> list = client.fetchProductsByCategory(category);
        return list == null ? List.of() : list;
    }

    public ProductDto getProductById(int id){
        ProductDto product = client.fetchProductById(id);
        return product;
    }

}
