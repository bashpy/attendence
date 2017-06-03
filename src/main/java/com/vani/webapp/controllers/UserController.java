package com.vani.webapp.controllers;

import com.vani.webapp.dto.UserDTO;
import com.vani.webapp.models.Role;
import com.vani.webapp.models.User;
import com.vani.webapp.service.RoleService;
import com.vani.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Date;

/**
 * Created by hexad3cimal on 28/5/17.
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/app/user/add")
    public String addUserPage()throws Exception{

        return "adduser";
    }


    @RequestMapping("/app/user/add/post")
    @ResponseBody
    public ResponseEntity<?> userAdd(@Valid @RequestBody UserDTO user, BindingResult result)throws Exception{


        if(result.hasErrors())
        {
            return new ResponseEntity<Object>("error",HttpStatus.BAD_REQUEST);
        }
        User userObject = new User();

        userObject.setCreatedTimeStamp(new Date());
        userObject.setPassword(user.getPassword());
        userObject.setFullName(user.getFullName());
        userObject.setPhoneNumber(user.getPhoneNo());
        userObject.setEmail(user.getEmail());

        Role roles = roleService.getById(user.getRole());
        userObject.setRole(roles);

        if(user.getId() != 0)
        {
            userService.updateUser(userObject);
            return new ResponseEntity<Object>("success", HttpStatus.OK);
        }
        userService.addUser(userObject);
        return new ResponseEntity<Object>("success", HttpStatus.OK);
    }
}
