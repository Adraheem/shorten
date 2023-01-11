package com.shortenServer.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ApiRequestException extends Exception {

    @Getter
    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public ApiRequestException(){
        this("API Request Error");
    }

    public ApiRequestException(String message){
        super(message);
    }

    public ApiRequestException(String message, HttpStatus status) {
        this(message);
        this.status = status;
    }
}
