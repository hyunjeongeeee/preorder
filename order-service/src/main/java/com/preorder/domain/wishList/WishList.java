package com.preorder.domain.wishList;

import com.preorder.web.wishList.dto.WishListDTO;
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

    @Column(name = "PD_ID", nullable = false)
    private int pdId;

    @Column(name = "MEMBER_NO", nullable = false)
    private long memberNo;

    @Column(name = "OP_ID", nullable = false)
    private int opId;

    @Setter
    @Column(name = "PD_COUNT", nullable = false)
    private int pdCount;

    @Builder
    public WishList (WishListDTO wishListDTO) {
        wishId = wishListDTO.getWishId();
        pdId = wishListDTO.getPdId();
        memberNo = wishListDTO.getMemberNo();
        opId = wishListDTO.getOpId();
        pdCount = wishListDTO.getPdCount();
    }




    @Builder
    public WishList(int pdId, long memberNo, int opId, int pdCount) {
//        this.wishId = wishId;
        this.pdId = pdId;
        this.memberNo = memberNo;
        this.opId = opId;
        this.pdCount = pdCount;
    }


}