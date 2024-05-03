package com.preorder.web.product.service;

import com.preorder.domain.product.Product;
import com.preorder.web.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class FeignService {
    private ProductRepository productRepository;

    public FeignService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

}
