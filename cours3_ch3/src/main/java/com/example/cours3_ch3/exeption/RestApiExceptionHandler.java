package com.example.cours3_ch3.exeption;

import com.example.cours3_ch3.controller.RestApiBController;
import com.example.cours3_ch3.controller.RestApiController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//global exception
@Slf4j
//@RestControllerAdvice(basePackages = "com.example.coure3_ch3.controller")
@RestControllerAdvice(basePackageClasses = {RestApiController.class, RestApiBController.class})
public class RestApiExceptionHandler {

    // 전체 exception handler
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity exception(
            Exception e
    ){
        log.error("",e);
        return ResponseEntity
                .status(200)
                .build();
    }

    @ExceptionHandler(value ={IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(
            IndexOutOfBoundsException e
    ){
        log.error("",e);
        return ResponseEntity
                .status(200)
                .build();
    }
}
