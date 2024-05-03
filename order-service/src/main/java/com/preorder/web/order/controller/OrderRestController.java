package com.preorder.web.order.controller;


import com.preorder.web.order.service.OrderService;
import com.preorder.web.productClient.ProductClient;
import com.preorder.web.productClient.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderRestController {

    private final OrderService orderService;
    private final ProductClient productClient;

    @GetMapping("/{memberNo}")
    public ResponseEntity<?> getOrderList(@PathVariable("pdId")int pdId) {
        List<ProductResponse> productResponse = orderService.findAll(pdId);
        return ResponseEntity.ok(productResponse);
    }


}