package com.preorder.web.product.service;

import com.preorder.domain.product.Product;
import com.preorder.web.product.dto.ProductRequestDTO;
import com.preorder.web.product.dto.ProductStockRequest;
import com.preorder.web.product.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    /**
     *  전체 상품목록 조회
     * */
    public List<Product> findAllProcess() {
        return productRepository.findAll();
    }

    /**
     * 상품 1개 상세정보 조회
     */
    public Optional<Product> findOneProcess(int id) {
        return productRepository.findByProductId(id);
    }

    /**
     * Order-service 통신용
     * */
    // ID로 상품 정보를 조회하여 DTO로 변환
    public ProductRequestDTO getProductById(long productId) {
        Product product = productRepository.findByProductId(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        ProductRequestDTO productDTO = new ProductRequestDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());
        productDTO.setProductPrice(product.getProductPrice());
        return productDTO;
    }

    /**
     * 재고 수량 관리용
     * 주문했을경우 수량 -pdCount  처리
     * => product 테이블
     * */
    @Transactional
    public ProductStockRequest updateProductStock(long productId, int productCount) {
        Product product = productRepository.findByProductId(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setProductStock(product.getProductStock() - productCount);
        productRepository.save(product);  // 주문 수량만큼 빼고 수량 업데이트(저장)
        return new ProductStockRequest(product.getProductId(), product.getProductStock());
    }

}
