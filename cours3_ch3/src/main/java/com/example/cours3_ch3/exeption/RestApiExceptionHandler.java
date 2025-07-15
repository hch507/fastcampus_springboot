package com.example.cours3_ch3.exeption;

import com.example.cours3_ch3.controller.RestApiBController;
import com.example.cours3_ch3.controller.RestApiController;
import com.example.cours3_ch3.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

//global exception
@Slf4j
//@RestControllerAdvice(basePackages = "com.example.coure3_ch3.controller")
@Order(1)
@RestControllerAdvice(basePackageClasses = {RestApiController.class, RestApiBController.class})
public class RestApiExceptionHandler {

    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(
            IndexOutOfBoundsException e
    ) {
        log.error("", e);
        return ResponseEntity
                .status(200)
                .build();
    }

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<Api> noSuchElement(
            NoSuchElementException e
    ) {
        var response = Api.builder()
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
