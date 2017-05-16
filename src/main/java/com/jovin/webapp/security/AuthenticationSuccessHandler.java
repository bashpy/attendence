package com.jovin.webapp.security;


import com.jovin.webapp.service.SessionService;
import com.jovin.webapp.utils.GetCurrentUserDetails;
import com.jovin.webapp.utils.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component("authenticationSuccessHandler")
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {



    @Autowired
    private GetCurrentUserDetails getCurrentUserDetails;

    @Autowired
    private SessionService sessionService;


    private static final String USER_HOME_PAGE = "/";
    private static final String ADMIN_HOME_PAGE = "/admin/";

    private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws ServletException, IOException {

        //Save the initial request url
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        request.getSession().setMaxInactiveInterval(10*60);
        try {
            //populate the session objects
            sessionService.populateSession(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (savedRequest == null) {
            try {
                if (NotEmpty.notEmpty(getCurrentUserDetails.getDetails())) {

                    if(new String("Administrator").equals(getCurrentUserDetails.getDetails().getRole().getRoleName()))

                        getRedirectStrategy().sendRedirect(request, response, ADMIN_HOME_PAGE);
                    else
                        getRedirectStrategy().sendRedirect(request, response, USER_HOME_PAGE);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            //redirect to requested url after login

            return;
        }

        String targetUrlParameter = getTargetUrlParameter();

        if (isAlwaysUseDefaultTargetUrl()
                || (targetUrlParameter != null && StringUtils.hasText(request
                .getParameter(targetUrlParameter)))) {
            requestCache.removeRequest(request, response);
            super.onAuthenticationSuccess(request, response, authentication);

            return;
        }

        clearAuthenticationAttributes(request);
        String targetUrl = savedRequest.getRedirectUrl();
        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }


}
