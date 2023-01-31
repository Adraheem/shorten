package com.shortenServer.dtos.requests;

import com.shortenServer.utils.RegexPattern;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateUserRequestDTO {

    @NotBlank(message = "username is required")
    @Email(message = "Invalid email address")
    private String username;

    private String fullName;

    @Pattern(regexp = RegexPattern.PASSWORD,
            message = "Password must be between 8 - 64 characters and must contain at least 1 uppercase, 1 lowercase," +
                    " 1 number and 1 special " +
                    "character")
    @NotBlank(message = "password is required")
    private String password;

}
