package com.vani.webapp.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Created by vani on 10/2/16.
 */
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(NoHandlerFoundException.class)
    public String handleError404()   {

        return "404";
    }



    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public String exception(Exception e) {
        e.printStackTrace();
        return "error";
    }

}
