package com.shortenServer.services.impl;

import com.shortenServer.data.models.LinkEntity;
import com.shortenServer.data.models.UserEntity;
import com.shortenServer.data.repositories.LinkRepository;
import com.shortenServer.dtos.requests.CheckAvailabilityRequestDTO;
import com.shortenServer.dtos.requests.CreateLinkRequestDTO;
import com.shortenServer.dtos.requests.UpdateLinkRequestDTO;
import com.shortenServer.dtos.responses.CheckSlugAvailabilityResponseDTO;
import com.shortenServer.dtos.responses.LinkDTO;
import com.shortenServer.dtos.responses.Paginated;
import com.shortenServer.exceptions.specifics.LinkNotFoundException;
import com.shortenServer.exceptions.specifics.SlugNotAvailableException;
import com.shortenServer.services.LinkService;
import com.shortenServer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class LinkServiceImpl implements LinkService {

    private LinkRepository linkRepository;
    private UserService userService;
    private final int SLUG_LENGTH = 8;

    @Autowired
    public LinkServiceImpl(LinkRepository linkRepository, UserService userService) {
        this.linkRepository = linkRepository;
        this.userService = userService;
    }

    private static LinkDTO parseToDto(LinkEntity link) {
        return LinkDTO.builder()
                .id(link.getId())
                .title(link.getTitle())
                .description(link.getDescription())
                .slug(link.getSlug())
                .url(link.getUrl())
                .build();
    }

    private String generateSlug() {
        SecureRandom secureRandom = new SecureRandom();
        String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder slug = new StringBuilder();

        for (int i = 0; i < SLUG_LENGTH; i++) {
            int position = secureRandom.nextInt(charset.length());
            char character = charset.charAt(position);
            slug.append(character);
        }

        if (linkRepository.existsBySlug(slug.toString())){
            return generateSlug();
        }
        return slug.toString();
    }

    @Override
    public LinkDTO createLink(CreateLinkRequestDTO createLinkRequestDTO) {
        UserEntity user = userService.getAuthenticatedUser();
        LinkEntity savedLink = linkRepository.save(LinkEntity.builder()
                .title(createLinkRequestDTO.getTitle())
                .url(createLinkRequestDTO.getUrl())
                .description(createLinkRequestDTO.getDescription())
                .slug(generateSlug())
                .user(user)
                .build()
        );
        return parseToDto(savedLink);
    }

    @Override
    public LinkDTO updateLink(UpdateLinkRequestDTO updateLinkRequestDTO) {
        UserEntity user = userService.getAuthenticatedUser();
        LinkEntity savedLink = linkRepository.findByUserAndId(user, updateLinkRequestDTO.getId())
                .orElseThrow(LinkNotFoundException::new);

        if (linkRepository.existsBySlug(updateLinkRequestDTO.getSlug())
                && !savedLink.getSlug().equals(updateLinkRequestDTO.getSlug())){
            throw new SlugNotAvailableException();
        }

        savedLink.setUrl(updateLinkRequestDTO.getUrl());
        savedLink.setTitle(updateLinkRequestDTO.getTitle());
        savedLink.setDescription(updateLinkRequestDTO.getDescription());
        savedLink.setSlug(updateLinkRequestDTO.getSlug());

        LinkEntity updatedLink = linkRepository.save(savedLink);

        return parseToDto(updatedLink);
    }

    @Override
    public CheckSlugAvailabilityResponseDTO checkAvailability(CheckAvailabilityRequestDTO checkAvailabilityRequestDTO) {
        return null;
    }

    @Override
    public void deleteLink(Long id) {

    }

    @Override
    public Paginated<LinkDTO> getAllLinks() {
        return null;
    }

    @Override
    public LinkDTO getLink(Long id) {
        return null;
    }

}
