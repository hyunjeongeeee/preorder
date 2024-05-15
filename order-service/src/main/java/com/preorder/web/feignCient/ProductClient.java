package com.preorder.web.feignCient;

import com.preorder.web.order.dto.ProductResponseDTO;
import com.preorder.web.order.dto.ProductStockResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// @FeignClient => 추상화
@FeignClient(name = "product-service" , url="http://localhost:8082/api/internal/products") // 적절한 URL로 교체
public interface ProductClient {
    // product-service 에서 특정 상품 정보를 가져오는 엔드포인트를 호출 (다른 서비스와 함께 조회할때)
    @GetMapping("/{productId}")
    ProductResponseDTO getProductById(@PathVariable(value = "productId") long productId);

    // product-service 에서 특정 상품 stock(재고정보)를 가져오는 엔드포인트를 호출
    @PostMapping("/{productId}/stock")
    ProductStockResponse getProductStock(@PathVariable(value = "productId") long productId, @RequestParam("productCount") int productCount);

    // product-service 에서 특정 상품 stock(재고정보)를 가져오는 엔드포인트를 호출
    @PostMapping("/{productId}/cancelStock")
    ProductStockResponse getProductStockForCancelOrder(@PathVariable(value = "productId") long productId, @RequestParam("productCount") int productCount);

}
