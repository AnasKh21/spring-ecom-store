/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.codewithmosh.store.model;

/**
 *
 * @author anas
 */
public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private Category category;

    public Product() {
    }    

    public Product(int id, String name, String description, double price, Category c) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = c;
    }
    
    public Product(Product product){
        this.id = product.id;
        this.name = product.name;
        this.description = product.description;
        this.price = product.price;
        this.category = product.category;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }
    public double getPrice(){
        return this.price;
    }
    public int getId(){
        return this.id;
    }

    public Category getCategory() { 
        return category; }

    public void setCategory(Category category) { 
        this.category = category; }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', price=" + price + "}";
    }
}
