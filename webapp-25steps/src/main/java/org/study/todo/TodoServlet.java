package org.study.todo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.study.todo.TodoService;

@WebServlet(urlPatterns = "/todo.do")
public class TodoServlet extends HttpServlet{

	private TodoService todoService = new TodoService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("todos", todoService.retrieveTodos());
		request.getRequestDispatcher("/WEB-INF/views/todo.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		String newTodo = request.getParameter("todo");
		todoService.addTodo(new Todo(newTodo));
		
//		request.setAttribute("todos", todoService.retrieveTodos());
//		request.getRequestDispatcher("/WEB-INF/views/todo.jsp").forward(request, response);
		response.sendRedirect("/todo.do");
	}
}
