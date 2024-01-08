package com.dgmf.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "tbl_orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;
    @Column(name = "total_quantity")
    private int totalQuantity;
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    private String status;
    @CreationTimestamp
    @Column(name = "date_created")
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;
    @Column(name = "shopping_cart_id")
    private Long shoppingCartId;
}
