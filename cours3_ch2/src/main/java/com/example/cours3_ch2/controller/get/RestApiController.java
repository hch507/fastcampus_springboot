package com.example.cours3_ch2.controller.get;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {

//    @GetMapping(path = "/hello")
//    public String hello(){
//        return "Hello Spring boot";
//    }

    @GetMapping(path = "/hello")
    public String hello(){
        var html = "<html> <body> <h1> Hello Spring boot <h1> <body> <html>";
        return html;
    }
}
