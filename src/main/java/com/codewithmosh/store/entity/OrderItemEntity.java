package com.codewithmosh.store.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Long productId;
        private int quantity;
        private BigDecimal unitPrice;
        private BigDecimal subtotal;

        @ManyToOne
        @JoinColumn(name = "order_id") // chaque item appartient a un ORDER ==> JPA crée la colonne order_id dans la table order_items 
        private OrderEntity order;

        public OrderItemEntity() {
        }
    
        public OrderItemEntity(Long id, OrderEntity order, Long productId, int quantity, BigDecimal unitPrice) {
            this.id = id;
            this.order = order;
            this.productId = productId;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
            this.subtotal = unitPrice.multiply(new BigDecimal(quantity));       
        }

        public OrderEntity getOrder() {
            return order;
        }

        public void setOrder(OrderEntity order) {
            this.order = order;
        }
    
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
        
    
        public Long getProductId() {
            return productId;
        }
    
        public void setProductId(Long productId) {
            this.productId = productId;
        }
    
        public int getQuantity() {
            return quantity;
        }
    
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    
        public BigDecimal getUnitPrice() {
            return unitPrice;
        }
    
        public void setUnitPrice(BigDecimal unitPrice) {
            this.unitPrice = unitPrice;
        }

        public BigDecimal getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(BigDecimal subtotal) {
            this.subtotal = subtotal;
        }

}
