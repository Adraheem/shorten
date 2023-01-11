package com.shortenServer.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@ControllerAdvice
public class ApiRequestExceptionHandler {

    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<?> apiRequestExceptionHandler(ApiRequestException e){
        ApiRequestExceptionResponse response =
                ApiRequestExceptionResponse.builder()
                        .message(e.getMessage())
                        .status(e.getStatus())
                        .build();
        return new ResponseEntity<>(response, e.getStatus());
    }
}
