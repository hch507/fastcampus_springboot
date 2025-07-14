package com.example.cours3_ch2.controller.post;

import com.example.cours3_ch2.model.BookRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiControlloer {

    @PostMapping("/post")
    public BookRequest post(
        @RequestBody BookRequest bookRequest
    ){
        System.out.println(bookRequest);
        return bookRequest;
    }

}
