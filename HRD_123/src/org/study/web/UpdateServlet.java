package org.study.web;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Date;
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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HRDShopDao dao = new HRDShopDao();
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		try {
			Member member = dao.getMemberInfo(id);
			request.setAttribute("member", member);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/views/updateForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("update post called");
		
		Member member = new Member();
		member.setMember_num(Integer.parseInt(request.getParameter("member_num")));
		member.setMember_name(URLDecoder.decode(
				new String(request.getParameter("member_name").getBytes("iso-8859-1")), "UTF-8"));
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
		
		HRDShopDao dao = new HRDShopDao();
		try {
			if (dao.updateMember(member)) {
				System.out.println("update member success");
				return;
			} else {
				System.out.println("update member fail");
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	}

}
