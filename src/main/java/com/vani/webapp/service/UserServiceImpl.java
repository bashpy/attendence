package com.vani.webapp.service;

import com.vani.webapp.dao.UserDao;
import com.vani.webapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hexad3cimal on 14/5/17.
 */

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserDao userDao;

    @Override
    public User getByEmail(String email) throws Exception {
        return userDao.getByEmail(email);
    }
}
