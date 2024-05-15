package com.preorder.web.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderCancelResponseDTO {
    private long orderId;
    private int productCount;
    private int productStock;
}
