package com.preorder.domain.wishList;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table(name = "WISHLIST")
@NoArgsConstructor
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WISH_ID")
    private int wishId;

    @Column(name = "PRODUCT_ID", nullable = false)
    private int productId;

    @Column(name = "MEMBER_ID", nullable = false)
    private long memberId;

    @Column(name = "OPTION_ID", nullable = false)
    private int optionId;

    @Setter
    @Column(name = "PRODUCT_COUNT", nullable = false)
    private int productCount;

    @Builder
    public WishList(int productId, long memberId, int optionId, int productCount) {
        this.productId = productId;
        this.memberId = memberId;
        this.optionId = optionId;
        this.productCount = productCount;
    }


}
