package com.shortenServer.data.repositories;

import com.shortenServer.data.models.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    boolean existsByName(String name);

}
