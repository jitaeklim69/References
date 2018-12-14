package org.study.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	String[] excludedUrls;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		
		String path = request.getRequestURI();
		String docRoot = request.getContextPath();
		System.out.println("LoginFilter: doFilter()> uri: " + path + " docRoot: " + docRoot);
		System.out.println(path.split(docRoot)[1]);
		
		if (path.matches(".*(css|js)") )
		{
			arg2.doFilter(arg0, arg1);
			return;
		}
		
		for (String url : excludedUrls) {
			if (url.equals(path.split(docRoot)[1])) {
				arg2.doFilter(arg0, arg1);
				return;
			}
		}
		
		// session validation
		System.out.println("login needed....");
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("user");
		if (name != null) { // already logged in
			arg2.doFilter(request, response);
		} else {
			if (request.getQueryString() != null)
			{
				path = path + "?" + request.getQueryString();
			}
			request.setAttribute("orgReqPath", path);
			request.setAttribute("error", "먼저 로그인 하세요");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		String params = config.getInitParameter("excluded");
		//System.out.println("LoginFilter: param> " + params);
		excludedUrls = params.split(",");
		for (int i = 0; i < excludedUrls.length; i++) {
			excludedUrls[i] = excludedUrls[i].trim();
		}
		//System.out.println(Arrays.toString(excludedUrls));
	}

}
