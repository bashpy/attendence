package com.jovin.webapp.dao;

import com.jovin.webapp.models.User;

/**
 * Created by hexad3cimal on 14/5/17.
 */
public interface UserDao {

    User getByEmail(String email)throws Exception;
}
