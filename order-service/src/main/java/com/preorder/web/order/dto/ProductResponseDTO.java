package com.preorder.web.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {

    private long productId;
    private String productName;
    private int productPrice;

}
