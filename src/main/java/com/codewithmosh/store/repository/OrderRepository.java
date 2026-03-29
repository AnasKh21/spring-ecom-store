package com.codewithmosh.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithmosh.store.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    
}