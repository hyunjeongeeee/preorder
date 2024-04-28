package com.preorder.domain.product;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = -757391364L;

    public static final QProduct product = new QProduct("product");

    public final StringPath memberId = createString("memberId");

    public final StringPath pdDescription = createString("pdDescription");

    public final NumberPath<Integer> pdId = createNumber("pdId", Integer.class);

    public final StringPath pdName = createString("pdName");

    public final NumberPath<Integer> pdPrice = createNumber("pdPrice", Integer.class);

    public final NumberPath<Integer> pdStock = createNumber("pdStock", Integer.class);

    public QProduct(String variable) {
        super(Product.class, forVariable(variable));
    }

    public QProduct(Path<? extends Product> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProduct(PathMetadata metadata) {
        super(Product.class, metadata);
    }

}

