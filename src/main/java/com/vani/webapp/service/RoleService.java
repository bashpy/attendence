package com.vani.webapp.service;

import com.vani.webapp.models.Roles;

import java.util.List;

/**
 * Created by hexad3cimal on 28/5/17.
 */
public interface RoleService {

    void addRole(Roles roles)throws Exception;
    List<Roles> rolesList() throws Exception;
    Roles getById(Integer roleId)throws Exception;
}
