package com.vani.webapp.service;

import com.vani.webapp.dao.RoleDao;
import com.vani.webapp.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by hexad3cimal on 28/5/17.
 */
@Service("RoleService")
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    public void addRole(Role roles) throws Exception {
        roleDao.addRole(roles);
    }

    @Override
    public List<Role> rolesList() throws Exception {
        return roleDao.rolesList();
    }

    @Override
    public Role getById(Integer roleId) throws Exception {
        return roleDao.getById(roleId);
    }
}
