package com.multi.module.controller;

import com.multi.module.anno.AuthLogin;
import com.multi.module.domain.user.service.UserService;
import com.multi.module.dto.AdminInfoDto;
import com.multi.module.dto.MemberInfoDto;
import com.multi.module.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("user")
@RestController
public class UserController {

    private final UserService userService;


    @GetMapping
    public String findUserName(@RequestParam("userName") String userName){
        return userService.findByName(userName).getName();
    }


    @GetMapping("/login/psn")
    public ResponseEntity<MemberInfoDto> find(@AuthLogin MemberInfoDto memberInfoDto){
        return ResponseEntity.ok(memberInfoDto);
    }

    @GetMapping("/login/admin")
    public ResponseEntity<AdminInfoDto> find(@AuthLogin(type = UserRole.ADMIN) AdminInfoDto adminInfoDto){
        return ResponseEntity.ok(adminInfoDto);
    }

}
