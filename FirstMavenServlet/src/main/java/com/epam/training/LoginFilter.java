package com.epam.training;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.epam.training.model.User;

//@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest genericRequest, ServletResponse genericResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) genericRequest;
        request.setAttribute("a", "kecske");
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            cookies = new Cookie[0];
        }
        if (request.getSession().getAttribute(LoginServlet.USER_PARAMETER) == null) {
            for (Cookie cookie : cookies) {
                if (LoginServlet.REMEMBER_ME_COOKIE_NAME.equals(cookie.getName())) {
                    String id = cookie.getValue();
                    String username = (String) request.getServletContext().getAttribute(id);
                    if (username != null) {
                        request.getSession().setAttribute(LoginServlet.USER_PARAMETER, new User(username, true));
                    }
                }
            }
        }
        chain.doFilter(genericRequest, genericResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
