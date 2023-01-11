package com.shortenServer.exceptions.specifics;

import com.shortenServer.exceptions.ApiRequestException;
import org.springframework.http.HttpStatus;

public class InvalidLoginDetailsException extends ApiRequestException {

    public InvalidLoginDetailsException() {
        this("Incorrect login details");
    }

    public InvalidLoginDetailsException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
