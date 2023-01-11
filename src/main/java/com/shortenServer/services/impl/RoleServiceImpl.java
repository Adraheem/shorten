package com.shortenServer.services.impl;

import com.shortenServer.data.models.RoleEntity;
import com.shortenServer.data.repositories.RoleRepository;
import com.shortenServer.exceptions.specifics.RoleNotFoundException;
import com.shortenServer.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleEntity getRoleByName(String name) throws RoleNotFoundException {
        return roleRepository.findByName(name).orElseThrow(RoleNotFoundException::new);
    }
}
