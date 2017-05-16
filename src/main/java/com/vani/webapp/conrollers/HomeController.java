package com.vani.webapp.conrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hexad3cimal on 16/5/17.
 */

@Controller
public class HomeController {

    @RequestMapping(value = "/home")
    public String getHomePage()throws Exception{

        return "home1";
    }
}
