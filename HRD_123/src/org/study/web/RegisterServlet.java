package org.study.web;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.dao.HRDShopDao;
import org.study.model.Member;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	HRDShopDao dao = new HRDShopDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("register doget called...");
		
		try {
			int nextMemberId = dao.getNextMemberId();
			request.setAttribute("id", nextMemberId);
			Date date = new Date(System.currentTimeMillis());
			DateFormat format = new SimpleDateFormat("yyyyMMdd");
			request.setAttribute("today", format.format(date));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/views/registerForm.jsp").forward(request, response);
	}


	// AJAX call 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("register dopost called");
		
		Member member = new Member();
		member.setMember_num(Integer.parseInt(request.getParameter("member_num")));
		member.setMember_name(URLDecoder.decode(
				new String(request.getParameter("member_name").getBytes("iso-8859-1")), "UTF-8"));
		member.setMember_pw(request.getParameter("member_pw1"));
		member.setMember_phone(request.getParameter("member_phone"));
		member.setMember_address(URLDecoder.decode(
				new String(request.getParameter("member_address").getBytes("iso-8859-1")), "UTF-8"));
		
		System.out.println("join date: " + request.getParameter("member_join_date"));
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		try {
			java.util.Date join_date = format.parse(request.getParameter("member_join_date"));
			member.setMember_join_date(new Date(join_date.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		member.setMember_title(request.getParameter("member_title"));
		member.setMember_city(request.getParameter("member_city"));
		
		//System.out.println(member);
		
		try {
			if (dao != null) {
				if (dao.insertMember(member)) {
					System.out.println("dabase update success");
					
					return;
				} else {
					System.out.println("dabase update fail");
					response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	}

}
