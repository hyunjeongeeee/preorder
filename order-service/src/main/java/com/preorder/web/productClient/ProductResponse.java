package com.preorder.web.productClient;


import com.preorder.domain.order.OrderStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponse {
    private int orderId;
    private int memberNo;
    private String orderAddr;
    private String orderPhone;
    private String orderMemo;
    private int orderPrice;
    private LocalDate orderDate;
    private OrderStatus orderStatus;

    private int pdId;
    private String pdName;
    private int pdPrice;
    private int pdStock;
    private String pdDescription;
    private String pdStatus;
}
