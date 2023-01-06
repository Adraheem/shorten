package com.shortenServer.data.repositories;

import com.shortenServer.data.models.LinkEntity;
import com.shortenServer.data.models.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends PagingAndSortingRepository<LinkEntity, Long> {

    boolean existsBySlug(String slug);

    boolean existsByUserAndId(UserEntity user, Long id);

    Page<LinkEntity> findAllByUser(UserEntity user);

    LinkEntity findByUserAndId(UserEntity user, Long id);

}
