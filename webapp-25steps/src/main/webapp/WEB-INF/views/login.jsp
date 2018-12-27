<%@page import="java.util.Locale"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Todo - Login</title>
</head>
<body>
	<h1>Login Page</h1>
	<form action="/login.do" method="post">
		<div>Enter your name: <input type="text" name="name"></div>
		<div><input type="submit" value="login"></div>
	</form>
</body>
</html>