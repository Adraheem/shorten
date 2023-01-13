package com.shortenServer.dtos.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginationParamsDTO {

    @Builder.Default
    private int size = 20, page = 0;

}
