package com.shortenServer.dtos.requests;

import com.shortenServer.utils.RegexPattern;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CheckAvailabilityRequestDTO {

    @NotBlank(message = "Link id is required")
    private Long id;

    @Pattern(regexp = RegexPattern.SLUG, message = "Invalid slug")
    private String slug;

}
