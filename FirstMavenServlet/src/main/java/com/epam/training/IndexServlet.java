package com.epam.training;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.training.model.User;

public class IndexServlet extends HttpServlet {

    private static final String VIEW = "index.jsp";
    private static final long serialVersionUID = 1L;

    public IndexServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute(LoginServlet.USER_PARAMETER);
        if (user != null && user.isAdmin()) {
            request.setAttribute("list", Arrays.asList(1, 2, 3, 4, 5, 6));
            Map<String, String> map = new HashMap<>();
            map.put("a", "a");
            map.put("b", "b");
            map.put("c", "c");
            request.setAttribute("map", map);
            request.setAttribute("version", getServletConfig().getInitParameter("Servlet version"));
            request.getRequestDispatcher(VIEW).forward(request, response);
        } else {
            request.getRequestDispatcher("error").forward(request, response);
        }
    }

}
