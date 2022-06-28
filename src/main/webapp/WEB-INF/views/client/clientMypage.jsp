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
			<a href="heartList"><li>
				<i class="bi bi-bookmark-heart-fill"></i>
				<p>찜 목록<p>
			</li></a>
			<a href="clientLibrary"><li>
				<i class="bi bi-book"></i>
				내 서재
			</li></a>
		</ul>
		<ul class="myinfo flex">
		<c:choose>
			<c:when test="${login.kakaoid eq 0}">
				<a href="clientUpdate"><li>
					<i class="bi bi-person-lines-fill"></i>
					<p>개인정보 수정</p>
				</li></a>
			</c:when>
			<c:when test="${login.kakaoid ne 0}">
				<li>
					<i class="bi bi-person-x-fill"></i>
					<p>카카오회원<br>정보수정 불가</p>
				</li>
			</c:when>
		</c:choose>
			<a href="clientOrderList"><li>
				<i class="bi bi-card-checklist"></i>
				<p>구매내역<p>
			</li></a>
			<c:if test="${empty login.member_authority}">
				<a href="listRequestWriter"><li>
					<i class="bi bi-pen"></i>
					작가신청
				</li></a>
			</c:if>
			<c:if test="${not empty login.member_authority}">
				<a href="writerNovel"><li>
					<i class="bi bi-pen"></i>
					소설 작성
				</li></a>
			</c:if>
		</ul>
		<c:if test="${not empty login.member_authority}">
			<ul class="myinfo flex">
				<a href="writerNovelList"><li>
					<i class="bi bi-list"></i>
					<p>내 소설</p>
				</li></a>
				<a href="chart"><li>
					<i class="bi bi-graph-up"></i>
					<p>통계<p>
			</ul>
		</c:if>
	</div>
</body>
</html>
<jsp:include page="../main/footer.jsp"/>