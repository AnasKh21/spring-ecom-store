package com.codewithmosh.store.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codewithmosh.store.service.OrderService;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    
    }

    @GetMapping("/buy/{productId}")
    public String buyProduct(@PathVariable int productId) {
        orderService.createOrderWithOneItem(productId, 1);
        return "redirect:/";
    }

}
