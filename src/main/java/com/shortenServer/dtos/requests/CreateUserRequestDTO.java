package com.shortenServer.dtos.requests;

import lombok.Data;

@Data
public class CreateUserRequestDTO {

    private String username;

    private String fullName;

    private String password;

}
