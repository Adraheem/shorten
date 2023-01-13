package com.shortenServer.services.impl;

import com.shortenServer.data.models.UserEntity;
import com.shortenServer.data.repositories.UserRepository;
import com.shortenServer.dtos.requests.ChangePasswordRequestDTO;
import com.shortenServer.dtos.requests.CreateUserRequestDTO;
import com.shortenServer.dtos.requests.LoginRequestDTO;
import com.shortenServer.dtos.requests.UpdateUserRequestDTO;
import com.shortenServer.dtos.responses.ChangePasswordResponseDTO;
import com.shortenServer.dtos.responses.CreateUserResponseDTO;
import com.shortenServer.dtos.responses.LoginResponseDTO;
import com.shortenServer.dtos.responses.UserDTO;
import com.shortenServer.exceptions.specifics.UnauthorizedRequestException;
import com.shortenServer.security.AuthenticatedUser;
import com.shortenServer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO updateUser(UpdateUserRequestDTO updateUserRequestDTO) {
        return null;
    }

    @Override
    public UserDTO getUser() {
        return null;
    }

    @Override
    public ChangePasswordResponseDTO changePassword(ChangePasswordRequestDTO changePasswordRequestD) {
        return null;
    }

    @Override
    public UserEntity getAuthenticatedUser() throws UnauthorizedRequestException {
        AuthenticatedUser authenticatedUser =
                (AuthenticatedUser) SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal();

        return userRepository.findByUsername(authenticatedUser.getUsername()).orElseThrow(
                UnauthorizedRequestException::new
        );
    }

}
