package com.vani.webapp.dao;

import com.vani.webapp.models.User;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by hexad3cimal on 14/5/17.
 */

@Repository("UserDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getByEmail(String email) throws Exception {
        return (User)sessionFactory.getCurrentSession().createCriteria(User.class)
                .setFetchMode("role", FetchMode.JOIN)
                .add(Restrictions.eq("email",email));
    }
}
