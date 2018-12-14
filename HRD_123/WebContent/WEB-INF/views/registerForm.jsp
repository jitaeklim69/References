<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/header.jsp"%>

<section>
	<h2>쇼핑몰 회원 등록</h2>

	<form id='reg_form' action='/HRD_123/register' method="post">

		<table align="center">
			<tr>
				<td>회원번호(자동발생)</td>
				<td><input type='text' name='member_num' value="${id }"
					readonly="readonly"></td>
			</tr>
			<tr>
				<td>회원성명</td>
				<td><input id='mem_name' type='text' name='member_name' placeholder="Enter name..." required ></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input id='mem_pw1' type='password' name='member_pw1' placeholder="Enter Password" required ></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input id='mem_pw2' type='password' name='member_pw2' placeholder="Enter Password again" required ></td>
			</tr>
			<tr>
				<td>회원전화</td>
				<td><input type='text' name='member_phone'></td>
			</tr>
			<tr>
				<td>회원주소</td>
				<td><input type='text' name='member_address'></td>
			</tr>
			<tr>
				<td>가입일자</td>
				<td><input type='text' name='member_join_date'
					value="${today }"></td>
			</tr>
			<tr>
				<td>고객등급[A:VIP,B=일반,C:직원]</td>
				<td><input type='text' name='member_title'></td>
			</tr>
			<tr>
				<td>도시코드</td>
				<td><input type='text' name='member_city'></td>
			</tr>
			<tr>
				<td colspan="2">
					<button id="reg_button" type="button" onclick="register()">등록</button>
					<button id="list_button" type="button" onclick="list()">조회</button>
				</td>

			</tr>
		</table>
	</form>
</section>

<script>
	var request;
	
	function register() {
		console.log("register called.");
		
		if (name_validate() === false) {
			return;
		}
		
		if (pw_validate() === false) {
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
		var url = "${pageContext.request.contextPath}/register";
		
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
				alert('회원등록이 완료되었습니다');
			} else {
				console.log(request.status);
				alert('회원등록이 실패하였습니다');
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
	
	function pw_validate() {
		var pw1 = document.getElementById('mem_pw1');
		var pw2 = document.getElementById('mem_pw2');
		
		if (pw1.value == '') {
			alert('비밀번호가 입력되지 않았습니다');
			return false;
		}
		
		if (pw2.value == '') {
			alert('비밀번호 확인이 입력되지 않았습니다');
			return false;
		}
		
		if (pw1.value != pw2.value) {
			alert('입력하신 비밀번호가 같지 않습니다.');
			return false;
		}
		
		return true;
	}
</script>
<%@ include file="/common/footer.jsp"%>