package com.preorder.web.product.service;

import com.preorder.domain.product.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product-service", url = "http://localhost:8082/api")
public interface ProductClient {

    @GetMapping("/products/{id}")
    Product findById(@PathVariable int id);

    @PostMapping("/products/list")
    List<Product> findByList(@RequestBody List<Product> products);

}