package com.shortenServer.exceptions.specifics;

import com.shortenServer.exceptions.ApiRequestException;
import org.springframework.http.HttpStatus;

public class SlugNotAvailableException extends ApiRequestException {

    public SlugNotAvailableException() {
        this("Slug not available");
    }

    public SlugNotAvailableException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
