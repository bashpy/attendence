package com.vani.webapp.service;

import com.vani.webapp.models.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hexad3cimal on 14/5/17.
 */

public interface UserService {

    User getByEmail(String email)throws Exception;
    void addUser(User user)throws Exception;
    void updateUser(User user)throws Exception;


}
