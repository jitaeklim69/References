<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/header.jsp"%>

<section>
	<h2>홈쇼핑 회원 정보 수정</h2>

	<form id='reg_form' action='/HRD_123/update' method="post">

		<table align="center">
			<tr>
				<td>회원번호</td>
				<td><input type='text' name='member_num' value="${member.member_num }"
					readonly="readonly"></td>
			</tr>
			<tr>
				<td>회원성명</td>
				<td><input id='mem_name' type='text' name='member_name' value="${member.member_name }" ></td>
			</tr>
			<tr>
				<td>회원전화</td>
				<td><input type='text' name='member_phone' value="${member.member_phone }"></td>
			</tr>
			<tr>
				<td>회원주소</td>
				<td><input type='text' name='member_address' value="${member.member_address }"></td>
			</tr>
			<tr>
				<td>가입일자</td>
				<td><input type='text' name='member_join_date'
					value="${member.member_join_date }"></td>
			</tr>
			<tr>
				<td>고객등급[A:VIP,B=일반,C:직원]</td>
				<td><input type='text' name='member_title' value="${member.member_title }"></td>
			</tr>
			<tr>
				<td>도시코드</td>
				<td><input type='text' name='member_city' value="${member.member_city }"></td>
			</tr>
			<tr>
				<td colspan="2">
					<button id="mod_button" type="button" onclick="update()">수정</button>
					<button id="list_button" type="button" onclick="list()">조회</button>
				</td>

			</tr>
		</table>
	</form>
</section>

<script>
	var request;
	
	function update() {
		console.log("update called.");
		
		if (name_validate() === false) {
			return;
		}
		
		var formObj = document.getElementById('reg_form');
		var elem = formObj.elements;
		var params = '';
		
		for (var i = 0; i < elem.length; i++) {
			if (elem[i].tagName == 'SELECT') {
				value = elem[i].options[elem[i].selectedIndex].value;
			} else {
				value = elem[i].value;
			}
			
			params += elem[i].name + "=" + encodeURIComponent(value) + "&";
		}
		
		console.log(params);
		
		request = new XMLHttpRequest();
		var url = "${pageContext.request.contextPath}/update";
		
		try {
			request.onreadystatechange = getResult;
			request.open("POST", url, true);
			request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			request.setRequestHeader("Content-length", params.length);
			request.send(params);
		} catch (e) {
			alert("서버로 요청이 실패");
		}
	}
	
	function getResult() {
		if (request.readyState == 4) {
			var result = request.responseText;
			
			if (request.status === 200) {
				alert('회원정보수정이 완료되었습니다');
			} else {
				console.log(request.status);
				alert('회원정보수정이 실패하였습니다');
			}
		}
	}
	
	function list() {
		console.log("list called.");
		var doc_root = '${pageContext.request.contextPath}';
		location.href = doc_root + "/list";
	}
	
	function name_validate() {
		var input_name = document.getElementById('mem_name');
		
		if (input_name.value === '') {
			alert('회원성명이 입력되지 않았습니다');
			return false;
		}
		
		return true;
	}
</script>
<%@ include file="/common/footer.jsp"%>