package com.example.cours3_ch3.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping(path = "")
    public void hello1(){
        throw new RuntimeException("run time exception call");
    }


    @GetMapping(path = "sample2")
    public void hello2(){
        var list = List.of("hello");
        var element = list.get(1);
        log.info("element : {}",element);
    }
}
