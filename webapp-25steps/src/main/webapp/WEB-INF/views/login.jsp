<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

<div class="container">
	<div class="jumbotron">
		<h1>Welcome, This is MyWay...</h1>
		<h3>Please, login...</h3>
		<form action="/login.do" method="post">
			<div style="color: red">${errorMessage }</div>
			<div>
				Enter your name: <input type="text" name="name">
			</div>
			<div>
				Enter your password: <input type="password" name="password">
			</div>
			<div>
				<input type="submit" value="login">
			</div>
		</form>

	</div>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>