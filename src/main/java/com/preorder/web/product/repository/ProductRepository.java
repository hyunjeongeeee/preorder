package com.preorder.web.product.repository;

import com.preorder.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

//    public Optional<Product> findById(long id);

}
