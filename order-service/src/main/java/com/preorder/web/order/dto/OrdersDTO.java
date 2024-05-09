package com.preorder.web.order.dto;

import com.preorder.domain.order.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDTO {
    private long orderId;
    private long productId;
    private long memberId;
    private String orderAddr;
    private String orderPhone;
    private String orderMemo;
    private int orderPrice;
    private LocalDate orderDate;
    private OrderStatus orderStatus;

    public OrdersDTO(long productId, long memberId, String orderAddr, String orderPhone, String orderMemo, int orderPrice) {
        this.productId = productId;
        this.memberId = memberId;
        this.orderAddr = orderAddr;
        this.orderPhone = orderPhone;
        this.orderMemo = orderMemo;
        this.orderPrice = orderPrice;
    }
}
