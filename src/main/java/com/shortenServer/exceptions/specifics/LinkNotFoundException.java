package com.shortenServer.exceptions.specifics;

import com.shortenServer.exceptions.ApiRequestException;
import org.springframework.http.HttpStatus;

public class LinkNotFoundException extends ApiRequestException {

    public LinkNotFoundException() {
        this("Link ot found");
    }

    public LinkNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
