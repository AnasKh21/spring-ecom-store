/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.codewithmosh.store.model;

/**
 *
 * @author anas
 */
public class Category {
    private int id;
    private String name;
    private String description;

    public Category(){}

    public Category(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Category(Category c) {
        this(c.id, c.name, c.description);}

    public int getId(){return this.id;}
    public String getName() { return name; }
    public String getDescription() { return description; }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
