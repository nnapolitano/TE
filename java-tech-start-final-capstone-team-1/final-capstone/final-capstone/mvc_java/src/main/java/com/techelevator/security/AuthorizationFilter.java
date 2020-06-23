package com.techelevator.security;

import com.techelevator.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

public class AuthorizationFilter implements Filter {

    public static final String LOGGED_USER = "LOGGED_USER";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        User sessionUser = getUserFromSession(httpRequest);

        String urlRequested = httpRequest.getRequestURI();
        if (
                urlRequested.contains("/admin/") ||
                        urlRequested.contains("/restricted/") ||
                        urlRequested.contains("/user/")
            // Put more URLs here to lock down
        ) {

            if (sessionUser == null) {
                redirectToLoginPage(httpRequest, httpResponse);
            }
            //httpResponse.sendError(403);

        }
        chain.doFilter(request, response);
    }

    private void redirectToLoginPage(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
            throws IOException {

        String originalRequest = httpRequest.getRequestURL().toString();
        String queryString = httpRequest.getQueryString();
        if (queryString != null) {
            originalRequest = originalRequest + "?" + queryString;
        }

        String context = httpRequest.getServletContext().getContextPath();
        httpResponse.sendRedirect(context + "/login?destination=" + URLEncoder.encode(originalRequest, "UTF-8"));
    }

    private User getUserFromSession(HttpServletRequest httpRequest) {
        return (User) httpRequest.getSession().getAttribute(LOGGED_USER);
    }

    @Override
    public void destroy() {

    }

}
