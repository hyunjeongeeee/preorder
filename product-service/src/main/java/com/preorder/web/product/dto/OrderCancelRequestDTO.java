package com.preorder.web.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCancelRequestDTO {
    private long orderId;
    private int productCount;
    private int productStock;

}
