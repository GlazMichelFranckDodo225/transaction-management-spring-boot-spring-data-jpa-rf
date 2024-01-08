package com.dgmf.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Entity
@Table(name = "tbl_payments")
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "card_type")
    private String cardType;
    @Column(name = "card_name")
    private String cardName;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "expiry_year")
    private int expiryYear;
    @Column(name = "expiry_month")
    private int expiryMonth;
    private int cvc;
    @Column(name = "order_id")
    private Long orderId;
}
