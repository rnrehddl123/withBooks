<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[WithBooks] 카테고리 목록</title>
</head>
<body>
<%@include file="../../adminHeader.jsp"%>
<div class="listCate">
	<b><h3>카테고리 목록</h3></b>
	<table border="1" width="500" height="200">
		<tr>
			<th width="30%">번호</th>
			<th width="70%">카테고리명</th>
		</tr>
	<c:if test="${empty listCategory}">
		<tr>
			<td colspan="2">등록된 카테고리가 없습니다.</td>	
		</tr>
	</c:if>
	<c:forEach items="${listCategory}" var="cdto">
		<tr>
			<td>${cdto.cnum}</td>
			<td>${cdto.cate_name}</td>
		</tr>
	</c:forEach>
	</table>
	
	<p>
	
		<input type="button" value="카테고리 추가" onclick="window.location='insertCate'">
</div>
</body>
</html>
<%@include file="../../adminFooter.jsp"%>