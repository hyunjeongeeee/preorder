package com.preorder.domain.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "PRODUCT")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private long productId;

    @Column(name = "PRODUCT_NAME", nullable = false, length = 500)
    private String productName;

    @Column(name = "PRODUCT_PRICE", nullable = false)
    private int productPrice;

    @Setter
    @Column(name = "PRODUCT_STOCK", nullable = false)
    private int productStock;

    @Column(name = "PRODUCT_DESCRIPTION", length = 1000)
    private String productDescription;

    @Column(name = "PRODUCT_STATUS", length = 1)
    private String productStatus;

}