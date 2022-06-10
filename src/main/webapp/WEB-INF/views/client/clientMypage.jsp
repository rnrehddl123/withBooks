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
	<div>
		<table border="1" align="center" width="800" height="600">
			<tr height="5%">
				<td align="left" colspan="3"><h3>000, 님 환영합니다</h3></td>
			</tr>
			<tr height="5%">
				<td align="right" colspan="3"><h3>(작가로 회원가입을 한 경우)글쓰기</h3></td>
			</tr>
			<tr height="30%">
				<th>캐시(리디 북스에)</th>
				
				<th>포인트(있던)</th>
				
				<th>쿠폰(내용입니다)</th>
				
			</tr>
			<tr height="30%">
				<th>내 서재(내가 구매한 책들)</th>
				
				<th>카트(구매할 책을 담아 놓음)</th>
				
				<th>선호작품(예시-판타지, 로맨스)</th>
				
			</tr>
			<tr height="35%">
				<td colspan="3" align="center">
					<ul>
						<li><a href="clientUpdate"><h3>개인정보수정</h3></a></li>
						<li><a href="clientOrderList"><h3>구매내역</h3></a></li>
						<li><h3>회원탈퇴</h3></li>
					</ul>		
				</td>
			</tr>
		</table>
	</div>
</body>
</html>