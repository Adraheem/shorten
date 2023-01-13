package com.shortenServer.dtos.responses;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LinkDTO {

    private Long id;

    private String url, title, description, slug;

}
