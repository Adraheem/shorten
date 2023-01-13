package com.shortenServer.exceptions.specifics;

import com.shortenServer.exceptions.ApiRequestException;
import org.springframework.http.HttpStatus;

public class UnauthorizedRequestException extends ApiRequestException {

    public UnauthorizedRequestException() {
        this("Unauthorized requests");
    }

    public UnauthorizedRequestException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
