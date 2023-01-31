package com.shortenServer.controllers;

import com.shortenServer.dtos.requests.CheckAvailabilityRequestDTO;
import com.shortenServer.dtos.requests.CreateLinkRequestDTO;
import com.shortenServer.dtos.requests.PaginationParamsDTO;
import com.shortenServer.dtos.requests.UpdateLinkRequestDTO;
import com.shortenServer.dtos.responses.LinkDTO;
import com.shortenServer.dtos.responses.Paginated;
import com.shortenServer.dtos.responses.SingleDataResponseDTO;
import com.shortenServer.services.LinkService;
import com.shortenServer.utils.RegexPattern;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    @Operation(summary = "Create new link")
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

    @Operation(summary = "Get link")
    @GetMapping("/{id}")
    public ResponseEntity<LinkDTO> getLink(
            @Parameter(name = "id", description = "The id of the link")
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(linkService.getLink(id), HttpStatus.OK);
    }

    @Operation(summary = "Update link")
    @PatchMapping("")
    public ResponseEntity<LinkDTO> updateLink(@RequestBody @Valid UpdateLinkRequestDTO updateLinkRequestDTO) {
        return new ResponseEntity<>(linkService.updateLink(updateLinkRequestDTO), HttpStatus.OK);
    }

    @Operation(summary = "Delete link")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLink(
            @Parameter(name = "id", description = "The id of the link to be deleted")
            @PathVariable Long id) {
        linkService.deleteLink(id);
        return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
    }

    @Operation(summary = "Check slug availability")
    @GetMapping("/check")
    public ResponseEntity<SingleDataResponseDTO<Boolean>> checkSlugAvailability(
            @Parameter(name = "slug", description = "The new slug to be checked")
            @Pattern(regexp = RegexPattern.SLUG, message = "Invalid slug")
            @RequestParam String slug,

            @Parameter(name = "id", description = "The id of the link to be checked")
            @Valid
            @NotBlank(message = "id is required")
            @RequestParam Long id
    ) {
        CheckAvailabilityRequestDTO request = CheckAvailabilityRequestDTO
                .builder()
                .id(id)
                .slug(slug)
                .build();
        return new ResponseEntity<>(linkService.checkAvailability(request), HttpStatus.OK);
    }

    @Operation(summary = "Get original url")
    @GetMapping("/get-original-url")
    public ResponseEntity<SingleDataResponseDTO<String>> getOriginalUrl(
            @Parameter(name = "slug")
            @RequestParam String slug) {
        return new ResponseEntity<>(linkService.getOriginalUrl(slug), HttpStatus.OK);
    }
}
