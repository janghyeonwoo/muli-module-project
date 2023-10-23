package com.multi.module.domain.user.repo;

import com.multi.module.domain.user.entity.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.multi.module.domain.user.entity.QUser.user;

@RequiredArgsConstructor
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public User findByNames(String userName) {
        return jpaQueryFactory.select(user)
                .from(user)
                .where(user.name.eq(userName))
                .fetchOne();
    }
}
