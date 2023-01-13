package com.shortenServer.dtos.requests;

import lombok.Data;

@Data
public class CreateLinkRequestDTO {

    private String url, title, description;

}
