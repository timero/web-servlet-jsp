package com.epam.training;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.training.model.User;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    
    public static final String USER_PARAMETER = "user";
    public static final String REMEMBER_ME_COOKIE_NAME = "remember-me";
    private static final long serialVersionUID = 1L;
    private static final int ONE_MONTH_IN_SECONDS = 3600 * 24 * 31;
    private static final String ERROR_PAGE = "error";
    private static final String MAIN_PAGE = "index";
    private static final String ADMIN_PASSWORD = "Secret123";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String REMEMBER_ME_PARAMETER = REMEMBER_ME_COOKIE_NAME;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminUser = getServletContext().getInitParameter("admin-user");
        String username = req.getParameter(USER_PARAMETER);
        String password = req.getParameter(PASSWORD_PARAMETER);
        boolean rememberMe = req.getParameter(REMEMBER_ME_PARAMETER) != null;
        if (adminUser.equals(username) && ADMIN_PASSWORD.equals(password)) {
            req.getSession().invalidate();
            if (req.getSession(false) != null) {
                req.changeSessionId();
            }
            req.getSession().setAttribute(USER_PARAMETER, new User(username, true));
            if (rememberMe) {
                String id = UUID.randomUUID().toString();
                getServletContext().setAttribute(id, username);
                Cookie cookie = new Cookie(REMEMBER_ME_COOKIE_NAME, id);
                cookie.setMaxAge(ONE_MONTH_IN_SECONDS);
                resp.addCookie(cookie);
            }
            resp.sendRedirect(resp.encodeURL(MAIN_PAGE));
        } else {
            resp.sendRedirect(ERROR_PAGE);
        }
    }
}
