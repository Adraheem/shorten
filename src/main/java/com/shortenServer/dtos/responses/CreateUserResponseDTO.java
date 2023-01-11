package com.shortenServer.dtos.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateUserResponseDTO {

    private String token;

}
