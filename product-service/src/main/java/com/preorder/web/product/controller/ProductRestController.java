package com.preorder.web.product.controller;

import com.preorder.web.product.dto.ProductRequestDTO;
import com.preorder.web.product.dto.ProductStockRequest;
import com.preorder.web.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/internal/products")
public class ProductRestController {

    private final ProductService productService;

    /**
     * 상품 1개 상세정보 조회
     */
    @GetMapping("/{productId}")
    public ProductRequestDTO getProductByPdId(@PathVariable("productId") long productId) {
        return productService.getProductById(productId);
    }

    /**
     * 재고 수량 관리용
     * 주문했을경우 수량 -1개 처리
     * */
    @PostMapping("/{productId}/stock")
    public ProductStockRequest updateStock(@PathVariable("productId") long productId, @RequestParam("productCount") int productCount) {
        return productService.updateProductStock(productId, productCount);
    }

}