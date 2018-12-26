<%@page import="java.util.Locale"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Todo - From JSP</title>
</head>
<body>
<%
	System.out.println(request.getParameter("name"));
	Date date = new Date();
%>
	<h1>My First JSP</h1>
	<p>Hello, ${name}</p>
	<div>current time: <%= date %></div>
</body>
</html>