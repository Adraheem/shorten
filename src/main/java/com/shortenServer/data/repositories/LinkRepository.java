package com.shortenServer.data.repositories;

import com.shortenServer.data.models.LinkEntity;
import com.shortenServer.data.models.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinkRepository extends
        PagingAndSortingRepository<LinkEntity, Long>,
        JpaRepository<LinkEntity, Long> {

    boolean existsBySlug(String slug);

    boolean existsByUserAndId(UserEntity user, Long id);

    Page<LinkEntity> findAllByUser(UserEntity user, Pageable pageable);

    Optional<LinkEntity> findByUserAndId(UserEntity user, Long id);

    Optional<LinkEntity> findBySlug(String slug);

}
