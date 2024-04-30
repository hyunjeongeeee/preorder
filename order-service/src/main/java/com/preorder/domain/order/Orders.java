package com.preorder.domain.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "ORDERS")
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert // 엔티티를 save할 때 null 값은 배제하고 insert 쿼리를 날리도록 한다.
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private int orderId;

    @Column(name = "PD_ID", nullable = false)
    private int pdId;

    @Column(name = "MEMBER_NO", nullable = false)
    private int memberNo;

    @Column(name = "ORDER_ADDR", nullable = false, length = 500)
    private String orderAddr;

    @Column(name = "ORDER_PHONE", nullable = false, length = 100)
    private String orderPhone;

    @Column(name = "ORDER_MEMO", length = 1000)
    private String orderMemo;

    @Column(name = "ORDER_PRICE", nullable = false)
    private int orderPrice;

    @CurrentTimestamp
    @Column(name = "ORDER_DATE", nullable = false)
    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS", nullable = false)
    private OrderStatus orderStatus;

}
