package com.preorder.domain.order;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;

@Getter
@SuperBuilder
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert // 엔티티를 save할 때 null 값은 배제하고 insert 쿼리를 날리도록 한다.
public class Orders {

    @Id // Primary Key 지정
    // AUTO_INCREMENT 설정 (id값이 null일 경우 자동 생성)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    @Column(nullable = false)
    private String memberId;

    @Column(nullable = false)
    private String orderName;

    @Column(nullable = false)
    private String orderAddr;

    @Column(nullable = false)
    private String orderPhone;

    @Column(nullable = false)
    private String orderMemo;

    @Column(nullable = true)
    private String shipMemo;

    @Column(nullable = false)
    private int shipPrice;

    @Column(nullable = false)
    private int orderPayment;

    @Column(nullable = false)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private LocalDate orderDate;

    @Column(nullable = false)
    @ColumnDefault("'Y'")
    private String orderStatus;


    @PrePersist
    void onPrePersist() {
        if (orderDate == null)  orderDate = LocalDate.now();
        if (orderStatus == null)  orderStatus = "Y";
    }
    /*

    CREATE TABLE ORDERS (
	ORDER_ID	INT	NOT NULL,
	MEMBER_ID	VARCHAR(100)	NOT NULL,
	ORDER_NAME	VARCHAR(100)	NOT NULL,
	ORDER_ADDR	VARCHAR(500)	NOT NULL,
	ORDER_PHONE	VARCHAR(100)	NOT NULL,
	ORDER_MEMO	VARCHAR(1000)	NULL,
	SHIP_MEMO	VARCHAR(1000)	NULL,
	ORDER_PRICE	INT	NOT NULL,
	ORDER_PAYMENT	VARCHAR(500)	NOT NULL,
	ORDER_DATE	DATE	NOT NULL	 DEFAULT (CURRENT_DATE),
	ORDER_CODE	VARCHAR(100)	NOT NULL,
	ORDER_STATUS	CHAR(1)	NOT NULL	DEFAULT 'Y'
);

    */
}
