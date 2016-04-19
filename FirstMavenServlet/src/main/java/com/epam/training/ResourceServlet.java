package com.epam.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResourceServlet")
public class ResourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    PrintWriter writer = response.getWriter();
	    writer.append("ResourceServlet:" + ResourceServlet.class.getResource("./").toString() + "\n");
	    writer.append("ResourceServlet class loader:" + ResourceServlet.class.getClassLoader().getResource("./").toString()+ "\n");
	    writer.append("ResourceServlet Parent class loader:" + ResourceServlet.class.getClassLoader().getParent().getResource("./").toString()+ "\n");

	    InputStream resourceAsStream = ResourceServlet.class.getClassLoader().getResourceAsStream("./../../input.txt");
	    InputStreamReader isr = new InputStreamReader(resourceAsStream);
	    BufferedReader br = new BufferedReader(isr);
	    String content = br.readLine();
	    writer.append(content);
	
	    writer.append(ResourceServlet.class.getClassLoader().getResourceAsStream("./../../../../../../../../../../../input.txt").toString());
	}

}
