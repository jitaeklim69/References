<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="./common/header.jspf"%>
<%@ include file="./common/navigation.jspf"%>

<h1>Login Page for 게시판</h1>

<p style="color:red">${error }</p>
<form name='loginForm' action='/login' method='POST'>
	<input type='hidden' name='${_csrf.parameterName }' value='${_csrf.token }' />
	
	<table class="table">
		<tr>
			<td>User:</td>
			<td><input type='text' name="username"></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type='password' name='password'></td>
		</tr>
		<tr>
			<td><input type='submit' value='로그인' /></td>
			<td><input type='reset' value='초기화' /></td>
		</tr>
	</table>
</form>


<P>The time on the server is ${serverTime}.</P>

<%@ include file="./common/footer.jspf"%>