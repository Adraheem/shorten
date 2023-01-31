package com.shortenServer.dtos.requests;

import com.shortenServer.utils.RegexPattern;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UpdateLinkRequestDTO {

    @NotNull(message = "id cannot be blank")
    private Long id;

    @NotBlank(message = "title cannot be blank")
    private String title;

    @NotBlank(message = "url cannot be blank")
    private String url;

    @Pattern(regexp = RegexPattern.SLUG, message = "Invalid slug provided")
    private String slug;

    private String description;

}
