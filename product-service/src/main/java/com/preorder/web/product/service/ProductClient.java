package com.preorder.web.product.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "product-service", url = "http://product-service/api")
public interface ProductClient {


}
