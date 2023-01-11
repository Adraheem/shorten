package com.shortenServer.services.impl;

import com.shortenServer.data.models.RoleEntity;
import com.shortenServer.data.models.UserEntity;
import com.shortenServer.data.repositories.UserRepository;
import com.shortenServer.dtos.requests.CreateUserRequestDTO;
import com.shortenServer.dtos.requests.LoginRequestDTO;
import com.shortenServer.dtos.responses.CreateUserResponseDTO;
import com.shortenServer.dtos.responses.LoginResponseDTO;
import com.shortenServer.exceptions.specifics.InvalidLoginDetailsException;
import com.shortenServer.exceptions.specifics.RoleNotFoundException;
import com.shortenServer.exceptions.specifics.UsernameAlreadyExistsException;
import com.shortenServer.security.JwtGenerator;
import com.shortenServer.services.AuthService;
import com.shortenServer.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtGenerator tokenGenerator;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, RoleService roleService,
                           PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager,
                           JwtGenerator tokenGenerator) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.tokenGenerator = tokenGenerator;
    }

    @Override
    public CreateUserResponseDTO createUser(CreateUserRequestDTO createUserRequestDTO)
            throws UsernameAlreadyExistsException, RoleNotFoundException, InvalidLoginDetailsException {
        if (userRepository.existsByUsername(createUserRequestDTO.getUsername()))
            throw new UsernameAlreadyExistsException();

        RoleEntity userRole = roleService.getRoleByName("USER");

        UserEntity savedUser = userRepository.save(
                                    UserEntity.builder()
                                            .fullName(createUserRequestDTO.getFullName())
                                            .username(createUserRequestDTO.getUsername())
                                            .password(passwordEncoder.encode(createUserRequestDTO.getPassword()))
                                            .roles(Collections.singletonList(userRole))
                                            .build()
                            );
        LoginResponseDTO login = this.login(LoginRequestDTO.builder()
                        .username(savedUser.getUsername())
                        .password(savedUser.getPassword())
                        .build());
        return CreateUserResponseDTO.builder().token(login.getToken()).build();
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) throws InvalidLoginDetailsException {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword())
            );
            String token = tokenGenerator.generateToken(authentication);
            return LoginResponseDTO.builder().token(token).build();
        } catch (Exception e){
            throw new InvalidLoginDetailsException();
        }
    }

}
