<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

	<div style="min-height: 500px" class="container">
		<H1>Welcome ${name }</H1>
		<h3 >Your Todos are, 
		<div style="text-align: right; display: inline-block; float: right; padding-right: 50px">
			<a class="btn btn-primary btn-sm" href="/add-todo.do">Add New Todo <span class="glyphicon glyphicon-plus"> </a>
		</div></h3>
		<ol>
			<table class="table table-striped">
				<thead>
					<th>Description</th>
					<th>Category</th>
					<th>Action</th>
				</thead>
				<c:forEach items="${todos }" var="todo">
					<tr>
						<td>${todo.name}</td>
						<td>${todo.category}</td>
						<td>
							<a class="btn btn-danger btn-sm" href="/delete-todo.do?todo=${todo.name }&category=${todo.category}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>	
		</ol>

	</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>