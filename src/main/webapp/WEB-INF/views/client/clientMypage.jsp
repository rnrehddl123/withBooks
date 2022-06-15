<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- clientMypage -->
<jsp:include page="../main/header.jsp"/>
<html>
<head>
	<title>clientMypage</title>
	<link href="resources/css/client.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div align="center">
		<table width="600" height="600">
			<tr height="5%">
				<td align="left" colspan="3"><h3>(id)님 환영합니다</h3></td>
			</tr>
			<tr height="5%">
				<td align="right" colspan="3"><h3>(작가로 회원가입을 한 경우)글쓰기</h3></td>
			</tr>
			<tr height="30%">
				<td width="200" align="center">보유 포인트</td>
				<td width="200" align="center">쿠폰</td>
				<td width="200" align="center">내 서재</td>
			</tr>
			<tr height="30%">
				<td width="200" align="center">장바구니</td>
				<td width="200" align="center">선호 장르</td>
				<td width="200"><!-- 공백 --></td>
			</tr>
			<tr height="35%">
				<td colspan="3" align="center">
					<ul>
						<li><h3><a href="clientOrderList">구매내역</a></h3></li>
						<li><h3><a href="clientUpdate">개인정보수정</a></h3></li>
						<li><h3><a href="clientDelete">회원탈퇴</a></h3></li>
						<!-- clientController에 clientDelete추가 해야함 -->
					</ul>		
				</td>
			</tr>
		</table>
	</div>
</body>
</html>