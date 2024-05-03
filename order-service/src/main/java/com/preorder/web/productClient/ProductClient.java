package com.preorder.web.productClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name ="product-service", url = "http://localhost:8082/api")
public interface ProductClient {

    @GetMapping("/orders/{pdId}")
    ProductResponse getMemberOrderList(@PathVariable("pdId") int pdId);
}
