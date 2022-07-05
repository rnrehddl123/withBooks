<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>[WithBooks] 작가목록</title>
</head>
<body>
<%@include file="../../adminHeader.jsp"%>
<div class="listWriter">
							<!-- 작가관리 페이지 -->
	<b><h3 align="center">작가 관리</h3></b>
	<table border="1" width="1000" height="500">
		<tr height="50"> 
			<th>회원 번호</th>
			<th>작가 이름</th>
			<th>작가 아이디</th>
			<th>전화번호</th>
			<th>계정삭제</th>
		</tr>
	<c:forEach var="wdto" items="${listWriter}">
		<c:if test="${wdto.member_authority eq 'writer'}">
		<tr>
			<td>${wdto.mnum}</td>
			<td><a href="writerNovelList">${wdto.member_name}</a></td>
			<td>${wdto.member_id}</td>
			<td>${wdto.member_Tel}</td>
			<td><input type="button" value="삭제" onclick="window.location='deleteMember?mnum=${wdto.mnum}'"></td>
		</tr>	
		</c:if>	
	</c:forEach>
	</table>
						<!-- 회원관리 : 페이징 -->
	<c:if test="${rowCount>0}">			
			<c:if test="${startPage>1}">
				[<a href="listWriter?pageNum=${startPage-1}">이전</a>]			
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				[<a href="listWriter?pageNum=${i}"><c:out value="${i}"/></a>]	
			</c:forEach>
			<c:if test="${endPage<pageCount}">
				[<a href="listWriter?pageNum=${endPage+1}">다음</a>]			
			</c:if>
	</c:if>
	
	<form name="f" action="listWriter" method="post">
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