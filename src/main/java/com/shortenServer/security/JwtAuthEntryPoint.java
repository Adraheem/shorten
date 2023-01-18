package com.shortenServer.security;

import com.shortenServer.exceptions.ApiRequestExceptionResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
//        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, authException.getMessage());
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        response.getWriter().write(
                ApiRequestExceptionResponse
                        .builder()
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .message("Internal server error")
                        .build()
                        .toString()
        );
    }
}
