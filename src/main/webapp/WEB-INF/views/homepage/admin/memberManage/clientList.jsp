<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>[WithBooks] 회원목록</title>
</head>
<body>
<%@include file="../../adminHeader.jsp"%>
<div class="listClient">
	<p>
	<b><h3 align="center">회원 관리</h3></b>
	<table border="1" width="1000" height="300">
		<tr height="50">
			<th>회원 번호</th>
			<th>회원 이름</th>
			<th>회원 아이디</th>
			<th>전화번호</th>
			<th>계정삭제</th>
		</tr>
	<c:if test="${empty listMember}">
		<tr>
			<td colspan="5" align="center">회원이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="mdto" items="${listMember}">
		<c:if test="${empty mdto.member_authority}">
		<tr>
			<td>${mdto.mnum}</td>
			<td>${mdto.member_name}</td>
			<td>${mdto.member_id}</td>
			<td>${mdto.member_Tel}</td>
			<td><input type="button" value="삭제" onclick="window.location='deleteMember?mnum=${mdto.mnum}'"></td>
		</tr>
		</c:if>	
	</c:forEach>
	</table>
	
	<p>
	
	<b><h3 align="center">작가 관리</h3></b>
	<table border="1" width="1000" height="300">
		<tr height="50"> 
			<th>작가 번호</th>
			<th>작가 이름</th>
			<th>작가 아이디</th>
			<th>전화번호</th>
			<th>계정삭제</th>
		</tr>
	<c:forEach var="wdto" items="${listMember}">
		<c:if test="${wdto.member_authority eq 'writer'}">
		<tr>
			<td>${wdto.mnum}</td>
			<td><a href="writerNovelSubject">${wdto.member_name}</a></td>
			<td>${wdto.member_id}</td>
			<td>${wdto.member_Tel}</td>
			<td><input type="button" value="삭제" onclick="window.location='deleteMember?mnum=${wdto.mnum}'"></td>
		</tr>	
		</c:if>	
	</c:forEach>
	</table>
</div>
</body>
</html>
<%@include file="../../adminFooter.jsp"%>