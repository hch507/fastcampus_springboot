package com.example.cours3_ch4.user.controller;

import com.example.cours3_ch4.user.model.UserEntity;
import com.example.cours3_ch4.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor // 생성자 매소드로 객체 생성
public class UserApiController {

    private final UserService userService;
    @PutMapping("")
    public UserEntity create(
            @RequestBody UserEntity userEntity
    ){
        return userService.save(userEntity);
    }

    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

}
