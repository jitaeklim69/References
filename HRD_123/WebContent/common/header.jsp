<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HRD 쇼핑물</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/common/hrd_shop.css">
</head>
<body>
	<header>
		<h1 class="title vcenter">쇼핑몰 회원관리 ver 1.0</h1>
	</header>
	<nav>
		<div class="navigation vcenter" >
			<a href="${pageContext.request.contextPath }/register">회원등록</a>
			<a href="${pageContext.request.contextPath }/list">회원목록조회/수정</a>
			<a href="${pageContext.request.contextPath }/saleList">회원매출조회</a>
			<a href="${pageContext.request.contextPath }/">홈으로.</a>
			<c:choose>
				<c:when test="${empty user }">
					<a style="float: right; margin-right: 10px;" href="${pageContext.request.contextPath }/login">로그인</a>
				</c:when>
				<c:otherwise>
					<a style="float: right; margin-right: 10px;" href="${pageContext.request.contextPath }/logout">로그아웃</a>
				</c:otherwise>
			</c:choose>
			
		</div>
	</nav>