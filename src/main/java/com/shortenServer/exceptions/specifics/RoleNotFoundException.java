package com.shortenServer.exceptions.specifics;

import com.shortenServer.exceptions.ApiRequestException;
import org.springframework.http.HttpStatus;

public class RoleNotFoundException extends ApiRequestException {

    public RoleNotFoundException() {
        this("Role not found");
    }

    public RoleNotFoundException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
