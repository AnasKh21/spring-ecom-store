package com.codewithmosh.store.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codewithmosh.store.dto.ProductDto;
import com.codewithmosh.store.entity.OrderEntity;
import com.codewithmosh.store.entity.OrderItemEntity;
import com.codewithmosh.store.repository.OrderItemRepository;
import com.codewithmosh.store.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductService productService;

    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.productService = productService;   

    }

    public OrderEntity createOrderWithOneItem(int productId, int quantity) {
        // 1. Créer une nouvelle commande
        OrderEntity order = new OrderEntity();
        // 2. Récuperer le produit d'abord
        ProductDto product = productService.getProductById(productId);
        if (product == null) {
            throw new IllegalArgumentException("Produit introuvable avec l'ID : " + productId);
        }
        OrderItemEntity item = new OrderItemEntity();
        item.setProductId(Long.valueOf(product.getId())); // ID du produit
        item.setQuantity(quantity);
        item.setUnitPrice(BigDecimal.valueOf(product.getPrice())); // Prix unitaire du produit
        item.setSubtotal(item.getUnitPrice().multiply(new BigDecimal(item.getQuantity()))); // Calcul du sous-total
        item.setOrder(order); // Associer l'item à la commande
        order.setOrderStatus(OrderEntity.OrderStatus.PENDING);
        order.setCreatedAt(LocalDateTime.now());
        // D'abord on crée une liste d'items pour la commande, même si elle ne contient qu'un seul item
        List<OrderItemEntity> items = new ArrayList<>();
        items.add(item);
        order.setItems(items);
        order.setTotalPrice(items.stream().map(OrderItemEntity::getSubtotal).reduce(BigDecimal.ZERO, BigDecimal::add)); // Calcul du prix total de la commande
        // 2. Enregistrer la commande dans la base de données
        OrderEntity savedOrder = orderRepository.save(order);
        item.setOrder(savedOrder);
        // 3. Enregistrer les items de la commande dans la base de données
        orderItemRepository.save(item);
        return savedOrder;
    }



}
