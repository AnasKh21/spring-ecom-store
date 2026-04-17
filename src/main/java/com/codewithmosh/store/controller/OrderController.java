package com.codewithmosh.store.controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.codewithmosh.store.service.OrderService;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    
    }

    @GetMapping("/buy/{productId}")
    public String buyProduct(
        @PathVariable int productId,
        @RequestParam int quantity
    ) {
    orderService.createOrder(productId, quantity);
    return "redirect:/orders";
}

   @GetMapping("/orders/{orderId}/pay")
    public String payOrder(@PathVariable Long orderId, Model model) {
        var order = orderService.payOrder(orderId);
        model.addAttribute("order", order);
        return "payment_success";
    }

    @GetMapping("/orders")
    public String showOrders(Model model) {
        var orders = orderService.getAllOrders();
        if (orders.isEmpty()) {
            return "redirect:/";
        }
        model.addAttribute("orders", orders);
        return "orders";        
    }
}
