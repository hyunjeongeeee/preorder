package com.preorder.web.order.repository;

import com.preorder.domain.order.Orders;
import com.preorder.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Product> {

}
