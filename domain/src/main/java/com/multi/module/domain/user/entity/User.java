package com.multi.module.domain.user.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_idx")
    private Long userIdx;

    @Column(name = "name")
    private String name;

}
