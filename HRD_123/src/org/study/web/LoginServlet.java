package org.study.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.study.dao.HRDShopDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		String pw = request.getParameter("pw");
		String orgPath = request.getParameter("orgReqPath");
		
		System.out.println("login(): Request--> " + request.getRequestURI());
		System.out.println("login() orgPath--> " + orgPath);
		HRDShopDao dao = new HRDShopDao();
		String name = null;
		try {
			name = dao.authenticateUser(id, pw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (name != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", name);
			
			if (orgPath.length() == 0) {
				response.sendRedirect(request.getContextPath() + "/");
			} else {
				response.sendRedirect(orgPath);
			}
		} else {
			request.setAttribute("error", "주어진 정보가 맞지 않습니다.");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}

}
