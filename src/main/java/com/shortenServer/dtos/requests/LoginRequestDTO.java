package com.shortenServer.dtos.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginRequestDTO {

    private String username, password;

}
