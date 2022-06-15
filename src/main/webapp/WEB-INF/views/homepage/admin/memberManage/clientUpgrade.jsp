<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>[WithBooks] 작가신청</title>
</head>
<%@include file="../../adminHeader.jsp"%>
<body>
<div class="upgradeClient">
	<div><b><h3 align="center">작가 신청 관리</h3></b></div><br>
	<table border="1" width="1000" height="500">
		<tr height="50">
			<th>회원 번호</th>
			<th>회원 이름</th>
			<th>회원 아이디</th>
			<th>전화번호</th>
			<th>
				수락|거절
			</th>
		</tr>
	<c:if test="${empty listClientUpgrade}">
		<tr>
			<td colspan="5" align="center">작가 신청 회원이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="udto" items="${listClientUpgrade}">
		<tr>
			<td>${udto.Mnum}</td>
			<td>${udto.Member_name}</td>
			<td>${udto.Member_id}</td>
			<td>${udto.Member_Tel}</td>
			<td><a href="">수락</a>| <!-- 회원관리 페이지로 넘어가게 하기 -->
				<a href="">거절</a>
			</td>
		</tr>		
	</c:forEach>	
	</table>
</div>
</body>
</html>
<%@include file="../../adminFooter.jsp"%>