package com.shortenServer.data.repositories;

import com.shortenServer.data.models.LinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkRepository extends JpaRepository<LinkEntity, Long> {

    boolean existsBySlug(String slug);

}
