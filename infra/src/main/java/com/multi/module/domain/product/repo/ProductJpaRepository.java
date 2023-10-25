package com.multi.module.domain.product.repo;

import com.multi.module.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product,Long> {
}
