package com.preorder.web.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductStockResponse {
    // 재고 수량 조정을 위한 DTO
    private long productId;
    private int productStock;

}