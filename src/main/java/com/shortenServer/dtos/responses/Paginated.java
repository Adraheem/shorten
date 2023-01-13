package com.shortenServer.dtos.responses;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Paginated<T> {

    private int totalPages;

    private long totalElements;

    private List<T> data = new ArrayList<>();

    public Paginated(Page<?> page){
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
    }

}
