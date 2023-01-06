package com.shortenServer.services.impl;

import com.shortenServer.data.repositories.UserRepository;
import com.shortenServer.dtos.requests.CreateUserRequestDTO;
import com.shortenServer.dtos.requests.LoginRequestDTO;
import com.shortenServer.dtos.responses.CreateUserResponseDTO;
import com.shortenServer.dtos.responses.LoginResponseDTO;
import com.shortenServer.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreateUserResponseDTO createUser(CreateUserRequestDTO createUserRequestDTO) {
        return null;
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        return null;
    }

}
