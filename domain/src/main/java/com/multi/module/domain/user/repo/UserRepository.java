package com.multi.module.domain.user.repo;

import com.multi.module.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long>, UserRepositoryCustom {

}
