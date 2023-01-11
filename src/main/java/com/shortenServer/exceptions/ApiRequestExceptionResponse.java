package com.shortenServer.exceptions;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiRequestExceptionResponse {

    private String message;
    private HttpStatus status;

}
