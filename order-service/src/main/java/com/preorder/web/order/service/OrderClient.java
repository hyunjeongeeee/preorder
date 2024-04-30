package com.preorder.web.order.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "order-service", url = "http://order-service/api")
public interface OrderClient {

}
