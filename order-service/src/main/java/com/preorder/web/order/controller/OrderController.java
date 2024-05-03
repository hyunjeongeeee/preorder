package com.preorder.web.order.controller;

import com.preorder.web.order.service.OrderService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

//    @GetMapping("/members/{memberNo}")
//    public ResponseEntity<MemberResponse> getMemberForOrder(@PathVariable long memberNo) {
//        MemberResponse member = orderService.getMemberDetails(memberNo);
//        return ResponseEntity.ok(member);
//    }





//    // 주석: 주문 ID에 따라 주문 정보를 조회하는 GET 요청을 처리합니다.
//    @GetMapping("/orders/{id}")
//    public ResponseEntity<Orders> getOrder(@PathVariable Long id) {
//        Orders order = orderService.getOrder(id);  // 주석: 주문 서비스를 호출하여 주문 정보를 가져옵니다.
//        if (order != null) {
//            return ResponseEntity.ok(order);  // 주석: 주문 정보가 있으면 HTTP 200 상태와 함께 주문 정보를 반환합니다.
//        } else {
//            return ResponseEntity.notFound().build();  // 주석: 주문 정보가 없으면 HTTP 404 상태를 반환합니다.
//        }
//    }


    // 주문 생성
//    @PostMapping
//    public ResponseEntity<Orders> createOrder(@RequestBody OrderRequest orderRequest) {
////        Orders orders = orderService.createOrder(orderRequest);
////        return ResponseEntity.status(HttpStatus.CREATED).body(orders);
//        return null;
//    }

//    // 주문 상세 조회
//    @GetMapping("/{orderId}")
//    public ResponseEntity<Orders> getOrderById(@PathVariable int orderId) {
//        Optional<Orders> orders = orderService.getOrderProcess(orderId);
//        return ResponseEntity.ok(orders.get());
//    }
}
