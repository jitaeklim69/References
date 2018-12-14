package org.study.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.dao.HRDShopDao;
import org.study.model.SaleRecord;

/**
 * Servlet implementation class SaleListServlet
 */
@WebServlet("/saleList")
public class SaleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("saleList servlet called");
		
		HRDShopDao dao = new HRDShopDao();
		
		try {
			List<SaleRecord> list = dao.getSaleList();
			System.out.println(list);
			request.setAttribute("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/views/sale.jsp").forward(request, response);
	}

}
