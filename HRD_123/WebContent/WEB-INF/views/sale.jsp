<%@page import="org.study.model.SaleRecord"%>
<%@page import="org.study.model.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="/common/header.jsp"%>

<section>
	<h2>회원매출조회</h2>

	<table border=1>
		<tr>
			<th>회원번호</th>
			<th>회원성명</th>
			<th>고객등급</th>
			<th>매출</th>
		</tr>
		
		<%
			List<SaleRecord> list = (List<SaleRecord>) request.getAttribute("list");
			for (SaleRecord sale : list) {
		%>
		<tr>
			<td><%= sale.getMember_num()%></td>
			<td><%= sale.getMember_name()%></td>
			<td><%= sale.getMember_title()%></td>
			<td><%= sale.getSale_total()%></td>
		</tr>
		<%} %>
	</table>

</section>

<script>
	
</script>
<%@ include file="/common/footer.jsp"%>