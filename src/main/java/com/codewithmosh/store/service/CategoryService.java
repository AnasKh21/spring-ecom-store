package com.codewithmosh.store.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codewithmosh.store.client.CategoryApiClient;

/**
 *
 * @author anas
 */
@Service
public class CategoryService {
    
    private final CategoryApiClient client;

    public CategoryService(CategoryApiClient client){
        this.client = client;
    }

    public List<String> getAllCategories(){
        return client.fetchAllCategories();
    }


}
