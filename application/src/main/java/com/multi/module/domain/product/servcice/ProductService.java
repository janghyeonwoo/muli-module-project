package com.multi.module.domain.product.servcice;
import com.multi.module.domain.product.entity.Product;
import com.multi.module.domain.product.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public Product findProduct(String prdName){
        return productRepository.findByProductName(prdName).get();
    }

}
