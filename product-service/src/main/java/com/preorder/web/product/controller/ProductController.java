package com.preorder.web.product.controller;

import com.preorder.domain.product.Product;
import com.preorder.web.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    /**
     * 전체 상품목록 조회
     * */
    @GetMapping("")
    public ResponseEntity<List<Product>> getProductList() {
        List<Product> products = productService.findAllProcess();
        return ResponseEntity.ok(products);
    }

    /**
     * 상품 1개 상세정보 조회
     *
     * @return
     */
    @GetMapping("/{pdId}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable("pdId") int pdId) {
        Optional<Product> product = productService.findOneProcess(pdId);
        return ResponseEntity.ok(product);
    }

}