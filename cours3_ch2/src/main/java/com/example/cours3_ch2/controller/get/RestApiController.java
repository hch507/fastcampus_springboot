package com.example.cours3_ch2.controller.get;

import com.example.cours3_ch2.model.BookParam;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping(path = "/echo/{message}")
//    public String echo(
//            @PathVariable String message
//    ){
//        System.out.println("echo message : "+ message);
//        return message;
//    }

    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
            @PathVariable String message,
            @PathVariable int age,
            @PathVariable boolean isMan
    ){
        System.out.println("echo message : "+ message);
        System.out.println("echo message : "+ age);
        System.out.println("echo message : "+ isMan);

        return message;
    }

    @GetMapping(path = "/book")
    public void queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam(name = "issued_day") String issuedDay
    ){
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }

    @GetMapping(path = "/book2")
    public void queryParam2(
            BookParam bookParam
    ){
        System.out.println(bookParam);
    }
}
