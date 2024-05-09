package com.preorder.web.order.repository;

import com.preorder.domain.order.OrderStatus;
import com.preorder.domain.order.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
    // orderId로 주문 목록 조회
    Optional<Orders> findByOrderId(long orderId);

    // 회원id에 해당하는 주문 목록 조회
    List<Orders> findByMemberId(long memberId);

    // 주문 -> 배송 상태변경
    List<Orders> findAllByOrderDateLessThanEqualAndOrderStatus(LocalDate localDate, OrderStatus orderStatus);


}
