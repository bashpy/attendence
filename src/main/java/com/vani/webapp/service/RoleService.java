package com.vani.webapp.service;

import com.vani.webapp.models.Role;

import java.util.List;

/**
 * Created by hexad3cimal on 28/5/17.
 */
public interface RoleService {

    void addRole(Role roles)throws Exception;
    List<Role> rolesList() throws Exception;
    Role getById(Integer roleId)throws Exception;
}
