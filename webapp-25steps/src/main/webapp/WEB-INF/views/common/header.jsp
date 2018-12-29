<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<style>
	.footer {
		margin-top: 100px;
		padding: 20px;
		width: 100%;
		height: 60px;
		background-color: #2a2730;
		color: white;
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
	        <li><a href="/list-todo.do">Todos</a></li>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <li>
	        	<c:choose>
	        		<c:when test="${empty name }">
	        			<a href="/login.do">Login <span class="glyphicon glyphicon-user"></span></a>
	        		</c:when>
	        		<c:otherwise>
	        			<a href="/logout.do">Logout <span class="glyphicon glyphicon-off"></span></a>
	        		</c:otherwise>
	        	</c:choose>
	        </li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>