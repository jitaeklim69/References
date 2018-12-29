<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

	<div style="min-height: 500px" class="container">
		<H1>Welcome ${name }</H1>
		<h3>Your New Todo: </h3>
		
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