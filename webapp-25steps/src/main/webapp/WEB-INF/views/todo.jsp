<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Todo</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<style>
	.footer {
		position: absolute;
		bottom: 0;
		width: 100%;
		height: 60px;
		background-color: #f5f5f5;
		
	}
</style>
</head>

<body>

	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="/">MyWay</a>
	    </div>
	
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#">Home <span class="sr-only">(current)</span></a></li>
	        <li><a href="/todo.do">Todos</a></li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <li><a href="/login.do">Login</a></li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>

	<div class="container">
		<H1>Welcome ${name }</H1>
		<h3>Your Todos are,</h3>
		<ol>
			<c:forEach items="${todos }" var="todo">
				<li>${todo.name } <span><a href="/delete-todo.do?todo=${todo.name }">Delete</a></span>
				</li>
			</c:forEach>
		</ol>
		
		<div>
			<form action="/todo.do" method="post">
				New Todo: <input type="text" name="todo">
				<input type="submit" value="Add">
			</form>
		</div>
	</div>

	<div class="footer">
		<div class="panel panel-default">
			<div class='panel-body'>
				footer content
			</div>
		</div>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>