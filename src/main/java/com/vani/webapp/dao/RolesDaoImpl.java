package com.vani.webapp.dao;

import com.vani.webapp.models.Roles;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hexad3cimal on 28/5/17.
 */

@Repository("RolesDao1")
public class RolesDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addRole(Roles roles) throws Exception {

        sessionFactory.getCurrentSession().save(roles);
    }

    @Override
    public List<Roles> rolesList() throws Exception {
        return sessionFactory.getCurrentSession().createCriteria(Roles.class).list();
    }

    @Override
    public Roles getById(Integer roleId) throws Exception {
        return (Roles)sessionFactory.getCurrentSession().createCriteria(Roles.class)
                .add(Restrictions.eq("id",roleId)).uniqueResult();
    }
}
