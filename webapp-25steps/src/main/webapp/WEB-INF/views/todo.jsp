<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Todo</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h1>Todo Page - ${name }</h1>

	<div>
		<h3>Your Todo's are, </h3>
		<ol>
			<c:forEach items="${todos }" var="todo">
				<li>${todo.name} <span><a href="/delete-todo.do?todo=${todo.name}">Delete</a></span></li>
			</c:forEach>
		</ol>
	</div>
	
	<div>
		<form action="/todo.do" method="post">
			<div>
				New Todo: <input type="text" name="todo">
			</div>
			<div>
				<input type="submit" value="Add">
			</div>
		</form>
	</div>
	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>