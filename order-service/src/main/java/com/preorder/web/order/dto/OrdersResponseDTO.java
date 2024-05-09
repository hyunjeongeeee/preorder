package com.preorder.web.order.dto;

import com.preorder.domain.order.Orders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrdersResponseDTO {
    private Orders orders;
    private ProductResponseDTO productResponseDTO;

}
