<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

	<div style="min-height: 500px" class="container">
		<H1>Welcome ${name }</H1>
		<h3>Your New Todo: </h3>
		
		<div>
			<form action="/add-todo.do" method="post">
				<div class="form-group">
					<label for="desc">Description: </label>
					<input id="desc" type="text" name="todo" class="form-control">
				</div>
				<div class="form-group">
					<label for="category">Category: </label>
					<input id="category" type="text" name="category" class="form-control">
				</div>
				<button type="submit" class="btn btn-primary">Add New Todo</button>
			</form>
		</div>
	</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>