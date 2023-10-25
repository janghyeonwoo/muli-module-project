package com.multi.module.domain.product.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(name = "product")
@Entity
public class Product {


    @Column(name = "prd_idx")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long prdIdx;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price;

}
