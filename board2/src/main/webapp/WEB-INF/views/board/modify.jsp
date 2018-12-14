<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>

<h1>게시물 수정</h1>

<form role='form' method='post'>
	<input type='hidden' name='page' value='${cri.page }' >
	<input type='hidden' name='perPageNum' value='${cri.perPageNum }'>

	<div class="box-body">
		<div class='form-group'>
			<label>BNO</label> <input type='text' name='bno' class='form-control'
				value='${boardVO.bno }' readonly='readonly'>
		</div>
		<div class='form-group'>
			<label for='exampleInputEmail1'>Title</label> <input type='text'
				name='title' value='${boardVO.title }' class='form-control'>
		</div>
		<div class='form-group'>
			<label for='exampleInputPassword1'>Content</label>
			<textarea name='content' rows='3' class='form-control'>${boardVO.content }</textarea>
		</div>
		<div class='form-group'>
			<label for='exampleInputEmail1'>Writer</label> <input type='text'
				name='writer' value='${boardVO.writer }' class='form-control'>
		</div>
	</div>

</form>

<div class="box-footer">
	<button type='submit' class='btn btn-primary'>SAVE</button>
	<button type='submit' class='btn btn-warning'>CANCEL</button>
</div>

<%@ include file="../common/footer.jspf"%>
<script>
	$(document).ready(function() {
		var formObj = $("form[role='form']");
		$(".btn-primary").on("click", function() {
			formObj.attr("action", "/board/modify");
			formObj.submit();
		});

		$(".btn-warning").on("click", function() {
			self.location = "/board/listPage?page=${cri.page}&perPageNum=${cri.perPageNum}";
		});
	});
</script>

