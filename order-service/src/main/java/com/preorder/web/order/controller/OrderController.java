package com.preorder.web.order.controller;

import com.preorder.domain.order.Orders;
import com.preorder.web.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // 주문 생성
//    @PostMapping
//    public ResponseEntity<Orders> createOrder(@RequestBody OrderRequest orderRequest) {
////        Orders orders = orderService.createOrder(orderRequest);
////        return ResponseEntity.status(HttpStatus.CREATED).body(orders);
//        return null;
//    }

    // 주문 상세 조회
    @GetMapping("/{orderId}")
    public ResponseEntity<Orders> getOrderById(@PathVariable int orderId) {
        Optional<Orders> orders = orderService.getOrderProcess(orderId);
        return ResponseEntity.ok(orders.get());
    }
}
