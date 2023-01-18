package com.shortenServer.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiRequestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<?> apiRequestExceptionHandler(ApiRequestException e) {
        ApiRequestExceptionResponse response =
                ApiRequestExceptionResponse.builder()
                        .message(e.getMessage())
                        .status(e.getStatus())
                        .build();
        return new ResponseEntity<>(response, e.getStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode statusCode,
            WebRequest request) {

        Map<String, String> data = new HashMap<>();
        HttpStatus status = HttpStatus.BAD_REQUEST;

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()){
            data.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        InvalidRequestBodyExceptionResponse response =
                InvalidRequestBodyExceptionResponse.builder()
                        .data(data)
                        .message("Bad request")
                        .status(status)
                        .statusCode(status.value())
                        .build();

        return new ResponseEntity<>(response, status);
    }
}
