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
	<div align="center">
		<table width="600" height="600">
			<tr height="5%">
				<td align="left" colspan="3"><h3>${login.member_name}님 환영합니다</h3></td>
			</tr>
			<tr height="5%"><!-- 공백 --></tr>
			<tr height="30%">
				<td width="200" align="center">보유 포인트<br>${login.cash}<br><a href="clientPay">충전하러가기</a></td>
				<td width="200" align="center">쿠폰<br>보유하신 쿠폰이 없습니다.</td>
				<td width="200" align="center"><a href="clientLibrary?mnum=${login.mnum}">내 서재</a></td>
			</tr>
			<tr height="30%">
				<td width="200" align="center"><a href="clientCart">장바구니</a></td>
				<td width="200" align="center">선호 장르<br>${login.member_preferred1},${login.member_preferred2},${login.member_preferred3}</td>
				<td width="200" align="center">(작가=소설쓰기)<br>(일반회원=공백)</td>
			</tr>
			<tr height="35%">
				<td colspan="3" align="center">
					<ul>
						<li><h3><a href="clientOrderList">구매내역</a></h3></li>
						<li><h3><a href="clientUpdate">개인정보수정</a></h3></li>
						<li><h3><a href="clientLeave">회원탈퇴</a></h3></li>
					</ul>		
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
<jsp:include page="../main/footer.jsp"/>