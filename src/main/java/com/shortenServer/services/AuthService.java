package com.shortenServer.services;

import com.shortenServer.dtos.requests.CreateUserRequestDTO;
import com.shortenServer.dtos.requests.LoginRequestDTO;
import com.shortenServer.dtos.responses.CreateUserResponseDTO;
import com.shortenServer.dtos.responses.LoginResponseDTO;
import com.shortenServer.exceptions.specifics.InvalidLoginDetailsException;
import com.shortenServer.exceptions.specifics.RoleNotFoundException;
import com.shortenServer.exceptions.specifics.UsernameAlreadyExistsException;

public interface AuthService {

    CreateUserResponseDTO createUser(CreateUserRequestDTO createUserRequestDTO)
            throws UsernameAlreadyExistsException, RoleNotFoundException, InvalidLoginDetailsException;

    LoginResponseDTO login(LoginRequestDTO loginRequestDTO)
            throws InvalidLoginDetailsException;

}
