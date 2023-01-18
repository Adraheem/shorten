package com.shortenServer.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateUserRequestDTO {

    @NotBlank(message = "username is required")
    @Pattern(regexp = "^([\\w.\\-_]+)?\\w+@[\\w-_]+(\\.\\w{2,})+$",
            flags = {Pattern.Flag.CASE_INSENSITIVE},
            message = "Invalid email address")
    private String username;

    private String fullName;

    @Pattern(regexp = "^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{8,64})$",
            message = "Password must contain at least 1 uppercase, 1 lowercase, 1 number and 1 special " +
                    "characters")
    @NotBlank(message = "password is required")
    private String password;

}
