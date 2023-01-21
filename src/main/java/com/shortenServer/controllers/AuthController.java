package com.shortenServer.controllers;

import com.shortenServer.dtos.requests.CreateUserRequestDTO;
import com.shortenServer.dtos.requests.LoginRequestDTO;
import com.shortenServer.dtos.responses.CreateUserResponseDTO;
import com.shortenServer.dtos.responses.LoginResponseDTO;
import com.shortenServer.exceptions.specifics.InvalidLoginDetailsException;
import com.shortenServer.exceptions.specifics.RoleNotFoundException;
import com.shortenServer.exceptions.specifics.UsernameAlreadyExistsException;
import com.shortenServer.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<CreateUserResponseDTO> signup(@Valid @RequestBody CreateUserRequestDTO request)
            throws UsernameAlreadyExistsException, InvalidLoginDetailsException, RoleNotFoundException {
        return new ResponseEntity<>(authService.createUser(request), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO request)
            throws InvalidLoginDetailsException {
        return new ResponseEntity<>(authService.login(request), HttpStatus.OK);
    }
}
