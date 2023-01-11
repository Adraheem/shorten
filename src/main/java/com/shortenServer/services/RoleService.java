package com.shortenServer.services;

import com.shortenServer.data.models.RoleEntity;
import com.shortenServer.exceptions.specifics.RoleNotFoundException;

public interface RoleService {

    RoleEntity getRoleByName(String name) throws RoleNotFoundException;

    RoleEntity createNewRole(String name);

}
