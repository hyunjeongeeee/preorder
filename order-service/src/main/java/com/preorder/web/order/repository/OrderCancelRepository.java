package com.preorder.web.order.repository;

import com.preorder.domain.order.OrderCancel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCancelRepository extends JpaRepository<OrderCancel, Long> {

}
