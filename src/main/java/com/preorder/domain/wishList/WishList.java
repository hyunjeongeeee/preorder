package com.preorder.domain.wishList;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name = "WISHLIST")
@NoArgsConstructor
@AllArgsConstructor
public class WishList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WISH_ID")
    private int wishId;

    @Column(name = "PD_ID", nullable = false)
    private int pdId;

    @Column(name = "MEMBER_NO", nullable = false)
    private int memberNo;

    @Column(name = "OP_ID", nullable = false)
    private int opId;

    @Column(name = "PD_COUNT", nullable = false)
    private int pdCount;

}
