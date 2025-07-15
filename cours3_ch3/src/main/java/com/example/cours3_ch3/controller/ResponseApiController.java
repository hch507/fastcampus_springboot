package com.example.cours3_ch3.controller;


import com.example.cours3_ch3.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/vi")
public class ResponseApiController {

    // object return
    @GetMapping("")
    public UserRequest user() {
        var user = new UserRequest();
        user.setUserName("홀길동");
        user.setUserAge(10);
        user.setEmail("hch");

        log.info("user: {}", user);

        return user;
    }

    // responsebody return
    @GetMapping("sample2")
    public ResponseEntity user2() {
        var user = new UserRequest();
        user.setUserName("홀길동");
        user.setUserAge(10);
        user.setEmail("hch");

        log.info("user: {}", user);
        var response = ResponseEntity.status(HttpStatus.OK).body(user);
        return response;
    }

    @GetMapping("sample3")
    public ResponseEntity user3() {
        var user = new UserRequest();
        user.setUserName("홀길동");
        user.setUserAge(10);
        user.setEmail("hch");

        log.info("user: {}", user);
        var response = ResponseEntity
                .status(HttpStatus.OK)
                .header("x-custom","hi")
                .body(user);
        return response;
    }
}
