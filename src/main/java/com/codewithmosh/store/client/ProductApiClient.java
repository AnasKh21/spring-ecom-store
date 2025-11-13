package com.codewithmosh.store.client;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.codewithmosh.store.dto.ProductDto;

@Component
public class ProductApiClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "https://fakestoreapi.com";

    public List<ProductDto> fetchAllProducts() {
        String productsUrl = BASE_URL + "/products";

        // 1) on APPELLE l’API et on demande un tableau de ProductDto
        ProductDto[] produits = restTemplate.getForObject(productsUrl, ProductDto[].class);

        // 2) si l’API renvoie null, on évite un NPE et on renvoie une liste vide
        if (produits == null) return Collections.emptyList();

        // 3) on convertit le tableau en List<ProductDto>
        return Arrays.asList(produits);
    }

    public ProductDto fetchProductById(int id) {
        String url = BASE_URL + "/products/{id}";
        return restTemplate.getForObject(url, ProductDto.class, id);
        // Le {id} de l’URL est remplacé par le paramètre 'id' passé après la classe.
    }

    public List<ProductDto> fetchProductsByCategory(String category) {
        String url = BASE_URL + "/products/category/{category}";
        ProductDto[] produits = restTemplate.getForObject(url, ProductDto[].class, category);
        return Arrays.asList(produits);
    }
    
    
}
