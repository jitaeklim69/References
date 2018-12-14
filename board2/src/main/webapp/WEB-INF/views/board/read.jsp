<%@ page language="java" contentType="text/html;charset=UTF-8" 
		pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navigation.jspf" %>

<h1>
게시물 조회
</h1>

<form role='form' method='post'>
	<input type='hidden' name='bno' value='${boardVO.bno }'>
	<input type='hidden' name='page' value='${cri.page }'>
	<input type='hidden' name='perPageNum' value='${cri.perPageNum }'>
</form>

<div class='box-body'>
	<div class='form-group'>
		<label for='exampleInputEmail1'>Title</label>
		<input type='text' name='title' value='${boardVO.title }' readonly='readonly'
			class='form-control'>
	</div>
	<div class='form-group'>
		<label for='exampleInputPassword1'>Content</label>
		<textarea name='content' rows='3' readonly='readonly'
			class='form-control'>${boardVO.content }</textarea>
	</div>
	<div class='form-group'>
		<label for='exampleInputEmail1'>Writer</label>
		<input type='text' name='writer' value='${boardVO.writer }' readonly='readonly'
			class='form-control'>
	</div>
</div>

<div class='box-footer'>
	<button type='submit' class="btn btn-warning">Modify</button>
	<button type='submit' class="btn btn-danger">Remove</button>
	<button type='submit' class="btn btn-primary">List ...</button>
</div>
<%@ include file="../common/footer.jspf" %>

<script>
	$(document).ready(function() {
		var formObj = $("form[role='form']");
		
		$(".btn-warning").on('click', function() {
			formObj.attr("action", "/board/modify");
			formObj.attr("method", "get");
			formObj.submit();
		});
		
		$(".btn-danger").on('click', function() {
			formObj.attr("action", "/board/remove");
			formObj.submit();
		});
		
		$(".btn-primary").on('click', function() {
			self.location = "/board/listPage?page=${cri.page}&perPageNum=${cri.perPageNum}";
		});
	});
</script>
