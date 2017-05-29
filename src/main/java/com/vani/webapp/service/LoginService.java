package com.vani.webapp.service;


import com.vani.webapp.models.Roles;
import com.vani.webapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vani on 19/9/16.
 */

@Service("loginService")
public class LoginService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        try {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

            User user = userService.getByEmail(s);
            if (user != null) {

                Roles roles = user.getRoles();
                grantedAuthorities.add(new SimpleGrantedAuthority(roles.getRoleName()));

            }

            return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);

        } catch (Exception e) {

        }

        return null;
    }
}
