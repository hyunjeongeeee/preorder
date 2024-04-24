package com.preorder.domain.member;

import com.preorder.domain.product.Product;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "wishlist")
public class WishList {

    @Id
    @ManyToOne
    @JoinColumn(name = "PD_ID")
    private Product pdId;  // 상품번호

    @Id
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member memberId;  // 회원 아이디

    @Column(nullable = false)
    private LocalDate wishAddDate;

    @PrePersist
    void prePersist() {
        if(wishAddDate == null) wishAddDate = LocalDate.now();
    }

}
