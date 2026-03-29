package com.codewithmosh.store;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codewithmosh.store.entity.OrderEntity;
import com.codewithmosh.store.repository.OrderRepository;


@SpringBootTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void testSaveOrder() {
        OrderEntity order = new OrderEntity();
        order.setOrderStatus(OrderEntity.OrderStatus.PENDING);
        order.setTotalPrice(new BigDecimal("100"));
        order.setCreatedAt(LocalDateTime.now());
        orderRepository.save(order);
    }

}