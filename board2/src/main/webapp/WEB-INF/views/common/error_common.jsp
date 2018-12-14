<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<h1>에러 내용</h1>

<h4>${exception.getMessage() }</h4>
<ul>
	<c:forEach items='${exception.getStackTrace() }' var='stack'>
		<li>${stack.toString() }</li>
	</c:forEach>
</ul>
<%@ include file="../common/footer.jspf"%>