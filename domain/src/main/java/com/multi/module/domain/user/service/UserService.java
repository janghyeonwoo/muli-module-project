package com.multi.module.domain.user.service;

import com.multi.module.domain.user.entity.User;
import com.multi.module.domain.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User findByName(String userName){
        return userRepository.findByNames(userName);
    }


}
