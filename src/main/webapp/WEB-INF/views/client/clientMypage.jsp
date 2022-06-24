<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- clientMypage -->
<jsp:include page="../main/header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>clientMypage</title>
	<link href="resources/css/client.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="mypage content">
		<h3>${login.member_name}님 환영합니다</h3>
		<ul class="myinfo flex">
			<a href="clientPay"><li>
				<i class="bi bi-coin"></i>
				<p>${login.cash}P</p>
			</li></a>
			<a href="####"><li>
				<i class="bi bi-ticket"></i>
				<p>보유하신 쿠폰이 없습니다.<p>
			</li></a>
			<a href="clientLibrary?mnum=${login.mnum}"><li>
				<i class="bi bi-book"></i>
				내 서재
			</li></a>
		</ul>
	</div>
</body>
</html>
<jsp:include page="../main/footer.jsp"/>