package com.preorder.web.cart.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class WishListDTO {

    private int cartId;
    private long memberNo;
    private int opId;
    private int pdCount;
    private LocalDate cartAddDate;

}
