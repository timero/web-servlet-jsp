package com.epam.training;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.training.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static final String USER_PARAMETER = "user";
    private static final String ERROR_PAGE = "error";
    private static final String MAIN_PAGE = "index";
    private static final String ADMIN_PASSWORD = "Secret123";
    private static final String PASSWORD_PARAMETER = "password";
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminUser = getServletContext().getInitParameter("admin-user");
        String username = req.getParameter(USER_PARAMETER);
        String password = req.getParameter(PASSWORD_PARAMETER);
        if (adminUser.equals(username) && ADMIN_PASSWORD.equals(password)) {
            if (req.getSession(false) != null) {
                req.changeSessionId();
            }
            req.getSession().setAttribute(USER_PARAMETER, new User(username, true));
            resp.sendRedirect(MAIN_PAGE);
        } else {
            resp.sendRedirect(ERROR_PAGE);
        }
    }
}
