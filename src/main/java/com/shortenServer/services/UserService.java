package com.shortenServer.services;

import com.shortenServer.dtos.requests.ChangePasswordRequestDTO;
import com.shortenServer.dtos.requests.CreateUserRequestDTO;
import com.shortenServer.dtos.requests.LoginRequestDTO;
import com.shortenServer.dtos.requests.UpdateUserRequestDTO;
import com.shortenServer.dtos.responses.ChangePasswordResponseDTO;
import com.shortenServer.dtos.responses.CreateUserResponseDTO;
import com.shortenServer.dtos.responses.LoginResponseDTO;
import com.shortenServer.dtos.responses.UserDTO;

public interface UserService {

    UserDTO updateUser(UpdateUserRequestDTO updateUserRequestDTO);

    UserDTO getUser();

    ChangePasswordResponseDTO changePassword(ChangePasswordRequestDTO changePasswordRequestD);

}
