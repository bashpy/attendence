package com.jovin.webapp.service;

import com.jovin.webapp.models.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hexad3cimal on 14/5/17.
 */

@Transactional
public interface UserService {

    User getByEmail(String email)throws Exception;

}
