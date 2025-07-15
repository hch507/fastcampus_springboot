package com.example.cours3_ch3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/b")
public class RestApiBController {

    @GetMapping(value = "/hello")
    public void hello(){

        throw new NumberFormatException("number format exception");
    }
}
