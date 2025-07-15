package com.example.cours3_ch3.controller;

import com.example.cours3_ch3.model.Api;
import com.example.cours3_ch3.model.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private static List<UserResponse> userList = List.of(
            UserResponse.builder()
                    .id("1")
                    .name("홍길동")
                    .age(10)
                    .build(),
            UserResponse.builder()
                    .id("2")
                    .name("유관순")
                    .age(11)
                    .build()

    );
    @GetMapping(value = "/id/{userId}")
    public Api<UserResponse> getUser(
            @PathVariable String userId
    ){
        var user = userList.stream().filter(
                it -> it.getId().equals(userId)
        ).findFirst().get();


        Api<UserResponse> response = Api.<UserResponse>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage("ok")
                .data(user)
                .build();

        return response;
    }
}
