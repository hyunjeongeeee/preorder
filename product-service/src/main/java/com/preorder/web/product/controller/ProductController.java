package com.preorder.web.product.controller;

import com.preorder.domain.product.Product;
import com.preorder.web.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * 상품 1개 조회
     * + 상품 상세보여주기
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") int id) {
        Product product =  productService.findOneProcess(id);
        return ResponseEntity.ok(product + product.toString());
    }

    /**
     * 전체 상품목록 조회
     * */
    @PostMapping("/list")
    public ResponseEntity<?> getAllProducts() {
        List<Product> list = productService.findAllProcess();
        return ResponseEntity.ok(list);
    }

}