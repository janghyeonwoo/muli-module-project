package com.multi.module.domain.product.repo;

import com.multi.module.domain.product.entity.Product;
import com.multi.module.domain.product.entity.QProduct;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.multi.module.domain.product.entity.QProduct.product;


@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository, ProductRepositoryCustom {
    private final ProductJpaRepository productJpaRepository;
    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public Optional<Product> findByProductName(String prdName) {
        return Optional.ofNullable(jpaQueryFactory.
                select(product)
                .from(product)
                .where(product.name.eq(prdName))
                .fetchOne());


    }

    @Override
    public Optional<Product> findById(Long prdIdx) {
        return productJpaRepository.findById(prdIdx);
    }

}
