package com.vani.webapp.controllers;

import com.vani.webapp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hexad3cimal on 28/5/17.
 */

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/app/role/list")
    @ResponseBody
    public ResponseEntity<?> getRoles() throws Exception{

        return new ResponseEntity<Object>(roleService.rolesList(), HttpStatus.OK);
    }
}
