package com.shortenServer.controllers;

import com.shortenServer.dtos.requests.CreateLinkRequestDTO;
import com.shortenServer.dtos.responses.LinkDTO;
import com.shortenServer.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/link")
public class LinkController {

    private LinkService linkService;

    @Autowired
    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("")
    public ResponseEntity<LinkDTO> createNewLink(@RequestBody CreateLinkRequestDTO request){
        return new ResponseEntity<>(linkService.createLink(request), HttpStatus.OK);
    }
}
