package com.shortenServer.data.repositories;

import com.shortenServer.data.models.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    boolean existsByName(String name);

    Optional<RoleEntity> findByName(String name);

}
