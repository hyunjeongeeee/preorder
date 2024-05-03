package com.preorder.web.order.service;

import com.preorder.domain.order.Orders;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service", url = "http://localhost:8083/api")
public interface OrderClient {


}
