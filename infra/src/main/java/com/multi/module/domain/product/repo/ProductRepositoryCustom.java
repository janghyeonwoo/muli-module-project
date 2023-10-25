package com.multi.module.domain.product.repo;

import com.multi.module.domain.product.entity.Product;

import java.util.Optional;

public interface ProductRepositoryCustom {
    Optional<Product> findByProductName(String prdName);
}
