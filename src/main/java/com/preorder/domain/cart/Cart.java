package com.preorder.domain.cart;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@SuperBuilder
@Entity
@Table(name = "cart")
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id // Primary Key 지정
    // AUTO_INCREMENT 설정 (id값이 null일 경우 자동 생성)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    @Column(nullable = false)
    private String memberId;

    @Column(nullable = false)
    private int opId;

    @Column(nullable = false)
    private int cartCount;

    @Column(nullable = false)
    @ColumnDefault("CURRENT_DATE")
    private LocalDate cartAddDate;

}
