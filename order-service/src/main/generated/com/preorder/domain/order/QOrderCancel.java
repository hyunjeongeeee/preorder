package com.preorder.domain.order;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrderCancel is a Querydsl query type for OrderCancel
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderCancel extends EntityPathBase<OrderCancel> {

    private static final long serialVersionUID = -323718444L;

    public static final QOrderCancel orderCancel = new QOrderCancel("orderCancel");

    public final DatePath<java.time.LocalDate> cancelDate = createDate("cancelDate", java.time.LocalDate.class);

    public final StringPath cancelReason = createString("cancelReason");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final NumberPath<Integer> optionId = createNumber("optionId", Integer.class);

    public final NumberPath<Long> orderId = createNumber("orderId", Long.class);

    public final NumberPath<Long> productId = createNumber("productId", Long.class);

    public QOrderCancel(String variable) {
        super(OrderCancel.class, forVariable(variable));
    }

    public QOrderCancel(Path<? extends OrderCancel> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderCancel(PathMetadata metadata) {
        super(OrderCancel.class, metadata);
    }

}

