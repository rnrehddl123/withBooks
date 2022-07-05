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
						<!-- 작가관리 페이지 -->
	
	<b><h3 align="center">회원 관리</h3></b>
	<table border="1" width="1000" height="500">
		<tr height="50">
			<th>회원 번호</th>
			<th>회원 이름</th>
			<th>회원 아이디</th>
			<th>전화번호</th>
			<!--  <th>계정삭제</th>-->
		</tr>
	<c:if test="${empty listMember}">
		<tr>
			<td colspan="4" align="center">회원이 없습니다.</td>
		</tr>
	</c:if>
	<c:forEach var="mdto" items="${listMember}">
		<c:if test="${empty mdto.member_authority}">
		<tr>
			<td>${mdto.mnum}</td>
			<td>${mdto.member_name}</td>
			<td>${mdto.member_id}</td>
			<td>${mdto.member_Tel}</td>
			<!-- <td><input type="button" value="삭제" onclick="window.location='deleteMember?mnum=${mdto.mnum}'"></td> -->
		</tr>
		</c:if>	
	</c:forEach>
	</table>
							<!-- 회원관리 : 페이징 -->
	<c:if test="${rowCount>0}">			
			<c:if test="${startPage>1}">
				[<a href="listClient?pageNum=${startPage-1}">이전</a>]			
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				[<a href="listClient?pageNum=${i}"><c:out value="${i}"/></a>]	
			</c:forEach>
			<c:if test="${endPage<pageCount}">
				[<a href="listClient?pageNum=${endPage+1}">다음</a>]			
			</c:if>
	</c:if>
							<!-- 회원관리 : 서치 -->
	<form name="f" action="listClient" method="post">
		<input type="hidden" name="mode" value="search">
		<select name="search">
					<option value="Member_name">이름</option>
					<option value="Member_id">아이디</option>
		</select>
		검색 : <input type="text" name="searchString"><input type="submit" value="검색"><p>
	</form>
</div>
</body>
</html>
<%@include file="../../adminFooter.jsp"%>