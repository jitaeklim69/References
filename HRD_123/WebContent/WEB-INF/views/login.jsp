<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/common/header.jsp"%>

<section>
	<h2>회원 로그인</h2>

	<form action="${pageContext.request.contextPath }/login" method="post">
		<input type="hidden" name="orgReqPath" value="${orgReqPath }">
		<table>
			<caption>
				<div style="color:red">${error }</div>
			</caption>
			<tr>
				<td>회원번호: </td>
				<td><input type='text' name='id'></td>
			</tr>
			<tr>
				<td>비밀번호: </td>
				<td><input type='password' name='pw'></td>
			</tr>
			<tr>
				<td colspan='2'><input type='submit' value='로그인'></td>
			</tr>
		</table>
	</form>

</section>

<script>
	
</script>
<%@ include file="/common/footer.jsp"%>