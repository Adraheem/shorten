package com.shortenServer.services;

import com.shortenServer.dtos.requests.CreateUserRequestDTO;
import com.shortenServer.dtos.requests.LoginRequestDTO;
import com.shortenServer.dtos.responses.CreateUserResponseDTO;
import com.shortenServer.dtos.responses.LoginResponseDTO;

public interface AuthService {

    CreateUserResponseDTO createUser(CreateUserRequestDTO createUserRequestDTO);

    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);

}
