package com.shortenServer.controllers;

import com.shortenServer.dtos.requests.CreateLinkRequestDTO;
import com.shortenServer.dtos.requests.PaginationParamsDTO;
import com.shortenServer.dtos.responses.LinkDTO;
import com.shortenServer.dtos.responses.Paginated;
import com.shortenServer.services.LinkService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@OpenAPIDefinition
@RequestMapping(value = "/api/v1/link")
public class LinkController {

    private LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @Operation( summary = "Create new link")
    @PostMapping("")
    public ResponseEntity<LinkDTO> createNewLink(@RequestBody @Valid CreateLinkRequestDTO request) {
        return new ResponseEntity<>(linkService.createLink(request), HttpStatus.OK);
    }

    @Operation(summary = "Get all links")
    @GetMapping("")
    public ResponseEntity<Paginated<LinkDTO>> getAllLinks(
            @Parameter(name = "size", description = "The number of links to return per page")
                @RequestParam Optional<Integer> size,
            @Parameter(name = "page", description = "Page to return")
                @RequestParam Optional<Integer> page) {

        PaginationParamsDTO params = PaginationParamsDTO.builder()
                .size(size.orElse(20))
                .page(page.orElse(0))
                .build();
        return new ResponseEntity<>(linkService.getAllLinks(params), HttpStatus.OK);
    }
}
