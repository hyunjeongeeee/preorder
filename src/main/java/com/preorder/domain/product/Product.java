package com.preorder.domain.product;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;


@ToString
@Table(name = "product")
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT 설정 (id값이 null일 경우 자동 생성)
    private int pdId;

    @Column(nullable = false)
    private String pdName;

    @Column(nullable = false)
    private int pdPrice;

    @Column(nullable = false)
    private int pdStock;

    @Column(nullable = false)
    private LocalDate pdAddDate;

    @PrePersist
    void onPrePersist() {
        if (pdAddDate == null)  pdAddDate = LocalDate.now();
    }

    @Column(nullable = true)
    private LocalDate pdUpdate;

    @Column(nullable = false)
    private String categoryCode;

    @Column(nullable = false)
    private  String pdStatus;
}