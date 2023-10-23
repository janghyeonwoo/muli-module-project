package com.multi.module.domain.user.repo;

import com.multi.module.domain.user.entity.User;

public interface UserRepositoryCustom {
    User findByNames(String userName);
}
