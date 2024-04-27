package com.preorder.domain.product;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Table(name = "PRODUCT")
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PD_ID")
    private int pdId;

    @Column(name = "MEMBER_ID", nullable = false, length = 100)
    private String memberId;

    @Column(name = "PD_NAME", nullable = false, length = 500)
    private String pdName;

    @Column(name = "PD_PRICE", nullable = false)
    private int pdPrice;

    @Column(name = "PD_STOCK", nullable = false)
    private int pdStock;

    @Column(name = "PD_DESCRIPTION", length = 1000)
    private String pdDescription;

}