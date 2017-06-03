package com.vani.webapp.dao;

import com.vani.webapp.models.Role;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hexad3cimal on 28/5/17.
 */

@Transactional
@Repository("RolesDao")
public class RolesDaoImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addRole(Role roles) throws Exception {

        sessionFactory.getCurrentSession().save(roles);
    }

    @Override
    public List<Role> rolesList() throws Exception {

        List<Role> roles = sessionFactory.getCurrentSession().createCriteria(Role.class).list();

        System.out.println("Roleeee"+roles.get(0));
        return sessionFactory.getCurrentSession().createCriteria(Role.class).list();
    }

    @Override
    public Role getById(Integer roleId) throws Exception {
        return (Role)sessionFactory.getCurrentSession().createCriteria(Role.class)
                .add(Restrictions.eq("id",roleId)).uniqueResult();
    }
}
