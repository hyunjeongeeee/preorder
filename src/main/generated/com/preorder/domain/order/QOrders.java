package com.preorder.domain.order;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrders is a Querydsl query type for Orders
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrders extends EntityPathBase<Orders> {

    private static final long serialVersionUID = -412161031L;

    public static final QOrders orders = new QOrders("orders");

    public final NumberPath<Integer> memberNo = createNumber("memberNo", Integer.class);

    public final StringPath orderAddr = createString("orderAddr");

    public final DatePath<java.time.LocalDate> orderDate = createDate("orderDate", java.time.LocalDate.class);

    public final NumberPath<Integer> orderId = createNumber("orderId", Integer.class);

    public final StringPath orderMemo = createString("orderMemo");

    public final StringPath orderPhone = createString("orderPhone");

    public final NumberPath<Integer> orderPrice = createNumber("orderPrice", Integer.class);

    public final EnumPath<OrderStatus> orderStatus = createEnum("orderStatus", OrderStatus.class);

    public final NumberPath<Integer> pdId = createNumber("pdId", Integer.class);

    public QOrders(String variable) {
        super(Orders.class, forVariable(variable));
    }

    public QOrders(Path<? extends Orders> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrders(PathMetadata metadata) {
        super(Orders.class, metadata);
    }

}

