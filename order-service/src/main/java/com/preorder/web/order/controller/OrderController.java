package com.preorder.web.order.controller;

import com.preorder.domain.order.OrderCancel;
import com.preorder.domain.order.Orders;
import com.preorder.web.order.dto.OrdersResponseDTO;
import com.preorder.web.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    // 주문 생성 + 재고 감소
    @PostMapping("/api/orders")
    public ResponseEntity<List<Orders>> createOrder(@RequestBody List<Orders> ordersList) {
        orderService.createOrder(ordersList);
        return ResponseEntity.ok(ordersList);
    }

    // 회원번호로 검색 => 주문 목록을 가져오는 엔드포인트
    @GetMapping("/api/members/{memberId}/orders")
    public ResponseEntity<List<OrdersResponseDTO>> getOrders(@PathVariable(value = "memberId") long memberId) {
        List<OrdersResponseDTO> list = orderService.getAllOrdersWithProductInfo(memberId);
        return ResponseEntity.ok(list);
    }

    // 주문 취소 후 상품 재고 조정
    @PostMapping("/api/orders/cancelStocks")
    public void updateProductStock(@RequestBody List<OrderCancel> orderCancelList) {
        orderService.cancelOrders(orderCancelList);
    }
}
