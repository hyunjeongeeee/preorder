package com.preorder.web.product.service;

import com.preorder.domain.product.Product;
import com.preorder.web.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * 상품 1개 조회
     * + 상품 상세보여주기
     */
    public Product findOneProcess(int id) {
        return productRepository.findById(id).orElse(null);
    }

    /**
     *  전체 상품목록 조회
     * */
    public List<Product> findAllProcess() {
        return productRepository.findAll();

    }

}
