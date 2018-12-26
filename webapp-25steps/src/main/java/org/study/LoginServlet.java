package org.study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String name = new String(request.getParameter("name").getBytes("8859_1"), "utf-8");
		String name = request.getParameter("name");
//		System.out.println(name);
		// parameter to attribute
		request.setAttribute("name", name);
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	
}
