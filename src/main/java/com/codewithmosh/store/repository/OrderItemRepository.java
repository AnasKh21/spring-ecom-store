package com.codewithmosh.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithmosh.store.entity.OrderItemEntity;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
}