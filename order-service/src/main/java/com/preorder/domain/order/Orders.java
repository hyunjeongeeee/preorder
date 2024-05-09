package com.preorder.domain.order;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CurrentTimestamp;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "ORDERS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicInsert // 엔티티를 save할 때 null 값은 배제하고 insert 쿼리를 날리도록 한다.
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private long orderId;

    @Column(name = "PRODUCT_ID", nullable = false)
    private int productId;

    @Column(name = "PRODUCT_COUNT", nullable = false)
    private int productCount;

    @Column(name = "MEMBER_ID", nullable = false)
    private long memberId;

    @Column(name = "ORDER_ADDR", nullable = false, length = 500)
    private String orderAddr;

    @Column(name = "ORDER_PHONE", nullable = false, length = 100)
    private String orderPhone;

    @Column(name = "ORDER_MEMO", length = 1000)
    private String orderMemo;

    @Column(name = "ORDER_PRICE", nullable = false)
    private int orderPrice;

    @Column(name = "ORDER_DATE", nullable = false, updatable = false)
    private LocalDate orderDate;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS", nullable = false)
    private OrderStatus orderStatus;



}
