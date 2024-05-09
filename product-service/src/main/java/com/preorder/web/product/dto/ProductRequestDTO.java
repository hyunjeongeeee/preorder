package com.preorder.web.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO {
    // product-service 에서 상품 정보를 반환하기 위한 DTO.
    private long productId;
    private String productName;
    private int productPrice;

}
