package com.preorder.web.order.dto;

import com.preorder.domain.order.Orders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class  StockResponseDTO {
    private Orders orders;
    private ProductStockResponse productStockResponse;
}