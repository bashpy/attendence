package com.vani.webapp.service;


import com.vani.webapp.utils.GetCurrentUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by vani on 24/9/16.
 */

@Service("SessionService")
public class SessionService {

    @Autowired
    private GetCurrentUserDetails getCurrentUserDetails;



    public void populateSession(HttpServletRequest request)
                                            throws Exception{

        populateUserAndMenu(request);

    }

    public void populateUserAndMenu(HttpServletRequest request)throws Exception{
        request.getSession().setAttribute("user",getCurrentUserDetails.getDetails());

    }




}
