package com.preorder.domain.wishList;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QWishList is a Querydsl query type for WishList
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWishList extends EntityPathBase<WishList> {

    private static final long serialVersionUID = 636832282L;

    public static final QWishList wishList = new QWishList("wishList");

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public final NumberPath<Integer> optionId = createNumber("optionId", Integer.class);

    public final NumberPath<Integer> productCount = createNumber("productCount", Integer.class);

    public final NumberPath<Integer> productId = createNumber("productId", Integer.class);

    public final NumberPath<Integer> wishId = createNumber("wishId", Integer.class);

    public QWishList(String variable) {
        super(WishList.class, forVariable(variable));
    }

    public QWishList(Path<? extends WishList> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWishList(PathMetadata metadata) {
        super(WishList.class, metadata);
    }

}

