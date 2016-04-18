package com.epam.training;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secret")
public class SecretServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, 
            HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");
        if ("epam".equals(user)) {
            resp.getOutputStream().println("Secret!!!");
        } else {
            resp.getOutputStream().println("Not authorized!!!");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, 
            HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


    
    
}
