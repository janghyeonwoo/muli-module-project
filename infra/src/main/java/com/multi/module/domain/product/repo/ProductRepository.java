package com.multi.module.domain.product.repo;

import com.multi.module.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends ProductRepositoryCustom{
    Optional<Product> findById(Long id);
}
