<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

	<div style="min-height: 500px" class="container">
		<H1>Welcome ${name }</H1>
		<h3>Your Todos are,</h3>
		<ol>
			<table class="table table-striped">
				<c:forEach items="${todos }" var="todo">
					<tr>
						<td>${todo.name } </td>
						<td>
							<a class="btn btn-danger btn-sm" href="/delete-todo.do?todo=${todo.name }">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>	
		</ol>
		
		<div>
			<form action="/add-todo.do" method="post" class="form-inline">
				<div class="form-group">
					<label for="todo">New Todo: </label>
					<input id="todo" type="text" name="todo">
				</div>
				
				<button type="submit" class="btn btn-primary">Add</button>
			</form>
		</div>
	</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>