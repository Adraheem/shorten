package com.shortenServer.services.impl;

import com.shortenServer.data.repositories.LinkRepository;
import com.shortenServer.dtos.requests.CheckAvailabilityRequestDTO;
import com.shortenServer.dtos.requests.CreateLinkRequestDTO;
import com.shortenServer.dtos.requests.UpdateSlugRequestDTO;
import com.shortenServer.dtos.responses.CheckSlugAvailabilityResponseDTO;
import com.shortenServer.dtos.responses.LinkDTO;
import com.shortenServer.dtos.responses.Paginated;
import com.shortenServer.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService {

    private LinkRepository linkRepository;

    @Autowired
    public LinkServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public LinkDTO createLink(CreateLinkRequestDTO createLinkRequestDTO) {
        return null;
    }

    @Override
    public LinkDTO updateSlug(UpdateSlugRequestDTO updateSlugRequestDTO) {
        return null;
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
