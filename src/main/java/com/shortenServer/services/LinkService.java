package com.shortenServer.services;

import com.shortenServer.dtos.requests.CheckAvailabilityRequestDTO;
import com.shortenServer.dtos.requests.CreateLinkRequestDTO;
import com.shortenServer.dtos.requests.PaginationParamsDTO;
import com.shortenServer.dtos.requests.UpdateLinkRequestDTO;
import com.shortenServer.dtos.responses.LinkDTO;
import com.shortenServer.dtos.responses.Paginated;
import com.shortenServer.dtos.responses.SingleDataResponseDTO;

public interface LinkService {

    LinkDTO createLink(CreateLinkRequestDTO createLinkRequestDTO);

    LinkDTO updateLink(UpdateLinkRequestDTO updateLinkRequestDTO);

    SingleDataResponseDTO<Boolean> checkAvailability(CheckAvailabilityRequestDTO checkAvailabilityRequestDTO);

    void deleteLink(Long id);

    Paginated<LinkDTO> getAllLinks(PaginationParamsDTO params);

    LinkDTO getLink(Long id);

    SingleDataResponseDTO<String> getOriginalUrl(String slug);

}
