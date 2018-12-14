<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/common/header.jsp"%>

<section>
	<h2>회원목록조회/수정</h2>

	<table border=1>
		<tr>
			<th>회원번호</th>
			<th>회원성명</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>가입일자</th>
			<th>고객등급</th>
			<th>거주지역</th>
		</tr>
		<c:forEach items="${list }" var="member">
		<tr>
			<td><a href="${pageContext.request.contextPath}/update?id=${member.member_num }">${member.member_num }</a></td>
			<td>${member.member_name }</td>
			<td>${member.member_phone }</td>
			<td>${member.member_address }</td>
			<td>${member.member_join_date }</td>
			<td>
				<c:if test="${member.member_title == 'A'}">
					VIP
				</c:if>
				<c:if test="${member.member_title == 'B'}">
					일반
				</c:if>
				<c:if test="${member.member_title == 'C'}">
					직원
				</c:if>
			</td>
			<td>${member.member_city }</td>
		</tr>
		</c:forEach>
	</table>

</section>

<script>
	
</script>
<%@ include file="/common/footer.jsp"%>