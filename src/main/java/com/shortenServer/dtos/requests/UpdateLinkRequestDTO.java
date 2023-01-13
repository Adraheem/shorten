package com.shortenServer.dtos.requests;

import lombok.Data;

@Data
public class UpdateLinkRequestDTO {

    private Long id;

    private String url, title, description, slug;

}
