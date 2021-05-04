<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(document).ready(function() {
	$("#nav li").on("click", function() {
		// attr은 속성을 변경
		$("#nav li").removeClass("active");
		$(this).addClass("active");
	});
	$("#logout").on("click", function(e) {
		e.preventDefault();
		var $form = $("<form>").attr("action","/shop/sboard/user/logout")
			.attr("method","post")
			.appendTo($("body")).submit();
	})
});
</script>
</head>
<body>
	<div class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/shop/sboard/post/list">ICIA</a>
			</div>
			<ul id="nav" class="nav navbar-nav">
				<li><a href="/shop/sboard/post/list">게시판으로</a></li>
				<c:if test="${username ne null }">
					<li><a href="/shop/sboard/user/info">내정보 보기</a></li>
					<li><a href="/shop/sboard/post/write">글쓰기</a></li>
					<li><a href="#" id="logout">로그아웃</a></li>
				</c:if>
				<c:if test="${username eq null }">
					<li><a href="/shop/sboard/user/join">회원가입</a></li>
					<li><a href="/shop/sboard/user/login">로그인</a></li>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>