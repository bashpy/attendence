package com.vani.webapp.service;

import com.vani.webapp.dao.RoleDao;
import com.vani.webapp.models.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hexad3cimal on 28/5/17.
 */

@Service("RoleService")
@Transactional
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    public void addRole(Roles roles) throws Exception {
        roleDao.addRole(roles);
    }

    @Override
    public List<Roles> rolesList() throws Exception {
        return roleDao.rolesList();
    }

    @Override
    public Roles getById(Integer roleId) throws Exception {
        return roleDao.getById(roleId);
    }
}
