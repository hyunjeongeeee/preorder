package com.preorder.domain.order;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "ORDER_CANCEL")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderCancel {

    @Id
    @Column(name = "ORDER_ID")
    private long orderId;

    @Column(name = "MEMBER_ID", nullable = false)
    private long memberId;

    @Column(name = "PRODUCT_ID", nullable = false)
    private long productId;

    @Column(name = "OPTION_ID", nullable = false)
    private int optionId;

    @Column(name = "CANCEL_DATE", nullable = false)
    private LocalDate cancelDate;

    @Column(name = "CANCEL_REASON", nullable = false, length = 1000)
    private String cancelReason;
}
