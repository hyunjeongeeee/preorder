package com.preorder.web.product.controller;

import com.preorder.domain.product.Product;
import com.preorder.web.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")

public class ProductController {

    private final ProductService productService;

    /**
     * 상품 1개 조회
     * + 상품 상세보여주기
     */
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Integer id) {
        log.info("***************상품번호 : {} ***************", id);
        return productService.findById(id);
    }

    /**
     * 전체 상품목록 조회
     * */
    @RequestMapping("/list")
    public List<Product> getAllProducts() {
        List<Product> list = productService.findAll();

        for (Product product : list) {
            System.out.println("product: " + product);
        }

        return list;
    }



}
