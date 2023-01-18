package com.shortenServer.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateLinkRequestDTO {

    @NotBlank(message = "url cannot be blank")
    private String url;

    @NotBlank(message = "title cannot be blank")
    private String title;

    private String description;

}
