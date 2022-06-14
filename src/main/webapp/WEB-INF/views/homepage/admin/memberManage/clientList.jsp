<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>[WithBooks] 회원목록</title>
</head>
<body>
<%@include file="../../adminHeader.jsp"%>
<div class="clientList">
	<p>
	<b><h3 align="center">회원 관리</h3></b>
	<table border="1" width="1000" height="500">
		<tr height="50">
			<th>회원 번호</th>
			<th>회원 이름</th>
			<th>회원 아이디</th>
			<th>전화번호</th>
			<th>계정삭제</th>
		</tr>
	<c:if test="${empty listClient}">
		<tr>
			<td colspan="5" align="center">회원이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="cdto" items="${listClient}">
		<tr>
			<td>${cdto.Mnum}</td>
			<td>${cdto.Member_name}</td>
			<td>${cdto.Member_id}</td>
			<td>${cdto.Member_Tel}</td>
			<td>삭제</td>
		</tr>		
	</c:forEach>
	</table>
	
	<p>
	
	<b><h3 align="center">작가 관리</h3></b>
	<table border="1" width="1000" height="500">
		<tr height="50"> 
			<th>작가 번호</th>
			<th>작가 이름</th>
			<th>작가 아이디</th>
			<th>전화번호</th>
			<th>계정삭제</th>
		</tr>
	<c:if test="${empty listWriter}">
		<tr>
			<td colspan="5" align="center">작가회원이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="wdto" items="${listWriter}">
		<tr>
			<td>${cdto.Mnum}</td>
			<td><a href="writerNovelSubject">${cdto.Member_name}</a></td>
			<td>${cdto.Member_id}</td>
			<td>${cdto.Member_Tel}</td>
			<td>삭제</td>
		</tr>		
	</c:forEach>
	</table>
</div>
</body>
</html>
<%@include file="../../adminFooter.jsp"%>