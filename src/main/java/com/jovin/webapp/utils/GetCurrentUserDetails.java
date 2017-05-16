package com.jovin.webapp.utils;


import com.jovin.webapp.models.User;
import com.jovin.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


/**
 * Created by jovin on 12/4/16.
 */

//for providing the logged in user object in the controllers
@Component("GetCurrentUserDetails")
public class GetCurrentUserDetails {

    @Autowired
    private UserService userService;


      public User getDetails() throws Exception {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            User user = userService.getByEmail(auth.getName());
            return user;

        }else
            throw  new Exception("User not found");
    }
}
