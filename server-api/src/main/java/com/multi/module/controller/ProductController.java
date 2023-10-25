package com.multi.module.controller;


import com.multi.module.domain.product.entity.Product;

import com.multi.module.domain.product.servcice.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("product")
@RestController
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public ResponseEntity<Product> findProduct(@RequestParam("prdName") String prdName) {
        return ResponseEntity.ok(productService.findProduct(prdName));
    }

}
