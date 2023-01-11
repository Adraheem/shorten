package com.shortenServer.exceptions.specifics;

import com.shortenServer.exceptions.ApiRequestException;
import org.springframework.http.HttpStatus;

public class UsernameAlreadyExistsException extends ApiRequestException {

    public UsernameAlreadyExistsException(){
        this("Username already exists");
    }

    public UsernameAlreadyExistsException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }

}
